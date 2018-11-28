package dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MenuItem;

/**
 * This class provides a central location for accessing the MENUITEM table.
 */
public class MenuItemAccessor {

    private static Connection conn;
    private static PreparedStatement selectAllStatement;
    private static PreparedStatement deleteStatement;
    private static PreparedStatement addStatement;
    private static PreparedStatement updateStatement;
    private static PreparedStatement selectMax;

    // constructor is private - no instantiation allowed
    private MenuItemAccessor() {
    }

    /**
     * Used only by methods in this class to guarantee a database connection.
     *
     * @throws SQLException
     */
    private static void init() throws SQLException {
        if (conn == null) {
            conn = ConnectionManager.getConnection();
            selectAllStatement = conn.prepareStatement("select * from MENUITEM");
            deleteStatement = conn.prepareStatement("delete from MENUITEM where ITEMID = ?");
            addStatement = conn.prepareStatement("insert into MENUITEM (ITEMID, ITEMCATEGORYID,DESCRIPTION,PRICE,VEGETARIAN) values (?, ?, ?, ?, FALSE)");
            updateStatement = conn.prepareStatement("update MENUITEM set ITEMCATEGORYID = ?, DESCRIPTION = ?, PRICE = ?, VEGETARIAN = FALSE WHERE ITEMID = ?");
            selectMax = conn.prepareStatement("select max(ITEMID) from MENUITEM");
        }
    }

    public static List<MenuItem> getAllMenuItems() throws SQLException {
        init();
        List<MenuItem> items = new ArrayList();

        ResultSet rs = selectAllStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ITEMID");
            String cat = rs.getString("ITEMCATEGORYID");
            String desc = rs.getString("DESCRIPTION");
            double price = rs.getDouble("PRICE");
            MenuItem item = new MenuItem(id, cat, desc, price);
            items.add(item);
        }
        return items;
    }

    public static boolean deleteItem(MenuItem item) throws SQLException {
        init();
        boolean res;

        deleteStatement.setInt(1, item.getId());
        int rowCount = deleteStatement.executeUpdate();
        res = rowCount == 1;
        return res;
    }

    public static ResultSet selectMax() throws  SQLException{
    
        init();
        ResultSet res;
        res = selectMax.executeQuery();
        return res;    
    }
    
    
    public static boolean addItem(MenuItem item) throws SQLException {
        init();
        boolean res;
        addStatement.setInt(1, item.getId());
        addStatement.setString(2, item.getCategory());
        addStatement.setString(3, item.getDescription());
        addStatement.setDouble(4, item.getPrice());

        int rowCount = addStatement.executeUpdate();
        res = rowCount == 1;
        return res;
    }

    public static boolean updateItem(MenuItem item) throws SQLException {
        init();
        boolean res;
        updateStatement.setString(1, item.getCategory());
        updateStatement.setString(2, item.getDescription());
        updateStatement.setDouble(3, item.getPrice());
        updateStatement.setInt(4, item.getId());

        int rowCount = updateStatement.executeUpdate();
        res = rowCount == 1;
        return res;
    }

} // end MenuItemAccessor
