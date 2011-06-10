package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.eclipse.persistence.annotations.Cache;

/**
 *
 * @author ondrepe
 */
@Entity
@Cache(alwaysRefresh=true)
@Table(name = "reader")
@NamedQueries({
  @NamedQuery(name = "ReaderPO.findAll", query = "SELECT r FROM ReaderPO r"),
  @NamedQuery(name = "ReaderPO.findByName", query = "SELECT r FROM ReaderPO r WHERE r.name = :name"),
  @NamedQuery(name = "ReaderPO.findBySurname", query = "SELECT r FROM ReaderPO r WHERE r.surname = :surname"),
  @NamedQuery(name = "ReaderPO.findByEmail", query = "SELECT r FROM ReaderPO r WHERE r.email = :email")})
public class ReaderPO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator = "readerTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "readerTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "reader", initialValue = 10000, allocationSize = 200)
  @Column(name = "idReader")
  private Integer idReader;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "surname")
  private String surname;
  
  @Column(name = "email")
  private String email;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "reader")
  private List<ChargeOutPO> chargeOuts;
  
  @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL)
  private List<AutentizationPO> autentizations;

  public ReaderPO() {
  }

  public ReaderPO(Integer idReader) {
    this.idReader = idReader;
  }

  public ReaderPO(Integer idReader, String name, String surname, String email) {
    this.idReader = idReader;
    this.name = name;
    this.surname = surname;
    this.email = email;
  }

  public Integer getIdReader() {
    return idReader;
  }

  public void setIdReader(Integer idReader) {
    this.idReader = idReader;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<ChargeOutPO> getChargeOuts() {
    return chargeOuts;
  }

  public void setChargeOuts(List<ChargeOutPO> chargeOuts) {
    this.chargeOuts = chargeOuts;
  }

  public List<AutentizationPO> getAutentizations() {
    return autentizations;
  }

  public void setAutentizations(List<AutentizationPO> autentizations) {
    this.autentizations = autentizations;
  }
  
}
