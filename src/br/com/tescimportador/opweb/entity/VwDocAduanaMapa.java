package br.com.tescimportador.opweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Data
@Entity
@Table(name = "VwDocAduanaMapa")
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class VwDocAduanaMapa implements Serializable{

	private static final long serialVersionUID = -1264539144012430512L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "OID_DOC_ADUANA_MAPA")
	@SequenceGenerator(name = "OID_DOC_ADUANA_MAPA", sequenceName = "oid_doc_aduana_mapa", allocationSize = 1)
	@Column(name = "oid", nullable = false)
	private Integer oid;
	
	@Column(name = "Prog_Navio", nullable = true, precision= 10, scale = 0)
	private BigDecimal Prog_Navio;
	
	@Column(name = "Cod_Documento", nullable = true)
	private Integer Cod_Documento;
	
	@Column(name = "Tipo_Importacao", nullable = true, length=20)
	private String Tipo_Importacao;
	
	@Column(name = "Num_CE", nullable = true, length=20)
	private String Num_CE;
	
	@Column(name = "Num_BL", nullable = true, length=20)
	private String Num_BL;
	
	@Column(name = "Data_Presenca_Carga", nullable = true)
	private Timestamp Data_Presenca_Carga;
	
	@Column(name = "Sit_Siscomex", nullable = true, columnDefinition = "TINYINT")
	private Integer Sit_Siscomex;
	
	@Column(name = "Data_Lib_Siscomex", nullable = true)
	private Timestamp Data_Lib_Siscomex;
	
	@Column(name = "Nome_Despachante", nullable = true, length=50)
	private String Nome_Despachante;
	
	@Column(name = "Doc_Importacao", nullable = true, length=20)
	private String Doc_Importacao;
	
	@Column(name = "Data_Doc_Importacao", nullable = true)
	private Timestamp Data_Doc_Importacao;
	
	@Column(name = "Data_Chegada_Doc_Impo", nullable = true)
	private Timestamp Data_Chegada_Doc_Impo;

	@Column(name = "Nome_Exportador", nullable = true, length=50)
	private String Nome_Exportador;
	
	@Column(name = "Peso_Bruto", nullable = true, scale=3, precision=11)
	private BigDecimal Peso_Bruto;
	
	@Column(name = "Peso_Liquido", nullable = true, scale=3, precision=11)
	private BigDecimal Peso_Liquido;
	
	@Column(name = "Data_Desembaraco", nullable = true)
	private Timestamp Data_Desembaraco;
	
	@Column(name = "Pais_Ori_Mercadoria", nullable = true, length=50)
	private String Pais_Ori_Mercadoria;
	
}
