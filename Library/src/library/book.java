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

// BOOK CLASS TO STORE BOOK DATA
public class book {
    
    // RESTRICT THE ACCESS TO THAT ATTRIBUTE
    private final String id;
    private final String authorFirstName;
    private final String authorLastName;
    private final String title;
    private final String genre;

    // CREATED CONSTRUCT
    public book(String id, String authorFirstName, String authorLastName, String title, String genre) {
        this.id = id;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.title = title;
        this.genre = genre;
    }
    // CREATED GETTER
    public String getID() {
        return id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

}



