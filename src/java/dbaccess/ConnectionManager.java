package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection conn = null;

    // Note: no public/private/protected modifier = "package private" - i.e.,
    // accessible only to classes in the same package.
    // So, the MenuItemAccessor can call this method, but the servlets can't.
    public static Connection getConnection() throws SQLException {
        return getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
    }
    
    public static Connection getConnection(String url, String user, String password) throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }
    
} // end class ConnectionManager
