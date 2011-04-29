package cz.cvut.fel.x33eja.libejb.command;

import cz.cvut.fel.x33eja.libejb.po.AbstractPOObject;
import java.util.List;

/**
 *
 * @author ondrepe
 */
public abstract class ListCommand<T extends AbstractPOObject> extends Command {
  
  @Override
  public Object execute(Object... data) {
    return this.execute();
  }
  
  public abstract List<T> execute();
}
