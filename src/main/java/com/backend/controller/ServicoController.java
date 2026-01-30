package com.backend.controller;

import com.backend.model.Servico;
import com.backend.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin(origins = "*")
public class ServicoController {

    private final ServicoService service;

    public ServicoController(ServicoService service) {
        this.service = service;
    }

    // LISTAR TODOS OU FILTRAR POR CONCLUÍDO
    @GetMapping
    public ResponseEntity<List<Servico>> listar(
            @RequestParam(required = false) Boolean concluido
    ) {
        List<Servico> servicos = (concluido != null)
                ? service.buscarPorConcluido(concluido)
                : service.listarTodos();

        return ResponseEntity.ok(servicos);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CRIAR SERVIÇO
    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody Servico servico) {
        Servico salvo = service.salvar(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // ATUALIZAR SERVIÇO
    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(
            @PathVariable Long id,
            @RequestBody Servico servicoAtualizado
    ) {
        Optional<Servico> existente = service.buscarPorId(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        servicoAtualizado.setId(id);
        Servico salvo = service.salvar(servicoAtualizado);
        return ResponseEntity.ok(salvo);
    }

    // DELETAR SERVIÇO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Servico> existente = service.buscarPorId(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // CONCLUIR SERVIÇO
    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Void> concluir(@PathVariable Long id) {
        boolean concluido = service.concluirServico(id);

        if (concluido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
