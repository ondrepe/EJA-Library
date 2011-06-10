package cz.cvut.fel.x33eja.lib.web.bean.publisher;

import cz.cvut.fel.x33eja.lib.iface.ejb.IPublisherBean;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import cz.cvut.fel.x33eja.lib.web.bean.CommonAdminBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@ViewScoped
public class PublisherAdminBean extends CommonAdminBean<Publisher> {

  @EJB
  private IPublisherBean publisherBean;
  
  @Override
  protected void addItem(Publisher item) {
    publisherBean.save(item);
  }

  @Override
  protected Publisher initItem() {
    return new Publisher();
  }

  @Override
  protected List<Publisher> load() {
    return publisherBean.getAllPublishers();
  }

  @Override
  protected void deleteItem(Publisher item) {
    publisherBean.remove(item.getIdPublisher());
  }
  
}
