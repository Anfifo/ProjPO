package pex.core;

/**
 * Exception for representing an invalid argument inside a composite expression.
 */
public class BadArgumentException extends RuntimeException {

    public BadArgumentException(){
        super();
    }

    public BadArgumentException(String error){
        super(error);
    }
}
