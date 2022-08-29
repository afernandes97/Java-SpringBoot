package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//avisando ao spring que essa classe sera um Bean de configuração
@Configuration
//sera abordado duas maneiras, a primeira seria a forma "tradicional" utilizada anteriormente, muitos projetos caso nao feito atualização, sera encontrado dessa maneira, utilizando a classe websecurityconfigureradapter
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { //a classe websecurityconfigureradapter permite fazer configurações customizaveis de configuração.

    //iremos utilizar dos metodos de substuição com o @override dessa classe webconfigureradapter
    @Override
    //metodo que pertence ao websecurityconfigureradpter utilizamos para customizar a configuração do http security, onde realmente ira receber as solicitacoes http
    protected void configure(HttpSecurity http) throws Exception {
        //configurar o http security, definindo o que sera utilizado
        http
                //definindo que sera utilizado o http basic
                .httpBasic()
                //sempre que quiser unir as configurações utilizar and
                .and()
                //definindo que sera utilizado junto com httpauthorizehttprequest, que para qlqr requisição sera permitido o acesso
                .authorizeHttpRequests()
                //anyrequest permitall avisando q sera permitido para qlr acesso(ainda nao expecificando as requisiçoes e que posteriormente sera definido)
                //.anyRequest().permitAll();
                //definindo que qualquer solicitação a api para consumo deve estar autenticado.
                .anyRequest().authenticated();
    }
}
