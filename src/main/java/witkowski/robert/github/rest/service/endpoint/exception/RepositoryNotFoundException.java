package witkowski.robert.github.rest.service.endpoint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RepositoryNotFoundException extends RuntimeException {
    public RepositoryNotFoundException(String owner, String name) {
        super(String.format("Repository with name %s in user %s not found.", name, owner));
    }
}
