package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.ejb.command.author.AuthorDeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.author.AuthorGetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.author.AuthorListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.author.AuthorSetCommand;
import cz.cvut.fel.x33eja.lib.iface.ejb.IAuthorBean;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ondrepe
 */
@Stateless
@DeclareRoles({"ADMIN", "READER", "ANONYM"})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AuthorBean implements IAuthorBean {
  
  @PersistenceContext
  private EntityManager em;
  @Resource
  private SessionContext ctx;
  
  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  public Author getAuthor(int i) {
    AuthorGetCommand command = new AuthorGetCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  public List<Author> getAllAuthors() {
    AuthorListCommand command = new AuthorListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void save(Author author) {
    AuthorSetCommand command = new AuthorSetCommand(em, ctx);
    command.execute(author);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void remove(int id) {
    AuthorDeleteCommand command = new AuthorDeleteCommand(em, ctx);
    command.execute(id);
  }
  
}
