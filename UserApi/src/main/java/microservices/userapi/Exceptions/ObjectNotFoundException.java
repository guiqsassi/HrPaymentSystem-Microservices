package microservices.userapi.Exceptions;

public class ObjectNotFoundException extends  RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
