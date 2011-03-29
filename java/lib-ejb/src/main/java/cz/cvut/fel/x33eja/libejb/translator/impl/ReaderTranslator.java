package cz.cvut.fel.x33eja.libejb.translator.impl;

import cz.cvut.fel.x33eja.libejb.db.po.ReaderPO;
import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libejb.translator.ITranslator;

/**
 *
 * @author ondrepe
 */
public class ReaderTranslator implements ITranslator<ReaderPO, Reader> {

    @Override
    public Reader fromPoToDo(ReaderPO from) {
        Reader to = new Reader();
        to.setIdReader(from.getIdReader());
        to.setName(from.getName());
        to.setSurname(from.getSurname());
        to.setEmail(from.getEmail());
        return to;
    }

    @Override
    public ReaderPO fromDoToPo(Reader from) {
        ReaderPO to = new ReaderPO();
        to.setIdReader(from.getIdReader());
        to.setName(from.getName());
        to.setSurname(from.getSurname());
        to.setEmail(from.getEmail());
        return to;
    }
}
