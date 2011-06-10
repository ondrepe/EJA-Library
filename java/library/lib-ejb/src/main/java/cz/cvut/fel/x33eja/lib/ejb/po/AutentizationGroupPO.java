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
@Table(name = "autentizationgroup")
@NamedQueries({
  @NamedQuery(name = "AutentizationGroupPO.findAll", query = "SELECT a FROM AutentizationGroupPO a"),
  @NamedQuery(name = "AutentizationGroupPO.findByGroupName", query = "SELECT a FROM AutentizationGroupPO a WHERE a.groupName = :groupName")})
public class AutentizationGroupPO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "groupName")
  private String groupName;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupName")
  private List<AutentizationPO> autentizations;

  public AutentizationGroupPO() {
  }

  public AutentizationGroupPO(String groupName) {
    this.groupName = groupName;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public List<AutentizationPO> getAutentizations() {
    return autentizations;
  }

  public void setAutentizations(List<AutentizationPO> autentizations) {
    this.autentizations = autentizations;
  }
}
