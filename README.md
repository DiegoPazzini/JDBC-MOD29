# JDBC-MOD29

O projeto é uma aplicação Java que realiza operações CRUD (Create, Read, Update, Delete) em entidades Cliente e Produto, persistindo os dados em um banco de dados PostgreSQL. Ele é composto por três principais pacotes: conexaoc, dao, e domain.

Pacote conexaoc
O pacote conexaoc contém a classe ConnectionFactory, responsável por estabelecer a conexão com o banco de dados PostgreSQL. A conexão é gerenciada de forma a evitar múltiplas conexões simultâneas e a ser reaberta em caso de fechamento.

Pacote domain
O pacote domain possui as classes Cliente e Produto, que representam as entidades que serão persistidas no banco de dados. Cada cliente possui um identificador único (id), um nome e um código. Cada produto possui um identificador único (id), um código e uma descrição.

Pacote dao
O pacote dao contém as interfaces IClienteDAO e IProdutoDAO, e as classes ClienteDAO e ProdutoDAO que as implementam, respectivamente. Essas classes realizam operações de persistência para as entidades Cliente e Produto no banco de dados. As operações incluem cadastrar, atualizar, buscar por código, buscar todos e excluir.

Funcionamento Geral
Conexão com o Banco de Dados: A classe ConnectionFactory estabelece a conexão com o banco de dados PostgreSQL.

Entidades Cliente e Produto: As classes Cliente e Produto definem a estrutura das entidades, com atributos como id, nome, código e descrição.

Operações de Persistência: As classes ClienteDAO e ProdutoDAO implementam as interfaces correspondentes e realizam operações CRUD no banco de dados para as entidades Cliente e Produto.

Testes: O pacote teste contém classes de teste para validar as operações de persistência utilizando o framework JUnit.

Configuração do Banco de Dados
O projeto está configurado para se conectar a um banco de dados PostgreSQL localmente, usando as credenciais: usuário (postgres), senha (Pira2021), e URL do banco de dados (jdbc:postgresql://localhost:5432/vendas_online_2).


## Skills utilizadas:
<div style="display: inline_block"><br>
   <img align="center" alt="Spring" height="50" width="50" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
  <img align="center" alt="Spring" height="60" width="60" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
