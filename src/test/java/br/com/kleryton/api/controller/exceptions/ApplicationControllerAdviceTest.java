package br.com.kleryton.api.controller.exceptions;

import br.com.kleryton.api.services.exceptions.IntegridadeDeDadosException;
import br.com.kleryton.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationControllerAdviceTest {

    public static final String MESSAGE = "Não foi possível encontrar o recurso solicitado!";
    public static final String INTEGRIDADE_DE_DADOS = "Integridade de dados!";
    @InjectMocks
    private ApplicationControllerAdvice resApplicationControllerAdvice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundThenReturnAResponseEntity() {
        ResponseEntity<StandarError> response = resApplicationControllerAdvice
                .objectNotFound(new ObjectNotFoundException(MESSAGE),
                        new MockHttpServletRequest());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandarError.class, response.getBody().getClass());
        assertEquals(MESSAGE, response.getBody().getError());
        assertEquals(404, response.getBody().getStatus());

    }

    @Test
    void whenDataIntegrityThenReturnAResponseEntity() {

        ResponseEntity<StandarError> response = resApplicationControllerAdvice
                .dataIntegrity(new IntegridadeDeDadosException(INTEGRIDADE_DE_DADOS),
                        new MockHttpServletRequest());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandarError.class, response.getBody().getClass());
        assertEquals(INTEGRIDADE_DE_DADOS, response.getBody().getError());
        assertEquals(400, response.getBody().getStatus());

    }

    @Test
    void argumentNotValid() {
    }
}