package cz.cvut.fel.x33eja.libdo.domain;

import java.io.Serializable;

/**
 *
 * @author ondrepe
 */
public class BookTitle implements Serializable {
    
  private Integer id; 
  private String publisher;
  private String isbn;
  private String name;
  private Integer year;
  private Integer pages;
  private String issue;
  private String about;
  
  //IDEA skore ?

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getIssue() {
    return issue;
  }

  public void setIssue(String issue) {
    this.issue = issue;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }
  
  public String getTitle() {
    return name + (year != null ? " (" + year + ")" : "");
  }
}
