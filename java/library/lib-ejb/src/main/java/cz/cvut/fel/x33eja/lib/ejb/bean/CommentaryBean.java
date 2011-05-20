package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.ejb.command.commentary.CommentaryDeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.commentary.CommentaryGetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.commentary.CommentaryListByIdCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.commentary.CommentaryListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.commentary.CommentarySetCommand;
import cz.cvut.fel.x33eja.lib.iface.ejb.ICommentaryBean;
import cz.cvut.fel.x33eja.lib.iface.to.Commentary;
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
public class CommentaryBean implements ICommentaryBean {

  @PersistenceContext
  private EntityManager em;
  @Resource
  private SessionContext ctx;
  
  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  public Commentary getCommentary(int i) {
    CommentaryGetCommand command = new CommentaryGetCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  public List<Commentary> getAllCommentaries() {
    CommentaryListCommand command = new CommentaryListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  public List<Commentary> getCommentariesByBook(int i) {
    CommentaryListByIdCommand command = new CommentaryListByIdCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void save(Commentary cmntr) {
    CommentarySetCommand command = new CommentarySetCommand(em, ctx);
    command.execute(cmntr);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void remove(int i) {
    CommentaryDeleteCommand command = new CommentaryDeleteCommand(em, ctx);
    command.execute(i);
  }
  
}
