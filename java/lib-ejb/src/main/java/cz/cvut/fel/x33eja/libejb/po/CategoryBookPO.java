package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "categorybook")
@NamedQueries({
    @NamedQuery(name = "Categorybook.findAll", query = "SELECT c FROM Categorybook c"),
    @NamedQuery(name = "Categorybook.findByIdCategoryBook", query = "SELECT c FROM Categorybook c WHERE c.idCategoryBook = :idCategoryBook")})
public class CategoryBookPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCategoryBook")
    private Integer idCategoryBook;
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoryPO category;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BookTitlePO booktitle;

    public CategoryBookPO() {
    }

    public CategoryBookPO(Integer idCategoryBook) {
        this.idCategoryBook = idCategoryBook;
    }

    public Integer getIdCategoryBook() {
        return idCategoryBook;
    }

    public void setIdCategoryBook(Integer idCategoryBook) {
        this.idCategoryBook = idCategoryBook;
    }

    public CategoryPO getCategory() {
        return category;
    }

    public void setCategory(CategoryPO category) {
        this.category = category;
    }

    public BookTitlePO getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(BookTitlePO booktitle) {
        this.booktitle = booktitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoryBook != null ? idCategoryBook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryBookPO)) {
            return false;
        }
        CategoryBookPO other = (CategoryBookPO) object;
        if ((this.idCategoryBook == null && other.idCategoryBook != null) || (this.idCategoryBook != null && !this.idCategoryBook.equals(other.idCategoryBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.Categorybook[idCategoryBook=" + idCategoryBook + "]";
    }

}
