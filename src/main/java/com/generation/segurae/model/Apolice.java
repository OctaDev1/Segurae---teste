package com.generation.segurae.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table(name = "tb_apolice")
public class Apolice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numeroApolice", length = 255, unique = true, nullable = false) 
	private String numeroApolice;
	
	@NotBlank(message = "O bem segurado não pode estar vazio!")
	@Column(name = "bemSegurado", length = 255)
	private String bemSegurado;
	
	@NotNull(message = "O ano do modelo não pode ser nulo!")
	@Column(name = "anoModelo")
	private Integer anoModelo; 
	
	@NotBlank(message = "A placa não pode estar vazia!")
	@Column(name = "placa", length = 255)
	private String placa;
	
	@NotBlank(message = "O número do Renavam não pode estar vazio!")
	@Column(name = "renavam", length = 255)
	private String renavam;
	
	@NotNull(message = "O valor da apólice não pode ser nulo!")
	@Column(name = "valorApolice", precision = 10, scale = 2) 
	private BigDecimal valorApolice; 
	
	@NotBlank(message = "O tipo de cobertura não pode estar vazio!")
	@Column(name = "tipoCobertura", length = 255)
	private String tipoCobertura;
	
	@NotNull(message = "A data de início não pode ser nula!") 
	@Column(name = "dataInicio")
	private LocalDate dataInicio;
	
	@NotNull(message = "A data de término não pode ser nula!") 
	@Column(name = "dataTermino")
	private LocalDate dataTermino;
	
	@NotNull(message = "O status da apólice não pode ser nulo!")
	@Column(name = "statusApolice")
	private Integer statusApolice;
	
	private String marcaModelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(String numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public String getBemSegurado() {
		return bemSegurado;
	}

	public void setBemSegurado(String bemSegurado) {
		this.bemSegurado = bemSegurado;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public BigDecimal getValorApolice() {
		return valorApolice;
	}

	public void setValorApolice(BigDecimal valorApolice) {
		this.valorApolice = valorApolice;
	}

	public String getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(String tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Integer getStatusApolice() {
		return statusApolice;
	}

	public void setStatusApolice(Integer statusApolice) {
		this.statusApolice = statusApolice;
	}
	
	
	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	@PrePersist
	public void gerarNumeroApolice() {
	    if (this.numeroApolice == null) {
	        int anoAtual = java.time.LocalDate.now().getYear();
	        String codigo = java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	        this.numeroApolice = "SEG-" + anoAtual + "-" + codigo;
	    }
	}
	
	
}
