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
@Table(name = "commentary")
@NamedQueries({
    @NamedQuery(name = "CommentaryPO.findAll", query = "SELECT c FROM CommentaryPO c"),
    @NamedQuery(name = "CommentaryPO.findByIdCommentary", query = "SELECT c FROM CommentaryPO c WHERE c.idCommentary = :idCommentary"),
    @NamedQuery(name = "CommentaryPO.findByAuthorName", query = "SELECT c FROM CommentaryPO c WHERE c.authorName = :authorName"),
    @NamedQuery(name = "CommentaryPO.findByTime", query = "SELECT c FROM CommentaryPO c WHERE c.time = :time")})
public class CommentaryPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCommentary")
    private Integer idCommentary;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commentaryPO", fetch = FetchType.LAZY)
    private List<CommentaryBookPO> commentaryBookPOList;

    public CommentaryPO() {
    }

    public CommentaryPO(Integer idCommentary) {
        this.idCommentary = idCommentary;
    }

    public CommentaryPO(Integer idCommentary, String authorName, Date time, String text) {
        this.idCommentary = idCommentary;
        this.authorName = authorName;
        this.time = time;
        this.text = text;
    }

    public Integer getIdCommentary() {
        return idCommentary;
    }

    public void setIdCommentary(Integer idCommentary) {
        this.idCommentary = idCommentary;
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

    public List<CommentaryBookPO> getCommentaryBookPOList() {
        return commentaryBookPOList;
    }

    public void setCommentaryBookPOList(List<CommentaryBookPO> commentaryBookPOList) {
        this.commentaryBookPOList = commentaryBookPOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommentary != null ? idCommentary.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentaryPO)) {
            return false;
        }
        CommentaryPO other = (CommentaryPO) object;
        if ((this.idCommentary == null && other.idCommentary != null) || (this.idCommentary != null && !this.idCommentary.equals(other.idCommentary))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.CommentaryPO[idCommentary=" + idCommentary + "]";
    }

}
