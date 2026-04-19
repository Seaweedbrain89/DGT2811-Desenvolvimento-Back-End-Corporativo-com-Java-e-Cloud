# CadastroEE - Sistema Cadastral Java EE

![Java](https://img.shields.io/badge/Java-17-orange)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-8-blue)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5-purple)
![SQL Server](https://img.shields.io/badge/SQL%20Server-Express-red)
![GlassFish](https://img.shields.io/badge/GlassFish-6.2.1-green)

> Universidade Estácio de Sá — Campus Centro São Bernardo do Campo  
> Disciplina: DGT2811 — Desenvolvimento Back-End Corporativo com Java e Cloud  
> Semestre: 2026.1 Flex  
> Autor: Felipe da Silva Barroso

---

## Sobre o projeto

Esse projeto foi desenvolvido como prática da disciplina Desenvolvimento Back-End Corporativo com Java e Cloud.
A ideia aqui foi construir um sistema web completo utilizando a stack clássica do Java EE, passando por todas as camadas:

- Persistência
- Regra de negócio
- Controle
- Interface

O sistema permite o gerenciamento de produtos com operações básicas de um CRUD.

---

## Tecnologias utilizadas

- Java (JDK 17)
- Jakarta EE 8
- JPA (Hibernate)
- EJB (Session Beans)
- Servlets
- JSP
- Bootstrap 5
- SQL Server
- GlassFish 6.2.1
- NetBeans

---

## Arquitetura

O projeto segue o padrão MVC dividido em três módulos:

- **CadastroEE (EAR)** → projeto principal
- **CadastroEE-ejb** → camada de negócio + persistência (JPA + EJB)
- **CadastroEE-war** → camada web (Servlets + JSP)

Separação de responsabilidades:

- **JPA** → mapeamento objeto-relacional
- **EJB** → regras de negócio
- **Servlets** → controle das requisições
- **JSP** → apresentação

---

## Funcionalidades

- ✔ Listar produtos
- ✔ Inserir novos produtos
- ✔ Alterar produtos existentes
- ✔ Excluir produtos

---

## Execução do sistema

Após o deploy no GlassFish, acesse:
http://localhost:8080/CadastroEE-war/ServletProdutoFC?acao=listar

---

## Banco de dados

- **Banco:** `loja`
- **Tabela:** `Produto`

Campos: `id`, `nome`, `quantidade`, `precoVenda`

---

## Configuração

O projeto utiliza um DataSource configurado no GlassFish:
jdbc/loja

Com conexão via SQL Server:
jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;

---

## Objetivo do projeto

Aplicar na prática:

- Integração com banco usando JPA
- Uso de EJB para lógica de negócio
- Construção de aplicação web com Servlets e JSP
- Organização em arquitetura MVC
- Uso de Bootstrap para interface

---

## Observações

O projeto foi desenvolvido com foco em aprendizado prático, seguindo o que foi proposto na disciplina.
Algumas decisões foram feitas de forma direta e funcional, priorizando entendimento do fluxo completo da aplicação.

---

## Possíveis melhorias futuras

- Validação de dados no backend
- Tratamento de erros mais robusto
- Uso de JSTL no lugar de scriptlets JSP
- Evolução para API REST (Spring Boot)
