package cz.cvut.fel.x33eja.lib.ejb.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;

/**
 *
 * @author ondrepe
 */
@Entity
@Cache(alwaysRefresh = true)
@Table(name = "autentization")
@NamedQueries({
  @NamedQuery(name = "AutentizationPO.findAll", query = "SELECT a FROM AutentizationPO a"),
  @NamedQuery(name = "AutentizationPO.findByLogin", query = "SELECT a FROM AutentizationPO a WHERE a.login = :login"),
  @NamedQuery(name = "AutentizationPO.findByPassword", query = "SELECT a FROM AutentizationPO a WHERE a.password = :password")})
public class AutentizationPO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "login")
  private String login;
  
  @Column(name = "password")
  private String password;
  
  @JoinColumn(name = "groupName", referencedColumnName = "groupName")
  @ManyToOne(optional = false)
  private AutentizationGroupPO groupName;
  
  @JoinColumn(name = "idReader", referencedColumnName = "idReader")
  @ManyToOne(cascade= CascadeType.ALL)
  private ReaderPO reader;

  public AutentizationPO() {
  }

  public AutentizationPO(String login) {
    this.login = login;
  }

  public AutentizationPO(String login, String password) {
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

  public AutentizationGroupPO getGroupName() {
    return groupName;
  }

  public void setGroupName(AutentizationGroupPO groupName) {
    this.groupName = groupName;
  }

  public ReaderPO getReader() {
    return reader;
  }

  public void setReader(ReaderPO reader) {
    this.reader = reader;
  }
}
