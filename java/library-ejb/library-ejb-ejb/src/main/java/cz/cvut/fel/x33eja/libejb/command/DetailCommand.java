package cz.cvut.fel.x33eja.libejb.command;

import cz.cvut.fel.x33eja.libdo.domain.AbstractIFaceObject;

/**
 *
 * @author ondrepe
 */
public abstract class DetailCommand<T extends AbstractIFaceObject> extends Command {
  
  @Override
  public Object execute(Object... data) {
    Object[] data1 = null;
    if(data.length > 1) {
      data1 = new Object[data.length - 1];
      for (int i = 0; i < data1.length; i++) {
        data1[i] = data[i+1];
      }
    }
    this.execute((Integer) data[0], data1);
    return null;
  }
  
  public abstract T execute(int i, Object... data);
}
