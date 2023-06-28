# CRUD de produtos

# 🚀 Desafio Backend Java com SpringBoot

Desafio referente à uma API RESTful que permite criar, editar, buscar e excluir produtos.

---

- [Requisitos](#requisitos)
- [Critérios de Avaliação](#criterios-avaliacao)
- [Instruções](#instruções)

### Requisitos

- Usuários: 
	- Cada produto deve ter um id, nome, valor;
	- A API deve permitir a criação de um novo produto;
	- A API deve permitir a atualização de um produto existente;
	- A API deve permitir buscar um produto existente;
	- A API deve permitir a exclusão de um produto existente;
	- A API deve permitir a listagem de todos os produtos com os respectivos dados(id, nome, valor).
  
  <a id="criterios-avaliacao"></a>
## Critérios de Avaliação

-   Usar o Spring Data para acessar o banco de dados e fazer o mapeamento dos relacionamentos;
-   Escolher o banco de dados que preferir, mas deve usar o Spring Data para acessá-lo;
-   Escolher a estrutura de pacotes que preferir, mas tente seguir as convenções do Spring Boot;
-   Usar o Maven ou o Gradle como gerenciador de dependências e construção;
-   A API deve seguir as práticas RESTful, incluindo o uso adequado dos verbos HTTP (POST, GET, PUT, DELETE) e códigos de status;
-   Deve seguir as boas práticas do Clean Code, mantendo seu código limpo, organizado e fácil de ler.

## Instruções
### Aplicação e suas dependências:
- Java 17.0.7
- Spring Boot 3.1.1
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-data-jdbc
- spring-boot-devtools
- h2-database

##EndPoint
- POST http://localhost:8000/produto/criar;
  Será enviado no body o JSON de exemplo com as informações produto:{"nome": "cinto", "valor": 40};
- PUT http://localhost:8000/produto/editar/idProduto(endpoint para editar o produto com id informado)
  Será enviado no body o JSON de exemplo com o id do produto informado:{"nome": "sapato", "valor": 20};
- DEL http://localhost:8000/produto/deletar/idProduto(endpoint para deletar o produto com id informado);
- GET http://localhost:8000/produto/buscar/idProduto(endpoint para buscar o produto com id informado);
- GET http://localhost:8000/produto/buscar/(buscará todos os produtos no database).

| componente | porta |
| --------- | ----------- |
| H2 DataBase Console  | `http://localhost:8000/h2-console` |


application.properties foi configurado para apontar para o banco local h2:
```
server.port=8000
spring.datasource.url=jdbc:h2:mem:catalogodeproduto;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false
spring.jpa.defer-datasource-initialization=true
