package practice.quiz_practice_december;

public class PasswordSmallerThanFiveCharactersException extends RuntimeException {
    public PasswordSmallerThanFiveCharactersException(String message) {
        super(message);
    }
}
