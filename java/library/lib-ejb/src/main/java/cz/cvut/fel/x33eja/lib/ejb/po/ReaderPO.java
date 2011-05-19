package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
  @NamedQuery(name = "ReaderPO.findByIdReader", query = "SELECT r FROM ReaderPO r WHERE r.idReader = :idReader"),
  @NamedQuery(name = "ReaderPO.findByName", query = "SELECT r FROM ReaderPO r WHERE r.name = :name"),
  @NamedQuery(name = "ReaderPO.findBySurname", query = "SELECT r FROM ReaderPO r WHERE r.surname = :surname"),
  @NamedQuery(name = "ReaderPO.findByEmail", query = "SELECT r FROM ReaderPO r WHERE r.email = :email")})
public class ReaderPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(generator = "readerTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "readerTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "reader", initialValue = 10000, allocationSize = 200)
  @Column(name = "idReader")
  private Integer idReader;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "surname")
  private String surname;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "email")
  private String email;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReader")
  private List<ChargeOutPO> chargeOutPOList;
  @OneToMany(mappedBy = "idReader")
  private List<AutentizationPO> autentizationPOList;

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

  public List<ChargeOutPO> getChargeOutPOList() {
    return chargeOutPOList;
  }

  public void setChargeOutPOList(List<ChargeOutPO> chargeOutPOList) {
    this.chargeOutPOList = chargeOutPOList;
  }

  public List<AutentizationPO> getAutentizationPOList() {
    return autentizationPOList;
  }

  public void setAutentizationPOList(List<AutentizationPO> autentizationPOList) {
    this.autentizationPOList = autentizationPOList;
  }
  
}
