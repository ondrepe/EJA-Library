package cz.cvut.fel.x33eja.libweb.view.common;

import cz.cvut.fel.x33eja.libweb.common.GlassfishJndiNamingStrategy;
import org.apache.wicket.protocol.http.WebApplication;
import org.wicketstuff.javaee.injection.JavaEEComponentInjector;

/**
 *
 * @author ondrepe
 */
public abstract class CommonLibraryWebApplication extends WebApplication {
  
  @Override
  public void init() {
    super.init();
    addComponentInstantiationListener(new JavaEEComponentInjector(this, new GlassfishJndiNamingStrategy()));
  }
  
}
