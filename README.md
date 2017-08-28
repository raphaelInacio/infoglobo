# Infoglobo

**Arquitetura do projeto**

O projeto segue arquitetura de microserviços com containers, possuindo 3 microserviços:

Schedule, REST e DataBase

O serviço de Schedule posui uma única resposabilidade que é cosumir o feed RSS, realizando uma consulta diaria (podendo ser parametrizado a frequência de leitura) no Feed de notícias
, processa o feed RSS realizando as formatações necessárias e armazena os dados em uma base MongoDB.

O serviço de REST é reponsável por disponibilizar os dados gravados através de uma API REST, esse serviço possui autenticação Basic Authorization
permitindo apenas usuários cadastrados realizar a consulta dos feeds.

O Serviço de DataBase é responsável por armazenar as informações vindas do Schedule e fornecer esses dados para o serviço REST,
esse serviço é compartilhado por dois microserviços, REST e Schedule

**Tencnologias Utilzadas**

Como base para desenvolvimento dos microserviços foi escolhido o microframework Spring Boot e MongoDB para o banco de dados, abaixo segue a lista de tecnogias base utilizadas.

- Spring Boot 
- Spring Framework (Security, Spring Data, )
- Java 8
- MongoDB
- Docker

**Executando o projeto com Docker**
docker-container up

**Consutando a API de feeds**
localhost:8080/api/feeds

**Relizando Autenticação**
As APIs estão protegidas com autenticação Basic Authorization em memória.
user : infoglobo
password : desafio

**Instalando dependencias java**
-mvn compile

**Executar um projeto via linha de comando**
-mvn spring-boot:run  - (http://localhost:8080/)


