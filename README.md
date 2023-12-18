# desafio-brickup
<h1 align="center">
  Lista de tarefas
</h1>

API para gerenciar tarefas (CRUD) desenvolvido para realização de desafio-teste para a empresa Brickup.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3
- Testes automatizados

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/):

- Criar Tarefa 
```
$ http POST :8080/api/tasks, {"title": "Desc Task 1", "Description": "Descrip. Task 1", "completed": false, "image": null}

[
  {
    "id": 1,
    "title": "Desc Task 1",
    "description": "Descrip. Task 1",
    "completed": false,
    "image": null
  }
]
```

- Listar Tarefas
```
$ http GET :8080/api/tasks

[
  {
    "id": 1,
    "title": "Desc Task 1",
    "description": "Descrip. Task 1",
    "completed": false,
    "image": null
  }
]
```

- Atualizar Tarefa
```
$ http PUT :8080/api/tasks/1

[
  {
    "id": 1,
    "title": "Desc Task 1 Att",
    "description": "Descrip. Task 1 Att",
    "completed": false,
    "image": "kajsxmaoaps0s9wiwkaskdmda"
  }
]
```

- Remover Tarefa
```
http DELETE :8080/api/tasks/1

[ ]
```

## Documentação Swagger

![image](https://github.com/rafaaellguimaraes/desafio-brickup/assets/52210750/d5cdeab7-c23c-4783-b813-ac35b65292fd)
