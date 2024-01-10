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
import br.com.desafio.services.ContaService;
import br.com.desafio.services.ValidacaoService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	@Autowired
	private ContaService services;
	
	@RequestMapping(method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Conta> findAll() {
		return services.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public Conta create(@RequestBody Conta conta) {
		return services.create(conta);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public Conta update(@RequestBody Long id, Conta conta) {
		return services.update(id, conta);
	}
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable("id")Long id) {
		services.delete(id);
	}
	
}
