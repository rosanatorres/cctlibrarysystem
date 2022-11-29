/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

// ALL USEFUL IMPORTS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rosanatorres/cleutersonmartins
 */
// MAIN CLASS
public class Library {

    /**
     * @param args the command line arguments
     */

    // MAIN FUNCTION
    public static void main(String[] args) {

        // SETTING PATHS TO ALL FILES
        String folderPath = "/Users/rosanatorres/NetBeansProjects/Livrary v1/Library";
        String booksFilePath = "/Users/rosanatorres/NetBeansProjects/Livrary v1/books.csv";
        String studentsFilePath = "/Users/rosanatorres/NetBeansProjects/Livrary v1/students.csv";
        String borrowingFilePath = "/Users/rosanatorres/NetBeansProjects/Livrary v1/borrowings.csv";
        String waitinglistPath = "/Users/rosanatorres/NetBeansProjects/Livrary v1/waitinglist.csv";

        // LOADING CSV FILES INTO ARRAY LISTS
        ArrayList<book> bal = loadBookData(booksFilePath);
        ArrayList<student> sal = loadStudentData(studentsFilePath);
        ArrayList<borrowing> bral = loadBorrowingData(borrowingFilePath);
        ArrayList<waitinglist> wl = loadWaitingList(waitinglistPath);

        Scanner in = new Scanner(System.in);
        String title, id;

        // INFINITE LOOP FOR MENU, STOPS WHEN USER ENTERS 12
        while (true) {
            int option = mainMenu();

            switch (option) {
                case 1:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Enter title to search:");
                    title = in.nextLine();
                    searchBookByTitle(title, bal);
                    break;
                case 2:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Enter ID to search:");
                    id = in.nextLine();
                    searchBookByID(id, bal);
                    break;
                case 3:
                    printBooksAlphabaticallyByTitle(bal);
                    break;
                case 4:
                    printBooksAlphabaticallyByID(bal);
                    break;
                case 5:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Enter name to search:");
                    title = in.nextLine();
                    searchStudentByName(title, sal);
                    break;
                case 6:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Enter ID to search:");
                    title = in.nextLine();
                    searchStudentByID(title, sal);
                    break;
                case 7:
                    printStudentsAlphabaticallyByName(sal);
                    break;
                case 8:
                    printStudentsAlphabaticallyByID(sal);
                    break;
                case 9:
                    registerBorrow(bral, borrowingFilePath, wl, waitinglistPath, folderPath);
                    break;
                case 10:
                    System.out.println("Enter Book id: ");
                    id = in.nextLine();
                    registerReturn(bral, borrowingFilePath, wl, waitinglistPath, folderPath, id);
                    break;
                case 11:
                    System.out.println("Enter student id: ");
                    id = in.nextLine();
                    displayBorrowingsOfStudent(id, bral);
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Invalid Entry!");
                    break;
            }
        }

    }

    // FUNCTION TO PRINT MAIN MENU
    public static int mainMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("|-----------------------------Main Menu----------------------------|");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|                        Please select an option:                  |");
        System.out.println("|1. Search book by title                                           |");
        System.out.println("|2. Search book by ID                                              |");
        System.out.println("|3. List all books in alphabatical order(by title)                 |");
        System.out.println("|4. List all books in alphabatical order(by ID)                    |");
        System.out.println("|5. Search student by name                                         |");
        System.out.println("|6. Search student by ID                                           |");
        System.out.println("|7. List all students in alphabatical order(by name)               |");
        System.out.println("|8. List all students in alphabatical order(by ID)                 |");
        System.out.println("|9. Register borrowing                                             |");
        System.out.println("|10. Register return                                               |");
        System.out.println("|11. Display all books borrowed by a specific student              |");
        System.out.println("|12. Exit                                                          |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|Enter your choice:                                                |");

