package com.api.parkingcontrol.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

//criando uma formatação global para datas
@Configuration
public class DateConfig {
    //define o padrão de data para os padrões esperados de utc
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    //seta dentro do localdatetimeserializer o padrão definido acima
    public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

    //passando a definição de formato para o JavaTimeModule para poder realizar a serialização
    //definindo @bean para que o spring entenda as configurações realizadas
    @Bean
    //@primary por questoes de prioridade
    @Primary
    public ObjectMapper objectMapper(){
        JavaTimeModule module = new JavaTimeModule();
        //adicionando o serializer que criamos
        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
        //e adiciona no ObjectMapper
        return new ObjectMapper().registerModule(module);
    }
}
