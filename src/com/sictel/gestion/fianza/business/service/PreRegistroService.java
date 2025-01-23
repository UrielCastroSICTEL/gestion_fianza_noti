/**
 * 
 */
package com.sictel.gestion.fianza.business.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sictel.gestion.fianza.business.entitie.Empresa;
import com.sictel.gestion.fianza.business.entitie.Registro;
import com.sictel.gestion.fianza.business.repository.RegistroRepository;

/**
 * 
 */
@Service
public class PreRegistroService {

	@Autowired
	RegistroRepository registroRepository;

	/**
	 * @param registro
	 * @return
	 */
	public Registro preRegistroGuardar(Registro registro) {

		registroRepository.save(registro);

		return registro;
	}

	/**
	 * @return
	 */
	public List<Registro> activos() {
		return registroRepository.activos();
	}

	/**
	 * @param registros
	 * @return
	 */
	public List<Empresa> externos(List<Registro> registros) {
		Map<Short, Empresa> map = new HashMap<Short, Empresa>();

		for (Registro registro : registros) {
			map.put(registro.getEmpresaExter().getEmpresaId(), registro.getEmpresaExter());
		}

		return new ArrayList<Empresa>(map.values());
	}

	/**
	 * @param registros
	 * @return
	 */
	public List<Empresa> internos(List<Registro> registros) {
		Map<Short, Empresa> map = new HashMap<Short, Empresa>();

		for (Registro registro : registros) {
			map.put(registro.getEmpresaLocal().getEmpresaId(), registro.getEmpresaLocal());
		}

		return new ArrayList<Empresa>(map.values());
	}

	/**
	 * @param registroId
	 * @return
	 */
	public Registro registro(Long registroId) {

		Registro dato = null;
		Optional<Registro> datoOptional = registroRepository.findById(registroId);
		if (datoOptional.isPresent()) {
			dato = datoOptional.get();
		}
		return dato;

	}

}
