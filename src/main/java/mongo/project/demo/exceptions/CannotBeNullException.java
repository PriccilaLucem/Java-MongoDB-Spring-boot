package mongo.project.demo.exceptions;

public class CannotBeNullException extends RuntimeException {
    public CannotBeNullException(String msg) {
        super(msg);
    }
}
