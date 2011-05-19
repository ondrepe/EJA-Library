package cz.cvut.fel.x33eja.lib.ejb.command;

import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public abstract class CommonCommand {

  protected EntityManager em;
  protected SessionContext ctx;

  public CommonCommand(EntityManager em) {
    this.em = em;
  }

  public CommonCommand(EntityManager em, SessionContext ctx) {
    this.em = em;
    this.ctx = ctx;
  }
  
  protected abstract boolean authorize();
}
