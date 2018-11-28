package dbaccess;

/**
 * Convenience class to hold useful constants.
 */
public class Constants {
    
    // It is better practice to store this information 
    // in a config file that we read on startup.
    
    public static final String URL = "jdbc:derby://localhost:1527/MENUITEM";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    
    // no instantiation allowed
    private Constants() {}
    
} // end class Constants
