package br.com.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.models.Cliente;
import br.com.desafio.models.Conta;
import br.com.desafio.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteControllers {
	@Autowired
	private ClienteService services;
	
	@RequestMapping(method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findAll() {
		return services.findAll();
	}
	
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public Optional<Cliente> findById(@PathVariable("id")Long id) {
		return services.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public Cliente create(@RequestBody Cliente cliente) {
		return services.create(cliente);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public Cliente update(@RequestBody Long id, Cliente cliente) {
		return services.update(id, cliente);
	}
	
	@RequestMapping(value="delete/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable("id")Long id) {
		services.delete(id);
	}
	
	@RequestMapping(value = "/{clienteId}/associar-conta", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente associarConta(@PathVariable("clienteId") Long clienteId, @RequestBody Conta conta) {
        return services.associarConta(clienteId, conta);
    }
}
