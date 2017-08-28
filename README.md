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

#2 Executando o projeto
 
**Iniciando o MongoDB**

Primeiro será necessário Iniciar o MongoDB, caso você ja tenha o docker instalado basta executar 

sudo docker container run -it -p 27017:27017 mongo:3.4 

**Build do projeto**

Entre no diretório raiz dos microserviços (/infoglobo) execute o comando abaixo.

cd schedule-feed && mvn clean install && cd .. && cd feed-rest-api && mvn clean install

**Excutando os containers**

sudo docker-container up

**Consutando a API de feeds**

localhost:8080/api/feeds

**Relizando Autenticação**

As APIs estão protegidas com autenticação Basic Authorization.
user : infoglobo
password : desafio


**Executar um projeto via linha de comando**
-mvn spring-boot:run  - (http://localhost:8080/)


