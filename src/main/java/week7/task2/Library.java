package week7.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Optional<Book> getBook(String isbn) {
        for(Book book : books){
            if(book.getISBN().equals(isbn)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }
}
