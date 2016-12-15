package pex.core;

/**
 * Exception for representing an invalid argument inside a composite expression.
 */
public class BadArgumentException extends RuntimeException {
    private String _message;

    public BadArgumentException(){
        super("Invalid Arguments");
    }

    public BadArgumentException(String error){
        super("Invalid Arguments: " + error);
        _message = "Invalid Arguments: " + error +" ";
    }

    public String getMessage(){
        return _message;
    }
}
