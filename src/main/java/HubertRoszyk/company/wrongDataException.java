package HubertRoszyk.company;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "wrong password")
public class wrongDataException extends RuntimeException{

}
