package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libejb.modules.CommandManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ondrepe
 */
public abstract class AbstractBean {
  
  @Autowired
  protected CommandManager manager;
}