        int option = in.nextInt();
        return option;
    }

    // FUNCTION TO PRINT ALL BOOKS
    private static void printAllBooks(ArrayList<book> books) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("BOOK ID                                AUTHOR NAME               TITLE                                                       GENRE");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < books.size(); i++) {
            book b = books.get(i);
            System.out.printf("%-25s%-25s%-60s%-20s\n", b.getID() + "  ", b.getAuthorFirstName() + " " + b.getAuthorLastName() + "    ", b.getTitle() + "    ", b.getGenre());
        }
    }

    // FUNCTION TO SEARCH BOOK BY TITLE
    private static void searchBookByTitle(String title, ArrayList<book> books) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            book b = books.get(i);
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Book found!");
                System.out.println("Book ID>     " + b.getID());
                System.out.println("Book title>  " + b.getTitle());
                System.out.println("Author name> " + b.getAuthorLastName() + " " + b.getAuthorFirstName());
                System.out.println("Genre>       " + b.getGenre());
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Book not found!");
        }
    }

    // FUNCTION TO SEARCH BOOK BY ID
    private static void searchBookByID(String id, ArrayList<book> books) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            book b = books.get(i);
            if (b.getID().equals(id)) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Book found!");
                System.out.println("Book ID>     " + b.getID());
                System.out.println("Book title>  " + b.getTitle());
                System.out.println("Author name> " + b.getAuthorLastName() + " " + b.getAuthorFirstName());
                System.out.println("Genre>       " + b.getGenre());
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Book not found!");
        }
    }

    // FUNCTION TO LOAD BOOKS DATA
    private static ArrayList<book> loadBookData(String filePath) {
        ArrayList<book> books = new ArrayList<>();
        String book = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            boolean firstLine = true;

            while ((book = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] bookData = book.split(",");
                books.add(new book(bookData[0], bookData[1], bookData[2], bookData[3], bookData[4]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }

    // FUNCTION TO PRINT ALL BOOKS ALPHABATICALLY BY TITLE
    public static void printBooksAlphabaticallyByTitle(ArrayList<book> books) {
        Collections.sort(books, (book b1, book b2) -> {
            String b1Title = b1.getTitle();
            String b2Title = b2.getTitle();
            return b1Title.compareToIgnoreCase(b2Title);
        });
        printAllBooks(books);
    }

    // FUNCTION TO PRINT ALL BOOKS ALPHABATICALLY BY ID
    public static void printBooksAlphabaticallyByID(ArrayList<book> books) {
        Collections.sort(books, (book b1, book b2) -> {
            String b1Title = b1.getID();
            String b2Title = b2.getID();
            return b1Title.compareTo(b2Title);
        });
        printAllBooks(books);
    }

    // FUNCTION TO PRINT ALL STUDENTS
    private static void printAllStudents(ArrayList<student> students) {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("STUDENT ID                              NAME                  ADDRESS");
        System.out.println("------------------------------------------------------------------------------------");
        for (int i = 0; i < students.size(); i++) {
            student s = students.get(i);
            System.out.printf("%-28s%-20s%-25s\n", s.getID() + "   ", s.getStudentFirstName() + " " + s.getStudentLastName() + "    ", s.getAddress() + "    ");
        }
    }

    // FUNCTION TO SEARCH STUDENT BY NAME
    private static void searchStudentByName(String name, ArrayList<student> students) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            student s = students.get(i);
            String studentName = s.getStudentFirstName() + " " + s.getStudentLastName();
            if (studentName.equalsIgnoreCase(name)) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Student found!");
                System.out.println("Student ID>   " + s.getID());
                System.out.println("Student name> " + s.getStudentFirstName() + " " + s.getStudentLastName());
                System.out.println("Address>      " + s.getAddress());
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("student not found!");
        }
    }

    // FUNCTION TO SEARCH STUDENT BY ID
    private static void searchStudentByID(String id, ArrayList<student> students) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            student s = students.get(i);
            if (s.getID().equals(id)) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Student found!");
                System.out.println("Student ID>   " + s.getID());
                System.out.println("Student name> " + s.getStudentLastName() + " " + s.getStudentFirstName());
                System.out.println("Address>      " + s.getAddress());
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Student not found!");
        }
    }

    // FUNCTION TO LOAD STUDENTS DATA
    private static ArrayList<student> loadStudentData(String filePath) {
        ArrayList<student> students = new ArrayList<>();
        String student;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            boolean firstLine = true;

            while ((student = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] studentData = student.split(",");
                students.add(new student(studentData[0], studentData[1], studentData[2], studentData[3]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

    // FUNCTION TO PRINT ALL STUDENTS ALPHABATICALLY BY NAME
    public static void printStudentsAlphabaticallyByName(ArrayList<student> students) {
        Collections.sort(students, (student s1, student s2) -> {
            String s1Name = s1.getStudentFirstName() + " " + s1.getStudentLastName();
            String s2Name = s2.getStudentFirstName() + " " + s2.getStudentLastName();
            return s1Name.compareToIgnoreCase(s2Name);
        });
        printAllStudents(students);
    }

    // FUNCTION TO PRINT ALL STUDENTS ALPHABATICALLY BY ID
    public static void printStudentsAlphabaticallyByID(ArrayList<student> students) {
        Collections.sort(students, (student s1, student s2) -> {
            String s1ID = s1.getID();
            String s2ID = s2.getID();
            return s1ID.compareToIgnoreCase(s2ID);
        });
        printAllStudents(students);
    }

    // FUNCTION TO LOAD BORROWING DATA
    public static ArrayList<borrowing> loadBorrowingData(String filePath) {
        ArrayList<borrowing> borrowings = new ArrayList<>();
        String borrowing;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            boolean firstLine = true;

            while ((borrowing = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] borrowingData = borrowing.split(",");
                borrowings.add(new borrowing(borrowingData[0], borrowingData[1], borrowingData[2], borrowingData[3]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }

        return borrowings;
    }

    // FUNCTION TO CONVERT BORROW LIST TO CSV FILE
    public static void borrowArrayListToCsv(ArrayList<borrowing> borrowing, String oldFilePath, String folderPath) {
        File oldFile = new File(oldFilePath);
        oldFile.delete();

        File newFile = new File(folderPath + "\\borrowings.csv");
        try {
            newFile.createNewFile();
            newFile.setReadable(true);
            newFile.setWritable(true);
            FileWriter fw = new FileWriter(newFile);
            fw.write("Borrow id,Student id,Book id,Returned\n");
            for (int i = 0; i < borrowing.size(); i++) {
                borrowing b = borrowing.get(i);
                String data = b.getBorrowID() + "," + b.getStudentID() + "," + b.getBookID() + "," + b.getReturned();
                fw.write(data);
                fw.write("\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // FUNCTION TO REGISTER BORROW
    public static void registerBorrow(ArrayList<borrowing> borrowing, String borrowingFilePath, ArrayList<waitinglist> waitinglist, String waitinglistPath, String folderPath) {
        char option;
        Scanner in = new Scanner(System.in);
        String borrowID, studentID, bookID, returned = "0";
        System.out.println("------------------------------------------------------------------");
        System.out.println("Enter book id");
        bookID = in.nextLine();
        System.out.println("Enter student id:");
        studentID = in.nextLine();

        for (borrowing b : borrowing) {
            if (b.getBookID().equals(bookID) && b.getReturned().equals("0")) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Book is already borrowed.");
                System.out.println("Add student to waiting list?(y/n)");
                option = in.next().charAt(0);
                if (option == 'y' || option == 'Y') {
                    addToWaitingList(waitinglist, waitinglistPath, folderPath, bookID, studentID);
                    System.out.println("Student added to waiting list.");
                    return;
                } else {
                    return;
                }
            }
        }

        int lastID = Integer.parseInt(borrowing.get(borrowing.size() - 1).getBorrowID());
        lastID++;
        borrowID = Integer.toString(lastID);
        borrowing b = new borrowing(borrowID, studentID, bookID, returned);
        borrowing.add(b);
        borrowArrayListToCsv(borrowing, borrowingFilePath, folderPath);
        System.out.println("Borrow registered");
    }

    //FUNCTION TO DISPLAY HISTORY BORROWED BY A ESPECIFIC STUDENT
    public static void displayBorrowingsOfStudent(String studentId, ArrayList<borrowing> borrowList) {

        ArrayList<borrowing> list = new ArrayList<>();
        borrowing b;
        boolean found = false;

        for (int i = 0; i < borrowList.size(); i++) {
            b = borrowList.get(i);
            if (b.getStudentID().equals(studentId)) {
                list.add(b);
                found = true;
            }
        }

        System.out.println("------------------------------------------------------------------");
        System.out.println("Borrowings of student " + studentId);
        if (found == false) {
            System.out.println("No boorowings found");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i).getBookID());
            }
        }
    }

    // FUNCTION TO LOAD WAITING LIST
    public static ArrayList<waitinglist> loadWaitingList(String filePath) {
        ArrayList<waitinglist> waitinglist = new ArrayList<>();
        String waitingEntry;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            boolean firstLine = true;

            while ((waitingEntry = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] waitingData = waitingEntry.split(",");
                waitinglist.add(new waitinglist(waitingData[0], waitingData[1]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }

        return waitinglist;
    }

    // FUNCTION TO ADD STUDENT TO WAITING LIST
    public static void addToWaitingList(ArrayList<waitinglist> waitinglist, String filePath, String folderPath, String bookID, String studentID) {

        ArrayList<waitinglist> newWaitingList = new ArrayList<waitinglist>();
        boolean found = false;
        for (waitinglist wl : waitinglist) {
            if (wl.getBookID().equals(bookID)) {
                wl.setWaitingList(wl.getWaitingList() + "|" + studentID);
                found = true;
            }
            newWaitingList.add(wl);
        }

        if (found == false) {
            waitinglist wl = new waitinglist(bookID, studentID);
            newWaitingList.add(wl);
        }

        waitingListToCsv(newWaitingList, filePath, folderPath);
    }

    // FUNCTION TO CONVERT WAITING LIST TO CSV
    public static void waitingListToCsv(ArrayList<waitinglist> waitinglist, String filePath, String folderPath) {
        File oldFile = new File(filePath);
        oldFile.delete();

        File newFile = new File(folderPath + "\\waitinglist.csv");
        try {
            newFile.createNewFile();
            newFile.setReadable(true);
            newFile.setWritable(true);
            try (FileWriter fw = new FileWriter(newFile)) {
                fw.write("Book id,waitinglist\n");
                for (int i = 0; i < waitinglist.size(); i++) {
                    waitinglist wl = waitinglist.get(i);
                    String data = wl.getBookID() + "," + wl.getWaitingList();
                    fw.write(data);
                    fw.write("\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // FUNCTION TO REGISTER RETURN 
    public static void registerReturn(ArrayList<borrowing> borrowing, String borrowFilePath, ArrayList<waitinglist> waitinglist, String waitinglistFilePath, String folderPath, String bookID) {
        borrowing b;
        ArrayList<borrowing> newList = new ArrayList<>();
        for (int i = 0; i < borrowing.size(); i++) {
            b = borrowing.get(i);
            if (b.getBookID().equals(bookID)) {
                b.setReturned("1");
                break;
            }
            newList.add(b);
        }
        borrowArrayListToCsv(newList, borrowFilePath, folderPath);

        System.out.println("------------------------------------------------------------------");
        System.out.println("Return registered.");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Next student in waiting list");

        waitinglist wl;
        boolean found = false;
        String fullWaitingList = "";
        for (int i = 0; i < waitinglist.size(); i++) {
            wl = waitinglist.get(i);
            if (wl.getBookID().equals(bookID)) {
                found = true;
                fullWaitingList = wl.getWaitingList();
                break;
            }
        }

        int index = 0;
        if (found == false) {
            System.out.println("...");
        } else {
            for (int i = 0; i < fullWaitingList.length(); i++) {
                if (fullWaitingList.charAt(i) == '|') {
                    index = i;
                    break;
                }
            }
            System.out.println("Student Id: " + fullWaitingList.substring(0, index));
        }
    }

}
