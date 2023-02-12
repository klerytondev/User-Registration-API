package br.com.kleryton.api.services;

import br.com.kleryton.api.domain.User;

public interface UserService {

    User findByID(Integer id);

}
