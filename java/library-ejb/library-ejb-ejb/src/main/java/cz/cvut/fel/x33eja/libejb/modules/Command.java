package cz.cvut.fel.x33eja.libejb.modules;

/**
 *
 * @author ondrepe
 */
public interface Command {

    public Object execute(CommandManager manager, Object... data);
}
