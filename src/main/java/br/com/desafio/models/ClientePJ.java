package br.com.desafio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class ClientePJ extends Cliente{
	
	@Column(name = "RAZAOSOCIAL", length = 100, nullable = true)
	private String razaoSocial;
	
	@Column(name = "CNPJ", length = 14, nullable = true)
	private String cnpj;
	
	public ClientePJ(String nome, String cnpj, String endereco, String senha) {
		super(nome, cnpj, endereco, senha);
		this.razaoSocial = razaoSocial;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	
}
