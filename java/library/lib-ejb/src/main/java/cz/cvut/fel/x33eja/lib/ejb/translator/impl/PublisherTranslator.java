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
  public Publisher translate(PublisherPO from) {
    Publisher publisher = new Publisher();
    
    publisher.setIdPublisher(from.getIdPublisher());
    publisher.setName(from.getName());
    
    return publisher;
  }
}
