package com.sictel.gestion.fianza.consola.config;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sictel.gestion.fianza.business.entitie.Registro;
import com.sictel.gestion.fianza.business.service.CorreoService;
import com.sictel.gestion.fianza.business.service.PreRegistroService;

@SpringBootApplication
public class GestionFianzaMain implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(GestionFianzaMain.class);
	private static final String RUTA_CARPE = "//resources//";
	private static final Integer RUTA_INDEX = 0;
	private static final String FILE_LECTURA = "archivo.csv";
	private static final String FILE_ESCRITU = "archivo_result.csv";

	@Autowired
	PreRegistroService preRegistroService;

	@Autowired
	CorreoService correoService;

	public static void main(String[] args) {
		log.info("    -- :: [FIA_NOTI] [INICIANDO... ] Iniciando... ");
		SpringApplication.run(GestionFianzaMain.class, args);
		log.info("    -- :: [FIA_NOTI] [TERMINADO... ] Se terminó");
	}

	@Override
	public void run(String... args) {

		log.info("    -- :: [FIA_NOTI] [INICIADO...  ] Se inició");

		List<Registro> registros = preRegistroService.activos();
		log.info("    -- :: [FIA_NOTI] [CONSULTA] El número de pre - registros "
				.concat(String.valueOf(registros.size())));

		correoService.notificar(registros);

		log.info("    -- :: [FIA_NOTI] [TERMINANDO...] Terminando... ");
	}

}