package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libdo.domain.Commentary;
import cz.cvut.fel.x33eja.libdo.session.ICommentaryBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 *
 * @author ondrepe
 */
@Stateless(mappedName="CommentaryBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionManagement(TransactionManagementType.BEAN)
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
