package br.com.kleryton.api.controller;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.domain.dtos.UserDTO;
import br.com.kleryton.api.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {

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

    @PostMapping(value = "/add")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> userUpdate(@PathVariable Long id, @RequestBody UserDTO obj){
        obj.setId(id);
        User userObj = userService.updateUser(obj);
        return ResponseEntity.ok().body(mapper.map(userObj, UserDTO.class));
    }
}
