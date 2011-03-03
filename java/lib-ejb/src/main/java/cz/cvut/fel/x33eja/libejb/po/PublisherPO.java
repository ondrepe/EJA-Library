package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "publisher")
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findByIdPublisher", query = "SELECT p FROM Publisher p WHERE p.idPublisher = :idPublisher"),
    @NamedQuery(name = "Publisher.findByName", query = "SELECT p FROM Publisher p WHERE p.name = :name")})
public class PublisherPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPublisher")
    private Integer idPublisher;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<BookTitlePO> booktitleList;

    public PublisherPO() {
    }

    public PublisherPO(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }

    public PublisherPO(Integer idPublisher, String name) {
        this.idPublisher = idPublisher;
        this.name = name;
    }

    public Integer getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookTitlePO> getBooktitleList() {
        return booktitleList;
    }

    public void setBooktitleList(List<BookTitlePO> booktitleList) {
        this.booktitleList = booktitleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublisher != null ? idPublisher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublisherPO)) {
            return false;
        }
        PublisherPO other = (PublisherPO) object;
        if ((this.idPublisher == null && other.idPublisher != null) || (this.idPublisher != null && !this.idPublisher.equals(other.idPublisher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.Publisher[idPublisher=" + idPublisher + "]";
    }

}
