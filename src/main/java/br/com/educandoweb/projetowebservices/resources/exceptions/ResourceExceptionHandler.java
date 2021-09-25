package br.com.educandoweb.projetowebservices.resources.exceptions;

import br.com.educandoweb.projetowebservices.services.exceptions.DatabaseException;
import br.com.educandoweb.projetowebservices.services.exceptions.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourcesNotFoundException resourcesNotFoundException, HttpServletRequest request){
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError erro = new StandardError(Instant.now(), status.value(), error, resourcesNotFoundException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException(DatabaseException resourcesNotFoundException, HttpServletRequest request){
        String error = "Data Base Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(), status.value(), error, resourcesNotFoundException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }
}
