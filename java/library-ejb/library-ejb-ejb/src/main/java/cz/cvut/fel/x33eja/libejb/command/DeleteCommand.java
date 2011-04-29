package cz.cvut.fel.x33eja.libejb.command;

/**
 *
 * @author ondrepe
 */
public abstract class DeleteCommand extends Command {
  
  @Override
  public Object execute(Object... data) {
    this.execute((Integer) data[0]);
    return null;
  }
  public abstract void execute(int id);
}
