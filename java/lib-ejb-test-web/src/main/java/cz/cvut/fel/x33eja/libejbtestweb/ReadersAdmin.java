package cz.cvut.fel.x33eja.libejbtestweb;

import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libdo.session.IReaderBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class ReadersAdmin {

  @EJB(name = "ReaderBean")
  private IReaderBean ra;
  
  private String name;
  private String surname;
  private String email;
  private Integer id;

  public ReadersAdmin() {
  }

  public List<Reader> getReaders() {
    return ra.getAllReaders();
  }

  public void add() {
    Reader r = new Reader(null, name, surname, email);
    ra.save(r);
  }

  public void delete() {
    ra.remove(id);
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public IReaderBean getRa() {
    return ra;
  }

  public void setRa(IReaderBean ra) {
    this.ra = ra;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

}
