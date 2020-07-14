package practice.signup.exception;

public class InvalidNameException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";

    public InvalidNameException() {
        super(ERROR_MESSAGE);
    }
}
