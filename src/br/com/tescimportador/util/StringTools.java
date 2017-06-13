package br.com.tescimportador.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.Normalizer;

import javax.swing.text.MaskFormatter;

public class StringTools {


	public static String cutTrim(String str,int ini, int end){
		return str.substring(ini, end).trim();
	}
	
	public static boolean isEmpty(String str){
		return (str == null || "".equals(str));
	}
	
	public static String stackTrace2String(Exception e){
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			pw.close();
			sw.close();
			System.err.println(sw.getBuffer().toString());
			return sw.getBuffer().toString();
		} catch (Exception ex) {
		}
		return null;
	}
	
	public static String retirarAcentosCaracteresEspeciais(String texto) {
		if (texto != null) {
			texto = retirarCaracteresEspeciais(texto);
			texto = retirarAcentos(texto);
		}
		return texto;
	}
	 
	public static String retirarCaracteresEspeciais(String texto) {
		if (texto != null) {
			texto = texto.replaceAll("[`~´'=?|<>^}`{!@#$%¨&*_°ºª§]"," "); 
			texto = texto.replaceAll("/", " ");
			texto = texto.replace("\\", " ");
		}
		return texto; 
	}
	
	public static String retirarAcentos(String texto) {
		if (texto != null) {
			texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
			texto = texto.replaceAll("[^\\p{ASCII}]", "");
		}
		return texto;
	}
	
	public static String retirarPontosTracos(String texto) {
		if (texto != null) {
			texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
			texto = texto.replaceAll("[.-]", "");
		}
		return texto;
	}
	
	public static String formatarCnpjCpf(String cnpjCpf){
		if(cnpjCpf!=null){
			try{
				MaskFormatter format = null;
				if(cnpjCpf.length() == 11){
					format = new MaskFormatter("###.###.###-##");
				}else if(cnpjCpf.length() == 14){
					format = new MaskFormatter("##.###.###/####-##");
				}
				if(format!=null){
					format.setValueContainsLiteralCharacters(false);
					cnpjCpf = format.valueToString(cnpjCpf);
				}
			}catch (Exception e) {}
		}
		return cnpjCpf;
	}
	
	public static String retornarSomenteNome(String arquivo){
		return arquivo.substring(0,arquivo.lastIndexOf("."));
	}
	
	public static String retornarSomenteExtencao(String arquivo){
		return arquivo.substring(arquivo.lastIndexOf(".")+1,arquivo.length());
	}
	public static String retornarHoraDoisDigitos(int i){
		if(i<10){
			return "0"+i;
		}
		return ""+i;
	}
	
}
