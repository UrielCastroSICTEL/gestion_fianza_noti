/**
 * 
 */
package com.sictel.gestion.fianza.consola.config;

import java.text.SimpleDateFormat;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
@Configuration
@PropertySource("classpath:config_gestion_fianza_noti.properties")
public class ConfigGestionFianzaNoti {
	
	@Autowired
	StandardPBEStringEncryptor standardPBEStringEncryptor;

	@Value("${config.ad.context.service}")
	String config_ad_context_service;
	static public String CONFIG_AD_CONTEXT_SERVICE;
	@Value("${config.ad.context.security.pri}")
	String config_ad_context_security_pri;
	static public String CONFIG_AD_CONTEXT_SECURITY_PRI;
	@Value("${config.ad.context.security.cre}")
	String config_ad_context_security_cre;
	static public String CONFIG_AD_CONTEXT_SECURITY_CRE;

	static public SimpleDateFormat CONFIG_FORMAT_DATE_INT;

	@Bean
	public ConfigGestionFianzaNoti reguardo() {

		CONFIG_AD_CONTEXT_SERVICE = config_ad_context_service;
		CONFIG_AD_CONTEXT_SECURITY_PRI = standardPBEStringEncryptor.decrypt(config_ad_context_security_pri);
		CONFIG_AD_CONTEXT_SECURITY_CRE = standardPBEStringEncryptor.decrypt(config_ad_context_security_cre);;

		CONFIG_FORMAT_DATE_INT = new SimpleDateFormat("yyyyMMdd");

		return new ConfigGestionFianzaNoti();
	}

}
