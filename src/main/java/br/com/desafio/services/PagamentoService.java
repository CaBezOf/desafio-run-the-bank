package br.com.desafio.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import br.com.desafio.models.Conta;


@Service
public class PagamentoService {
	
    private ValidacaoService validacaoService;
    
    private NotificacaoService notificacaoService;


    public void realizarPagamento(Conta contaOrigem, Conta contaDestino, double valor) {
        if (!validacaoService.validarTransferencia(contaOrigem, contaDestino, valor)) {
            System.out.println("Pagamento não pode ser realizado. Operação inválida");
            return;
        }

        contaOrigem.debitar(valor);

        contaDestino.creditar(valor);

        notificacaoService.notificarClientes(contaOrigem, contaDestino);

        System.out.println("Pagamento de R$" + valor + " realizado com sucesso.");
    }

    

    public void reverterPagamento(Conta contaOrigem, Conta contaDestino, double valor) {
        contaOrigem.creditar(valor);
        contaDestino.debitar(valor);

        notificacaoService.notificarClientes(contaOrigem, contaDestino);

        System.out.println("Pagamento de R$" + valor + " revertido com sucesso.");
    }
	
}
