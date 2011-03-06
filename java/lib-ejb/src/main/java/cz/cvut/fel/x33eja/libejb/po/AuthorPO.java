/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Table(name = "author")
@NamedQueries({
    @NamedQuery(name = "AuthorPO.findAll", query = "SELECT a FROM AuthorPO a"),
    @NamedQuery(name = "AuthorPO.findByIdAuthor", query = "SELECT a FROM AuthorPO a WHERE a.idAuthor = :idAuthor"),
    @NamedQuery(name = "AuthorPO.findByName", query = "SELECT a FROM AuthorPO a WHERE a.name = :name"),
    @NamedQuery(name = "AuthorPO.findBySurname", query = "SELECT a FROM AuthorPO a WHERE a.surname = :surname")})
public class AuthorPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAuthor")
    private Integer idAuthor;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorPO", fetch = FetchType.LAZY)
    private List<AuthorBookPO> authorBookPOList;

    public AuthorPO() {
    }

    public AuthorPO(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public AuthorPO(Integer idAuthor, String name, String surname) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.surname = surname;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
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

    public List<AuthorBookPO> getAuthorBookPOList() {
        return authorBookPOList;
    }

    public void setAuthorBookPOList(List<AuthorBookPO> authorBookPOList) {
        this.authorBookPOList = authorBookPOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuthor != null ? idAuthor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorPO)) {
            return false;
        }
        AuthorPO other = (AuthorPO) object;
        if ((this.idAuthor == null && other.idAuthor != null) || (this.idAuthor != null && !this.idAuthor.equals(other.idAuthor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.AuthorPO[idAuthor=" + idAuthor + "]";
    }

}
