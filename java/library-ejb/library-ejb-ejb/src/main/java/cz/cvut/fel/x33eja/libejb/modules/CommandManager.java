package cz.cvut.fel.x33eja.libejb.modules;

import cz.cvut.fel.x33eja.libejb.translator.CommonTranslator;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public interface CommandManager {

    public Object doProcess(CommandEnum command, Object... data);
    public EntityManager getEm();
    public CommonTranslator getTranslator();
}
