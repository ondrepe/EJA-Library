package cz.cvut.fel.x33eja.libweb.view.reader;

import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libdo.domain.ReaderDetail;
import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryPanel;
import cz.cvut.fel.x33eja.libweb.common.LibraryBeanLocator;
import cz.cvut.fel.x33eja.libweb.model.reader.SortableReaderDataProvider;
import cz.cvut.fel.x33eja.libweb.view.common.CommonActionPanel;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author ondrepe
 */
public class ReaderTable extends CommonLibraryPanel {
  
  private DefaultDataTable<Reader> table;
  private ModalWindow mw;
  private Model<ReaderDetail> mwModel;
  
  public ReaderTable(String id) {
    super(id);
  }
  
  public ReaderTable(String id, IModel<Reader> model) {
    super(id, model);
  }

  @Override
  protected void initComponents() {
    table = new DefaultDataTable<Reader>("readerTable-table", getColumnList(), new SortableReaderDataProvider(), 2);
    mwModel = new Model<ReaderDetail>();
    mw = new ReaderDetailModalWindow("readerTable-mw", mwModel);
    add(table);
    add(mw);
  }
  
  private List<IColumn<Reader>> getColumnList() {
    List<IColumn<Reader>> columns = new ArrayList<IColumn<Reader>>();
    columns.add(new PropertyColumn(new Model<String>("Id"), "idReader"));
    columns.add(new PropertyColumn(new Model<String>("Name"), "name"));
    columns.add(new PropertyColumn(new Model<String>("Surname"), "surname"));
    columns.add(new PropertyColumn(new Model<String>("E-mail"), "email"));
    columns.add(new PropertyColumn<Reader>(new Model<String>("Active"), "activeChargeOutsCount") {

      @Override
      public void populateItem(Item<ICellPopulator<Reader>> cellItem, String componentId, IModel<Reader> rowModel) {
        cellItem.add(new CommonActionPanel<Reader>(componentId, rowModel, createLabelModel(rowModel)) {

          @Override
          protected void onLinkClick(AjaxRequestTarget target) {
            mwModel.setObject(LibraryBeanLocator.getReaderBean().getActiveChargeOutsByReader(this.getObject().getIdReader()));
            mw.setTitle(this.getObject().getName() + " " + this.getObject().getSurname() + " (" + this.getObject().getEmail() + ")");
            mw.show(target);
          }
        });
      }    
    });
    columns.add(new PropertyColumn<Reader>(new Model<String>("Reserved"), "reservedChargeOutsCount") {

      @Override
      public void populateItem(Item<ICellPopulator<Reader>> cellItem, String componentId, IModel<Reader> rowModel) {
        cellItem.add(new CommonActionPanel<Reader>(componentId, rowModel, createLabelModel(rowModel)) {

          @Override
          protected void onLinkClick(AjaxRequestTarget target) {
            mwModel.setObject(LibraryBeanLocator.getReaderBean().getReservedChargeOutsByReader(this.getObject().getIdReader()));
            mw.setTitle(this.getObject().getName() + " " + this.getObject().getSurname() + " (" + this.getObject().getEmail() + ")");
            mw.show(target);
          }
        });
      }
    });
    columns.add(new PropertyColumn<Reader>(new Model<String>("All"), "chargeOutsCount") {

      @Override
      public void populateItem(Item<ICellPopulator<Reader>> cellItem, String componentId, IModel<Reader> rowModel) {
        cellItem.add(new CommonActionPanel<Reader>(componentId, rowModel, createLabelModel(rowModel)) {

          @Override
          protected void onLinkClick(AjaxRequestTarget target) {
            mwModel.setObject(LibraryBeanLocator.getReaderBean().getChargeOutsByReader(this.getObject().getIdReader()));
            mw.setTitle(this.getObject().getName() + " " + this.getObject().getSurname() + " (" + this.getObject().getEmail() + ")");
            mw.show(target);
          }
        });
      }
    });
    return columns;
  }
}
