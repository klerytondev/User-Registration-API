package br.com.kleryton.api.services.impl;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.repositories.UserRepositorie;
import br.com.kleryton.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositorie userRepositorie;

    @Override
    public User findByID(Integer id) {
        Optional<User> userOptional = userRepositorie.findById(id);
        return userOptional.orElse(null);
    }
}
