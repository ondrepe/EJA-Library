package cz.cvut.fel.x33eja.libejb.command;

import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public abstract class Command {
  
  protected EntityManager em;

  public void setEm(EntityManager em) {
    this.em = em;
  }
  
  public abstract Object execute(Object... data);
}
