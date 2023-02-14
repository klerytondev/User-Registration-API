package br.com.kleryton.api.controller.exceptions;

import br.com.kleryton.api.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * @author: Kleryton de souza
 */
//Anotação que permite tratar exceções em toda a aplicação de forma global
@ControllerAdvice
public class ApplicationControllerAdvice {
    /*
     *  Handler para tratar Status 404, caso o servidor não encontre uma representação atual do recurso solicitado
     */
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandarError err = new StandarError();
        HttpStatus status = HttpStatus.NOT_FOUND;
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Não foi possível encontrar o recurso solicitado!");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    /*
     * Handler para tratar Status 400, geradas pelas validações dos objetos da bean validation nos RequestsDtos
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandarError> ArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        StandarError err = new StandarError();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("null field");
        err.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
