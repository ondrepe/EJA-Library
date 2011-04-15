package cz.cvut.fel.x33eja.libweb.view.reader;

import cz.cvut.fel.x33eja.libdo.domain.ChargeOut;
import cz.cvut.fel.x33eja.libdo.domain.ReaderDetail;
import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryPanel;
import cz.cvut.fel.x33eja.libweb.model.reader.ReaderDetailDataProvider;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author ondrepe
 */
public class ReaderChargeOutTable extends CommonLibraryPanel<ReaderDetail> {

  private DefaultDataTable<ChargeOut> dataTable;
  
  public ReaderChargeOutTable(String id, IModel<ReaderDetail> model) {
    super(id, model);
  }
  
  @Override
  protected void initComponents() {
    dataTable = new DefaultDataTable<ChargeOut>("readerChargeOutTable-table", getColumnList(), new ReaderDetailDataProvider(getModel()), 5);
    add(dataTable);
  }
  
  private List<IColumn<ChargeOut>> getColumnList() {
    List<IColumn<ChargeOut>> columns = new ArrayList<IColumn<ChargeOut>>();
    columns.add(new PropertyColumn<ChargeOut>(new Model<String>("Id"), "id"));
    columns.add(new PropertyColumn<ChargeOut>(new Model<String>("Name"), "book"){

      @Override
      protected IModel<?> createLabelModel(IModel<ChargeOut> rowModel) {
        return new PropertyModel(new PropertyModel(rowModel, getPropertyExpression()), "title");
      }
    });
    columns.add(new PropertyColumn<ChargeOut>(new Model<String>("From"), "from"));
    columns.add(new PropertyColumn<ChargeOut>(new Model<String>("To"), "to"));
    columns.add(new PropertyColumn<ChargeOut>(new Model<String>("Status"), "status"));
    return columns;
  }
}
