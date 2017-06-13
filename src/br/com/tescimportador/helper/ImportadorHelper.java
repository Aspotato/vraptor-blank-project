package br.com.tescimportador.helper;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.tescimportador.dao.GenericDAOOpweb;
import br.com.tescimportador.opweb.entity.VwDocAduanaMapa;
import br.com.tescimportador.opweb.entity.VwLineupMapa;
import br.com.tescimportador.opweb.entity.VwMercadoriaMapa;
import br.com.tescimportador.opweb.entity.VwTipDoc;
import br.com.tescimportador.util.JbossUtil;
import br.com.tescimportador.util.Util;

public class ImportadorHelper {
	
	public void importTipDoc() throws Exception{
		ArrayList<String[]> csvlines = Util.readCsv(JbossUtil.getCsvPath()+"VwTipDoc.csv");
		for (String[] line : csvlines) {
			if(!Util.nw(line[0]).contains("Cod_Documento")){
				VwTipDoc tipDoc = new VwTipDoc();
				tipDoc.setCod_Documento(new BigDecimal(Util.nw(line[0])));
				tipDoc.setDesc_Documento(Util.nw(line[1]));
				GenericDAOOpweb.saveOrUpdate(tipDoc);
			}
		}
	}

	public void importVwLineUpMapa() throws Exception{
		ArrayList<String[]> csvlines = Util.readCsv(JbossUtil.getCsvPath()+"VwLineupMapa.csv");
		for (String[] line : csvlines) {
			if(!Util.nw(line[0]).contains("Prog_Navio")){
				VwLineupMapa vwLineupMapa = new VwLineupMapa();
				vwLineupMapa.setProg_Navio(new BigDecimal(Util.nw(line[0])));
				vwLineupMapa.setCod_Navio(Util.nw(line[1]));
				vwLineupMapa.setNavio(Util.nw(line[2]));
				vwLineupMapa.setViagem(Util.nw(line[3]));
				vwLineupMapa.setBerco(Util.nw(line[4]));
				vwLineupMapa.setPosicao(new Integer(Util.nw(line[5])));
				vwLineupMapa.setMercadoria(Util.nw(line[6]));
				vwLineupMapa.setAgente(Util.nw(line[7]));
				vwLineupMapa.setDATETA(Util.stringToDate(Util.nw(line[8])));
				vwLineupMapa.setDATATR(Util.stringToDate(Util.nw(line[9])));
				vwLineupMapa.setDATDES(Util.stringToDate(Util.nw(line[10])));

				GenericDAOOpweb.saveOrUpdate(vwLineupMapa);
			}
		}
	}

	public void importVwDocAduanaMapa() throws Exception{
		ArrayList<String[]> csvlines = Util.readCsv(JbossUtil.getCsvPath()+"VwDocAduanaMapa.csv");
		for (String[] line : csvlines) {
			if(!Util.nw(line[0]).contains("Prog_Navio")){
				VwDocAduanaMapa vwDocAduanaMapa = new VwDocAduanaMapa();
				vwDocAduanaMapa.setProg_Navio(new BigDecimal( Util.nw(line[0])));
				vwDocAduanaMapa.setCod_Documento(new Integer(Util.nw(line[1])));
				vwDocAduanaMapa.setTipo_Importacao(Util.nw(line[2]));
				vwDocAduanaMapa.setNum_CE(Util.nw(line[3]));
				vwDocAduanaMapa.setNum_BL(Util.nw(line[4]));
				vwDocAduanaMapa.setData_Presenca_Carga(Util.stringToDate(Util.nw(line[5])));
				vwDocAduanaMapa.setSit_Siscomex(null);
				vwDocAduanaMapa.setData_Lib_Siscomex(Util.stringToDate(Util.nw(line[7])));
				vwDocAduanaMapa.setNome_Despachante(Util.nw(line[8]));
				vwDocAduanaMapa.setDoc_Importacao(Util.nw(line[9]));
				vwDocAduanaMapa.setData_Doc_Importacao(Util.stringToDate(Util.nw(line[10])));
				vwDocAduanaMapa.setData_Chegada_Doc_Impo(Util.stringToDate(Util.nw(line[11])));
				vwDocAduanaMapa.setNome_Exportador(Util.nw(line[12]));
				vwDocAduanaMapa.setPeso_Bruto(new BigDecimal(Util.nw(line[13])));
				vwDocAduanaMapa.setPeso_Liquido(new BigDecimal(Util.nw(line[14])));
				vwDocAduanaMapa.setData_Desembaraco(Util.stringToDate(Util.nw(line[15])));
				vwDocAduanaMapa.setPais_Ori_Mercadoria(null);

				GenericDAOOpweb.saveOrUpdate(vwDocAduanaMapa);
			}
		}
	}

	public void importVwMercadoriaMapa() throws Exception{
		ArrayList<String[]> csvlines = Util.readCsv(JbossUtil.getCsvPath()+"VwMercadoriaMapa.csv");
		for (String[] line : csvlines) {
			if(!Util.nw(line[0]).contains("Prog_Navio")){
				VwMercadoriaMapa vwMercadoriaMapa = new VwMercadoriaMapa();
				vwMercadoriaMapa.setProg_Navio(new BigDecimal(Util.nw(line[0])));
				vwMercadoriaMapa.setProg_Receb(new BigDecimal(Util.nw(line[1])));
				vwMercadoriaMapa.setNome_Mercadoria(Util.nw(line[2]));
				vwMercadoriaMapa.setCod_NCM(Util.nw(line[3]));
				vwMercadoriaMapa.setQtd_Previsao_Receb(new BigDecimal(Util.nw(line[4])));
				vwMercadoriaMapa.setTons_Prev_Receb(new BigDecimal(Util.nw(line[5])));
				if(line.length>6)
					vwMercadoriaMapa.setDoc_Controle(Util.nw(line[6]));
				if(line.length>7)
					vwMercadoriaMapa.setCod_Documento(Util.nw(line[7]));

				GenericDAOOpweb.saveOrUpdate(vwMercadoriaMapa);
			}
		}
	}
	
	public void clearAllTables() throws Exception{
		GenericDAOOpweb.removeAllFromTable("VwTipDoc");
		GenericDAOOpweb.removeAllFromTable("VwMercadoriaMapa");
		GenericDAOOpweb.removeAllFromTable("VwLineupMapa");
		GenericDAOOpweb.removeAllFromTable("VwDocAduanaMapa");
		
	}

}
