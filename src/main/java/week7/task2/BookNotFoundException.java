package week7.task2;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String ISBN) {
        super("Book with ISBN " + ISBN + " not found.");
    }
}
