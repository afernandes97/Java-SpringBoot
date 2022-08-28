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
