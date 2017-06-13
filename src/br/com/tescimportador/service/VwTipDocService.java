package br.com.tescimportador.service;

import java.util.ArrayList;

import br.com.tescimportador.dao.VwTipDocDAO;

public class VwTipDocService {

	private static VwTipDocDAO vwTipDocDAO = new VwTipDocDAO();

	public ArrayList<Object[]> findAll() throws Exception {
		return vwTipDocDAO.findAll();
	}


}
