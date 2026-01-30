package com.backend.service;

import com.backend.model.Servico;
import com.backend.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    public Optional<Servico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Servico salvar(Servico servico) {
        if (servico.getConcluido() == null) {
            servico.setConcluido(false);
        }
        return repository.save(servico);
    }

    public void deletar(Long id) {
        repository.deleteById((id));
    }

    public List<Servico> buscarPorConcluido(Boolean concluido) {
        return repository.findByConcluido(concluido);
    }

    public boolean concluirServico(Long id) {
        Optional<Servico> optionalServico = repository.findById(id);
        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            servico.setConcluido(true);
            repository.save(servico);
            return true;
        }
        return false;
    }
}
