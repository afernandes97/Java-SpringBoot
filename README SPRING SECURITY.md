# Spring Security

<img src="https://pbs.twimg.com/media/DU7GUGCV4AAf90X.jpg">

Temas que serão abordados:
  - Principais vulnerabilidades Spring
  - Fluxo Basic Authentication
  - Configurações Default 
  - Personalizar Autenticação
  - Autenticação em Memória
  - Autenticação Base Dados
  - Controle de Acesso

## Referencias de estudo
(prints e trechos de textos copiados e ou reescritos com base no video e ebook citados abaixo)
* [Spring Security | Curso 2022](https://www.youtube.com/watch?v=t6prPki7daU&t=6034s)

## Autenticação e Controle de Acesso com Spring Security

O Spring Security é um dos projetos que fazem parte do eco sistema Spring, conta com uma poderoza estrutura personalizada para aplicar e implementar autenticação/autorizações em aplicações java spring.

## Vulnerabilidades de Segurança em Aplicações Web

Algumas Vulnerabilidades de segurança comuns em aplicações web:
  - Vulnerabilidades na Autenticação e Autorização;
  - Cross Site Request Forgery - CSRF;
  - Usando Dependências com Vulnerabilidades Conhecidas;

Site para consultar as top 10 vulnerabilidades acontecendo nas aplicações web pelo mundo:
* [Top 10 OWASP](https://owasp.org/www-project-top-ten)

### Vulnerabilidade na Autenticação e Autorização

![image](https://user-images.githubusercontent.com/30484386/187073806-458caceb-8538-4211-ae9e-712213baa08c.png)

Imagine o Cenário, João deseja realizar uma requisição na aplicação e esta logado com seu usuario, na chamada acima, ele solicita uma requisição ao Spring Security que verifica se ele esta autenticado, caso sim, retorna os dados dos produtos de joao.

![image](https://user-images.githubusercontent.com/30484386/187073818-2fc352f5-92e7-422c-b714-a8ae31c240b3.png)

Porém, o serviço de autenticação / autorização, só está verificando se o João está logado, mas não se ele tem acesso ao endpoin, agora imagine que joão faça uma requisição aos produtos de Maria (imagem acima), como a aplição não está verificando se ele tem autorização a rota, ele conseguira consumir os produtos de Maria, que seria um erro de segurança.

### Cross Site Request Forgery - CSRF

Situação se aplica para aplicações que tem algum tipo de interface, quando temos esse tipo de situação, precisamos incluir tratativas no Spring security para não ter problema com essa vulnerabilidade.

Ações que podem mitigar essa vulnerabilidade?
  - User tokens para identificar a requisição;
  - Utilizar CORS limitados;
  - Validar a origem da requisição;
  - etc.

![image](https://user-images.githubusercontent.com/30484386/187194824-0d128812-2a75-4720-9e9c-ee5ee694cf21.png)

### Usando Dependências com Vulnerabilidades Conhecidas

Um exemplo é a vulnerabilidade detectada no Log4J2 nas versões anteriores no final do ano de 2021.

## Basic Authentication

- Fluxo Basic Authentication

![image](https://user-images.githubusercontent.com/30484386/187194664-77a1d110-4a45-4f66-a773-11be491f534c.png)

No primeiro o cliente tenta fazer a requisição sem estar autenticado e não mandando nenhum header authorization. Sendo assim o cliente não tem autorização para fazer o consumo.

![image](https://user-images.githubusercontent.com/30484386/187194715-7bcfc0a6-9a78-4010-94cd-c6b7ddb4dfc9.png)

No segundo cenario, temos o cliente realizando a requisição e passando o authorization mais o encode user:password, Sendo assim o cliente tem a autorização necessaria para consumir o endpoint.

## Overview do Projeto Spring Boot com Spring Security

A ideia é dar continuidade a API já desenvolvida anteriormente, o Parking Control API,  adicionando a API o Spring Security que sera responsavel por cuidar da autenticação e controle de acesso.

1. Primeiro iremos adicionar a dependencia ao projeto.

```diff
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
```

2. Ao adicionar a dependencia, o proprio spring security já configura uma autenticação básica no projeto, gerando um password automatico:

```diff
Using generated security password: 90d19b02-50be-4a11-a708-fe2b5c2e6fd1

This generated password is for development use only. Your security configuration must be updated before running your application in production.
```

![image](https://user-images.githubusercontent.com/30484386/187199018-12a4cff0-5c8a-4c20-85b7-2e630aef37a1.png)

o usuario padrão gerado é user

3. Podemos personalizar a forma que sera autenticado, ao adicionar a dependencia no projeto ela vem com a autenticação default

4. Adicionar ao pacote ja existente no projeto /configs, um novo pacote especifico para segurança, configs/security

![image](https://user-images.githubusercontent.com/30484386/187199604-a30ba4f9-e636-435d-abad-17f704d140d8.png)
