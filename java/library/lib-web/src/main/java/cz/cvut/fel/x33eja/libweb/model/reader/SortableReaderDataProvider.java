package cz.cvut.fel.x33eja.libweb.model.reader;

import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import cz.cvut.fel.x33eja.libweb.common.LibraryBeanLocator;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ondrepe
 */
public class SortableReaderDataProvider extends SortableDataProvider<Reader> {

  private List<Reader> list;
  
  @Override
  public Iterator<? extends Reader> iterator(int first, int count) {
    if(list == null) {
      list = LibraryBeanLocator.getReaderBean().getAllReaders();
    }
    return list.listIterator(first);
  }

  @Override
  public int size() {
    if(list == null) {
      list = LibraryBeanLocator.getReaderBean().getAllReaders();
    }
    return list.size();
  } 

  @Override
  public IModel<Reader> model(Reader object) {
    return new DetachableReaderModel(object);
  }
  
}
