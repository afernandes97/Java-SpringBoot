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

* [Spring Boot | Curso Completo 2022](https://www.youtube.com/watch?v=LXRU-Z36GEU)
* [Spring Boot | Ebook | Michelli Brito](https://www.michellibrito.com/)

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

## Bean

Bean é um objeto que é instanciado, montado e gerenciado por um container do Spring através da Inversão de Controle(IoC) e injeção de Dependências. Exemplos de Estereótipos do Spring(Beans): @Component(Classe generica, se encaixa em qualquer uma das situações), @Service(Classe de serviço), @Repository(Classe de persistência com o banco de dados), @Controller(Classe para criar/gerenciar os endpoints).



