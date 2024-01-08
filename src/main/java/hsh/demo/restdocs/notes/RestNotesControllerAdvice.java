package hsh.demo.restdocs.notes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestNotesControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    void handleIllegalArgumentException(IllegalArgumentException ex,
                                        HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(ResourceDoesNotExistException.class)
    void handleResourceDoesNotExistException(ResourceDoesNotExistException ex,
                                             HttpServletRequest request,
                                             HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(),
                "The resource '" + request.getRequestURI() + "' does not exist");
    }
}
