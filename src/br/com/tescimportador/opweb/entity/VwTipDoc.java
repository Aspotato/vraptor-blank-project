package br.com.tescimportador.opweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Data
@Entity
@Table(name = "VwTipDoc")
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class VwTipDoc implements Serializable{

	private static final long serialVersionUID = 539084241760652937L;

	@Id
	@Column(name = "Cod_Documento",  nullable = false, precision= 10, scale = 0)
	private BigDecimal Cod_Documento;

	@Column(name = "Desc_Documento", nullable = false, length=20)
	private String Desc_Documento;
}
