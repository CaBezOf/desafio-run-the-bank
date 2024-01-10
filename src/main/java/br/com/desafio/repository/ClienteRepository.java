package br.com.desafio.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
