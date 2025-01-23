/**
 * 
 */
package com.sictel.gestion.fianza.business.service;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.sictel.gestion.fianza.business.entitie.Correo;
import com.sictel.gestion.fianza.business.entitie.Notificacion;
import com.sictel.gestion.fianza.business.entitie.Registro;
import com.sictel.gestion.fianza.business.enu.CorreoNotiTipo;
import com.sictel.gestion.fianza.business.repository.CorreoRepository;
import com.sictel.gestion.fianza.business.repository.NotificacionRepository;
import com.sictel.gestion.fianza.consola.config.ConfigGestionFianzaNoti;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.property.BodyType;
import microsoft.exchange.webservices.data.core.enumeration.property.Importance;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.FileAttachment;
import microsoft.exchange.webservices.data.property.complex.MessageBody;

/**
 * @author Uriel Castro u.castro@sictel
 *
 */
@Service
public class CorreoService {

	@Autowired
	CorreoRepository correoRepository;

	@Autowired
	NotificacionRepository notificacionRepository;

	private static final Logger log = LoggerFactory.getLogger(CorreoService.class);
	String base = "    -- :: [FIA_NOTI] ";
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	Integer miliSeg_Day = 86400000;

	/**
	 * 
	 */
	public Boolean testCorreo() {
		List<String> to = new ArrayList<String>();
		List<String> cc = new ArrayList<String>();
		List<String> cco = new ArrayList<String>();
		Correo correo = correoRepository.findById(CorreoNotiTipo.NOTI_1S.toString()).get();

		to.add("ucastro@sictel.com");
		cc.add("uriel_castro_arriaga@hotmail.com");

		return enviarCorreo(correo, to, cc, cco);
	}

