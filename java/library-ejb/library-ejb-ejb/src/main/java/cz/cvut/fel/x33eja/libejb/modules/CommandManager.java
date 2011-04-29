package cz.cvut.fel.x33eja.libejb.modules;

import cz.cvut.fel.x33eja.libdo.domain.AbstractIFaceObject;
import cz.cvut.fel.x33eja.libejb.annotation.Transactional;
import cz.cvut.fel.x33eja.libejb.annotation.Translated;
import cz.cvut.fel.x33eja.libejb.command.Command;
import cz.cvut.fel.x33eja.libejb.po.AbstractPOObject;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;
import cz.cvut.fel.x33eja.libejb.translator.impl.ReaderTranslator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author ondrepe
 */
public class CommandManager {

  @PersistenceContext(type = PersistenceContextType.EXTENDED)
  private EntityManager em;

  @Transactional
  public Object doProcess(CommandEnum commandName, Object... data) {
    Command command = CommandCreator.getCommand(commandName);
    command.setEm(em);
    Object retVal = execute(command, data);
    return retVal;
  }
  
  @Translated
  public Object execute(Command command, Object... data) {
    Object retVal = command.execute(data);
    if(retVal instanceof AbstractPOObject) {
      return translateObject((AbstractPOObject) retVal);
    } else if (retVal instanceof List) {
      return translateList((List<AbstractPOObject>) retVal);
    }
    return retVal;
  }
  
  private AbstractIFaceObject translateObject(AbstractPOObject object) {
    ReaderTranslator rt = new ReaderTranslator();
    return rt.fromPoToDo((ReaderPO) object);
  }
  
  private List translateList(List object) {
    ReaderTranslator rt = new ReaderTranslator();
    
    List<ReaderPO> list = (List<ReaderPO>) object;
    return rt.fromPoListToDoList(list);
  }
  
}
