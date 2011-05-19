package cz.cvut.fel.x33eja.lib.ejb.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "parameter")
@NamedQueries({
  @NamedQuery(name = "ParameterPO.findAll", query = "SELECT p FROM ParameterPO p"),
  @NamedQuery(name = "ParameterPO.findByIdParameter", query = "SELECT p FROM ParameterPO p WHERE p.idParameter = :idParameter"),
  @NamedQuery(name = "ParameterPO.findByGroup", query = "SELECT p FROM ParameterPO p WHERE p.paramgroup = :paramgroup"),
  @NamedQuery(name = "ParameterPO.findByName", query = "SELECT p FROM ParameterPO p WHERE p.name = :name"),
  @NamedQuery(name = "ParameterPO.findByDatatype", query = "SELECT p FROM ParameterPO p WHERE p.datatype = :datatype"),
  @NamedQuery(name = "ParameterPO.findByAbout", query = "SELECT p FROM ParameterPO p WHERE p.about = :about")})
public class ParameterPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(generator = "paramTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "paramTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "parameter", initialValue = 10000, allocationSize = 200)
  @Column(name = "idParameter")
  private Integer idParameter;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "paramgroup")
  private String paramgroup;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "datatype")
  private String datatype;
  @Size(max = 200)
  @Column(name = "about")
  private String about;

  public ParameterPO() {
  }

  public ParameterPO(Integer idParameter) {
    this.idParameter = idParameter;
  }

  public ParameterPO(Integer idParameter, String paramgroup, String name, String datatype) {
    this.idParameter = idParameter;
    this.paramgroup = paramgroup;
    this.name = name;
    this.datatype = datatype;
  }

  public Integer getIdParameter() {
    return idParameter;
  }

  public void setIdParameter(Integer idParameter) {
    this.idParameter = idParameter;
  }

  public String getParamgroup() {
    return paramgroup;
  }

  public void setParamgroup(String paramgroup) {
    this.paramgroup = paramgroup;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDatatype() {
    return datatype;
  }

  public void setDatatype(String datatype) {
    this.datatype = datatype;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }
}
