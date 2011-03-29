package cz.cvut.fel.x33eja.libdo.domain;

import java.io.Serializable;

/**
 *
 * @author ondrepe
 */
public class Reader implements Serializable {

    private Integer idReader;
    private String name;
    private String surname;
    private String email;

    public Reader() { }

    public Reader(Integer idReader, String name, String surname, String email) {
        this.idReader = idReader;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdReader() {
        return idReader;
    }

    public void setIdReader(Integer idReader) {
        this.idReader = idReader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
