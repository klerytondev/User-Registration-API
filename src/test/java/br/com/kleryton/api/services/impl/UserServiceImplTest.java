package br.com.kleryton.api.services.impl;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.domain.dtos.UserDTO;
import br.com.kleryton.api.repositories.UserRepositorie;
import br.com.kleryton.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

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
        when(repositorie.findById(Mockito.anyLong())).thenReturn(optionalUser);

        //   Retorno no metodo findByID da classe UserServiceImpl
        User response = service.findByID(ID);

        //    Asegura que meu User não é nulo
        assertNotNull(response);

        //   Assegura que os dois argumentos são iguais
        assertEquals(User.class, response.getClass());

        //   Assegura que os dois objetos são iguais
        assertEquals(ID, response.getId());//   Assegura que os dois IDs são iguais
        assertEquals(NAME, response.getName());//   Assegura que os dois IDs são iguais
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFound() {
        //Quando buscar um ID não existente no repositorie deve retornar uma exception
        when(repositorie.findById(anyLong())).thenThrow(new ObjectNotFoundException("Objeto não encontrado!"));

        try {
            // Quando chamar o service.findByID(ID) mockado deve lançar a exceção
            service.findByID(ID);
        } catch (Exception ex) {
            // Assegura as exceções são iguais
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            // Assegura as mensagen das exceções são iguais
            assertEquals("Objeto não encontrado!", ex.getMessage());
        }
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