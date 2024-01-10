package br.com.desafio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTA_ID", nullable = false)
    private Long contaId;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "AGENCIA", nullable = false)
    private String agencia;

    @Column(name = "SALDO", nullable = false)
    private double saldo;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    public Conta() {
    }

    public Conta(String agencia, double saldo, boolean status) {
        this.agencia = agencia;
        this.saldo = saldo;
        this.status = status;
    }

    public Long getContaId() {
        return contaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean isContaAtiva() {
        return status;
    }

    public void debitar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor a ser debitado deve ser maior que zero.");
            return;
        }
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Débito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o débito de R$" + valor + ".");
        }
    }

    public void creditar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor a ser creditado deve ser maior que zero.");
            return;
        }
        saldo += valor;
        System.out.println("Crédito de R$" + valor + " realizado com sucesso.");
    }
}
