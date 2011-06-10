package cz.cvut.fel.x33eja.lib.ejb.command;

import cz.cvut.fel.x33eja.lib.ejb.po.AutentizationPO;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public abstract class CommonCommand {

  protected EntityManager em;
  protected SessionContext ctx;
  private boolean adminLogged = false;
  private boolean readerLogged = false;
  private boolean anonym = false;
  private ReaderPO reader;

  public CommonCommand(EntityManager em) {
    this.em = em;
    this.initPermissions();
  }

  public CommonCommand(EntityManager em, SessionContext ctx) {
    this.em = em;
    this.ctx = ctx;
    this.initPermissions();
  }

  protected abstract boolean authorize();

  private void initPermissions() {
    try {
      adminLogged = ctx.isCallerInRole("ADMIN");
      readerLogged = ctx.isCallerInRole("READER");
      
      if (!adminLogged) {
        if (readerLogged) {
          String login = ctx.getCallerPrincipal().getName();
          AutentizationPO autentization = em.find(AutentizationPO.class, login);
          reader = autentization.getReader();
        } else {
          anonym = true;
        }
      }
    } catch (Throwable ex) {
      System.err.println(ex);
      anonym = true;
    }
  }

  public boolean isAdmin() {
    return adminLogged;
  }

  public boolean isReader() {
    return readerLogged;
  }

  public boolean isAnonym() {
    return anonym;
  }

  public ReaderPO getReader() {
    return reader;
  }
}
