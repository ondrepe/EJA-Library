package cz.cvut.fel.x33eja.lib.ejb.command.author;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.AuthorTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class AuthorListCommand extends ListCommand<AuthorPO, Author> {

  public AuthorListCommand(EntityManager em) {
    super(em);
  }

  public AuthorListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<AuthorPO> list() {
    Query query = em.createNamedQuery("AuthorPO.findAll");
    return query.getResultList();
  }

  @Override
  protected List<Author> convert(List<AuthorPO> list) {
    AuthorTranslator translator = new AuthorTranslator();
    return translator.translateList(list);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
