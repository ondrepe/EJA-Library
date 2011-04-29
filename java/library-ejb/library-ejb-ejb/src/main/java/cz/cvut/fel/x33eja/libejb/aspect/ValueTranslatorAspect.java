package cz.cvut.fel.x33eja.libejb.aspect;

import cz.cvut.fel.x33eja.libdo.domain.AbstractIFaceObject;
import cz.cvut.fel.x33eja.libejb.modules.CommandManager;
import cz.cvut.fel.x33eja.libejb.po.AbstractPOObject;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;
import cz.cvut.fel.x33eja.libejb.translator.impl.ReaderTranslator;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author ondrepe
 */
@Aspect
public class ValueTranslatorAspect {
  
  @Around(value = "@annotation(cz.cvut.fel.x33eja.libejb.annotation.Translated) && target(bean)", argNames = "bean")
  public Object translateValue(ProceedingJoinPoint pjp, CommandManager bean) throws Throwable {
    Object retVal = pjp.proceed();
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
