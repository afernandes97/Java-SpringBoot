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


# Spring Framework

<img src="https://user-images.githubusercontent.com/30484386/186647617-a29e0a81-adde-44c4-86b7-1b1b07c0df68.png">

O Spring Framework consiste em um projeto base onde tem classes básicas e avançadas, e é divido em 7 grupos.
Data Access para transações com banco de dados, web para construir aplicações para web, AOP para  a programação orientada a aspectos, intrumentação e orientação a mensagens, testes unitarios quanto integrados e o core container(destacado na imagem), dentro do spring framework, de todos os grupos o core container é o principal deles, por que dentro dele está a implementação da inversão de controle (IoC) utilizando a injeção de dependencia para gerenciar os Beans (a baixo explicação de cada um).

## Inversão de Controle (IoC)

Nada mais é que um padrão de projeto em que um objeto apenas declara suas dependências sem cria-las e delega a tarefa de construir tais dependências a um Container IoC(Core container). A inversão de controle é algo abstrato é um padrão de projeto, e o spring implementa na pratica o IoC através da Injeção de Dependência.

## Injeção de Dependência

É algo mais concreto, a injeção de dependência é utilizada pelo Spring Framework de aplicar a implmentação da inversão de controle(IoC) quando necessário.

## Bean

Bean é um objeto que é instanciado, montado e gerenciado por um container do Spring através da Inversão de Controle(IoC) e injeção de Dependências. Exemplos de Estereótipos do Spring(Beans): @Component(Classe generica, se encaixa em qualquer uma das situações), @Service(Classe de serviço), @Repository(Classe de persistência com o banco de dados), @Controller(Classe para criar/gerenciar os endpoints).



