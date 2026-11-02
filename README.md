# Tech Challenge Fase 2 - Sistema de Restaurante | Pós-Tech Java FIAP

> **Aluno:** Ronildo Mendes Viana  
> **Curso:** Pós-Tech em Arquitetura e Desenvolvimento Java  
> **Entrega:** Tech Challenge - Fase 2 (Individual)

---

## Links Rápidos
- **Vídeo de Apresentação:** [Assistir no YouTube](https://youtu.be/7AWTUO1mP3A)
- **Repositório GitHub:** [https://github.com/roni-viana/tech-challenge-fase2](https://github.com/roni-viana/tech-challenge-fase2)
- **Collection Postman:** Localizada na raiz do repositório (`./Postman - Tech Challenge - Fase 2.postman_collection.json`)

---

## Visão Geral do Projeto

Este projeto consiste na evolução do sistema de gestão para restaurantes, desenvolvido como entrega da Fase 2 da Pós-Tech da FIAP. A arquitetura foi concebida seguindo rigorosamente os princípios da **Clean Architecture**, com testes unitários automatizados cobrindo os casos de uso e orquestração de contêineres através de **Docker Compose**.

### Principais Funcionalidades:
- Cadastro e gestão de tipos de utilizador (Cliente e Proprietário/Dono).
- Cadastro e gestão de utilizadores com validação de perfil.
- Cadastro e gestão de restaurantes vinculados a um utilizador proprietário.
- Cadastro, atualização, consulta e exclusão de itens de cardápio vinculados a restaurantes.

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA & Hibernate**
- **PostgreSQL** (Banco de dados relacional)
- **Maven Wrapper**
- **Docker & Docker Compose** (Containerização completa)
- **JUnit 5 & Mockito** (Testes unitários)

---

## Arquitetura do Projeto (Clean Architecture)

A estrutura do projeto está modularizada em camadas concêntricas e isoladas:

```
src/main/java/com/postech/tech_challenge_fase2/
├── domain/                      # Regras de Negócio e Entidades Puras
│   └── entity/                  # Restaurante, Utilizador, ItemCardapio, TipoUsuario
├── application/                 # Casos de Uso e Portas
│   ├── usecases/                # Lógica de aplicação (Criar, Buscar, Listar, etc.)
│   ├── gateways/                # Contratos/Interfaces de abstração de dados
│   └── exception/               # Exceções de regras de negócio
└── infrastructure/              # Frameworks, Adaptadores e Configurações
    ├── controllers/             # REST Endpoints (Spring MVC)
    ├── persistence/             # Entidades JPA e Repositórios Spring Data
    ├── gateways/                # Implementação concreta dos Gateways
    ├── config/                  # Injeção manual de dependências dos UseCases
    └── exception/               # GlobalExceptionHandler (Padronização HTTP)
```

---

## Testes Automatizados

O projeto contém suíte de testes unitários com JUnit 5 e Mockito, validando os fluxos dos Casos de Uso, Controladores e Gateways.

Para executar todos os testes da aplicação:

```bash
./mvnw clean test
```

*(No Windows / Prompt de Comando, utilize: `mvnw.cmd clean test`)*

---

## Como Executar o Projeto com Docker

Toda a infraestrutura (API Java e banco de dados PostgreSQL) está containerizada e orquestrada para inicialização em lote.

### Pré-requisitos
- Docker Engine e Docker Compose instalados e em execução.

### 1. Iniciar os Serviços
Na raiz do projeto (onde reside o arquivo `docker-compose.yml`), execute:

```bash
docker compose up -d --build
```
*(ou `docker-compose up -d --build` caso utilize a sintaxe legada do Docker Compose)*

### 2. Acompanhar a Inicialização da API
Para verificar se a aplicação subiu corretamente e conectou ao banco de dados:

```bash
docker logs -f tech_challenge_app
```

### 3. Endereços de Acesso
- **URL Base da API:** `http://localhost:8080`
- **Documentação Swagger UI:** `http://localhost:8080/swagger-ui.html`

### 4. Encerrar o Ambiente e Limpar Volumes
Para parar a execução e remover os contêineres e volumes associados:

```bash
docker compose down -v
```

---

## Validação com Postman

A coleção com todas as rotas e payloads pré-configurados está inclusa diretamente na raiz do repositório:
- Arquivo: `Postman - Tech Challenge - Fase 2.postman_collection.json`

### Como importar:
1. Abra o Postman.
2. Clique no botão **Import** (canto superior esquerdo).
3. Selecione o arquivo `.json` localizado na pasta do projeto.

### Sequência recomendada de execução:
1. **Cadastrar Dono/Proprietário:** `POST /api/v1/utilizadores` (definindo `idTipoUsuario: 1`).
2. **Cadastrar Restaurante:** `POST /api/v1/restaurantes` (informando no payload o `idProprietario` gerado no passo 1).
3. **Cadastrar Item no Cardápio:** `POST /api/v1/itens-cardapio` (vinculando ao `idRestaurante` criado no passo 2).
4. **Consultas e Validações:** Executar as requisições `GET` para confirmar a persistência dos dados no banco PostgreSQL.
