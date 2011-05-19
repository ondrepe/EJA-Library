package cz.cvut.fel.x33eja.lib.ejb.translator.impl;

import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.CommonTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;

/**
 *
 * @author ondrepe
 */
public class PublisherTranslator extends CommonTranslator<PublisherPO, Publisher> {

  @Override
  public Publisher fromPoToDo(PublisherPO from) {
    Publisher publisher = new Publisher();
    
    return publisher;
  }

  @Override
  public PublisherPO fromDoToPo(Publisher from) {
    PublisherPO publisher = new PublisherPO();
    return publisher;
  }
  
}
