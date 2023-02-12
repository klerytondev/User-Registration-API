package br.com.kleryton.api.services.impl;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findByID(Integer id) {
        return null;
    }
}
