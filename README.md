# Cadastro de Usuários
API Restful genérica que realiza o cadastro de usuários em uma base dados.

# Funcionalidades
1. Gerenciamento de usuario (CRUD completo)
2. Testes Unitários

# Documentação
*  A documentação da API foi gerada com Swagger e está disponível em```https://bank-account-deploy.herokuapp.com/swagger-ui.html```
*  Na pasta resources está contida a collection do postman.

# Diagrama de modelo lógico do banco de dados
![image](https://user-images.githubusercontent.com/97842444/170992159-d464df7b-c452-4cbe-ab04-13ea87b4b232.png)

# Pré-requisitos(manual de execução)
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [JDK17](https://www.oracle.com/java/technologies/downloads/#java17), [MAVEN 3](https://maven.apache.org/index.html) e [MYSQL](https://www.mysql.com/downloads/). 
Além disto é bom ter um editor para trabalhar com o código como [Spring Tools](https://spring.io/tools)

# Executar a aplicação localmente
Primeiro é necessário iniciar seu banco de dados MySQL. É necessário criar as tabelas do banco. A API faz isso para você se na primeira execução você utilizar a seguinte propriedade ```spring.datasource.url=jdbc:mysql://localhost:3306/BD_BankAccountManagement?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSl=false``` a base é denominada 'BD_BankAccountManagement' e o banco por padrão é criado desde que o MYSQL tenha sido inicializado, os seguintes dados são utilizados:

# application-test.properties
```bash
# Servidor Web
server.port=8080

# Spring DATASOURCE (DataSourceProperties)
spring.datasource.url=jdbc:mysql://localhost:3306/BD_modelunitedtest?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSl=false

	spring.datasource.username=root
	spring.datasource.password=root

# Hibernate ddl auto (update)
spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:mysql://localhost:3306/BD_modelunitedtest?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSl=false
spring.datasource.username=root
spring.datasource.password=root

# Dialeto
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```
# Principais técnologias utilizadas
1. Java JDK 17
2. Maven 3
3. MySQL Database
4. JDBC
5. Postman(testes)
6. Docker
7. Spring Boot 2.7.9


### funcionalidades
- [x] Gerenciamento de usuários
- [x] Gerenciamento de people
- [x] Gerenciamento de transactions
- [X] Criacao de uma account
- [X] Operação de cadastro em umusuário
- [X] Operação de consulta em um usuário
- [X] Operação de consulta de uma lista de usuários
- [X] Operação de update de usuário
- [X] Operação de deletar um usuário
- [X] Validações
- [x] Tratamento de exceções
- [X] Deploy do projeto no Heroku
- [X] Testes Unitários

### Status do Projeto
<h4 align="left"> 
	🚧  React Select 🚀 concluded  🚧
</h4>

### Autor
---
<a href="https://github.com/klerytondev/">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/klerytondev" width="100px;" alt=""/>
 <br />
 <sub><b>Kleryton Souza</b></sub></a> <a>🚀</a>

Made by Kleryton de Souza 👋🏽 Entre em contato!

[![Twitter Badge](https://img.shields.io/badge/-@SouzaKleryton-1ca0f1?style=flat-square&labelColor=1ca0f1&logo=twitter&logoColor=white&link=https://twitter.com/SouzaKleryton)](https://twitter.com/SouzaKleryton) [![Linkedin Badge](https://img.shields.io/badge/-kleryton-souza?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/kleryton-souza-a1733673/)](https://www.linkedin.com/in/kleryton-souza-a1733673/) 
[![Gmail Badge](https://img.shields.io/badge/kleryton.dev@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:kleryton.dev@gmail.com)](mailto:kleryton.dev@gmail.com)

# Copyright
Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
