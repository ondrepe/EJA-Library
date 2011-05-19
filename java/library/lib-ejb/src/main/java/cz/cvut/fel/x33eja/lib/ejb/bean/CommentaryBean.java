package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.iface.ejb.ICommentaryBean;
import cz.cvut.fel.x33eja.lib.iface.to.Commentary;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author ondrepe
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CommentaryBean implements ICommentaryBean {

  @Override
  public Commentary getCommentary(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<Commentary> getAllCommentaries() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<Commentary> getCommentariesByBook(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void save(Commentary cmntr) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void remove(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
