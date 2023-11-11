# TheX - Clients API

Este é um projeto Spring Boot gerado com base nas seguintes configurações:

- **Gerenciador de Projeto:** Maven
- **Linguagem:** Java
- **Spring Boot Versão:** 3.1.5

## Visão Geral

O projeto TheX - Clients API faz parte do ecossistema Market-TheX e é responsável pelo gerenciamento de clientes. Sua principal finalidade é fornecer uma API para o cadastro e administração de informações sobre os clientes da plataforma.

## Dependências

O projeto utiliza as seguintes dependências do Spring Boot:

- **Spring Web:** Responsável por construir aplicativos web, incluindo aplicativos RESTful, usando o Spring MVC. Utiliza o Apache Tomcat como o contêiner embarcado padrão. [Mais informações][1]

- **Spring Data JPA:** Utilizado para persistir dados em bancos de dados SQL usando o Spring Data e Hibernate. [Mais informações][2]

- **Spring Boot DevTools:** Fornece reinicializações rápidas de aplicativos, LiveReload e configurações para aprimorar a experiência de desenvolvimento. [Mais informações][3]

- **Validation:** Utiliza a validação de beans com o Hibernate Validator. [Mais informações][4]

- **Lombok:** Uma biblioteca de anotações Java que ajuda a reduzir a quantidade de código boilerplate. [Mais informações][5]

- **Flyway Migration:** Utilizado para controle de versão do banco de dados e migrações de esquema. [Mais informações][6]

- **SQLite JDBC:** Um driver JDBC para o SQLite, que permite a interação com bancos de dados SQLite em projetos Java. [Detalhes][7]

- **Spring Boot Starter Test:** Fornece suporte para a criação de testes unitários e de integração em projetos Spring Boot. Ela inclui bibliotecas comuns de teste, configurações de ambiente de teste e utilitários para facilitar a escrita de testes. [Mais informações][8]

[1]: https://docs.spring.io/spring-boot/docs/current/reference/html/web.html
[2]: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
[3]: https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools
[4]: https://hibernate.org/validator/
[5]: https://projectlombok.org/features/all
[6]: https://flywaydb.org/documentation/
[7]: https://github.com/xerial/sqlite-jdbc
[8]: https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-test-auto-configuration.html

## Como Iniciar

1. Faça o clone deste repositório.

2. Importe o projeto em sua IDE de desenvolvimento (por exemplo, IntelliJ IDEA, Eclipse).

3. Configure um banco de dados e ajuste as configurações de conexão em `application.properties`.

4. Execute o projeto e acesse a API de clientes através da URL: `http://localhost:8080/api/clientes`.

### Exemplos de Uso

1. **`POST http://[HOST]/clients`**
    - **Descrição**: Para registrar um novo cliente, faça uma solicitação POST com os detalhes do client no corpo da solicitação.

2. **`GET http://[HOST]/clients/{clientID}`**
    - **Descrição**: Faça uma solicitação GET para recuperar informações sobre um cliente específico.

3. **`GET http://[HOST]/clients`**
    - **Descrição**: Faça uma solicitação GET para listar todos os clients.

4. **`PUT http://[HOST]/clients/{clientID}`**
    - **Descrição**: Faça uma solicitação PUT com os detalhes do cliente no corpo da solicitação para atualizar as informações de um cliente.

5. **`DELETE http://[HOST]/clients/{clientID}`**
    - **Descrição**: Faça uma solicitação DELETE para excluir um client.

6. **`GET http://[HOST]/health`**
    - **Descrição**: Faça uma solicitação GET para verificar a saúde do sistema.