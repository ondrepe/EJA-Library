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
        //list.add(new TestMethod("addReader", addReader()));
        list.add(new TestMethod("filterReaders_IS", getResult(filterReaders())));
        list.add(new TestMethod("deleteReader", deleteReader()));
        list.add(new TestMethod("filterReaders_NOT", getResult(!filterReaders())));
        return list;
    }

    private boolean filterReaders() {
        boolean result = false;
        List<Reader> list = ra.filterReaders(null);
        if(list.size() > 0)
            result = true;
        return result;
    }

    private String addReader() {
        Reader r = new Reader(1, "Karel", "Nemecek", "karel@gmail.com");
        ra.setReader(r);
        return "OK";
    }

    private String deleteReader() {
        ra.deleteReader(1);
        return "OK";
    }

    private String getResult(boolean result) {
        if(result)
            return "OK";
        return "X";
    }

}
