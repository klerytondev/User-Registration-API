package br.com.kleryton.api.services.impl;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.domain.dtos.UserDTO;
import br.com.kleryton.api.repositories.UserRepositorie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserServiceImplTest {

    public static final String NAME = "Kleryton";
    public static final Long ID = 1L;
    public static final String EMAIL = "klertyton@gmail.com";
    public static final String PASSWORD = "258";

    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserRepositorie repositorie;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDto;
    private Optional<User> optionalUser;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        //  Quando userRepositorie.findById=Mockado(repositorie.findById) for chamado,
        //  então retorna optionalUser
        Mockito.when(repositorie.findById(Mockito.anyLong())).thenReturn(optionalUser);
        //   Retorno no metodo findByID da classe UserServiceImpl
        User response = service.findByID(ID);
        //   Assegura que os dois argumentos são iguais
        Assertions.assertEquals(User.class, response.getClass());
    }

    @Test
    void findAll() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDto = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}