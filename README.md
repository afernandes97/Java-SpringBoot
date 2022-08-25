# Spring Boot Framework

<img src="https://pbs.twimg.com/media/DU7GUGCV4AAf90X.jpg">

Este artigo tem como base servir de acompanhamento quanto a minha evolção como desenvolvedor beck-end java, atualmente trabalho com front-end mas já vem um tempo que venho sentindo vontade para unir os dois.
No começo desse aglomerado de estudos, atualmente, estou avançando quanto ao estudo referente a java SE, porem este artigo estara focado no aprendizado, uso e boas praticas quanto ao desenvolvimento Java Spring Boot.


## Como vai funcionar

1. A ideia consiste em estudar ( e comitar minha evolução ) enquanto eu estiver sem projeto no meu trabalho atual.
2. O projeto consiste em aplicar padrões que estão no mercado.
3. Serão N projetos a depender de cada conceito estudado.
4. No minimo 1h de estudo ao dia.

## Referencias de estudo
(prints e trechos de textos copiados e ou reescritos com base no video e ebook citados abaixo)
* [Spring Boot | Curso Completo 2022](https://www.youtube.com/watch?v=LXRU-Z36GEU)
* [Spring Boot | E-book | Michelli Brito](https://www.michellibrito.com/)

# Spring Framework

<img src="https://user-images.githubusercontent.com/30484386/186647617-a29e0a81-adde-44c4-86b7-1b1b07c0df68.png">

O Spring Framework consiste em um projeto base onde tem classes básicas e avançadas, e é divido em 7 grupos.
Data Access para transações com banco de dados, web contém os recursos para uma aplicação web, como a implementação do
MVC, Web Services REST, entre outros, AOP fornece a implementação para programação orientada a
aspectos, o modulo Instrumentation fornece implementações de
instrumentaçã e o módulo Messaging contém implementação e
suporte para programação baseada em mensagens, teste possui o suporte para os testes unitários utilizando JUnit e
testes de integração e o core container(destacado na imagem), dentro do spring framework, de todos os grupos o core container é o principal deles, por que dentro dele está a implementação da inversão de controle (IoC) utilizando a injeção de dependencia para gerenciar os Beans (a baixo explicação de cada um).

## Inversão de Controle (IoC)

Nada mais é que um padrão de projeto em que um objeto apenas declara suas dependências sem cria-las e delega a tarefa de construir tais dependências a um Container IoC(Core container). A inversão de controle é algo abstrato é um padrão de projeto, e o spring implementa na pratica o IoC através da Injeção de Dependência.

Exemplo:
Considerando duas classes A e B, onde a casse A possui uma dependência da classe B( já que a A utiliza um método da B). ASsim a classe A sempre teria que criar uma nova instancia da classe B para poder utilizar o método(veja a baixo)

Metodo A:
 ```diff
  public class A{
    private B b;
    
    public void metodoA() {
      b = new B();
      b.metodoB();
    }
  }
  ```
    
Metodo B:
 ```diff
  public class B{
    public void metodoB() {
      ...
    }
  }
  ```
  
Porém utilizando a Inversão de Controle, a classe A não precisa se preocupar em criar uma instância de B, pois essa responsabilidade passa ser cargo do Container do Spring, que realiza a inversão de controle através da injeção de dependência(abaixo explicação).

## Injeção de Dependência

É algo mais concreto, a injeção de dependência é utilizada pelo Spring Framework de aplicar a implmentação da inversão de controle(IoC) quando necessário.

Exemplo:

A classe A cria um ponto de injeção da classe B(pelo contrutor por exemplo) e quando houver necessidade o container irá criar uma instância da classe B para que a A possa utilizar o metodo dentro da B

Metodo A:
 ```diff
  public class A{
    private B b;
    
    public A(B b){    
      b = new B();
    }
    public void metodoA() {
      b.metodoB();
    }
  }
  ```

Metodo B:
 ```diff
  public class B{
    public void metodoB() {
      ...
    }
  }
  ```
  
## Core Container

Quando a aplicação é executada, o Core Container é iniciado, as
configurações da aplicação pré-definidas em classes ou arquivos XML são
lidas e as dependências necessárias são definidas e criadas através da IoC e destruídas quando não mais forem utilizadas. Essas dependências são os Beans(explicado abaixo), Esses passos definem o ciclo de vida de um Container.

![image](https://user-images.githubusercontent.com/30484386/186658358-29e5edff-1ebb-4aea-97a7-32daa872597e.png)
(imagem do e-book springboot 3 edição)

## Bean

Bean é um objeto que é instanciado, montado e gerenciado por um container do Spring através da Inversão de Controle(IoC) e injeção de Dependências. Exemplos de Estereótipos do Spring(Beans): @Component(Classe generica, se encaixa em qualquer uma das situações), @Service(Classe de serviço), @Repository(Classe de persistência com o banco de dados), @Controller(Classe para criar/gerenciar os endpoints).

Ciclo de vida de um Bean:

![image](https://user-images.githubusercontent.com/30484386/186658518-419283d9-0d30-439d-a774-8f5d8c579692.png)
(imagem do e-book springboot 3 edição)


# Projeto 1 - Parking Control API
* [Curso do projeto 1](https://www.youtube.com/watch?v=LXRU-Z36GEU)
* [Repositório](https://github.com/afernandes97/Java-SpringBoot/tree/main/parking-control)

O projeto consiste em criar uma API de estacionamento, utilizando Spring boot, Spring MVC(construir a aplicação web), Spring Data JPA(transações com banco de dados postgree), Spring Validation(realiza validações).

## Swagger API Methods

![image](https://user-images.githubusercontent.com/30484386/186662095-afcb206b-ae29-49ca-97b3-4aca97103ca8.png)

A ideia da API é controlar as vagas de estacionamentos.

Utilizando o * [Spring Initializr](https://start.spring.io/) para dar o start no projeto, ele gera um arquivo de configuração inicial dependendo das configurações escolhidas.

Configurações definidas para o projeto:

![image](https://user-images.githubusercontent.com/30484386/186666576-d09adea2-c916-4345-b302-f7adcd65aa9f.png)

## Configurações conexão Banco de Dados Postgre(application.properties):

```diff
//url de conexao com banco local
spring.datasource.url = jdbc:postgresql://localhost:5432/parking-control-db
//definindo username do banco local
spring.datasource.username = username
//definindo senha do banco local
spring.datasource.password = *****
//sempre que algo seja atualizado nas entidades, ao executar a aplicação sera criado automaticamente na base de dados
spring.jpa.hibernate.ddl-auto=update
//desabilitar non_contextual_creation o hibernate procura metadados ao iniciar a aplicação podendo gerar conflitos
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```
## Gerando Getters and Setters automatico com IntelliJ:

1. No Model que você pretende gerar, clique com botão direito ao final da página e depois em generate(já com o modelo pré definido)

![image](https://user-images.githubusercontent.com/30484386/186702922-5a0338b9-3b35-48db-9702-9ac8a0d350e4.png)


2. Irá abrir a tela abaixo, clique em Getter and Setter

![image](https://user-images.githubusercontent.com/30484386/186703122-73f44cd2-33bf-4cf2-b978-6ac7b2c074ad.png)

3. Selecione os item aos quais irá querer gerar o getter and setter, depois clique em OK

![image](https://user-images.githubusercontent.com/30484386/186703447-8432ce9c-5fdc-49e2-b65d-93b4f9829853.png)

4. Os Getters and Setters serão gerados automaticamente.
