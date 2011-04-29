package cz.cvut.fel.x33eja.libejb.command;

import cz.cvut.fel.x33eja.libejb.po.AbstractPOObject;

/**
 *
 * @author ondrepe
 */
public abstract class GetCommand<T extends AbstractPOObject> extends Command {
  
  @Override
  public Object execute(Object... data) {
    return this.execute((Integer) data[0]);
  }
  
  public abstract T execute(int id);
}
