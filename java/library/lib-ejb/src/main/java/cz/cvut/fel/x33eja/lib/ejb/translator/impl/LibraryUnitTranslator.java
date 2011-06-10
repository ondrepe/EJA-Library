package cz.cvut.fel.x33eja.lib.ejb.translator.impl;

import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.CommonTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.LibraryUnit;

/**
 *
 * @author ondrepe
 */
public class LibraryUnitTranslator extends CommonTranslator<LibraryUnitPO, LibraryUnit> {

  @Override
  public LibraryUnit translate(LibraryUnitPO from) {
    LibraryUnit libUnit = new LibraryUnit();
    
    libUnit.setIdLibraryUnit(from.getIdLibraryUnit());
    
    BookTitleTranslator translator = new BookTitleTranslator();
    libUnit.setIdBookTitle(translator.translate(from.getBookTitle()));
    
    return libUnit;
  }
}
