package me.jaff.pokedexapi.exception;

import me.jaff.pokedexapi.model.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<BaseResponse> handleResourceException(Exception ex, WebRequest request){
        return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(),
                ((ServletWebRequest)request).getRequest().getRequestURI(), null), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(),
                ((ServletWebRequest)request).getRequest().getRequestURI(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // create a method to handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
