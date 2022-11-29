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

// STUDENT CLASS TO STORE STUDENTS DATA
public class student {

    // RESTRICT THE ACCESS TO THAT ATTRIBUTE
    private final String id;
    private final String studentFirstName;
    private final String studentLastName;
    private final String address;

    // CREATED CONSTRUCT
    public student(String id, String studentFirstName, String studentLastName, String address) {
        this.id = id;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.address = address;
    }

    // CREATED GETTER
    public String getID() {
        return id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getAddress() {
        return address;
    }

}
