package cz.cvut.fel.x33eja.lib.web.bean.publisher;

import cz.cvut.fel.x33eja.lib.iface.ejb.IPublisherBean;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import cz.cvut.fel.x33eja.lib.web.bean.CommonAddBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class PublisherAdd extends CommonAddBean<Publisher> {

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
  
}
