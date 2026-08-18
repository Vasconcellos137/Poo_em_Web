# POO na Web

## Request 
- Métodos pra realizar no HTML: GET, POST, PUT, PATCH, PET ...
- Existem métodos http pra cada coisa que precisar fazer no bagulho

## Framework Spring
- Biblioteca/conjunto de diversos frameworks para diversos casos, é um framework q conecta todas as suas variantes.
- Facilita a vida em relação a esse processo.

# Site Home: https://spring.io/ 

## Spring Boot 
- Facilita utilização do Spring num geral.

# Ferramenta p/ criar um porjeto Spring: https://start.spring.io/

# Configurações Spring Initializer:
Project: Maven
Language: Java
Spring Boot: 4.1.0
Group: br.edu.ifpr -> Dominnio ao contrario
Artifact: ToDoListIF -> Nome do projeto
Package name -> Junção dos anteriores
Packaging: Jar
Configuration: Properties
Java: 21

Dependencies:
Spring Data JPA;
MySQL Driver SQL;
Spring Boot DevTools;
Spring Web;
Thymeleaf;
Lombok.

# ProjetoSpring
- Pasta resources -> Conexão frontend

Padrão de organização:
- model -> Classes de entidade, ou conjunto de classes que compõem o BD -> Aqui divide em 2, modelo e repositório (model e repository).
- view -> Fica em resources, contém html, css, imagem.
- controller -> meio de campo entre camada web, repositório e modelo. Recebe requisições e gera resposta.

- Pode-se utilizar frameworcks de vários tipos diferentes pra um mesmo programa.
- 