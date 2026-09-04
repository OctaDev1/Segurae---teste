package com.generation.segurae.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome completo é obrigatório!")
	@Size(min = 2, max = 100, message = "O nome completo deve ter entre 2 e 100 caracteres")
	@Column(name = "nomeCompleto", nullable = false, length = 100)
	private String nomeCompleto;

	@NotBlank(message = "O e-mail é obrigatório!")
	@Email(message = "Informe um e-mail válido!")
	@Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")
	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@NotBlank(message = "O CPF ou CNPJ é obrigatório!")
	@Size(min = 11, max = 14, message = "O CPF deve ter 11 dígitos ou o CNPJ deve ter 14 dígitos")
	@Column(name = "cpfCnpj", nullable = false, unique = true, length = 14)
	private String cpfCnpj;

	@NotNull(message = "A data de nascimento é obrigatória!")
	@Column(name = "dataNascimento", nullable = false)
	private LocalDate dataNascimento;

	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("cliente")
	private Usuario usuario;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cliente")
	private List<Apolice> apolices;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Apolice> getApolices() {
		return apolices;
	}

	public void setApolices(List<Apolice> apolices) {
		this.apolices = apolices;
	}
	
	
}
