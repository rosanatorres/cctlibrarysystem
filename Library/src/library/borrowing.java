/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author rosanatorres/cleutersonmartins
 */

// BORROWING CLASS TO STORE BORROWING DATA
public class borrowing {

    // RESTRICT THE ACCESS TO THAT ATTRIBUTE
    private final String borrowID;
    private final String studentID;
    private final String bookID;
    private String returned;

    // CREATED CONSTRUCT
    public borrowing(String borrowID, String studentID, String bookID, String returned) {
        this.borrowID = borrowID;
        this.studentID = studentID;
        this.bookID = bookID;
        this.returned = returned;
    }

    // CREATED GETTER AND SETTER
    public String getBorrowID() {
        return borrowID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getBookID() {
        return bookID;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }
}
