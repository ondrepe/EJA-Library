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
    @NamedQuery(name = "Booktitle.findAll", query = "SELECT b FROM Booktitle b"),
    @NamedQuery(name = "Booktitle.findByIsbn", query = "SELECT b FROM Booktitle b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Booktitle.findByName", query = "SELECT b FROM Booktitle b WHERE b.name = :name"),
    @NamedQuery(name = "Booktitle.findByYear", query = "SELECT b FROM Booktitle b WHERE b.year = :year"),
    @NamedQuery(name = "Booktitle.findByPagesCount", query = "SELECT b FROM Booktitle b WHERE b.pagesCount = :pagesCount"),
    @NamedQuery(name = "Booktitle.findByIssueNumber", query = "SELECT b FROM Booktitle b WHERE b.issueNumber = :issueNumber"),
    @NamedQuery(name = "Booktitle.findByScore", query = "SELECT b FROM Booktitle b WHERE b.score = :score")})
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
    @Column(name = "score")
    private Integer score;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booktitle", fetch = FetchType.LAZY)
    private List<CategoryBookPO> categorybookList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booktitle", fetch = FetchType.LAZY)
    private List<BookPO> bookList;
    @JoinColumn(name = "idPublisher", referencedColumnName = "idPublisher")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PublisherPO publisher;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booktitle", fetch = FetchType.LAZY)
    private List<AuthorBookPO> authorbookList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booktitle", fetch = FetchType.LAZY)
    private List<ComentaryBookPO> comentarybookList;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<CategoryBookPO> getCategorybookList() {
        return categorybookList;
    }

    public void setCategorybookList(List<CategoryBookPO> categorybookList) {
        this.categorybookList = categorybookList;
    }

    public List<BookPO> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookPO> bookList) {
        this.bookList = bookList;
    }

    public PublisherPO getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherPO publisher) {
        this.publisher = publisher;
    }

    public List<AuthorBookPO> getAuthorbookList() {
        return authorbookList;
    }

    public void setAuthorbookList(List<AuthorBookPO> authorbookList) {
        this.authorbookList = authorbookList;
    }

    public List<ComentaryBookPO> getComentarybookList() {
        return comentarybookList;
    }

    public void setComentarybookList(List<ComentaryBookPO> comentarybookList) {
        this.comentarybookList = comentarybookList;
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
        return "cz.cvut.fel.x33eja.libejb.po.Booktitle[isbn=" + isbn + "]";
    }

}
