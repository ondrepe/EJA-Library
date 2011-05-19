package cz.cvut.fel.x33eja.lib.iface.to;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ondrepe
 */
public class BookTitle extends CommonTO {

  private Integer id;
  private List<Author> authors;
  private List<Category> categories;
  private Publisher publisher;
  private String isbn;
  private String name;
  private Integer year;
  private Integer pages;
  private String issue;
  private String about;
  private Integer avgScore;
  private Integer count;

  public Integer getAvgScore() {
    return avgScore;
  }

  public void setAvgScore(Integer score) {
    this.avgScore = score;
  }

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

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
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

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public List<Author> getAuthors() {
    if (authors == null) {
      authors = new ArrayList<Author>();
    }
    return authors;
  }

  public List<Category> getCategories() {
    if (categories == null) {
      categories = new ArrayList<Category>();
    }
    return categories;
  }
}
