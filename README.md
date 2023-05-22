# Car Insurance Quote

Teste técnico da [Audsat](https://audsat.com.br/pt) para desenvolvedor back-end 2023:
Aplicação responsável por orçamentos de seguro de carros.

---
## Technical test

### Prazo

O prazo de devolução é de 3 dias corridos, ou seja, até o dia 22/05/2023 (segunda-feira).

### Pontos de Avaliação

1. Desenvolvimento Java e uso de suas bibliotecas
2. Uso de conceitos de OOP
3. Uso de conceitos SOLID
4. Uso de conceitos Design Patterns
5. Criação de serviços REST
6. Construção de Testes Unitários
7. Organização de projeto e clean code
8. Uso de ferramentas de versionamento da aplicação
9. Diagramação da Arquitetura


### Diferenciais

1. Uso de Clean Architecture 
2. Configuração do projeto com gradle 
3. Testes de Integração 
4. Conteinerização da Aplicação 
5. Autenticação de Serviços


### História de usuário

**Como**

Cliente da seguradora

**Quero**

Que seja construído um pacotes de serviços referente a orçamentos de seguro de carros

**Para**

Que com estes serviços possamos disponibilizar informações sobre precificação de seguros


### Regras de Negócio

O orçamento do seguro deve ser calculado com base em algumas premissas, estas premissas serão listadas a seguir:

- O valor base de cálculo do orçamento é de 6% com base no valor da tabela fipe do veículo
- Quanto maior o risco maior será o valor do seguro e para cada item de risco mapeado 2% a mais será acrescentado na base de cálculo. 
São estes os riscos que devem ser mapeados:
  - O motorista principal se encontra na faixa etária de 18 a 25 anos.
  - O motorista possui sinistro em seu nome.
  - O veículo ao qual será segurado possui sinistro.

**Exemplo**

orçamento = 6% da fipe

Motorista principal se encontra na faixa etária de 18 a 25 anos = true

orçamento += 2% da fipe (orçamento = 8%)

O motorista possui sinistro em seu nome = true

orçamento += 2% da fipe (orçamento = 10%)

O veículo ao qual será segurado possui sinistro = false

Neste caso o orçamento continua em 10% da fipe pois este risco está marcado como false.

Resultado
orçamento = 10% da fipe

### REST

#### Cadastro de orçamento

DEFINA O VERBO HTTP - /insurance/budget

Request Payload

DEFINA O PAYLOAD DA REQUISIÇÃO

Response Payload

DEFINA O PAYLOAD DA RESPOSTA

#### Consulta de orçamento

DEFINA O VERBO HTTP - /insurance/budget/:insuranceId

Request Payload

DEFINA O PAYLOAD DA REQUISIÇÃO

Response Payload

DEFINA O PAYLOAD DA RESPOSTA

**Observação**

Nesta consulta é importante retornar os dados do orçamento e o valor calculado.

### Atualização de orçamento

DEFINA O VERBO HTTP - /insurance/budget/:insuranceId

Request Payload

DEFINA O PAYLOAD DA REQUISIÇÃO

Response Payload

DEFINA O PAYLOAD DA RESPOSTA


#### Remoção de orçamento

DEFINA O VERBO HTTP - /insurance/budget/:insuranceId

Request Payload

DEFINA O PAYLOAD DA REQUISIÇÃO

Response Payload

DEFINA O PAYLOAD DA RESPOSTA

### Entregáveis

Para esta tarefa o candidato deverá se comprometer com os seguintes integráveis:

1. Entrega do código - para este entregável o ideal é que o candidato disponibilize o código-fonte via repositório público (github, gitlab, bitbucket, etc.). Criar um histórico de commits com bons comentários ajudará na pontuação. 
2. Diagrama Arquitetural - Realizar um diagrama arquitetural de integração do sistema construído com o sistema de uma corretora hipotética para o nosso cenário. Quanto mais detalhada a diagramação melhor será a pontuação. O diagrama poderá ser entregue em jpeg ou png dentro do próprio repositório do código. 
3. Documento de Configuração e Inicialização - O projeto deverá contar com um arquivo README com as informações para configurar e executar o código. 
4. Documento de APIs - Este item é opcional mas ajudará na sua avaliação. Ainda dentro do projeto um candidato deverá disponibilizar uma documentação em YAML utilizando a especificação OpenAPI 3.0.

---


## Architectural diagram

A arquitetura da aplicação e do banco de dados podem ser consultados em:

```shell
cd car-insurance-quotes\src\main\resources\architectural\diagram
```

O arquivo `car-insurance-quotes.pdf` contém os seguintes diagramas arquiteturais:

1. Cadastro de orçamento
2. Consulta de orçamento
3. Atualização de orçamento
4. Remoção de orçamento
5. Modelagem da Aplicação


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

## Test scenarios

### Test scenario 1

**Exemplo citado no item Regras de Negócio.**

O orçamento se encaixa em dois dos três itens de risco.

Riscos:

Motorista principal se encontra na faixa etária de 18 a 25 anos = true

O motorista possui sinistro em seu nome = true

O veículo ao qual será segurado possui sinistro = false

Resultado:

10% da fipe.

```json
{
  "id": 1,
  "customer": {
    "id": 1,
    "name": "Renata Maldonado",
    "driver": {
      "id": 1,
      "document": "38545528201",
      "birthdate": "2000-05-20",
      "yearsOld": 23,
      "mainDriver": true,
      "hasClaim": true
    }
  },
  "creationDt": "2023-05-21T19:26:55.51836",
  "updatedAt": null,
  "car": {
    "id": 1,
    "model": "Strada Opening Edition 1.3 Flex 8V Cd",
    "manufacturer": "Fiat",
    "year": 2003,
    "fipeValue": 22780.00,
    "hasClaim": false,
    "drivers": [
      {
        "id": 1,
        "document": "38545528201",
        "birthdate": "2000-05-20",
        "yearsOld": 23,
        "mainDriver": true,
        "hasClaim": true
      }
    ]
  },
  "isActive": true,
  "fipePercentage": 10.00,
  "amount": 2278.00
}
```

### Test scenario 2

O orçamento se encaixa em todos os três itens de risco.

Riscos:

Motorista principal se encontra na faixa etária de 18 a 25 anos = true

O motorista possui sinistro em seu nome = true

O veículo ao qual será segurado possui sinistro = true

Resultado:

12% da fipe.

```json
{
  "id": 2,
  "customer": {
    "id": 2,
    "name": "Eduarda Bosco",
    "driver": {
      "id": 2,
      "document": "93461350030",
      "birthdate": "2000-05-20",
      "yearsOld": 23,
      "mainDriver": true,
      "hasClaim": true
    }
  },
  "creationDt": "2023-05-21T19:27:58.979603",
  "updatedAt": null,
  "car": {
    "id": 2,
    "model": "116Ia 1.6 Tb 16V 136Cv 5P",
    "manufacturer": "BMW",
    "year": 2012,
    "fipeValue": 70670.00,
    "hasClaim": true,
    "drivers": [
      {
        "id": 2,
        "document": "93461350030",
        "birthdate": "2000-05-20",
        "yearsOld": 23,
        "mainDriver": true,
        "hasClaim": true
      }
    ]
  },
  "isActive": true,
  "fipePercentage": 12.00,
  "amount": 8480.40
}
```

### Test scenario 3

O orçamento não se encaixa em nenhum dos três itens de risco.

Riscos:

Motorista principal se encontra na faixa etária de 18 a 25 anos = false

O motorista possui sinistro em seu nome = false

O veículo ao qual será segurado possui sinistro = false

Resultado:

6% da fipe.

```json
{
  "id": 3,
  "customer": {
    "id": 3,
    "name": "Vanda Saraiva",
    "driver": {
      "id": 3,
      "document": "56254205762",
      "birthdate": "1990-05-20",
      "yearsOld": 33,
      "mainDriver": true,
      "hasClaim": false
    }
  },
  "creationDt": "2023-05-21T19:29:15.470398",
  "updatedAt": null,
  "car": {
    "id": 3,
    "model": "Gallardo Coupe Lp560 4",
    "manufacturer": "Lamborghini",
    "year": 2009,
    "fipeValue": 936959.00,
    "hasClaim": false,
    "drivers": [
      {
        "id": 3,
        "document": "56254205762",
        "birthdate": "1990-05-20",
        "yearsOld": 33,
        "mainDriver": true,
        "hasClaim": false
      }
    ]
  },
  "isActive": true,
  "fipePercentage": 6.00,
  "amount": 56217.54
}
```
