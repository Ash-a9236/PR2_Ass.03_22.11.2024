package ash_a9236.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryBookManagement {
    private ArrayList<Book> books;

    public LibraryBookManagement(ArrayList<Book> books) {
        this.books = new ArrayList<>();
    }

/*----------------------------------------------------------------------------------------------------------------------
    BASIC METHODS
----------------------------------------------------------------------------------------------------------------------*/
    public void addBook (Book book) {
        books.addLast(book);
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
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " removed");
                books.remove(book);
            }
        }
    }

/*----------------------------------------------------------------------------------------------------------------------
    SEARCHING METHODS
----------------------------------------------------------------------------------------------------------------------*/

    public Book findBookViaTitle (String title) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return book;
            }
        }
        return null;
    }

    public Book searchByYearRange (int startDate, int endDate) {
        for (Book book : books) {
            if (book.getYear() >= startDate && book.getYear() <= endDate) {
                return book;
            }
        }
        return null;
    }

    public Book searchAuthor (String author) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

/*----------------------------------------------------------------------------------------------------------------------
    SORTING METHODS
----------------------------------------------------------------------------------------------------------------------*/
    public void sortBooksByYear () {
        books.sort(Comparator.comparingInt(Book::getYear));
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void sortBooksByTitle () {
        books.sort(Comparator.comparing(Book::getTitle));
        for (Book book : books) {
            System.out.println(book);
        }
    }
/*----------------------------------------------------------------------------------------------------------------------
    I/O METHODS
----------------------------------------------------------------------------------------------------------------------*/

    public void saveToFile(ArrayList<Book> books, boolean append) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter( "Books.csv", append));

            //Header
            writer.write("TITLE, AUTHOR, YEAR");
            writer.newLine();

            for (Book book : books) {
                String toCVS = book.getTitle() + ", " + book.getAuthor() + ", " + book.getYear();
                writer.write(toCVS);
                writer.newLine();
            }

            System.out.println("Data Written To File");

        } catch (IOException e) {
            System.out.println("Cannot perform task");
            e.printStackTrace();
        }
    }

    public void loadFromFile() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Books.csv"));
            String line = "";
            String[] strs = line.split(",");

            for (String str : strs) {
                System.out.println(str);
            }

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
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
