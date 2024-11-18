package week7.task2;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Book book1 = new Book("Effective Java", "Joshua Bloch", "9780134685991", Status.AVAILABLE);
        Book book2 = new Book("Clean Code", "Robert C. Martin", "9780132350884", Status.CHECKED_OUT);

        library.addBook(book1);
        library.addBook(book2);

        String ISBNToSearch = "9780134685991"; // Book exists
        String ISBNNotFound = "9780139999999"; // Book doesn't exist

        //orElse
        System.out.println("Using orElse:");
        Book foundBookOrElse = library.getBook(ISBNToSearch)
                .orElse(new Book("Default Title", "Unknown Author", ISBNToSearch, Status.RESERVED));
        System.out.println(foundBookOrElse);

        //orElseGet
        System.out.println("\nUsing orElseGet:");
        Book foundBookOrElseGet = library.getBook(ISBNNotFound)
                .orElseGet(() -> new Book("Default Title", "Unknown Author", ISBNNotFound, Status.RESERVED));
        System.out.println(foundBookOrElseGet);

        //orElseThrow
        System.out.println("\nUsing orElseThrow:");
        try {
            Book foundBookOrElseThrow = library.getBook(ISBNToSearch)
                    .orElseThrow(() -> new BookNotFoundException(ISBNNotFound));
            System.out.println(foundBookOrElseThrow);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
