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
import javax.persistence.Lob;
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
@Table(name = "comentary")
@NamedQueries({
    @NamedQuery(name = "Comentary.findAll", query = "SELECT c FROM Comentary c"),
    @NamedQuery(name = "Comentary.findByIdComentary", query = "SELECT c FROM Comentary c WHERE c.idComentary = :idComentary"),
    @NamedQuery(name = "Comentary.findByAuthorName", query = "SELECT c FROM Comentary c WHERE c.authorName = :authorName"),
    @NamedQuery(name = "Comentary.findByTime", query = "SELECT c FROM Comentary c WHERE c.time = :time")})
public class ComentaryPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idComentary")
    private Integer idComentary;
    @Basic(optional = false)
    @Column(name = "authorName")
    private String authorName;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @Lob
    @Column(name = "text")
    private String text;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comentary", fetch = FetchType.LAZY)
    private List<ComentaryBookPO> comentarybookList;

    public ComentaryPO() {
    }

    public ComentaryPO(Integer idComentary) {
        this.idComentary = idComentary;
    }

    public ComentaryPO(Integer idComentary, String authorName, Date time, String text) {
        this.idComentary = idComentary;
        this.authorName = authorName;
        this.time = time;
        this.text = text;
    }

    public Integer getIdComentary() {
        return idComentary;
    }

    public void setIdComentary(Integer idComentary) {
        this.idComentary = idComentary;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        hash += (idComentary != null ? idComentary.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentaryPO)) {
            return false;
        }
        ComentaryPO other = (ComentaryPO) object;
        if ((this.idComentary == null && other.idComentary != null) || (this.idComentary != null && !this.idComentary.equals(other.idComentary))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.Comentary[idComentary=" + idComentary + "]";
    }

}
