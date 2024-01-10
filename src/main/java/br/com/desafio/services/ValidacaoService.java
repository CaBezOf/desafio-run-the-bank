package br.com.desafio.services;

import org.springframework.stereotype.Service;

import br.com.desafio.models.Conta;


@Service
public class ValidacaoService {

	public boolean validarTransferencia(Conta contaOrigem, Conta contaDestino, double valorTransferencia) {
		if(!contaOrigem.isContaAtiva()) {
			System.out.println("A conta está inativa. A transferência não pode ser realizada");
			return false;
		}
		
		if (!contaDestino.isContaAtiva()) {
            System.out.println("A conta de destino está inativa. A transferência não pode ser realizada.");
            return false;
        }
		
		if(contaOrigem.getSaldo() < valorTransferencia) {
			System.out.println("A conta não possui saldo suficiente para realizar a transferência.");
			return false;
		}
		
		return true;
	}
	
	
	
	
}
