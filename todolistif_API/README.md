# API de tarefas

API REST de tarefas feita com Spring Boot. A aplicação usa MySQL e, por padrão,
fica disponível em `http://localhost:8080`.

## Requisições

### Cadastrar uma tarefa

`POST /api/todos`

```json
{
  "title": "Estudar Spring Boot",
  "deadLine": "2026-10-30T18:00:00"
}
```

Retorna `201 Created` e os dados da tarefa. O banco gera o `id`, a aplicação
preenche `createdAt` e `finishedAt` começa como `null`.

### Listar todas, concluídas ou pendentes

- `GET /api/todos`
- `GET /api/todos/concluidas`
- `GET /api/todos/pendentes`

As listas retornam `200 OK`. Uma busca sem resultados retorna `[]`.

### Informar a conclusão

`PATCH /api/todos/1/conclusao`

```json
{
  "finishedAt": "2026-10-22T10:30:00"
}
```

Retorna `200 OK` com a tarefa atualizada, incluindo `finishedAt`.

### Excluir uma tarefa

`DELETE /api/todos/1`

Retorna `204 No Content`, sem corpo.

## Organização dos DTOs

`TodoRequestDTO` recebe apenas o título e o prazo ao cadastrar.

`TodoCompletionRequestDTO` recebe a data de conclusão ao concluir uma tarefa.

`TodoResponseDTO` é usado nas respostas e inclui `finishedAt`, para que o cliente
possa conferir a data registrada. Assim, os dados que o cliente pode enviar ficam
separados dos dados que a API devolve.

## Caminho de uma requisição

O Controller recebe a rota e escolhe o status HTTP. Ele chama a Service, que
aplica a operação e transforma os resultados em DTOs. Quando precisa ler ou
salvar tarefas, a Service usa o Repository, que conversa com o banco de dados.