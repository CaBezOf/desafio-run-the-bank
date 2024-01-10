package br.com.desafio.services;

import org.springframework.stereotype.Service;

import br.com.desafio.models.Conta;

@Service
public class TransferenciaService {
	
	public void reverterTransferencia(Conta contaOrigem, Conta contaDestino, double valorTransferencia) {
        if (contaDestino.getSaldo() < valorTransferencia) {
            System.out.println("A conta de destino não possui saldo suficiente para reverter a transferência.");
            return;
        }

        contaDestino.debitar(valorTransferencia);
        contaOrigem.creditar(valorTransferencia);

        System.out.println("Transferência revertida com sucesso.");
    }
}
