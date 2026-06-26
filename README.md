# 💰 Finance Control API

## 🚧 Status do Projeto

Em desenvolvimento — novas funcionalidades e melhorias estão sendo adicionadas continuamente.

---

# 📌 Sobre o Projeto

O **Finance Control API** é uma API REST desenvolvida com **Java** e **Spring Boot** para gerenciamento de finanças pessoais.

A aplicação permite cadastrar categorias e transações financeiras, controlar receitas e despesas, calcular o saldo atual e aplicar regras de negócio para garantir a integridade dos dados.

Este projeto foi desenvolvido com o objetivo de aprimorar conhecimentos em desenvolvimento backend, arquitetura de software e boas práticas utilizando Spring Boot.

---

# 🚀 Tecnologias Utilizadas

* Java 25
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven

---

# 📂 Estrutura do Projeto

O projeto segue uma arquitetura em camadas, organizada por funcionalidades.

### Módulo de Categorias

* Controller
* Service
* Repository
* DTOs
* Entity

### Módulo de Transações

* Controller
* Service
* Repository
* DTOs
* Entity
* Enum

### Tratamento de Exceções

* Exceções personalizadas
* Handler global de exceções

---

# ✨ Funcionalidades

## Categorias

* Cadastro de categorias
* Listagem de categorias
* Busca por ID
* Atualização de categoria
* Exclusão de categoria
* Validação para impedir categorias duplicadas
* Bloqueio da exclusão de categorias vinculadas a transações

## Transações

* Cadastro de transações
* Listagem de transações
* Busca por ID
* Atualização de transações
* Exclusão de transações
* Validação de categoria existente
* Validação de valor positivo
* Validação de data obrigatória
* Bloqueio de datas futuras
* Validação do tipo da transação

## Dashboard Financeiro

* Total de receitas
* Total de despesas
* Saldo atual

---

# 📊 Endpoints da API

## Categorias

| Método | Endpoint         |
| ------ | ---------------- |
| POST   | /categories      |
| GET    | /categories      |
| GET    | /categories/{id} |
| PUT    | /categories/{id} |
| DELETE | /categories/{id} |

## Transações

| Método | Endpoint              |
| ------ | --------------------- |
| POST   | /transactions         |
| GET    | /transactions         |
| GET    | /transactions/{id}    |
| PUT    | /transactions/{id}    |
| DELETE | /transactions/{id}    |
| GET    | /transactions/balance |

---

# 🛡️ Tratamento de Exceções

A API possui tratamento global para os principais erros da aplicação:

* Recurso não encontrado (404)
* Violações de regras de negócio (400)

Exemplo de resposta:

```json
{
  "timestamp": "2026-06-20T15:30:00Z",
  "status": 400,
  "error": "Erro de negócio",
  "message": "Categoria já cadastrada",
  "path": "/categories"
}
```

---

# 🔄 Arquitetura com DTOs

A aplicação utiliza DTOs para separar os dados trafegados pela API das entidades de domínio.

### DTOs de Entrada

* CategoryRequestDTO
* TransactionRequestDTO

### DTOs de Saída

* CategoryResponseDTO
* TransactionResponseDTO
* BalanceDTO

---

# 🎯 Objetivos de Aprendizagem

Este projeto foi desenvolvido para praticar:

* Desenvolvimento de APIs REST com Spring Boot
* Arquitetura em camadas
* Padrão DTO
* Validação de regras de negócio
* Spring Data JPA
* Boas práticas no desenvolvimento de APIs
* Conceitos de desenvolvimento backend
* Organização e manutenção de código limpo


## 👨‍💻 Author

Developed by Breno Souza as a personal learning project focused on backend development with Java and Spring Boot.