	/**
	 * @param registros
	 */
	public void notificar(List<Registro> registros) {
		CorreoNotiTipo correoNotiTipo = null;
		Boolean enviado = false;
		Boolean enviar = false;
		String noPreRegistro = "";
		String logBase = "";
		Integer noDias = 0;
		Integer noNotis = 0;
		Date hoy = null;

		try {
			hoy = ConfigGestionFianzaNoti.CONFIG_FORMAT_DATE_INT
					.parse(ConfigGestionFianzaNoti.CONFIG_FORMAT_DATE_INT.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (Registro registro : registros) {
			noDias = (int) (hoy.getTime() - registro.getRegistroCreado().getTime()) / miliSeg_Day;
			noPreRegistro = "0000/".concat(registro.getEmpresaLocal().getEmpresaSigla()).concat("-")
					.concat(registro.getEmpresaExter().getEmpresaSigla()).concat("/")
					.concat(registro.getFianzaTipo().getFianzaTipoSigla()).concat("/")
					.concat(String.valueOf(registro.getRegistroCreadoInt() / 10000));
			logBase = "[PRE_REG] [".concat(noPreRegistro).concat("] ");
			enviar = false;

			log.info(base.concat(logBase).concat("Fecha registro [").concat(registro.getRegistroCreado().toString())
					.concat("]"));
			log.info(base.concat(logBase).concat("No. notificaciones [")
					.concat(String.valueOf(registro.getNotificaciones().size()).concat("]")));
			log.info(base.concat(logBase).concat("Dias desde registro [").concat(String.valueOf(noDias).concat("]")));
			log.info(base.concat(logBase).concat("Semanas desde registro [")
					.concat(String.valueOf((noDias) / 7).concat("]")));

			if (noDias > 14) {
				correoNotiTipo = CorreoNotiTipo.NOTI_ALE;
			} else if (noDias > 7) {
				correoNotiTipo = CorreoNotiTipo.NOTI_2S;
			} else {
				correoNotiTipo = CorreoNotiTipo.NOTI_1S;
			}

			if (correoNotiTipo != CorreoNotiTipo.NOTI_ALE) {
				if (registro.getNotificaciones().size() > 0) {
					noNotis = 0;

					for (Notificacion noti : registro.getNotificaciones()) {
						if (correoNotiTipo == CorreoNotiTipo.valueOf(noti.getNotificacionTipo())
								&& noti.getNotificacionEnvi()) {
							noNotis++;
						}
					}

					if (noNotis == 0) {
						enviar = true;
					}
				} else {
					enviar = true;
				}
			} else {
				enviar = true;
			}

			log.info(base.concat(logBase).concat("Tipo de correo [".concat(correoNotiTipo.toString()).concat("]")));

			if (enviar) {
				enviado = crearCorreo(registro, noPreRegistro, correoNotiTipo);
				Notificacion notificacion = new Notificacion();

				notificacion.setNotificacionEnvi(enviado);
				notificacion.setNotificacionFech(new java.sql.Date(new Date().getTime()));
				notificacion.setNotificacionFechInt(
						Integer.valueOf(ConfigGestionFianzaNoti.CONFIG_FORMAT_DATE_INT.format(new Date())));
				notificacion.setNotificacionId(null);
				notificacion.setNotificacionTipo(correoNotiTipo.toString());
				notificacion.setRegistroId(registro.getRegistroId());

				notificacionRepository.save(notificacion);
			} else {
				log.info(base.concat("[EMAIL] NO SE ENVIA CORREO"));
			}

		}

	}

	/**
	 * @param registro
	 * @param noPreRegistro
	 * @param correoNotiTipo
	 * @return
	 */
	private Boolean crearCorreo(Registro registro, String noPreRegistro, CorreoNotiTipo correoNotiTipo) {
		Integer hoyInt = Integer.valueOf(ConfigGestionFianzaNoti.CONFIG_FORMAT_DATE_INT.format(new Date()));
		Correo correo = correoRepository.findById(correoNotiTipo.toString()).get();
		String tipoReg = registro.getRegistroTipo().equals("FIANZA") ? "fianza" : "póliza";
		List<String> to = new ArrayList<String>();
		List<String> cc = new ArrayList<String>();
		List<String> cco = new ArrayList<String>();

		to.add(registro.getEmpleado().getEmpleadoEmail());
		cc.add(registro.getComercial().getComercialEmail());

		if (correoNotiTipo == CorreoNotiTipo.NOTI_ALE) {
			cc.add(registro.getResponsable().getEmpleadoEmail());
		}

		String texto = String.format(correo.getCorreoTexto(), tipoReg, tipoReg, noPreRegistro,
				sdfDate.format(registro.getRegistroCreado()), String.valueOf(hoyInt - registro.getRegistroCreadoInt()),
				registro.getFianzaTipo().getFianzaTipoNomb(), registro.getEmpresaExter().getEmpresaNomb(),
				registro.getEmpresaLocal().getEmpresaNomb(), registro.getAseguradora().getAseguradoraNomb(),
				"[".concat(registro.getComercial().getComercialEmail()).concat("] ")
						.concat(registro.getComercial().getComercialNomb()),
				"[".concat(registro.getEmpleado().getEmpleadoEmail()).concat("] ")
						.concat(registro.getEmpleado().getEmpleadoNomCompl()),
				"[".concat(registro.getResponsable().getEmpleadoEmail()).concat("] ")
						.concat(registro.getResponsable().getEmpleadoNomCompl()));

		correo.setCorreoTexto(texto);
		correo.setCorreoAsunto(String.format(correo.getCorreoAsunto(), tipoReg));

		return enviarCorreo(correo, to, cc, cco);
	}

	/**
	 * @param correo
	 * @param to
	 * @param cc
	 * @param cco
	 */
	private Boolean enviarCorreo(Correo correo, List<String> to, List<String> cc, List<String> cco) {
		Boolean result = false;
		try {
			ResourceLoader resourceLoader = new DefaultResourceLoader();
			StringBuilder sb = null;
			ExchangeService service = new ExchangeService();

			service.setUrl(new URI(ConfigGestionFianzaNoti.CONFIG_AD_CONTEXT_SERVICE));

			ExchangeCredentials credentials = new WebCredentials(ConfigGestionFianzaNoti.CONFIG_AD_CONTEXT_SECURITY_PRI,
					ConfigGestionFianzaNoti.CONFIG_AD_CONTEXT_SECURITY_CRE);

			service.setCredentials(credentials);
			EmailMessage message = new EmailMessage(service);

			message.setImportance(Importance.High);

			for (String string : correo.getCorreoDetalle().getCorreoDetalleAttach().split(",")) {
				Resource resource = resourceLoader.getResource("classpath:".concat(string));
				FileAttachment x = message.getAttachments().addFileAttachment(string,
						resource.getInputStream().readAllBytes());
				x.setIsInline(true);
				x.setContentId(string);
				log.info(base.concat("[EMAIL] ").concat("Carga attachmeent - ").concat(string));
			}

			message.setSubject(correo.getCorreoAsunto());

			for (String string : to) {
				message.getToRecipients().add(string);
			}

			for (String string : cc) {
				message.getToRecipients().add(string);
			}

			for (String string : cco) {
				message.getToRecipients().add(string);
			}

			sb = new StringBuilder();
			sb.append(correo.getCorreoDetalle().getCorreoDetalleCabecera());
			sb.append(correo.getCorreoTexto());
			sb.append(correo.getCorreoDetalle().getCorreoDetalleElem01());
			sb.append(correo.getCorreoDetalle().getCorreoDetalleElem02());
			sb.append(correo.getCorreoDetalle().getCorreoDetallePiePag());

			message.setBody(new MessageBody(BodyType.HTML, sb.toString()));
			message.sendAndSaveCopy();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}

		return result;
	}

}
