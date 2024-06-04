# ProjetoAgendei API Microservices

## Descrição
Este projeto fornece uma API REST usando arquitetura em microservices para o sistema de agendamento `ProjetoAgendei`, permitindo operações de CRUD para gerenciamento de agendamentos de diversos tipos de serviços. A API está construída utilizando Java Spring Boot 3.

## Estrutura do Projeto
Aqui está a estrutura de diretórios do projeto:

- `src/main/java/com/agendei/projetoagendei`: Contém o código fonte do projeto.
  - `controller`: Camada de controladores que gerenciam as requisições HTTP.
  - `dtos`: Data Transfer Objects usados para transferir dados entre subcamadas.
  - `model`: Classes de modelo que representam as entidades do negócio.
  - `repository`: Interfaces do Spring Data JPA para interação com a base de dados.
  - `service`: Camada de serviços que contém a lógica de negócios.
- `ProjetoAgendeiApplication.java`: Classe principal que inicia a aplicação Spring Boot.
- `resources`: Contém arquivos de recursos como configurações de aplicação e mensagens.
  - `service`: Camada de serviços que contém a lógica de negócios.
- `test`: Diretório para testes unitários e de integração.

## Pré-requisitos
- Java JDK 11 ou superior
- Maven 3.6 ou superior

## Configuração e Instalação
1. Clone o repositório do projeto:
   ```
   git clone https://github.com/Barros7/agendei
   ```
2. Navegue até o diretório do projeto e instale as dependências:
   ```
   mvn install
   ```
3. Execute a aplicação:
   ```
   mvn spring-boot:run
   ```

## Uso
Para interagir com a API, você pode utilizar ferramentas como Reqbin, Insomnia, Postman ou cURL. Exemplo de requisição para listar utilizadores:
```
curl -X GET http://localhost:8080/users
```