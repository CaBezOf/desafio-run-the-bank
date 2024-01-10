package br.com.desafio.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import br.com.desafio.models.Cliente;
import br.com.desafio.models.Conta;
import br.com.desafio.repository.ClienteRepository;
import br.com.desafio.repository.ContaRepository;

@Service
public class ClienteService implements ApplicationRunner {
    private static final Logger LOGGER = Logger.getLogger(ClienteRepository.class.getName());

    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;

    public ClienteService(ClienteRepository clienteRepository, ContaRepository contaRepository) {
        this.clienteRepository = clienteRepository;
        this.contaRepository = contaRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long clienteId) {
        return clienteRepository.findById(clienteId);
    }

    public Cliente update(Long clienteId, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(clienteId);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNome(clienteAtualizado.getNome());

            return clienteRepository.save(cliente);
        } else {
            LOGGER.log(Level.INFO, "Cliente não encontrado");
            return null;
        }
    }

    public void delete(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
    

    public Cliente associarConta(Long clienteId, Conta novaConta) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(clienteId);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();

            if (cliente.getClienteid() == null) {
                clienteRepository.save(cliente);
            }

            novaConta.setCliente(cliente);
            cliente.getContas().add(novaConta);
            contaRepository.save(novaConta);
            return cliente;
        } else {
            LOGGER.log(Level.INFO, "Cliente ou Conta não encontrado");
            return null;
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var cliente = new Cliente("Rodrigo Valle Barancelli", "22438900032", "Rua legal", "123456");
        var conta = new Conta("11245", 123, true);

        cliente.setNome("aba");
        cliente.setCpf("123456");
        cliente.setEndereco("sadsadasd");
        cliente.setSenha("123456");

        conta.setAgencia("456465");
        conta.setSaldo(456);
        conta.setStatus(true);
        conta.setCliente(cliente);

        LOGGER.log(Level.INFO, "Persist");
        clienteRepository.save(cliente);
        LOGGER.log(Level.INFO, cliente.toString());

        LOGGER.log(Level.INFO, "Find");
        clienteRepository.findById(cliente.getClienteid()).ifPresent(it -> {
            LOGGER.log(Level.INFO, cliente.toString());
        });

        LOGGER.log(Level.INFO, "Persist");
        contaRepository.save(conta);
        LOGGER.log(Level.INFO, conta.toString());

        LOGGER.log(Level.INFO, "Find");
        contaRepository.findById(conta.getContaId()).ifPresent(it -> {
            LOGGER.log(Level.INFO, conta.toString());
        });
    }
}
