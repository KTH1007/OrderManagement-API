package kr.co.ordermanagement.domain.exception;

public class CanNotCancellableStateException extends RuntimeException{
    public CanNotCancellableStateException(String messsge) {
        super(messsge);
    }
}
