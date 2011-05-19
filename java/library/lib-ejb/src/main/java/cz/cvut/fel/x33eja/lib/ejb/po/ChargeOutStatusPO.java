package cz.cvut.fel.x33eja.lib.ejb.po;

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

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "chargeoutstatus")
@NamedQueries({
  @NamedQuery(name = "ChargeOutStatusPO.findAll", query = "SELECT c FROM ChargeOutStatusPO c"),
  @NamedQuery(name = "ChargeOutStatusPO.findByName", query = "SELECT c FROM ChargeOutStatusPO c WHERE c.name = :name")})
public class ChargeOutStatusPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "name")
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
  private List<ChargeOutPO> chargeOutPOList;

  public ChargeOutStatusPO() {
  }

  public ChargeOutStatusPO(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ChargeOutPO> getChargeOutPOList() {
    return chargeOutPOList;
  }

  public void setChargeOutPOList(List<ChargeOutPO> chargeOutPOList) {
    this.chargeOutPOList = chargeOutPOList;
  }
}
