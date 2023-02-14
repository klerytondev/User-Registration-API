package br.com.kleryton.api.services;

import br.com.kleryton.api.domain.User;

import java.util.List;

public interface UserService {

    User findByID(Long id);
    List<User> findAll();
}
