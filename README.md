# CRM Sao Rafael

## 1. Introducao

Esta aplicacao é uma API REST para gerenciamento basico de um sistema clinico. Ela permite cadastrar, consultar e remover medicos e pacientes, alem de marcar, listar e desmarcar consultas medicas.

O projeto organiza a regra de negocio em services, a persistencia em repositories com Spring Data JPA e expoe os recursos por meio de controllers REST.

## 2. Tecnologias e dependencias

- Java 21
- Maven
- Spring Boot 4.0.6
- Spring Web MVC, usado para criacao dos endpoints REST
- Spring Data JPA, usado para persistencia e acesso ao banco de dados
- Oracle JDBC Driver (`ojdbc11`), usado para conexao com banco Oracle
- Hibernate, usado pelo Spring Data JPA como implementacao de ORM
- Lombok, usado para reduzir codigo repetitivo em modelos, como getters e setters
- Dependencias de teste do Spring Boot para Web MVC e Data JPA

A configuracao de banco fica em `src/main/resources/application.properties`. O projeto esta configurado para usar Oracle, com `spring.jpa.hibernate.ddl-auto=update`, exibicao de SQL habilitada e formatacao das queries do Hibernate.

## 3. Endpoints da API

### Medicos

| Metodo | Endpoint | Descricao |
| --- | --- | --- |
| `GET` | `/medicos` | Lista todos os medicos cadastrados. |
| `GET` | `/medicos/{id}` | Busca um medico pelo ID. |
| `POST` | `/medicos` | Cadastra um novo medico. |
| `DELETE` | `/medicos/{id}` | Remove um medico pelo ID. |

Exemplo de corpo para `POST /medicos`:

```json
{
  "nome": "Maria Silva",
  "documento": "12345678900",
  "numeroTelefone": "11999999999",
  "especialidade": "Cardiologia",
  "crm": "CRM12345"
}
```

### Pacientes

| Metodo | Endpoint | Descricao |
| --- | --- | --- |
| `GET` | `/pacientes` | Lista todos os pacientes cadastrados. |
| `GET` | `/pacientes/{id}` | Busca um paciente pelo ID. |
| `POST` | `/pacientes` | Cadastra um novo paciente. |
| `DELETE` | `/pacientes/{id}` | Remove um paciente pelo ID. |

Exemplo de corpo para `POST /pacientes`:

```json
{
  "nome": "Joao Santos",
  "documento": "98765432100",
  "numeroTelefone": "11888888888"
}
```

### Consultas

| Metodo | Endpoint | Descricao |
| --- | --- | --- |
| `GET` | `/consultas` | Lista todas as consultas medicas. |
| `GET` | `/consultas/medicos/{id}` | Lista consultas vinculadas a um medico. |
| `GET` | `/consultas/pacientes/{id}` | Lista consultas vinculadas a um paciente. |
| `POST` | `/consultas` | Marca uma nova consulta medica. |
| `DELETE` | `/consultas/{id}` | Desmarca uma consulta pelo ID. |

Exemplo de corpo para `POST /consultas`:

```json
{
  "medico": {
    "id": 1
  },
  "paciente": {
    "id": 1
  },
  "dataMarcada": "2026-05-10T14:30:00",
  "descricao": "Consulta de rotina"
}
```

Para marcar uma consulta, o medico e o paciente informados no corpo da requisicao precisam existir previamente no banco de dados.
