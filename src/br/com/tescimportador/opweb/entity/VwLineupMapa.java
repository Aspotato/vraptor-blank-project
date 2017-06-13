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
@Table(name = "VwLineupMapa")
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class VwLineupMapa  implements Serializable{

	private static final long serialVersionUID = 5281845262000527417L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "OID_LINEUP_MAPA")
	@SequenceGenerator(name = "OID_LINEUP_MAPA", sequenceName = "oid_lineup_mapa", allocationSize = 1)
	@Column(name = "oid", nullable = false)
	private Integer oid;
	
	@Column(name = "Prog_Navio", nullable = true, precision= 10, scale = 0)
	private BigDecimal Prog_Navio;

	@Column(name = "Cod_Navio", nullable = true, length = 30)
	private String Cod_Navio;
	
	@Column(name = "Navio", nullable = true, length = 50)
	private String Navio;

	@Column(name = "Viagem", nullable = true, length = 20)
	private String Viagem;

	@Column(name = "Berco", nullable = true, length = 10)
	private String Berco;
	
	@Column(name = "Posicao", nullable = true ,columnDefinition= "TINYINT")
	private Integer Posicao;
	
	@Column(name = "Mercadoria", nullable = true, length = 20)
	private String Mercadoria;
	
	@Column(name = "Agente", nullable = true, length = 35)
	private String Agente;
	
	@Column(name = "DATETA", nullable = true, length = 35)
	private Timestamp DATETA;
	
	@Column(name = "DATATR", nullable = true, length = 35)
	private Timestamp DATATR;
	
	@Column(name = "DATDES", nullable = true, length = 35)
	private Timestamp DATDES;
}
