package exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
