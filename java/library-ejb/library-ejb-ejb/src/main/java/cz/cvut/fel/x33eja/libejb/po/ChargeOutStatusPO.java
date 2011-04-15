package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "chargeoutstatus")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ChargeOutStatusPO.findAll", query = "SELECT c FROM ChargeOutStatusPO c"),
  @NamedQuery(name = "ChargeOutStatusPO.findByIdChargeOutStatus", query = "SELECT c FROM ChargeOutStatusPO c WHERE c.idChargeOutStatus = :idChargeOutStatus"),
  @NamedQuery(name = "ChargeOutStatusPO.findByName", query = "SELECT c FROM ChargeOutStatusPO c WHERE c.name = :name")})
public class ChargeOutStatusPO implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "idChargeOutStatus")
  private Integer idChargeOutStatus;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "name")
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
  private List<ChargeOutPO> chargeOutPOList;

  public ChargeOutStatusPO() {
  }

  public ChargeOutStatusPO(Integer idChargeOutStatus) {
    this.idChargeOutStatus = idChargeOutStatus;
  }

  public ChargeOutStatusPO(Integer idChargeOutStatus, String name) {
    this.idChargeOutStatus = idChargeOutStatus;
    this.name = name;
  }

  public Integer getIdChargeOutStatus() {
    return idChargeOutStatus;
  }

  public void setIdChargeOutStatus(Integer idChargeOutStatus) {
    this.idChargeOutStatus = idChargeOutStatus;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlTransient
  public List<ChargeOutPO> getChargeOutPOList() {
    return chargeOutPOList;
  }

  public void setChargeOutPOList(List<ChargeOutPO> chargeOutPOList) {
    this.chargeOutPOList = chargeOutPOList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idChargeOutStatus != null ? idChargeOutStatus.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ChargeOutStatusPO)) {
      return false;
    }
    ChargeOutStatusPO other = (ChargeOutStatusPO) object;
    if ((this.idChargeOutStatus == null && other.idChargeOutStatus != null) || (this.idChargeOutStatus != null && !this.idChargeOutStatus.equals(other.idChargeOutStatus))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cz.cvut.fel.x33eja.libejb.po.ChargeOutStatusPO[ idChargeOutStatus=" + idChargeOutStatus + " ]";
  }
  
}
