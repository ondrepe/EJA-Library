package cz.cvut.fel.x33eja.lib.web.bean.publisher;

import cz.cvut.fel.x33eja.lib.iface.ejb.IPublisherBean;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import cz.cvut.fel.x33eja.lib.web.bean.CommonListBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class PublisherList extends CommonListBean<Publisher> {

  @EJB
  private IPublisherBean publisherBean;
  
  @Override
  protected List<Publisher> load() {
    return publisherBean.getAllPublishers();
  }
  
}
