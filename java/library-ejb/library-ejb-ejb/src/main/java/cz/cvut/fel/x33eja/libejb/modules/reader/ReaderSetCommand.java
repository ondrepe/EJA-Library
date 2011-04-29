package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.command.SetCommand;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;

/**
 *
 * @author ondrepe
 */
public class ReaderSetCommand extends SetCommand<ReaderPO> {

  @Override
  public void execute(ReaderPO reader) {
    SetCommand command;
    if(reader.getIdReader() == null || !new ReaderExistCommand().execute(reader.getIdReader()))
      command = new ReaderCreateCommand();
    else
      command = new ReaderUpdateCommand();
    command.execute(reader);           
  }

}
