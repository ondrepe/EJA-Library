package cz.cvut.fel.x33eja.lib.iface.to;

import java.io.Serializable;

/**
 *
 * @author ondrepe
 */
public enum ChargeOutStatus implements Serializable {

  RESERVED(1),
  ACTIVE(2),
  RETURNED(3);
  
  private int status;

  private ChargeOutStatus(int status) {
    this.status = status;
  }

  public int getStatus() {
    return status;
  }
  
  public boolean equals(int i) {
    return status == i;
  }
  
  public static ChargeOutStatus fromStatus(int i) {
    ChargeOutStatus status = null;
    switch(i) {
      case 1: 
        status = RESERVED;
        break;
      case 2: 
        status = ACTIVE;
        break;
      case 3: 
        status = RETURNED;
        break;
    }
    return status;
  }
}
