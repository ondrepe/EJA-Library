package cz.cvut.fel.x33eja.libejb.command;

import cz.cvut.fel.x33eja.libejb.po.AbstractPOObject;

/**
 *
 * @author ondrepe
 */
public abstract class SetCommand<T extends AbstractPOObject> extends Command {
  
  @Override
  public Object execute(Object... data) {
    this.execute(data[0]);
    return null;
  }
  
  public abstract void execute(T object);
}
