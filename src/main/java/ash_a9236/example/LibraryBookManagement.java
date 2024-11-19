package ash_a9236.example;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookManagement {
    private ArrayList<Book> books;

    public LibraryBookManagement() {
        books = new ArrayList<>();
    }

    public void addBook (Book book) {
        books.addLast(book);
    }

    public Book findBookViaTitle (String title) {

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }

        return null;
    }

    public void manuallyAddBook() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please input the book's title : ");
        String title = console.nextLine();

        System.out.println("Please input the book's author : ");
        String author = console.nextLine();

        //create try-catch for int (??)
        System.out.println("Please input the book's year of publication : ");
        int year = console.nextInt();

        Book newBook = new Book(title, author, year);
        addBook(newBook);

    }

    public void removeBookViaTitle (String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
            }
        }

    }




    /*
    Design a menu-driven program that allows users to:

        o Display All Books Sorted by Title:
                Sorts and displays the books alphabetically by title.

        o Display All Books Sorted by Year:
                Sorts and displays the books in ascending order by publication year.

        o Filter Books by Author:
                Displays all books written by a specified author.

        o Filter Books by Year Range:
                Displays all books published within a specified range of years.

        o Add a New Book:
                Allows the user to add a new book to the collection.

        o Remove a Book:
                Allows the user to remove a book from the collection by title.

        o Save and Exit:
                Saves all changes back to the file and exits the program.
     */




}
