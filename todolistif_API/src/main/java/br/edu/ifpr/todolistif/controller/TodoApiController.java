package br.edu.ifpr.todolistif.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpr.todolistif.dto.TodoCompletionRequestDTO;
import br.edu.ifpr.todolistif.dto.TodoRequestDTO;
import br.edu.ifpr.todolistif.dto.TodoResponseDTO;
import br.edu.ifpr.todolistif.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    private final TodoService service;

    public TodoApiController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TodoResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/concluidas")
    public List<TodoResponseDTO> listarConcluidas() {
        return service.listarConcluidas();
    }

    @GetMapping("/pendentes")
    public List<TodoResponseDTO> listarPendentes() {
        return service.listarPendentes();
    }

    @PostMapping
    public ResponseEntity<TodoResponseDTO> cadastrar(@RequestBody TodoRequestDTO dados) {
        TodoResponseDTO resposta = service.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/conclusao")
    public ResponseEntity<TodoResponseDTO> concluir(
            @PathVariable Long id,
            @RequestBody TodoCompletionRequestDTO dados) {
        return ResponseEntity.ok(service.concluir(id, dados));
    }
}
