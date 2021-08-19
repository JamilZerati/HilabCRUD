# Hilab Crud Challenge

Projeto desafio para a vaga de estágio.

## How To Use

1. Clonar projeto.
2. Instalar as dependências do maven.
3. Rodar comando para iniciar o mongoDB


``` docker 
docker run --name mongoDB -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=passadmin -p 27017:27017 -d mongo
```

4. Importar Collection do Postman que está no diretório `./resources/HilabTest.postman_collection.json`
5. Chamar os Endpoints

## Como Trocar a implementação do repositório

1. Ir no [UserService](./src/main/java/com/hilab/hilabcrud/service/UserService.java)
2. Mudar qualifier entre `mongoDB` e `fileDB`


## Libs

- [Gson](https://github.com/google/gson) : Facilitar a conversão entre objeto e JSON.
- [Spring MongoTemplate](https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/core/MongoTemplate.html) : Lib para integrar com o mongoDB.
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/) : Fazer a validação dos dados de entrada.
- [Spring Boot](https://spring.io/projects/spring-boot) : Framework para criar aplicação web.
- [Maven](https://maven.apache.org/) : Para gerenciar dependências de objetos.
- [Git](https://git-scm.com/) : Gerenciar versionamento do projeto.