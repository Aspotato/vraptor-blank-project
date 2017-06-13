package br.com.tescimportador.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.tescimportador.util.HibernateSessionFactoryOpweb;


public class VwTipDocDAO {

	@SuppressWarnings("unchecked")
	public ArrayList<Object[]> findAll() throws Exception {
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = null;
		try {
			ArrayList<Object[]> result = new ArrayList<Object[]>();
			trans = em.beginTransaction();
			Query query = em.createSQLQuery("SELECT Cod_Documento, "+
					" Desc_Documento FROM VwTipDoc");
			result =  (ArrayList<Object[]>) query.list();
			trans.commit();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			if (trans!=null&&trans.isActive()) {
				trans.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
	}

}
