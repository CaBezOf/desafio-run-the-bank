package br.com.desafio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteid;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Conta> contas = new ArrayList<>();

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "ENDERECO", length = 100, nullable = false)
    private String endereco;

    @Column(name = "SENHA", length = 15, nullable = false)
    private String senha;

    @Column(name = "CPF", length = 14)
    private String cpf;

    @Column(name = "CNPJ", length = 14)
    private String cnpj;

    @Column(name = "RAZAOSOCIAL", length = 50)
    private String razaoSocial;

    public Cliente(String nome, String cpfCnpj, String endereco, String senha) {
        this.nome = nome;
        setDocumento(cpfCnpj);
        this.endereco = endereco;
        this.senha = senha;
    }

    public Cliente() {
    }

    public Long getClienteid() {
        return clienteid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    private void setDocumento(String cpfCnpj) {
        if (cpfCnpj.length() == 11) {
            this.cpf = cpfCnpj;
        } else if (cpfCnpj.length() == 14) {
            this.cnpj = cpfCnpj;
        } else {
            throw new IllegalArgumentException("CPF/CNPJ inválido: " + cpfCnpj);
        }
    }
}
