package cz.cvut.fel.x33eja.libweb.common;

import org.wicketstuff.javaee.naming.IJndiNamingStrategy;

/**
 *
 * @author ondrepe
 */
public class GlassfishJndiNamingStrategy implements IJndiNamingStrategy {

  @Override
  public String calculateName(String ejbName, Class<?> ejbType) {
    return (ejbName == null ? ejbType.getName() : "java:app/lib-ejb-1.0/" + ejbName);
  }
  
}
