abstract  class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title; 
    }

    public String getAuthor() { 
        return author; 
    }

    public String getISBN() { 
        return isbn; 
    }

    public abstract void displayDetails();
}

class PrintedBook extends Book {
    private int pages;

    public PrintedBook(String title, String author, String isbn, int pages) {
        super(title, author, isbn);
        this.pages = pages;
    }

    @Override
    public void displayDetails() {
        System.out.println("Printed Book: " + getTitle() + " by " + getAuthor() + "\nISBN: " + getISBN() + "\nPages: " + pages);
    }
}

class EBook extends Book {
    private double fileSize; // in MB

    public EBook(String title, String author, String isbn, double fileSize) {
        super(title, author, isbn);
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-Book: " + getTitle() + " by " + getAuthor() +
                           "\nISBN: " + getISBN() + "\nFile Size: " + fileSize + "MB");
    }
}

class AudioBook extends Book {
    private double duration; // in hours

    public AudioBook(String title, String author, String isbn, double duration) {
        super(title, author, isbn);
        this.duration = duration;
    }

    @Override
    public void displayDetails() {
        System.out.println("Audio Book: " + getTitle() + " by " + getAuthor() +
                           "\nISBN: " + getISBN() + "\nDuration: " + duration + " hours");
    }
}

public class Library {
    public static void main(String[] args) {
        Book printed = new PrintedBook("Java Programming", "James Gosling", "123-456789", 500);
        Book ebook = new EBook("Effective Java", "Joshua Bloch", "987-654321", 2.5);
        Book audio = new AudioBook("The Art of War", "Sun Tzu", "111-222333", 3.2);

        printed.displayDetails();
        System.out.println();
        ebook.displayDetails();
        System.out.println();
        audio.displayDetails();
    }    
}
