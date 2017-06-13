package br.com.tescimportador.controller;

import java.util.ArrayList;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tescimportador.helper.ImportadorHelper;
import br.com.tescimportador.service.VwTipDocService;

@Resource
public class IndexController {

	private final Result result;

	private static VwTipDocService vwTipDocService = new VwTipDocService();
	private static ImportadorHelper helper = new ImportadorHelper();

	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() throws Exception {
		@SuppressWarnings("unused")
		ArrayList<Object[]> retorno = vwTipDocService.findAll();
		helper.clearAllTables();
		System.out.println("Todos os dados removidos");
		helper.importTipDoc();
		System.out.println("Tipo Doc Importado");
		helper.importVwLineUpMapa();
		System.out.println("VwLine Mapa Importado");
		helper.importVwDocAduanaMapa();
		System.out.println("Doc Aduana Mapa Importado");
		helper.importVwMercadoriaMapa();
		System.out.println("Mercadoria Mapa Importado");
		result.include("variable", "VRaptor!");
	}



}
