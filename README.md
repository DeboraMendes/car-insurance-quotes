# Car Insurance Quote

Aplicação responsável por orçamentos de seguro de carros.

## Requirements

Para buildar e executar a aplicação, você precisa ter baixado e configurado:

- [JDK 17](https://www.oracle.com/br/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org)

## Build application
```shell
cd car-insurance-quotes
mvn install
```

## Run application

Existem várias maneiras de executar uma aplicação Spring Boot em sua máquina local.

Uma maneira é executar o método `main` na classe `br.com.audsat.carinsurancequotes.CarInsuranceQuotesApplication` do seu IDE.

## H2 database

O H2 oferece suporte a vários modos de conexão e configurações de conexão.

A aplicação utiliza o formato In-memory (private).

Para acessar a UI do H2 utilize:

- [H2 Console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:audsat`
- User Name: `sa`
- Password: `password`

## OpenAPI 3.0

A aplicação utiliza o Swagger 3 como implementação da especificação OpenAPI 3.

Para acessar a UI do Swagger utilize:

- [Swagger](http://localhost:8080/swagger-ui/index.html#/)

## Architectural diagram

A arquitetura da aplicação e do banco de dados podem ser consultados em:

```shell
cd car-insurance-quotes\src\main\resources\architectural\diagram
```
