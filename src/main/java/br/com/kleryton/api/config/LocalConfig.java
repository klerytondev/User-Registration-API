package br.com.kleryton.api.config;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepositorie userRepositorie;

    @Bean
    public void startDB() {
        User user01 = new User(null, "Kleryton", "kleryton.inside@gmail.com", "123");
        User user02 = new User(null, "Maira", "maira.luana20@gmail.com", "456");
        userRepositorie.saveAll(List.of(user01, user02));
    }
}
