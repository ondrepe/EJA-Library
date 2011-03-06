/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "booktitle")
@NamedQueries({
    @NamedQuery(name = "BookTitlePO.findAll", query = "SELECT b FROM BookTitlePO b"),
    @NamedQuery(name = "BookTitlePO.findByIsbn", query = "SELECT b FROM BookTitlePO b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "BookTitlePO.findByName", query = "SELECT b FROM BookTitlePO b WHERE b.name = :name"),
    @NamedQuery(name = "BookTitlePO.findByYear", query = "SELECT b FROM BookTitlePO b WHERE b.year = :year"),
    @NamedQuery(name = "BookTitlePO.findByPagesCount", query = "SELECT b FROM BookTitlePO b WHERE b.pagesCount = :pagesCount"),
    @NamedQuery(name = "BookTitlePO.findByIssueNumber", query = "SELECT b FROM BookTitlePO b WHERE b.issueNumber = :issueNumber")})
public class BookTitlePO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Column(name = "pagesCount")
    private Integer pagesCount;
    @Column(name = "issueNumber")
    private String issueNumber;
    @Lob
    @Column(name = "about")
    private String about;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO", fetch = FetchType.LAZY)
    private List<CommentaryBookPO> commentaryBookPOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO", fetch = FetchType.LAZY)
    private List<CategoryBookPO> categoryBookPOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO", fetch = FetchType.LAZY)
    private List<LibraryUnitPO> libraryUnitPOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO", fetch = FetchType.LAZY)
    private List<ScorePO> scorePOList;
    @JoinColumn(name = "idPublisher", referencedColumnName = "idPublisher")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PublisherPO publisherPO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO", fetch = FetchType.LAZY)
    private List<AuthorBookPO> authorBookPOList;

    public BookTitlePO() {
    }

    public BookTitlePO(String isbn) {
        this.isbn = isbn;
    }

    public BookTitlePO(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<CommentaryBookPO> getCommentaryBookPOList() {
        return commentaryBookPOList;
    }

    public void setCommentaryBookPOList(List<CommentaryBookPO> commentaryBookPOList) {
        this.commentaryBookPOList = commentaryBookPOList;
    }

    public List<CategoryBookPO> getCategoryBookPOList() {
        return categoryBookPOList;
    }

    public void setCategoryBookPOList(List<CategoryBookPO> categoryBookPOList) {
        this.categoryBookPOList = categoryBookPOList;
    }

    public List<LibraryUnitPO> getLibraryUnitPOList() {
        return libraryUnitPOList;
    }

    public void setLibraryUnitPOList(List<LibraryUnitPO> libraryUnitPOList) {
        this.libraryUnitPOList = libraryUnitPOList;
    }

    public List<ScorePO> getScorePOList() {
        return scorePOList;
    }

    public void setScorePOList(List<ScorePO> scorePOList) {
        this.scorePOList = scorePOList;
    }

    public PublisherPO getPublisherPO() {
        return publisherPO;
    }

    public void setPublisherPO(PublisherPO publisherPO) {
        this.publisherPO = publisherPO;
    }

    public List<AuthorBookPO> getAuthorBookPOList() {
        return authorBookPOList;
    }

    public void setAuthorBookPOList(List<AuthorBookPO> authorBookPOList) {
        this.authorBookPOList = authorBookPOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookTitlePO)) {
            return false;
        }
        BookTitlePO other = (BookTitlePO) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.BookTitlePO[isbn=" + isbn + "]";
    }

}
