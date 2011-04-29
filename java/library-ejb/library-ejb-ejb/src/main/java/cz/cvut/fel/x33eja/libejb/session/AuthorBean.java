package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libdo.domain.Author;
import cz.cvut.fel.x33eja.libdo.session.IAuthorBean;
import cz.cvut.fel.x33eja.libejb.modules.author.AuthorCommandEnum;
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
@Stateless(mappedName="AuthorBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class AuthorBean extends AbstractBean implements IAuthorBean {
  
  @Override
  public Author getAuthor(int i) {
    return (Author) manager.doProcess(AuthorCommandEnum.GET, i);
  }

  @Override
  public List<Author> getAllAuthors() {
    return (List<Author>) manager.doProcess(AuthorCommandEnum.LIST);
  }

  @Override
  public void save(Author author) {
    manager.doProcess(AuthorCommandEnum.SET, author);
  }

  @Override
  public void remove(int id) {
    manager.doProcess(AuthorCommandEnum.DELETE, id);
  }
  
}
