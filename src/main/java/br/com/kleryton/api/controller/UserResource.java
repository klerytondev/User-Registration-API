package br.com.kleryton.api.controller;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.domain.dtos.UserDTO;
import br.com.kleryton.api.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findByID(@PathVariable Long id) {
        return ResponseEntity.ok().body(mapper.map(userService.findByID(id), UserDTO.class));

    }

    @GetMapping(value = "/findall")
    public ResponseEntity<List<UserDTO>> findAll() {

        return ResponseEntity.ok().body(userService.findAll().stream().map(list -> mapper.map(list, UserDTO.class))
                .collect(Collectors.toList()));
    }

}
