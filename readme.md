# Estoque Fullstack Application

Este é um projeto fullstack desenvolvido com **Spring Boot** no backend e **Angular** no frontend, focado no gerenciamento de produtos e cidades com operações CRUD.

## Tecnologias Utilizadas

### Backend:
- **Java 17**
- **Spring Boot 3.3.2**
- **Spring Data JPA**
- **MySQL**
- **Maven**

### Frontend:
- **Angular**
- **TypeScript**
- **HTML**
- **CSS**

## Funcionalidades

### Backend:
- **Gerenciamento de Produtos:** Criação, leitura, atualização e exclusão (CRUD) de produtos.
- **Gerenciamento de Cidades:** Leitura de cidades cadastradas.
- **APIs REST:** Integração via APIs RESTful para comunicação com o frontend.

### Frontend:
- **Listagem de Produtos:** Exibe todos os produtos cadastrados.
- **Cadastro de Produtos:** Permite o cadastro de novos produtos.
- **Edição de Produtos:** Edição de produtos existentes.
- **Listagem de Cidades:** Exibe as cidades cadastradas no sistema.

## Estrutura do Projeto

### Backend (Spring Boot)
- **Controller:** `ProductController` e `CityController` gerenciam as requisições HTTP.
- **Service:** `ProductService` e `CityService` contêm a lógica de negócios.
- **Repository:** `ProductRepository` e `CityRepository` gerenciam a persistência dos dados.
- **DTO:** `ProductDto` e `CityDto` para transferência de dados entre as camadas.

### Frontend (Angular)
- **Components:** Componentes para listagem, cadastro e edição de produtos, além da listagem de cidades.
- **Services:** Serviços para consumir as APIs REST do backend.
- **Routes:** Configuração de rotas para navegação entre os componentes.

## Pré-requisitos

- **JDK 17**
- **Node.js**
- **Angular CLI**
- **MySQL**

## Configuração e Execução

### Backend
1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/estoque-backend.git
   cd estoque-backend
