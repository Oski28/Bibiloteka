package Library.Model.Exception;

public class PublicationAlreadyExistsException extends RuntimeException {
    public PublicationAlreadyExistsException(String message){
        super(message);
    }
}
