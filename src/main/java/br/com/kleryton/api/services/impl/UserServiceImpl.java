package br.com.kleryton.api.services.impl;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.domain.dtos.UserDTO;
import br.com.kleryton.api.repositories.UserRepositorie;
import br.com.kleryton.api.services.UserService;
import br.com.kleryton.api.services.exceptions.IntegridadeDeDadosException;
import br.com.kleryton.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositorie userRepositorie;
    @Autowired
    private ModelMapper mapper;

    @Override
    public User findByID(Long id) {
        Optional<User> userOptional = userRepositorie.findById(id);
        return userOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public List<User> findAll() {
        return userRepositorie.findAll();
    }

    @Override
    public User createUser(UserDTO userDTO) {
        finsByEmail(userDTO);
        return userRepositorie.save(mapper.map(userDTO, User.class));
    }

    @Override
    public User updateUser(UserDTO obj) {
        return userRepositorie.save(mapper.map(obj, User.class));
    }

    private void finsByEmail(UserDTO obj){
        Optional<User> user = userRepositorie.findByEmail(obj.getEmail());
        if(user.isPresent()){
            throw new IntegridadeDeDadosException("Email já cadastrado!");
        }
    }
}
