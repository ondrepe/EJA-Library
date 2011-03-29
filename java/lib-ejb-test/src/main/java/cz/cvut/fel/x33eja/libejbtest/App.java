package cz.cvut.fel.x33eja.libejbtest;

import cz.cvut.fel.x33eja.libejbtest.modules.reader.ReaderAdministration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Lib-ejb Test!" );
        ReaderAdministration reader = new ReaderAdministration();
        boolean isLoaded = reader.testInit();
        System.out.println("ReaderAdministrationEJB: " + isLoaded);
    }
}
