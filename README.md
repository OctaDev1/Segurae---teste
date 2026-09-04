# 🚗 Seguraê 

Sistema de Gerenciamento de Seguros Automotivos desenvolvido com **Java + Spring Boot**, com o objetivo de centralizar informações sobre clientes, veículos e apólices, proporcionando uma gestão mais simples, segura e eficiente.

---

## 📋 Sobre o Projeto

O **Seguraê** é uma aplicação desenvolvida para facilitar o gerenciamento de seguros automotivos.

O sistema permite cadastrar, consultar, atualizar e remover informações de clientes, veículos e apólices de seguro, tornando mais eficiente o acompanhamento dos contratos e das coberturas contratadas.

Além disso, a aplicação conta com autenticação e autorização utilizando **Spring Security** e **JWT**, documentação da API com **Swagger/OpenAPI** e deploy realizado no **Render**, simulando um ambiente utilizado em aplicações reais.

---

## 🎯 Objetivos

- Centralizar informações de clientes, veículos e apólices;
- Facilitar o gerenciamento de contratos de seguro;
- Garantir maior segurança no acesso ao sistema;
- Disponibilizar uma API REST para integração com outras aplicações;
- Automatizar o controle das informações relacionadas aos seguros.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| ☕ Java | Linguagem de programação |
| 🌱 Spring Boot | Framework principal |
| 🗄️ Spring Data JPA | Persistência de dados |
| 🔥 Hibernate | ORM |
| 🐬 MySQL | Banco de dados |
| 🔒 Spring Security | Autenticação e autorização |
| 🔑 JWT | Segurança baseada em Token |
| 📖 Swagger/OpenAPI | Documentação da API |
| 🌐 Tomcat | Servidor de aplicação |
| 📦 Maven | Gerenciador de dependências |
| 🔧 Git | Controle de versão |
| 🐙 GitHub | Hospedagem do projeto |
| ☁️ Render | Deploy da aplicação |

---

## 🏛️ Arquitetura

O projeto segue o padrão de arquitetura em camadas:

```text
                      👤 Cliente
                               │
                               ▼
                     🌐 Requisição HTTP
                               │
                               ▼
             🔐 Spring Security + JWT
                               │
                               ▼
                    🎮 Controller (API)
                               │
                               ▼
                  ⚙️ Service (Regras de Negócio)
                               │
                               ▼
               🗄️ Repository (JPA/Hibernate)
                               │
                               ▼
                   🐬 Banco de Dados MySQL

```

---

# 📊 Banco de Dados

**db_segurae**

Nosso banco de dados foi desenvolvido utilizando o SGBD **MySQL**.

A seguir estão as principais tabelas utilizadas no sistema.

---

## 📌 Tabela: tb_cliente

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | BIGINT | Identificador único do cliente |
| nomeCompleto | VARCHAR(100) | Nome do segurado |
| cpfCnpj | VARCHAR(14) | CPF/CNPJ do segurado |
| email | VARCHAR(100) | Endereço de e-mail |
| dataNascimento | DATE | Data de nascimento |

---

## 📌 Tabela: tb_apolice

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | BIGINT | Identificador único da apólice |
| anoModelo | INT | Ano do automóvel |
| numeroApolice | VARCHAR(255) | Número da apólice |
| bemSegurado | VARCHAR(255) | Tipo de automóvel |
| placa | VARCHAR(7) | Placa do automóvel |
| renavam | VARCHAR(11) | Renavam do automóvel |
| tipoCobertura | VARCHAR(255) | Tipo de cobertura |
| dataInicio | DATE | Data do início da vigência da apólice |
| dataTermino | DATE| Data do término da vigência da apólice |
| statusApolice | TINYINT | Situação atual da apólice |
| marcaModelo | VARCHAR(255) | Marca e modelo do automóvel |
| valorApolice | DECIMAL(12,2) | Valor em reais da apólice |

---

## 📌 Tabela: tb_usuario

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | BIGINT | Identificador único do usuário |
| nome | VARCHAR(100) | Nome completo |
| email | VARCHAR(100) | Login (e-mail) |
| senha | VARCHAR(100) | Senha criptografada |
| foto | VARCHAR(150) | URL da foto de perfil |

---

## 📈 Diagrama Entidade-Relacionamento

![Diagrama do Banco de Dados](https://raw.githubusercontent.com/OctaDev1/Docs/main/seguraeDER.png)

---

## 📂 Estrutura do Projeto

```text
src
├── model
├── repository
├── controller
├── service
├── security
├── dto
└── configuration
```

---

## ⚙️ Como executar o projeto

### Clone o repositório

```bash
git clone https://github.com/OctaDev1/Segurae.git
```

### Entre na pasta

```bash
cd segurae
```

### Configure o banco de dados

Crie um banco chamado:

```text
db_segurae
```

Configure o arquivo:

```text
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_segurae
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Executando

Execute a classe principal do Spring Boot:

```text
SeguraeApplication.java
```

Ou pelo Maven:

```bash
mvn spring-boot:run
```

---

## 📌 Funcionalidades

- Cadastro de clientes
- Consulta de clientes
- Atualização de clientes
- Exclusão de clientes
- Cadastro de apólices
- Gerenciamento de seguros
- Cadastro de usuários
- Login com JWT
- Documentação da API com Swagger
- API REST
- Integração com banco de dados MySQL

---

## 🛠️ Futuras Implementações

### 🚘 Gestão Inteligente

- Cotação baseada no perfil do motorista.
- Consulta automática à Tabela FIPE.
- Simulação de planos e coberturas.

### 🚨 Gestão de Sinistros

- Abertura de sinistro totalmente online.
- Envio de fotos e documentos.
- Acompanhamento do status em tempo real.

### 👤 Experiência do Cliente

- Notificações de renovação da apólice.
- Download da apólice em PDF.
- Histórico de apólices e pagamentos.


---

## 👥 Equipe

O **Seguraê** foi desenvolvido pela equipe **OctaDev**, formada por estudantes do Bootcamp Java Full Stack da Generation Brasil, com foco na aplicação de boas práticas de desenvolvimento de software, metodologias ágeis e construção de APIs REST utilizando Java e Spring Boot.

### Desenvolvedores

- Felipe Oliveira Lopes
- Gabriel José Alegre
- Giovanna Karolline Menezes Ribeiro
- Guilherme Oliveira
- João Vitor Diniz Alves
- Juliana Macedo
- Maryane Praxedes Alves da Silva
- Thiago José Nascimento Versiani

---

## 📄 Licença

Este projeto possui finalidade acadêmica e de aprendizado.
