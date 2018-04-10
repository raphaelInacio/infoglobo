# Infoglobo

### Arquitetura

##########

O projeto segue arquitetura de microserviços com containers, possuindo 3 microserviços:

Schedule, REST e DataBase

O serviço de Schedule possui uma única responsabilidade que é consumir o Feed RSS, realizando uma consulta diária (podendo ser parametrizado a frequência de leitura).
Após a consulta ele processa as informações realizando as formatações necessárias e armazena os dados em uma base de dados MongoDB.

O serviço de REST é responsável por fornecer acesso aos dados gravados pelo serviço Schedule, através de um WebService REST, esse serviço possui autenticação do tipo Basic Authorization e permite que apenas usuários cadastrados realizem a visualização dos feeds.

O Serviço de DataBase é responsável por armazenar as informações vindas do Schedule e fornecer esses dados para o serviço REST,
esse serviço é compartilhado por dois microserviços, REST e Schedule

### Tecnologias Utilzadas

Para desenvolvimento dos microserviços foi escolhido o microframework Spring Boot e MongoDB para o banco de dados, abaixo segue a lista das principais tecnologias utilizadas.

- Spring Boot 
- Spring Framework (Security, Spring Data, )
- Java 8
- MongoDB
- Docker

### Executando o projeto
 
**Iniciando o MongoDB**

Primeiro será necessário Iniciar o MongoDB, se você já tem o docker instalado execute o comando abaixo 

```
sudo docker container run -it -p 27017:27017 mongo:3.4 
```
**Build do projeto**

Agora precisamos gerar os jars de cada microserviço, então, entre no diretório raiz dos microserviços (/infoglobo) execute o comando abaixo.

```
cd schedule-feed && mvn clean package && cd .. && cd feed-rest-api && mvn clean package
```

O comando executado gerá o build dos projetos utilizando o maven.

**Excutando os containers**

Com os jars de cada microserviço gerado, precisamos subir os containers e testar nosso projeto.

Na raiz o projeto temos o docker-compose.yml, responsável por montar as imagens necessárias e subir nossos serviços, para executar o docker-compose execute o comando abaixo.

```
sudo docker-container up
```
**Consutando a API de feeds**

Se tudo ocorreu bem até aqui, você já pode testar a aplicação acessando o link abaixo.

```
localhost:8080/api/feeds
```
**Autenticação**

É provavel que você tenha recebido um erro de autorização ao acessar a API, o motivo é que as APIs estão protegidas com autenticação do tipo Basic Authorization.

É necessário informar usuário e senha para acessar a aplicação, informe o usuário e senha abaixo e teste novamente a aplicação.

```
user : infoglobo
password : desafio
```


