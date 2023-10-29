# APIArS
<div align="center">
  <img  src="./logo_individual.png">
  Repositório Individual Da Disciplina API-Restful (Serratec).
</div>

# Projeto Funcionario - Departamento
Este é o repositório do projeto Funcionario - Departamento, um sistema para gerenciar departamentos e seus funcionarios, incluindo setores e usuarios.
<br><br>

### Estrutura do Projeto
O projeto segue uma estrutura organizada em pacotes. Os principais pacotes incluem:

<strong>Config:</strong> Contém classes de configuração, como Swagger, CORS e autenticaçaõ JWT.

<strong>Entities:</strong> Armazena as classes bean, que representam as entidades do projeto (Funcionário, Departamento, Setor, User, Roles).

<strong>Repositories:</strong> Interfaces responsáveis por executar as queries de consulta no banco de dados para cada entidade.

<strong>Services:</strong> Contém as classes de serviço que lidam com a lógica das requisições.

<strong>Controllers:</strong> Armazena as classes de controle que recebem as requisições HTTP e retornam as respostas adequadas atraves das operações CRUD.
<br><br>

### Funcionalidades Principais

O projeto inclui as seguintes funcionalidades principais:

<strong>CRUD Completo:</strong> Cada controller oferece operações de busca por ID (GET), listagem de todos os registros (GET), salvamento (POST), atualização (PUT) e remoção (DELETE).

<strong>Consumo do ViaCep:</strong> Integração com o serviço ViaCep para obter informações de endereços por CEP.

<strong>Configuração de E-mail:</strong> Implementação de configurações de e-mail para comunicações com clientes e funcionários.

<strong>Configuração de Exceptions:</strong> Gerenciamento de exceções e erros para um tratamento adequado.

<strong>Inserção de Validações:</strong> Uso de anotações para validações em todas as entidades.

<strong>Documentação com Swagger:</strong> Inclusão de anotações nos controllers para facilitar a geração de documentação Swagger.

<strong>Enums e DTOs:</strong> Criação de Enums e DTOs para simplificar as solicitações e respostas.
<br><br>

### Melhorias e Aprimoramentos

<strong>Inserção de Validações:</strong> Utilização de anotações para validações em todas as entidades.

<strong>Configuração JWT:</strong> Implementação de autenticação JSON Web Token (JWT) para garantir a segurança das operações.

<strong>Criação de Enums:</strong> Enums são criados, geralmente associados a opções de seleção, como dropdowns e checkboxes.

<strong>Criação de DTOs:</strong> Criação de Data Transfer Objects para simplificar as solicitações e respostas.

<strong>Configuração de Upload de Imagem:</strong> Suporte para o upload de imagens, por exemplo, para produtos.
<br><br>

### Tecnologias Utilizadas

<strong>Java:</strong> Linguagem de programação principal.

<strong>Spring Boot:</strong> Framework para desenvolvimento de aplicativos Java.

<strong>Swagger:</strong> Para documentação e testes de API.

<strong>CORS:</strong> Configuração para permitir requisições de domínios diferentes.

<strong>JSON Web Token (JWT):</strong> Utilizado para autenticação e segurança.

<strong>ViaCep API:</strong> Integração para obter informações de endereços.

<strong>Banco de Dados:</strong> Utilizado para armazenamento de dados.

<strong>JavaMail:</strong> Biblioteca para manipulação de e-mails
<br><br>

### Versionamento

Seguimos um padrão de versionamento com três dígitos, iniciando na versão 1.0.0. Utilizamos commits por partes para manter o controle e rastreamento das modificações no projeto. Certifique-se de seguir as diretrizes de versionamento ao contribuir para este repositório.

### Autoria

Este projeto foi desenvolvido por uma pessoa. É um projeto de código fechado e não aceita contribuições externas.

Responsável: Arthur da Silva Monteiro

<strong>Contato:</strong>
Para perguntas, sugestões ou colaborações, entre em contato com arthurmonteiro20172018@gmail.com.
