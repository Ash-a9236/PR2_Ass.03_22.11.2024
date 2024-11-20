package ash_a9236.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        LibraryBookManagement lbm = new LibraryBookManagement(books);


        lbm.addBook(new Book("To Kill a Mockingbird",      "Harper Lee",          1960));
        lbm.addBook(new Book("1984",                       "George Orwell",       1949));
        lbm.addBook(new Book("The Great Gatsby",           "F. Scott Fitzgerald", 1925));
        lbm.addBook(new Book("Moby-Dick",                  "Herman Melville",     1851));
        lbm.addBook(new Book("Pride and Prejudice",        "Jane Austen",         1813));
        lbm.addBook(new Book("The Catcher in the Rye",     "J.D. Salinger",       1951));
        lbm.addBook(new Book("The Hobbit",                 "J.R.R. Tolkien",      1937));
        lbm.addBook(new Book("Crime and Punishment",       "Fyodor Dostoevsky",   1866));
        lbm.addBook(new Book("War and Peace",              "Leo Tolstoy",         1869));
        lbm.addBook(new Book("Brave New World",            "Aldous Huxley",       1932));
        lbm.addBook(new Book("The Odyssey",                "Homer",               800));
        lbm.addBook(new Book("The Divine Comedy",          "Dante Alighieri",     1320));
        lbm.addBook(new Book("Frankenstein",               "Mary Shelley",        1818));
        lbm.addBook(new Book("The Brothers Karamazov",     "Fyodor Dostoevsky",   1880));
        lbm.addBook(new Book("The Picture of Dorian Gray", "Oscar Wilde",         1890));

        lbm.saveToFile(books, false);

        Scanner console = new Scanner(System.in);
        String userAns;

        do {
            System.out.println("_________________________________________________________________");
            System.out.println("         Welcome to the Library Management System!\n");
            System.out.println("    1. Add Book                      5. Sort Books by Year");
            System.out.println("    2. Remove Book                   6. Search Author");
            System.out.println("    3. Book info                     7. Search Year Range");
            System.out.println("    4. Sort Books by Title           8. Save changes to File");
            System.out.println("                       9. Exit");
            System.out.println("_________________________________________________________________\n");

            userAns = console.next();


            switch (userAns) {
                case "1":
                    System.out.println("ADDING BOOK");
                    lbm.manuallyAddBook();
                    break;

                case "2":
                    System.out.println("REMOVE BOOK");

                    System.out.print("Enter the Book's Title : ");
                    String title = console.nextLine();
                    lbm.removeBookViaTitle(title);

                    lbm.saveToFile(books, false); //will re-write the file completely since a book was removed
                    break;

                case "3":
                    System.out.println("BOOK INFO");

                    System.out.println("To see a specific book, press '1', to see all the available books, press '2'");
                    int ans = console.nextInt();
                    String junkline01 = console.nextLine();

                    if (ans == 1) {
                        System.out.println("Please enter the book's title : ");
                        String bookTitle = console.nextLine();

                        lbm.findBookViaTitle(bookTitle);
                    } else if (ans == 2) {
                        lbm.loadFromFile();
                    } else {
                        System.out.println("invalid answer, please try again");
                    }

                    break;

                case "4":
                    System.out.println("SORT BOOKS VIA TITLE");
                    lbm.sortBooksByTitle();
                    break;

                case "5":
                    System.out.println("SORT BOOKS VIA YEAR");
                    lbm.sortBooksByYear();
                    break;

                case "6":
                    System.out.println("SEARCH AUTHOR");

                    System.out.print("Enter the Author : ");
                    String author01 = console.nextLine();

                    if (lbm.searchAuthor(author01) == null) {
                        System.out.println("No book found for this author...");
                    }

                    break;

                case "7":
                    System.out.println("SEARCH YEAR RANGE");

                    System.out.println("Please input the start year : ");
                    int lowYear = console.nextInt();
                    String junkline02 = console.nextLine();

                    System.out.println("Please input the end year : ");
                    int highYear = console.nextInt();
                    String junkline03 = console.nextLine();

                    if (lbm.searchByYearRange(lowYear, highYear) == null) {
                        System.out.println("No book found for this year range...");
                    }

                    break;

                case "8":
                    System.out.println("SAVE CHANGES TO FILE");
                    lbm.saveToFile(books, true);
                    break;

                case "9":
                    System.out.println("SAVING...");
                    lbm.saveToFile(books, true);

                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!userAns.equals("9"));
    }
}
