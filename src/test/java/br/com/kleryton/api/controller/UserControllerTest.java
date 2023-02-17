package br.com.kleryton.api.controller;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.domain.dtos.UserDTO;
import br.com.kleryton.api.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    public static final String NAME = "Kleryton";
    public static final Long ID = 1L;
    public static final String EMAIL = "kleryton@gmail.com";
    public static final String PASSWORD = "258";
    public static final int INDEX = 0;
    public static final String OBJETO_NÃO_ENCONTRADO = "Objeto não encontrado!";

    private User user;
    private UserDTO userDto;

//    Cria uma instância real mockada
    @InjectMocks
    private UserController controller;

//  @Cria uma instância mockada
    @Mock
    private ModelMapper mapper;

//  @Cria uma instância mockada
    @Mock
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findByID() {
    }

    @Test
    void findAll() {
    }

    @Test
    void createUser() {
    }

    @Test
    void userUpdate() {
    }

    @Test
    void deleteUser() {
    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDto = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}