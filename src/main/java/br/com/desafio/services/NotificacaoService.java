package br.com.desafio.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import br.com.desafio.models.Conta;

@Service
public class NotificacaoService {
	
	protected void notificarClientes(Conta contaOrigem, Conta contaDestino) {

    	String endpointURL = "https://run.mocky.io/v3/9769bf3a-b0b6-477a-9ff5-91f63010c9d3";

        try {
            URL url = new URL(endpointURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                System.out.println("Notificação externa: " + response.toString());
            }
        } catch (IOException e) {
            System.err.println("Falha na notificação externa: " + e.getMessage());
        }
    }
	
}	
