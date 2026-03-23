# Sistema Academia
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gustavohazambuja/sistema_academia/blob/master/LICENSE) 

# Sobre o projeto

Sistema Academia é uma aplicação backend desenvolvida para gerenciar as operações fundamentais de uma academia. O sistema centraliza o cadastro de alunos e instrutores, permitindo o controle de treinos e planos.

Nela podemos cadastrar instrutores e alunos com validação automática de CPF, listar usuários por filtros específicos (como plano para alunos) e gerenciar rematrículas e  exclusão de registros. 

Além disso, a aplicação possui um módulo de criação de treinos, onde é possível vincular um aluno a um instrutor, definir objetivos e consultar o histórico completo de treinos de um aluno específico. O sistema também prepara a estrutura para resumos financeiros.

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- PostgreSQL
- Docker / Docker Compose

# Como executar o projeto

Pré-requisitos: Java 17+ e Docker instalados.

## Executando com Docker

Este projeto está configurado para rodar em containers, facilitando a configuração do ambiente e do banco de dados PostgreSQL.

1. Clone o repositório:
```
git clone https://github.com/gustavohazambuja/sistema_academia.git
cd sistema_academia
```

2. Execute o comando do Docker Compose para construir a imagem e subir os containers
```
docker-compose up --build
```

3. A aplicação estará disponível em:
```
http://localhost:8080
```

# Endpoints Principais:
- Alunos: GET /alunos/listarAlunos
- Instrutores: GET /instrutores/listarInstrutores
- Treinos: POST /treinos/criarTreino

```

# Autor

Gustavo Henrique Azambuja

https://www.linkedin.com/in/gustavohazambuja/
