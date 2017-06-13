package br.com.tescimportador.opweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "VwMercadoriaMapa")
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class VwMercadoriaMapa implements Serializable{

	private static final long serialVersionUID = 7801441433727115194L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "OID_MERCADORIA_MAPA")
	@SequenceGenerator(name = "OID_MERCADORIA_MAPA", sequenceName = "oid_mercadoria_mapa", allocationSize = 1)
	@Column(name = "oid", nullable = false)
	private Integer oid;
	
	@Column(name = "Prog_Navio", nullable = true, precision= 10, scale = 0)
	private BigDecimal Prog_Navio;
	
	@Column(name = "Prog_Receb", nullable = true , precision= 10, scale = 0)
	private BigDecimal Prog_Receb;
	
	@Column(name = "Nome_Mercadoria", nullable = true, length=100)
	private String Nome_Mercadoria;
	
	@Column(name = "Cod_NCM", nullable = true, length=30)
	private String Cod_NCM;

	@Column(name = "Qtd_Previsao_Receb", nullable = true , precision= 9, scale = 0)
	private BigDecimal Qtd_Previsao_Receb;
	
	@Column(name = "Tons_Prev_Receb", nullable = true, scale=3, precision=12)
	private BigDecimal Tons_Prev_Receb;
	
	@Column(name = "Doc_Controle", nullable = true, length=20)
	private String Doc_Controle;
	
	@Column(name = "Cod_Documento", nullable = true, length=20)
	private String Cod_Documento;
	
}
