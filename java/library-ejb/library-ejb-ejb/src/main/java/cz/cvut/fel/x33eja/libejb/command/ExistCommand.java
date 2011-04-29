package cz.cvut.fel.x33eja.libejb.command;

/**
 *
 * @author ondrepe
 */
public abstract class ExistCommand extends Command {
  
  @Override
  public Object execute(Object... data) {
    return this.execute((Integer) data[0]);
  }
  
  public abstract boolean execute(int id);
}
