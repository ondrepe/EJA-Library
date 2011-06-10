package cz.cvut.fel.x33eja.lib.ejb.command.author;

import cz.cvut.fel.x33eja.lib.ejb.command.GetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.AuthorTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class AuthorGetCommand extends GetCommand<AuthorPO, Author> {

  public AuthorGetCommand(EntityManager em) {
    super(em);
  }

  public AuthorGetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected AuthorPO get(int id) {
    AuthorPO author = em.find(AuthorPO.class, id);
    return author;
  }

  @Override
  protected Author convert(AuthorPO object) {
    AuthorTranslator translator = new AuthorTranslator();
    return translator.translate(object);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
