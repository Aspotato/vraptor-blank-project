package br.com.tescimportador.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateSessionFactoryOpweb {
	static Logger LOG = Logger.getLogger(HibernateSessionFactoryOpweb.class.getName());

	private static SessionFactory sessionFactory;

	private static String CAMINHO_CLASSES = JbossUtil.getWarPath()+"/WEB-INF/classes/";

	private static final String PACKAGE_VIEWS = "br.com.tescimportador.opweb.entity";

	static {
		try {
			PropertiesUtils pUtils  = null;
			pUtils = new PropertiesUtils("pontosistemas-opweb.properties");

			createSessionFactory(pUtils.getProperties());

		} catch (Throwable ex) {
			ex.printStackTrace();
			LOG.error("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void createSessionFactory(Properties propriedades) {
		try {
			Configuration cfg = new Configuration();
			cfg.addProperties(propriedades);

			List<String> list = getClasseNamesInPackage(PACKAGE_VIEWS);
			for (String classe : list) {
				cfg.addAnnotatedClass(Class.forName(classe.replace(".class", "")));
			}

			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();        
			sessionFactory= cfg.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static Session getCurrentSessions() {
		return sessionFactory.getCurrentSession();
	}

	public static void closeSession() {
		sessionFactory.close();
	}

	private static List<String> getClasseNamesInPackage(String strPackage) {
		ArrayList<String> classes = new ArrayList<String>();

		String packageName = strPackage.replaceAll("\\.", "/");
		try {
			File dir = new File(CAMINHO_CLASSES + "/" + packageName);
			LOG.info("dir="+dir);
			for (String files : dir.list()) {
				LOG.info("entity:" + strPackage + "." + files);
				classes.add(strPackage + "." + files);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classes;
	}
}

