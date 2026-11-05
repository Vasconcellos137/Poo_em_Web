15.10.26     POO - Roberta

- o que diferencia a aplicação mvc com relação a API é o view -> a maneira como é feita a troca de conteúdos.
- O recurso utilizado pra fazer essa troca, por exemplo a troca via Json


# MVC

model _@Entity

Controller _@Controller

repository

view
  -html
  -css
  -img

Comp - html ---> Request ---> TOMCAT - MySQL ---> Request ---> Comp - html

# APIs

Cliente (Cell, TV, Comp) --> Request --> BD --> Resp - Json --> Cliente

# Camadas
  -Controller
  -Service
  -DTOs

---

# Atividade
## Questões a serem respondidas - Meu tema é Controller

O q controller MVC devolve ao navegador ?
O q muda com @RestController ?
Como receber JSON em POST/api/todos ?
Quais responsabilidades pertencem ao Service ?

---

- Lombok oferece anotações a mais para deixar o java menos verboso, mais curto.
