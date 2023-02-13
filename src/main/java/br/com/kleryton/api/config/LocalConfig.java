package br.com.kleryton.api.config;

import br.com.kleryton.api.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepositorie userRepositorie;

    @Bean
    public void startDB(){

    }
}
