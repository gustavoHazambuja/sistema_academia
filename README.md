# Sistema Academia
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gustavohazambuja/sistema_academia/blob/master/LICENSE) 

# Sobre o projeto

Sistema Academia é uma aplicação backend que consiste em um sistema de gerenciamento para academias, controlando o fluxo de alunos, instrutores e a prescrição de exercícios.

Nela podemos cadastrar e gerenciar alunos e instrutores com validações automáticas de dados (como CPF), além de criar treinos personalizados vinculando um aluno a um instrutor. O sistema também permite consultar o histórico completo de treinos de um aluno específico.

Podemos também realizar buscas filtradas, como encontrar alunos por plano ou por nome, listar instrutores de forma paginada e todo o ambiente de banco de dados e aplicação foi configurado para rodar em containers.

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
