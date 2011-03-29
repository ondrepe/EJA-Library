package cz.cvut.fel.x33eja.libejb.db.po;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "Authorization")
@NamedQueries({
    @NamedQuery(name = "AuthorizationPO.findAll", query = "SELECT a FROM AuthorizationPO a"),
    @NamedQuery(name = "AuthorizationPO.findByLogin", query = "SELECT a FROM AuthorizationPO a WHERE a.login = :login"),
    @NamedQuery(name = "AuthorizationPO.findByPassword", query = "SELECT a FROM AuthorizationPO a WHERE a.password = :password")})
public class AuthorizationPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public AuthorizationPO() {
    }

    public AuthorizationPO(String login) {
        this.login = login;
    }

    public AuthorizationPO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorizationPO)) {
            return false;
        }
        AuthorizationPO other = (AuthorizationPO) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.db.po.AuthorizationPO[login=" + login + "]";
    }

}
