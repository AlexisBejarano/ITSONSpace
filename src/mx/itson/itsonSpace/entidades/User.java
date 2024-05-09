/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.itsonSpace.entidades;

/**
 *
 * @author Aletz
 */
public class User {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * @return the passwotd
     */
    public String getPasswotd() {
        return passwotd;
    }

    /**
     * @param passwotd the passwotd to set
     */
    public void setPasswotd(String passwotd) {
        this.passwotd = passwotd;
    }
    private int id=0;
    private String user="";
    private String eMail="";
    private String passwotd="";
}
