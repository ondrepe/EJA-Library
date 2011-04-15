package cz.cvut.fel.x33eja.libweb.model.reader;

import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libweb.common.LibraryBeanLocator;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author ondrepe
 */
public class DetachableReaderModel extends LoadableDetachableModel<Reader> {

  private final int id;
  
  public DetachableReaderModel(Reader reader) {
    this(reader.getIdReader());
  }
  
  public DetachableReaderModel(int id) {
    this.id = id;
  }
  
  @Override
  protected Reader load() {
    return LibraryBeanLocator.getReaderBean().getReader(id);
  }
  
}
