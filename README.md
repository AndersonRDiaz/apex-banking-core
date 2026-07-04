# Apex Banking Core

Uma aplicação de core bancário corporativo desenvolvida para demonstrar princípios avançados de engenharia de software, código limpo (Clean Code) e evolução arquitetural em Java.

Este projeto simula um ecossistema financeiro seguro, evoluindo de um gerenciamento nativo em memória RAM para uma API REST completa pronta para a nuvem.

---

## 🗺️ Roadmap Arquitetural

Para demonstrar o crescimento profissional e a clara separação de responsabilidades, este repositório está estruturado em três fases evolutivas distintas:

### 🏁 Fase 1: Fundação Orientada a Objetos & Gerenciamento de Memória (Fase Atual)
* **Foco:** Java puro, paradigmas avançados de POO e consistência de dados.
* **Recursos Principais:**
    * Modelagem de domínio complexa com Herança de Classes (`CheckingAccount` & `SavingsAccount`).
    * Regras de saque polimórficas (Cheque especial vs. Taxa de rendimento).
    * Mecanismo de Auditoria Interna (Histórico de transações encapsulado dentro do objeto).
    * Programação defensiva com manipulação precisa de referências a objetos via `ArrayList`.

### 🏗️ Fase 2: Persistência de Dados Enterprise (Próxima Fase)
* **Foco:** Integração com banco de dados relacional e integridade de dados.
* **Recursos Principais:**
    * Transição do armazenamento volátil em memória RAM para um banco de dados **PostgreSQL**.
    * Implementação de **JPA / Hibernate** para Mapeamento Objeto-Relacional (ORM).
    * Desacoplamento do acesso a dados utilizando o padrão **Repository Pattern** (abordagem Data Mapper).

### 🚀 Fase 3: API Cloud Distribuída com Spring Boot (Fase Final)
* **Foco:** Escalabilidade corporativa, padrões de projeto e web services RESTful.
* **Recursos Principais:**
    * Migração para o framework **Spring Boot** e Injeção de Dependências (IoC).
    * Arquitetura em camadas padrão de mercado: `Controllers` (API REST) ➡️ `Services` (Regras de Negócio) ➡️ `Repositories` (Dados).
    * Tratamento global de exceções robusto e Segurança Transacional (conformidade ACID via `@Transactional`).
    * Implementação de testes unitários automatizados utilizando **JUnit** e Mockito.

---

## 🛠️ Tecnologias & Conceitos Desenvolvidos

* **Linguagem:** Java (Código e documentação interna padronizados em inglês)
* **Conceitos:** Programação Orientada a Objetos (POO), Polimorfismo, Encapsulamento, Arquitetura de Software, Auditoria Transacional.
* **Ambiente Alvo:** Sistemas Bancários Corporativos & Fintechs.

---

## 🧠 Autor

* **Ing Christian Diaz** - *Estudante de Ciência da Computação na FIAP & Desenvolvedor Back-end*