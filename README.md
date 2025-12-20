# 📋 Sistema de Recursos Humanos (RH)

Sistema desktop desenvolvido em **Java Swing**, com foco em **gestão de colaboradores**, controle de **departamentos**, **cargos**, **endereços**, **contatos**, **histórico de ações (log)** e **relatórios gerenciais**.

O projeto foi desenvolvido com uma arquitetura organizada, separando claramente **camadas de visualização, acesso a dados e banco de dados**, utilizando boas práticas de programação e banco relacional.

---

## 🧠 Objetivo do Projeto

O objetivo do sistema é simular um **sistema real de RH**, permitindo:

- Cadastro completo de funcionários  
- Controle de desligamento (com regras de negócio)  
- Manutenção de departamentos e cargos  
- Registro de histórico de ações (log)  
- Geração de relatórios em PDF  
- Interface moderna e padronizada  

---

## 🛠️ Tecnologias Utilizadas

### 🔹 Back-end / Desktop
- Java 24  
- Java Swing  
- JDBC  

### 🔹 Banco de Dados
- PostgreSQL  
- Procedures  
- Triggers  
- Views  
- Materialized Views  
- Functions (escalares e tabeladas)  
- Controle de permissões com Roles  

### 🔹 Interface Gráfica
- FlatLaf (Look and Feel moderno)  
- JTable customizada  
- Placeholders nos campos  
- Layout fixo 16:9  

### 🔹 Relatórios
- JasperReports  
- Jaspersoft Studio  
- Exportação automática para PDF  

---

## 🗂️ Estrutura do Projeto

```text
src/
 ├─ main/
 │  ├─ java/
 │  │  ├─ dao/          # Acesso a dados (DAO)
 │  │  ├─ model/        # Entidades do sistema
 │  │  ├─ view/         # Telas Swing
 │  │  ├─ util/         # Utilitários (Relatórios, UI, etc)
 │  │  └─ database/     # Conexão com banco
 │  └─ resources/
 │     └─ relatorios/
 │        └─ rel_funcionarios.jasper
```

# 🧩 Funcionalidades Principais

## 👤 Funcionários
- Cadastro completo (dados pessoais, endereço e contato)
- Validação de idade (18 a 75 anos)
- Validação de salário
- Desligamento com data de saída
- Exclusão permitida somente após desligamento
- Histórico automático de ações

---

## 🏢 Departamentos
- Cadastro
- Edição por duplo clique
- Exclusão controlada

---

## 🧑‍💼 Cargos
- Vinculados a departamentos
- CRUD completo
- Validações obrigatórias

---

## 🧾 Log do Sistema
Registro automático de ações:
- Inserção de funcionário
- Desligamento de funcionário  

Características:
- Mantido via **trigger**
- Relacionado a **usuário** e **funcionário**
- Histórico permanente

---

## 🗃️ Banco de Dados
O banco foi modelado seguindo o fluxo:
**modelo conceitual → lógico → físico**,  
com integridade referencial e regras de negócio aplicadas diretamente no banco.

### Destaques

#### 🔁 Triggers
- Validação de salário
- Registro automático no log

#### ⚙️ Procedures
- Cadastro completo de funcionário
- Desligamento controlado

#### 👁️ Views
- `vw_funcionario_completo`

#### 📦 Materialized View
- Estatísticas por departamento

#### 🧮 Functions
- Total de funcionários por departamento
- Funcionários ativos por departamento

#### 🔐 Roles
- `admin`
- `colaborador`

---

## 📊 Relatórios com JasperReports
O sistema possui relatório de funcionários gerado via **JasperReports**, com as seguintes características:

- Consulta direta ao banco de dados
- Geração em **PDF**
- Layout padrão **A4**

### Informações exibidas
- Nome
- Idade
- Salário formatado
- Cargo
- Departamento
- Data de admissão
- Data de saída

### 🔄 Fluxo do Relatório
1. Usuário clica em **Gerar relatório**
2. O Jasper carrega o arquivo `.jasper`
3. O relatório é preenchido via **JDBC**
4. O PDF é gerado automaticamente
5. O arquivo é aberto no sistema operacional

---

## 🎨 Estilização com FlatLaf
Para modernizar a interface Swing, foi utilizado o **FlatLaf**, trazendo:

- Visual moderno (flat design)
- Melhor contraste e legibilidade
- Padronização visual do sistema

### Recursos aplicados
- Placeholders em campos de texto
- Tabelas sem grid
- Altura de linhas personalizada
- Fonte padrão moderna (Segoe UI)
- Layout fixo **16:9**
- Cabeçalhos de tabelas estilizados

---

## 🔐 Regras de Negócio Importantes
- Funcionário não pode ser excluído se estiver ativo
- Salário não pode ser negativo
- Idade válida entre **18 e 75 anos**
- Apenas um endereço e um contato podem ser principais
- Logs não são removidos (histórico permanente)

---

## ▶️ Como Executar o Projeto
1. Criar o banco de dados no **PostgreSQL**
2. Executar o script SQL completo do projeto
3. Configurar as credenciais de conexão
4. Abrir o projeto no **NetBeans**
5. Executar a classe **Principal**

---

## 📌 Considerações Finais
Este projeto foi desenvolvido com foco em:
- Organização e clareza de código
- Regras de negócio realistas
- Uso correto de banco de dados relacional
- Interface agradável e moderna
- Aplicação prática de conceitos acadêmicos

