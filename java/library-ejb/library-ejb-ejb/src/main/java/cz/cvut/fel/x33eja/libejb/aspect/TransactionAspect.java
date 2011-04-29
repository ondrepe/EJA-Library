/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.x33eja.libejb.aspect;

import cz.cvut.fel.x33eja.libejb.modules.CommandManager;
import javax.transaction.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 *
 * @author ondrepe
 */
@Aspect
public class TransactionAspect {

  private JtaTransactionManager txManager;

  @Around(value = "@annotation(cz.cvut.fel.x33eja.libejb.annotation.Transactional) && target(bean)", argNames = "bean")
  public Object transactions(ProceedingJoinPoint pjp, CommandManager bean) throws Throwable {
    Object result = null;
    TransactionManager tx = txManager.getTransactionManager();
    tx.begin();
    try {
//      bean.getEm().clear();
      result = pjp.proceed();
      tx.commit();
    } catch (Throwable e) {
      tx.rollback();
      throw e;
    }
    return result;
  }

  public void setTxManager(JtaTransactionManager txManager) {
    this.txManager = txManager;
  }
}
