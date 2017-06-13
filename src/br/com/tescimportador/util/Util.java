package br.com.tescimportador.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Util {

	public Util() {
	}

	public static ArrayList<String[]> readCsv(String csvFile){

		ArrayList<String[]> retorno = new ArrayList<String[]>();

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			 csvFile = new String(csvFile.getBytes(), "ISO-8859-1");

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				String[] lineCs = line.split(cvsSplitBy);
				retorno.add(lineCs);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return retorno;
	}
	
	public static String nw(String value) throws UnsupportedEncodingException{
		value = value.replace("\"", "");
		value = value.replace("\"", "");
		//Charset.forName("UTF-8").encode(value);
		value = new String(value.getBytes(), "UTF-8");
		return value;
	}
	
	public static Timestamp stringToDate(String date_str) throws ParseException{
		if(date_str == null ||date_str.equals("")){
			return null;
		}
		DateFormat formatter = null;
		if(date_str.contains("-")){
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else{
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		}

		Date date = (Date)formatter.parse(date_str);
		return new Timestamp(date.getTime()) ;
	}

}
