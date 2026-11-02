# Etapa de Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
# Baixa as dependências primeiro para aproveitar o cache do Docker
RUN mvn dependency:go-offline
COPY src ./src
# Compila a aplicação ignorando os testes para ser mais rápido
RUN mvn clean package -DskipTests

# Etapa de Execução
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copia o ficheiro .jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]