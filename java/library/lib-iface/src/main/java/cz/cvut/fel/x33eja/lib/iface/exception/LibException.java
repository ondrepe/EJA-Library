package cz.cvut.fel.x33eja.lib.iface.exception;

/**
 *
 * @author ondrepe
 */
public class LibException extends RuntimeException {

  private LibExceptionCode code;
  
  public LibException(String message) {
    super(message);
    this.code = LibExceptionCode.UNKNOWN;
  }
  
  public LibException(LibExceptionCode code) {
    this.code = code;
  }
  
  public LibException(String message, LibExceptionCode code) {
    this(message);
    this.code = code;
  }
  
  public LibException(String message, Throwable cause) {
    super(message, cause);
  }
  
  public LibException(LibExceptionCode code, Throwable cause) {
    super(cause);
    this.code = code;
  }
  
  public LibException(String message, LibExceptionCode code, Throwable cause) {
    this(message, cause);
    this.code = code;
  }

  public LibExceptionCode getCode() {
    return code;
  }
  
}
