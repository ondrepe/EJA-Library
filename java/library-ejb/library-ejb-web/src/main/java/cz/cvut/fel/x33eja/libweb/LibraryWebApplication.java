package cz.cvut.fel.x33eja.libweb;

import cz.cvut.fel.x33eja.libweb.view.LibraryHomePage;
import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryPage;
import cz.cvut.fel.x33eja.libweb.view.common.CommonLibraryWebApplication;

public class LibraryWebApplication extends CommonLibraryWebApplication {

  @Override
  public Class<? extends CommonLibraryPage> getHomePage() {
    return LibraryHomePage.class;
  }
}
