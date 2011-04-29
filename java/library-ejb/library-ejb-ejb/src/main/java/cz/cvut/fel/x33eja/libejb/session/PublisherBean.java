package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libdo.domain.Publisher;
import cz.cvut.fel.x33eja.libdo.session.IPublisherBean;
import cz.cvut.fel.x33eja.libejb.modules.publisher.PublisherCommandEnum;
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
@Stateless(mappedName="PublisherBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class PublisherBean extends AbstractBean implements IPublisherBean {

  @Override
  public Publisher getPublisher(int i) {
    return (Publisher) manager.doProcess(PublisherCommandEnum.GET, i);
  }

  @Override
  public List<Publisher> getAllPublishers() {
    return (List<Publisher>) manager.doProcess(PublisherCommandEnum.LIST);
  }

  @Override
  public void save(Publisher pblshr) {
    manager.doProcess(PublisherCommandEnum.SET, pblshr);
  }

  @Override
  public void remove(int i) {
    manager.doProcess(PublisherCommandEnum.DELETE, i);
  }
  
}
