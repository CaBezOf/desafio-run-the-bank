package br.com.desafio.services;

import java.util.ArrayList;
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
public class ContaService implements ApplicationRunner {
    private static final Logger LOGGER = Logger.getLogger(ClienteRepository.class.getName());

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public Conta create(Conta conta) {
        return contaRepository.save(conta);
    }

    public Optional<Conta> findById(Long contaId) {
        return contaRepository.findById(contaId);
    }

    public Conta update(Long contaId, Conta contaAtualizada) {
        Optional<Conta> contaExistente = contaRepository.findById(contaId);

        if (contaExistente.isPresent()) {
            Conta conta = contaExistente.get();
            conta.setSaldo(contaAtualizada.getSaldo());
            conta.setStatus(contaAtualizada.getStatus());

            return contaRepository.save(conta);
        } else {
            LOGGER.log(Level.INFO, "Conta não encontrada");
            return null;
        }
    }

    public void delete(Long contaId) {
        contaRepository.deleteById(contaId);
    }

    public Conta criarContaComCliente(Conta novaConta, Cliente cliente) {
        if (cliente.getClienteid() == null) {
            clienteRepository.save(cliente);
        }

        novaConta.setCliente(cliente);
        cliente.getContas().add(novaConta);
        contaRepository.save(novaConta);
        return novaConta;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var conta = new Conta("11245", 123, true);
        var conta2 = new Conta("115245", 555, true);
        var cliente = new Cliente("Rodrigo Valle Barancelli", "22438900032", "Rua legal", "123456");
        List<Conta> contas = new ArrayList<>();
        contas.add(conta);
        contas.add(conta2);

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
