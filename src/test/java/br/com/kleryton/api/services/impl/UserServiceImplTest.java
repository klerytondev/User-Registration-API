package br.com.kleryton.api.services.impl;

import br.com.kleryton.api.domain.User;
import br.com.kleryton.api.domain.dtos.UserDTO;
import br.com.kleryton.api.repositories.UserRepositorie;
import br.com.kleryton.api.services.exceptions.IntegridadeDeDadosException;
import br.com.kleryton.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceImplTest {

    public static final String NAME = "Kleryton";
    public static final Long ID = 1L;
    public static final String EMAIL = "kleryton@gmail.com";
    public static final String PASSWORD = "258";
    public static final int INDEX = 0;
    public static final String OBJETO_NÃO_ENCONTRADO = "Objeto não encontrado!";

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
//      Quando userRepositorie.findById=Mockado(repositorie.findById) for chamado,
//      então retorna optionalUser
        when(repositorie.findById(anyLong())).thenReturn(optionalUser);

//       Retorno no metodo findByID da classe UserServiceImpl
        User response = service.findByID(ID);

//       Asegura que meu User não é nulo
        assertNotNull(response);

//       Assegura que os dois argumentos são iguais
        assertEquals(User.class, response.getClass());

//       Assegura que os dois objetos são iguais
        assertEquals(ID, response.getId());
//       Assegura que os dois IDs são iguais
        assertEquals(NAME, response.getName());
//      Assegura que os dois IDs são iguais
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFound() {
        //Quando buscar um ID não existente no repositorie deve retornar uma exception
        when(repositorie.findById(anyLong())).thenThrow(new ObjectNotFoundException(OBJETO_NÃO_ENCONTRADO));

        try {
            // Quando chamar o service.findByID(ID) mockado deve lançar a exceção
            service.findByID(ID);
        } catch (Exception ex) {
//          Assegura as exceções são iguais
            assertEquals(ObjectNotFoundException.class, ex.getClass());
//          Assegura as mensagen das exceções são iguais
            assertEquals(OBJETO_NÃO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfUsers() {
        when(repositorie.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();
//      Verifica o User retornado do service.findAll() não é nulo
        assertNotNull(response);
//        Asseguura que o retorno do objeto mockado é apenas 1
        assertEquals(1, response.size());
//        Assegura que o retorno do objeto mockado é igual ao objeto retornado do service
        assertEquals(User.class, response.get(INDEX).getClass());
//        Assegura que o retorno do ID do objeto mockado é igual ao ID doobjeto retornado do service
        assertEquals(ID, response.get(INDEX).getId());
//        Assegura que o retorno do NAME do objeto mockado é igual ao NAME doobjeto retornado do service
        assertEquals(NAME, response.get(INDEX).getName());
//        Assegura que o retorno do EMAIL do objeto mockado é igual ao EMAIL doobjeto retornado do service
        assertEquals(EMAIL, response.get(INDEX).getEmail());
//        Assegura que o retorno do ID do objeto mockado é igual ao ID doobjeto retornado do service
        assertEquals(PASSWORD, response.get(INDEX).getPassword());

    }

    @Test
    void whenCreateUserThenAnUserInstance() {

        when(repositorie.save(Mockito.any())).thenReturn(user);

        User response = service.createUser(userDto);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenUpdateUserThenAnIntegridadeDeDadosException() {
        when(repositorie.findByEmail(Mockito.anyString())).thenReturn(optionalUser);

        try {
            optionalUser.get().setId(3L);
            service.createUser(userDto);
        } catch (Exception ex) {
            assertEquals(IntegridadeDeDadosException.class, ex.getClass());
            assertEquals("Email já cadastrado!", ex.getMessage());
        }
    }


    @Test
    void whenUpdateUserThenAnUserUpdate() {
        when(repositorie.save(Mockito.any())).thenReturn(user);

        User response = service.updateUser(userDto);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void deleteUserWithSucces() {
        when(repositorie.findById(Mockito.anyLong())).thenReturn(optionalUser);
//        Não faça nada quando o metodo findById for passado e passado qualquer valor Long
        doNothing().when(repositorie).deleteById(Mockito.anyLong());

        service.deleteUser(ID);

//        Verifica quantas vezes o metodo FindyByID foi chmado. Para a teste abaixo apenas 1
        verify(repositorie, times(1)).deleteById(Mockito.anyLong());
    }

    @Test
    void deleteUserObjectNotFoundException() {
        when(repositorie.findById(Mockito.anyLong())).thenThrow(new ObjectNotFoundException(OBJETO_NÃO_ENCONTRADO));

        try{
            service.deleteUser(ID);

        }catch (RuntimeException ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NÃO_ENCONTRADO, ex.getMessage());
        }
    }


    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDto = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}