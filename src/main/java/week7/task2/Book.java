package week7.task2;

enum Status{
    AVAILABLE, CHECKED_OUT, RESERVED;
}

public class Book {
    private String title, author, ISBN;
    private Status status;

    public Book(String title, String author, String ISBN, Status status){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = status;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getISBN(){
        return ISBN;
    }

    @Override
    public String toString(){
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Status: " + status;
    }
}
