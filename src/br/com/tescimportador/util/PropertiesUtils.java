package br.com.tescimportador.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	private static Properties props;
	private static String arquivoProperties;
	private static String diretorioArquivoProperties;
	
	public PropertiesUtils(String diretorio, String arquivo) throws Exception {
		super();
		diretorioArquivoProperties = diretorio;
		arquivoProperties = arquivo;
		refreshProperties();
	}
	
	public PropertiesUtils(String arquivo) throws Exception {
		super();
		arquivoProperties = arquivo;
		refreshProperties();
	}

	public void clearProperties() throws Exception{
		props = null;
	}
	
	@SuppressWarnings("resource")
	public void refreshProperties() throws Exception{
		if(diretorioArquivoProperties==null || diretorioArquivoProperties.length()==0){
			diretorioArquivoProperties = JbossUtil.getClassesPath();
		}
		File file = new File(diretorioArquivoProperties + arquivoProperties);
		if(!file.exists()){
			throw new Exception("Arquivo de configuração "+diretorioArquivoProperties + arquivoProperties+" não encontrado.");
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		props = new Properties();
		props.load(fileInputStream);
	}
	
	public Properties getProperties() throws Exception{
		return props;
	}
	
	public String getPropertie(String key) throws Exception{
		if(props==null){
			refreshProperties();
		}
		
		String ret = (String) props.get(key);
		if(StringTools.isEmpty(ret)){
			throw new Exception(key+" não encontrado no arquivo de configuração.");
		}
		return ret;
	}
	
}
