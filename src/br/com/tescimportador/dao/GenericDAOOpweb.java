package br.com.tescimportador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.tescimportador.util.HibernateSessionFactoryOpweb;

public class GenericDAOOpweb {

	public static Object saveOrUpdate(Object o) throws Exception {
		if(o==null)
			return null;
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = em.beginTransaction();
		try {
			o=em.merge(o);
			trans.commit();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			if (trans!=null&&trans.isActive()) {
				trans.rollback();
			}
			System.err.println(o.toString());
		} finally {
			em.close();
		}
		return null;
	}

	public static ArrayList<Object> saveOrUpdateAll(ArrayList<Object> list) throws Exception {
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = em.beginTransaction();
		try {
			for (int i = 0; i < list.size(); i++) {
				list.set(i, em.merge(list.get(i)));
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (trans!=null&&trans.isActive()) {
				trans.rollback();
			}
		} finally {
			em.close();
		}
		return list;
	}

	public static void removeAllFromTable(String table) throws Exception {
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = em.beginTransaction();
		try {
			Query query = em.createSQLQuery("delete from "+table+"");
			query.executeUpdate();
			trans.commit();
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}


	public static void remove(Object o) throws Exception {
		if(o==null)
			return;
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = em.beginTransaction();
		try {
			em.delete(o);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (trans!=null&&trans.isActive()) {
				trans.rollback();
			}
		} finally {
			em.close();
		}
	}

	public static void removeAll(ArrayList<Object> list) throws Exception {
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = em.beginTransaction();
		try {
			for (Object o : list) {
				em.delete(o);
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (trans!=null&&trans.isActive()) {
				trans.rollback();
			}
		} finally {
			em.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void removeAllByClass(Class classe) throws Exception {
		ArrayList<Object> list = (ArrayList<Object>) findAll(classe);
		removeAll(list);
	}

	@SuppressWarnings({ "rawtypes" })
	public static List findAll(Class classe) throws Exception {
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = em.beginTransaction();
		try {
			Query query = em.createQuery("Select a from " + classe.getName() + " a");
			List ret = query.list();
			trans.commit();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			if (trans!=null&&trans.isActive()) {
				trans.rollback();
			}
		} finally {
			em.close();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes" })
	public static List findAllBy(Class classe,String campo, Object valor) throws Exception {
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = em.beginTransaction();
		try {
			Query query = em.createQuery("Select a from " + classe.getName() + " a"
					+ " where a."+campo+" = :valor");
			query.setParameter("valor", valor);
			List ret = query.list();
			trans.commit();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			if (trans!=null&&trans.isActive()) {
				trans.rollback();
			}
		} finally {
			em.close();
		}
		return null;
	}

	public static int executeQuery(String strQuery) throws Exception {
		Session em = HibernateSessionFactoryOpweb.getSession();
		Transaction trans = em.beginTransaction();
		try {
			Query query = em.createSQLQuery(strQuery);
			int i = query.executeUpdate();
			trans.commit();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			if (trans!=null&&trans.isActive()) {
				trans.rollback();
			}
		} finally {
			em.close();
		}
		return 0;
	}



}
