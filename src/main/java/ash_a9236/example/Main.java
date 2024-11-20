package ash_a9236.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        LibraryBookManagement lbm = new LibraryBookManagement(books);

        Scanner console = new Scanner(System.in);
        String userAns;

        System.out.println("_________________________________________________________________");
        System.out.println("         Welcome to the Library Management System!\n");
        System.out.println("    1. Add Book                      5. Search Author");
        System.out.println("    2. Remove Book                   6. Search Year Range");
        System.out.println("    3. Sort Books by Title           7. Save to File");
        System.out.println("    4. Sort Books by Year            8. Exit");
        System.out.println("_________________________________________________________________\n");

        userAns = console.next();
        switch (userAns) {
            case "1":
                System.out.println("ADDING BOOK");
                lbm.manuallyAddBook();
                break;

            case "2":
                System.out.println("REMOVE STUDENT");
                System.out.print("Enter Student ID : ");
                int ID01 = console.nextInt();
                String IDExtraLine01 = console.nextLine();

                sm.searchStudentByID(ID01);
                break;

            case "3":
                System.out.println("DISPLAYING STUDENTS");

                sm.displayStudents();
                break;

            case "4":
                System.out.println("DELETING STUDENT");
                System.out.print("Enter Student ID : ");
                int ID02 = console.nextInt();
                String IDExtraLine02 = console.nextLine();

                sm.removeStudent(ID02);
                break;

            case "5":
                System.out.println("SAVING TO FILE");
                System.out.print("Enter File Name : ");

                String fileName = console.nextLine();
                fileName.substring(0, fileName.indexOf("."));

                sm.saveToFileMain(fileName);
                break;

            case "6":
                System.out.println("LOAD FROM FILE");
                System.out.print("Enter File Name : ");

                String fileName01 = console.nextLine();
                fileName01.substring(0, fileName01.indexOf("."));

                sm.loadFromFile(fileName01);

                break;

            case "7":
                System.out.println("SORT STUDENTS BY ID");

                sm.sortStudentByID();
                break;

            case "8":
                System.out.println("SORT STUDENTS BY GPA");

                sm.sortStudentByGPA();
                break;

            case "9":
                System.out.println("Exiting program. Thank you!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}