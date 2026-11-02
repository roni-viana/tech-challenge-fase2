# Tech Challenge Fase 2 - Sistema de Restaurante

Este projeto é a entrega da Fase 2 do Tech Challenge, cujo objetivo é construir a base de um sistema de gestão de restaurante seguindo os princípios de Clean Architecture.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 4.1.2
- PostgreSQL
- Maven
- Docker & Docker Compose
- JUnit 5 & Mockito (Testes Unitários)

## Arquitetura
O projeto foi desenvolvido seguindo a **Clean Architecture**, dividindo o código em camadas isoladas:
1. **Domain:** Entidades de negócio puro (Restaurante, Utilizador, ItemCardapio, TipoUsuario).
2. **Application:** Casos de Uso (Regras de negócio) e Interfaces (Gateways) para inversão de dependência.
3. **Infrastructure:** Detalhes de implementação, como Controladores REST (Spring MVC), Repositórios (Spring Data JPA) e configurações de injeção de dependências.

## Como Executar o Projeto com Docker

O projeto já está configurado para subir a aplicação e o banco de dados simultaneamente utilizando o Docker Compose.

1. Certifique-se de ter o Docker Desktop instalado e em execução.
2. Abra o terminal na raiz do projeto (onde está o `docker-compose.yml`).
3. Execute o comando:
   ```bash
   docker-compose up -d --build