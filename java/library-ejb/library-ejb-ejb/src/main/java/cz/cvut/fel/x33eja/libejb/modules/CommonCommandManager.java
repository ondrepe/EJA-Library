package cz.cvut.fel.x33eja.libejb.modules;

import cz.cvut.fel.x33eja.libejb.translator.CommonTranslator;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ondrepe
 */
public abstract class CommonCommandManager implements CommandManager {

  @PersistenceContext(type=PersistenceContextType.EXTENDED)
  private EntityManager em;
  protected CommonTranslator translator;

  @Override
  @Transactional
  public Object doProcess(CommandEnum commandName, Object... data) {
    Command command = getCommand(commandName);
    return command.execute(this, data);
  }

  @Override
  public EntityManager getEm() {
    return em;
  }

  public void setTranslator(CommonTranslator translator) {
    this.translator = translator;
  }

  @Override
  public CommonTranslator getTranslator() {
    return translator;
  }

  public abstract Command getCommand(CommandEnum commandName);
}
