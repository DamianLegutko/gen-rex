package pl.damianlegutko.util.genrex.exception;

public class GenRexRuntimeException extends RuntimeException {
    public GenRexRuntimeException(String message) {
        super(message);
    }

    public GenRexRuntimeException(Throwable cause) {
        super(cause);
    }

    public GenRexRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
