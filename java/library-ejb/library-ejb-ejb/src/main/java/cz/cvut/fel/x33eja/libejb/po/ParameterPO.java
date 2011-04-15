package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "parameter")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ParameterPO.findAll", query = "SELECT p FROM ParameterPO p"),
  @NamedQuery(name = "ParameterPO.findByIdParameter", query = "SELECT p FROM ParameterPO p WHERE p.idParameter = :idParameter"),
  @NamedQuery(name = "ParameterPO.findByParamGroup", query = "SELECT p FROM ParameterPO p WHERE p.paramGroup = :paramGroup"),
  @NamedQuery(name = "ParameterPO.findByName", query = "SELECT p FROM ParameterPO p WHERE p.name = :name"),
  @NamedQuery(name = "ParameterPO.findByDatatype", query = "SELECT p FROM ParameterPO p WHERE p.datatype = :datatype"),
  @NamedQuery(name = "ParameterPO.findByAbout", query = "SELECT p FROM ParameterPO p WHERE p.about = :about")})
public class ParameterPO implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "Parameter_table", strategy = GenerationType.TABLE)
  @TableGenerator(name = "Parameter_table", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_NUM", pkColumnValue = "PARAMETER_SEQ")
  @Basic(optional = false)
  @NotNull
  @Column(name = "idParameter")
  private Integer idParameter;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "paramGroup")
  private String paramGroup;
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

  public ParameterPO(Integer idParameter, String paramGroup, String name, String datatype) {
    this.idParameter = idParameter;
    this.paramGroup = paramGroup;
    this.name = name;
    this.datatype = datatype;
  }

  public Integer getIdParameter() {
    return idParameter;
  }

  public void setIdParameter(Integer idParameter) {
    this.idParameter = idParameter;
  }

  public String getParamGroup() {
    return paramGroup;
  }

  public void setParamGroup(String paramGroup) {
    this.paramGroup = paramGroup;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idParameter != null ? idParameter.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ParameterPO)) {
      return false;
    }
    ParameterPO other = (ParameterPO) object;
    if ((this.idParameter == null && other.idParameter != null) || (this.idParameter != null && !this.idParameter.equals(other.idParameter))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cz.cvut.fel.x33eja.libejb.po.ParameterPO[ idParameter=" + idParameter + " ]";
  }
  
}
