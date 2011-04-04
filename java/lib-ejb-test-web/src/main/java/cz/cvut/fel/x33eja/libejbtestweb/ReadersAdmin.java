/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.fel.x33eja.libejbtestweb;

import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libdo.session.ReadersAdministrationRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class ReadersAdmin {

    @EJB
    private ReadersAdministrationRemote ra;
    /** Creates a new instance of ReadersAdmin */
    public ReadersAdmin() {
    }

    public List<TestMethod> getTestMethods() {
        ArrayList<TestMethod> list = new ArrayList<TestMethod>();
        list.add(new TestMethod("init", getResult(ra != null)));
        list.add(new TestMethod("addReader", addReader()));
        list.add(new TestMethod("filterReaders", filterReaders()));
        return list;
    }

    private String filterReaders() {
        boolean result = false;
        List<Reader> list = ra.filterReaders("");
        if(list.size() > 0)
            result = true;
        return getResult(result);
    }

    private String addReader() {
        Reader r = new Reader(1, "Karel", "Nemecek", "karel@gmail.com");
        ra.addReader(r);
        return "OK";
    }

    private String getResult(boolean result) {
        if(result)
            return "OK";
        return "X";
    }

}