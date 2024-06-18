# README - Projeto Agendei Microservices

## Sobre o Projeto

O Projeto Agendei é um sistema baseado em microserviços para gerenciamento de clínicas médicas, lavagens de carros e um gateway. O projeto utiliza Spring Boot e Docker para orquestrar os serviços.

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

O projeto está dividido em três microserviços principais:

- **Car Wash:** Gerenciamento de serviços de lavagem de carros.
- **Medical Appointment:** Gerenciamento de clínicas e consultas médicas.
- **Gateway:** Gateway para roteamento de solicitações entre os serviços.

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:
- JDK 17
- Docker e Docker Compose
- Maven (para gestão de dependências e build do projeto Java)

## Configuração e Instalação

1. **Clonar o repositório:**
   ```
   git clone [URL_DO_REPOSITORIO]
   cd agendei-backend-microservices-
   ```

2. **Construção dos serviços:**
   Cada microserviço precisa ser construído separadamente utilizando Maven.
   ```
   cd [nome_do_microservico]
   ./mvnw clean install
   ```

3. **Docker:**
   Utilize o Docker Compose para criar e iniciar todos os serviços:
   ```
   docker-compose up --build
   ```

## Uso

Após a inicialização dos serviços via Docker, os microserviços estarão disponíveis nos seguintes portos:

- **Car Wash:** http://localhost:8081
- **Medical Appointment:** http://localhost:8082
- **Gateway:** http://localhost:8083

## Documentação da API

Cada microserviço possui endpoints definidos para operações CRUD. 
Por exemplo, o microserviço Medical Appointment disponibiliza:

- **POST /clinics** - Adiciona uma nova clínica
- **GET /clinics** - Lista todas as clínicas
- **GET /clinics/{id}** - Detalhes de uma clínica específica
- **PUT /clinics/{id}** - Atualiza uma clínica existente
- **DELETE /clinics/{id}** - Remove uma clínica

O microserviço Car Wash disponibiliza:

- **POST /car-wash** - Adiciona uma nova officina
- **GET /car-wash** - Lista todas as oficinas
- **GET /car-wash/{id}** - Detalhes de uma oficina específica
- **PUT /car-wash/{id}** - Atualiza uma oficina existente
- **DELETE /car-wash/{id}** - Remove uma oficina

O microserviço Users disponibiliza:

- **POST /users** - Adiciona um novo user
- **GET /users** - Lista todos os users
- **GET /users/{id}** - Detalhes de um user específico
- **PUT /users/{id}** - Atualiza um user existente
- **DELETE /users/{id}** - Remove um user