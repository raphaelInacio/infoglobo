**Arquitetura do projeto**

O projeto segue arquitetura de microserviços com containers, possuindo 3 microserviços:

Schedule, REST e DataBase

O serviço de Schedule realiza uma leitura por dia (podendo ser parametrizado a frequência leitrua) no Feed de noticiais
processa as informações realizando as formatações de acordo com os requisitos e armazena essas informações 

O serviço de REST é reponsável por disponibilizar os dados gravados através de uma API REST, esse serviço possui autenticação Basic Authorization
permitindo apenas usuários cadastrados realizar a consulta dos feeds.

O Serviço de DataBase é responsável por armazenar as informações vindas do Schedule e fornecer esses dados para o serviço REST,
esse serviço é compartilhado com os dois microserviços, REST e Schedule

**Tencnologias Base Utilzadas**

Como base para desenvolvimento dos microserviços foi escolhido o microframework Spring Boot, para o desenvolvimento dos micorserviços 
e MongoDB para o banco de dados.

- Spring Boot
- Java 8
- MongoDB
- Docker

**Executando os containers**

docker-container up

**Consutando os feeds**
localhost:8080/api/feeds

**Autenticação**
As APIs estão protegidas com autenticação Basic Authorization em memória.
user : infoglobo
password : desafio

**Instalando dependencias java**
-mvn compile

**Executar um projeto via linha de comando**
-mvn spring-boot:run  - (http://localhost:8080/)


