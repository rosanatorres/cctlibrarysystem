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
// WAITINGLIST CLASS TO STORE WAITING LIST
public class waitinglist {

    // RESTRICT THE ACCESS TO THAT ATTRIBUTE
    private final String bookID;
    private String waitingList;

    // CREATED CONSTRUCT
    public waitinglist(String bookID, String waitingList) {
        this.bookID = bookID;
        this.waitingList = waitingList;
    }
    //CREATED GETTER AND SETTER
    public String getBookID() {
        return bookID;
    }

    public String getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(String waitingList) {
        this.waitingList = waitingList;
    }
}
