/**
 * 
 */
/**
 * 
 */
module gestion_fianza_noti {

	requires spring.core;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.beans;
	requires spring.orm;
	requires spring.tx;
	requires spring.data.jpa;
	requires spring.data.commons;
	requires spring.jdbc;
	requires org.hibernate.orm.core;
	requires org.postgresql.jdbc;
	requires org.slf4j;
	requires jakarta.persistence;
	requires transitive java.sql;
	requires java.instrument;
	requires java.sql.rowset;
	requires ews.java.api;

	opens com.sictel.gestion.fianza.consola.config to spring.core, spring.beans, spring.context, resources;
	opens com.sictel.gestion.fianza.business.repository to spring.core, spring.beans, spring.context;
	opens com.sictel.gestion.fianza.business.service to spring.core, spring.beans, spring.context;
	opens com.sictel.gestion.fianza.business.entitie
			to spring.core, spring.beans, spring.context, org.hibernate.orm.core;

	exports com.sictel.gestion.fianza.business.entitie;
	exports com.sictel.gestion.fianza.business.repository;
	exports com.sictel.gestion.fianza.business.service;

}