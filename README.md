#Projeto para teste tecnico objective

**Descricao**<br>
API desenvolvida apenas para teste tecnico para a empresa objective

**Instalação**
**Pré-requisitos**
<br>
- Java 11 ou superior
- Maven 3.6 ou superior

**OU**

- Maven 3.6 ou superior
- Docker

**Para Instalar**
<br>
1. Clone o repositório: `git clone https://github.com/Lauriiano/objective.git`
2. Acesse o diretório: `cd objective`
3. Instale as dependências: `mvn clean package`

**Para Rodar**
<br> 
- Execute o comando para iniciar a aplicação: `java -jar target/conta-objective.jar`
- Acesse através do navegador: `http://localhost:8080`

## Usando o docker

1. Clone o repositório: `git clone https://github.com/Lauriiano/objective.git`
2. Acesse o diretório: `cd objective`
3. Instale as dependências: `mvn clean package`
4. crie a imagem: `docker build -t conta-objective .` 
5. suba o container com a aplicação: `docker run -p 8080:8080 -d conta-objective`


**Base PATH**<br>
>http://localhost:8080/objective/v1/

**Swagger**<br>
>http://localhost:8080/objective/v1/swagger-ui/index.html
