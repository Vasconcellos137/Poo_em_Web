package br.edu.ifpr.todolistif.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.edu.ifpr.todolistif.dto.TodoCompletionRequestDTO;
import br.edu.ifpr.todolistif.dto.TodoRequestDTO;
import br.edu.ifpr.todolistif.dto.TodoResponseDTO;
import br.edu.ifpr.todolistif.model.Todo;
import br.edu.ifpr.todolistif.repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoResponseDTO> listar(){
        List<Todo> tarefas = repository.findAll();
        List<TodoResponseDTO> resposta = new ArrayList<>();

        for (Todo tarefa : tarefas) {
            TodoResponseDTO dto = new TodoResponseDTO(tarefa);
            resposta.add(dto);
        }

        return resposta;
    }

    public TodoResponseDTO cadastrar(TodoRequestDTO dados) {
        Todo tarefa = new Todo();
        tarefa.setTitle(dados.getTitle());
        tarefa.setDeadLine(dados.getDeadLine());
        return new TodoResponseDTO(repository.save(tarefa));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public TodoResponseDTO concluir(Long id, TodoCompletionRequestDTO dados) {
        Todo tarefa = repository.findTodoById(id);
        if (tarefa == null) {
            throw new NoSuchElementException("Tarefa não encontrada: " + id);
        }

        tarefa.setFinishedAt(dados.getFinishedAt());
        return new TodoResponseDTO(repository.save(tarefa));
    }

    public List<TodoResponseDTO> listarConcluidas() {
        List<Todo> tarefas = repository.findByFinishedAtIsNotNull();
        List<TodoResponseDTO> resposta = new ArrayList<>();

        for (Todo tarefa : tarefas) {
            TodoResponseDTO dto = new TodoResponseDTO(tarefa);
            resposta.add(dto);
        }

        return resposta;
    }

    public List<TodoResponseDTO> listarPendentes() {
        List<Todo> tarefas = repository.findByFinishedAtIsNull();
        List<TodoResponseDTO> resposta = new ArrayList<>();

        for (Todo tarefa : tarefas) {
            TodoResponseDTO dto = new TodoResponseDTO(tarefa);
            resposta.add(dto);
        }

        return resposta;
    }

}
