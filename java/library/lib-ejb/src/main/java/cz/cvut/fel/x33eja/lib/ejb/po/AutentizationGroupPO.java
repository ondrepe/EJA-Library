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
@Table(name = "autentizationgroup")
@NamedQueries({
  @NamedQuery(name = "AutentizationGroupPO.findAll", query = "SELECT a FROM AutentizationGroupPO a"),
  @NamedQuery(name = "AutentizationGroupPO.findByGroupName", query = "SELECT a FROM AutentizationGroupPO a WHERE a.groupName = :groupName")})
public class AutentizationGroupPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "groupName")
  private String groupName;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupName")
  private List<AutentizationPO> autentizationPOList;

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

  public List<AutentizationPO> getAutentizationPOList() {
    return autentizationPOList;
  }

  public void setAutentizationPOList(List<AutentizationPO> autentizationPOList) {
    this.autentizationPOList = autentizationPOList;
  }
}
