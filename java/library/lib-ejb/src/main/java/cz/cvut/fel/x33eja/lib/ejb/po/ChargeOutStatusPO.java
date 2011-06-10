package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "chargeoutstatus")
@NamedQueries({
  @NamedQuery(name = "ChargeOutStatusPO.findAll", query = "SELECT c FROM ChargeOutStatusPO c"),
  @NamedQuery(name = "ChargeOutStatusPO.findByName", query = "SELECT c FROM ChargeOutStatusPO c WHERE c.name = :name")})
public class ChargeOutStatusPO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "name")
  private String name;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
  private List<ChargeOutPO> chargeOuts;

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

  public List<ChargeOutPO> getChargeOuts() {
    return chargeOuts;
  }

  public void setChargeOuts(List<ChargeOutPO> chargeOuts) {
    this.chargeOuts = chargeOuts;
  }
}
