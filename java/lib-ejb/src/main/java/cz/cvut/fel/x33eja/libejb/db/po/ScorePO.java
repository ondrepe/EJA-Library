package cz.cvut.fel.x33eja.libejb.db.po;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Score")
@NamedQueries({
    @NamedQuery(name = "ScorePO.findAll", query = "SELECT s FROM ScorePO s"),
    @NamedQuery(name = "ScorePO.findByIdScore", query = "SELECT s FROM ScorePO s WHERE s.idScore = :idScore"),
    @NamedQuery(name = "ScorePO.findByValue", query = "SELECT s FROM ScorePO s WHERE s.value = :value"),
    @NamedQuery(name = "ScorePO.findByData", query = "SELECT s FROM ScorePO s WHERE s.data = :data")})
public class ScorePO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idScore")
    private Integer idScore;
    @Basic(optional = false)
    @Column(name = "value")
    private int value;
    @Column(name = "data")
    private String data;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne(optional = false)
    private BookTitlePO bookTitlePO;

    public ScorePO() {
    }

    public ScorePO(Integer idScore) {
        this.idScore = idScore;
    }

    public ScorePO(Integer idScore, int value) {
        this.idScore = idScore;
        this.value = value;
    }

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BookTitlePO getBookTitlePO() {
        return bookTitlePO;
    }

    public void setBookTitlePO(BookTitlePO bookTitlePO) {
        this.bookTitlePO = bookTitlePO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idScore != null ? idScore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScorePO)) {
            return false;
        }
        ScorePO other = (ScorePO) object;
        if ((this.idScore == null && other.idScore != null) || (this.idScore != null && !this.idScore.equals(other.idScore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.db.po.ScorePO[idScore=" + idScore + "]";
    }

}
