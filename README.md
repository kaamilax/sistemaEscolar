Um sistema escolar simples desenvolvido em Java com Spring Boot, com o objetivo de gerenciar informações acadêmicas de uma instituição de ensino.


Funcionalidades

O sistema permite realizar operações de CRUD (criar, consultar, atualizar e excluir) para:

    Alunos: cadastro e gerenciamento de alunos.

    Professores: cadastro e gerenciamento de professores.

    Disciplinas: cadastro e gerenciamento de disciplinas.

    Notas: registro e gerenciamento de notas dos alunos.

    Matrículas: gerenciamento de matrículas.

Tecnologias utilizadas

    Java

    Spring Boot

    Spring Data JPA

    Maven

    Banco de dados relacional

Como executar o projeto

    Clone o repositório:

    git clone URL_DO_SEU_REPOSITORIO

    Entre na pasta do projeto:

    cd sistemaEscolar

    Configure as variáveis de ambiente necessárias para a conexão com o banco de dados:

        DB_URL: URL de conexão com o banco.

        DB_USERNAME: usuário do banco.

        DB_PASSWORD: senha do banco.

    Execute a aplicação pela sua IDE ou utilizando o Maven Wrapper:

    No Windows:

    .\mvnw.cmd spring-boot:run

Objetivo

Este projeto foi desenvolvido para praticar conceitos de desenvolvimento de aplicações Java, organização em camadas e operações CRUD utilizando Spring Boot.
