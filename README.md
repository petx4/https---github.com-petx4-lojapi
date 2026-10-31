# LojAPI - Cadastro de Produtos com Spring Boot + JPA + MySQL

Projeto simples de CRUD: um front-end em HTML/JavaScript conversa com uma API
REST feita em Spring Boot, que salva os dados em um banco MySQL.

Criado com **Maven**, **Java**, **Spring Web**, **Spring Data JPA** e **MySQL Driver**.

## Como o front e o back se comunicam

```
index.html (navegador)  --fetch / JSON-->  ProdutoController  -->  ProdutoRepository  -->  MySQL
```

| Metodo | URL             | O que faz                |
|--------|-----------------|--------------------------|
| GET    | /produtos       | Lista todos os produtos  |
| GET    | /produtos/{id}  | Busca um produto         |
| POST   | /produtos       | Cadastra um produto      |

Exemplo de JSON:

```json
{ "nome": "Teclado", "descricao": "Teclado USB", "preco": 89.90, "quantidade": 10 }
```

## Estrutura

```
src/main/java/com/senai/lojapi/
├── LojapiApplication.java             -> classe principal (main)
├── entity/Produto.java                -> entidade JPA (tabela "produto")
├── repository/ProdutoRepository.java  -> acesso ao banco (Spring Data JPA)
├── controller/ProdutoController.java  -> endpoints REST (/produtos)
└── config/CorsConfig.java             -> libera o front chamar a API
src/main/resources/
├── application.properties             -> conexao com o MySQL
└── static/index.html                  -> front-end
```

## Como rodar

1. Tenha o **MySQL** rodando em `localhost:3306`.
2. Ajuste usuario e senha em `src/main/resources/application.properties`
   (padrao: `root` / `root`). O banco `loja` e a tabela `produto` sao criados sozinhos.
3. Rode o projeto (precisa de JDK 17 ou superior):

   ```
   mvnw.cmd spring-boot:run        (Windows)
   ./mvnw spring-boot:run          (Linux / Mac)
   ```

   Ou abra a pasta no IntelliJ e execute a classe `LojapiApplication`.

4. Abra `http://localhost:8080` no navegador.
