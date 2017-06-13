package br.com.tescimportador.util;

public class JbossUtil {

	
	public static String getJbossTempDir(){
		try {
			if (System.getProperty("os.name").contains("Linux")) {
				return System.getProperty("jboss.server.tmp.dir").replace("file:", "");
			} else {
				return System.getProperty("jboss.server.tmp.dir").replace("file:/", "");
			}
		} catch (Exception e) {
            return getHomeDir()+"/tmp";
		}
	}

	public static String getHomeDir() {
		try {
			if (System.getProperty("os.name").contains("Linux")) {
				return System.getProperty("jboss.server.base.dir").replace("file:", "");
			} else {
				return System.getProperty("jboss.server.base.dir").replace("file:/", "");
			}
		} catch (Exception e) {
			return "D:/pontocob/jboss7.1TESC/standalone";
		}
	}

	public static String getWarName() {
		return "tesc-importador.war";
	}
	
	public static String getWarPath(){
		return getHomeDir() +"/deployments/" + getWarName();
	}
	
	public static String getClassesPath(){
		return getWarPath() +"/WEB-INF/config/";
	}
	public static String getCsvPath(){
		return getWarPath() +"/WEB-INF/csv/";
	}
}
