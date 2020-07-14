package practice.signup.exception;

public class InvalidPasswordException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.\n";

    public InvalidPasswordException() {
        super(ERROR_MESSAGE);
    }
}
