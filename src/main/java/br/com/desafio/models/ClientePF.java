package br.com.desafio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class ClientePF extends Cliente {
	
	@Column(name = "CPF", length = 14, nullable = true)
	private String cpf;
	
	public ClientePF(String nome, String cpf, String endereco, String senha) {
		super(nome, cpf, endereco, senha);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
