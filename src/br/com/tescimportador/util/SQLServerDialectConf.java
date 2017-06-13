package br.com.tescimportador.util;

import org.hibernate.dialect.SQLServer2008Dialect;

/**
 * Erro com campo boolean no Hibernate 4
 * http://stackoverflow.com/questions/8667965/found-bit-expected-boolean-after-hibernate-4-upgrade
 * 
 * Utilizar esta classe como:
 * hibernate.dialect=br.com.tesc.portaladministrador.util.SQLServerDialectConf
 * @author Samuel
 *
 */
public class SQLServerDialectConf extends SQLServer2008Dialect {

	public SQLServerDialectConf() {
		super();
        registerColumnType( java.sql.Types.BOOLEAN,"bit");
	}

	@Override
	public boolean useInputStreamToInsertBlob() {
		return false;
	}
	
}
