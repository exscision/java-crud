# JSP // Servlet Crud
## Advanced Java - Create, Read, Update, Delete 

### Description
This application is a simple crud application for reading data from a database table, and outputing the data on a webpage.
You are able to Add items, modify existing items, and delete items. 

This application uses RESTful design, and uses accessors to access the database. 

## Examples
```java

    //generates a connection to the database, based on the URL, USER, and PASSWORD constants.
    public static Connection getConnection() throws SQLException {
        return getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
    }
    
    public static Connection getConnection(String url, String user, String password) throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    // initializes the queries to the database
    private static void init() throws SQLException {
        if (conn == null) {
            conn = ConnectionManager.getConnection();
            selectAllStatement = conn.prepareStatement("select * from MENUITEM");
            deleteStatement = conn.prepareStatement("delete from MENUITEM where ITEMID = ?");
            addStatement = conn.prepareStatement("insert into MENUITEM" 
                    + "(ITEMID, ITEMCATEGORYID,DESCRIPTION,PRICE,VEGETARIAN)"
                    + "values (?, ?, ?, ?, FALSE)");
            updateStatement = conn.prepareStatement("update MENUITEM set"
                    + "ITEMCATEGORYID = ?, DESCRIPTION = ?, PRICE = ?, VEGETARIAN = FALSE WHERE ITEMID = ?");
            selectMax = conn.prepareStatement("select max(ITEMID) from MENUITEM");
        }
    }
```


### Version
Current Version: 1.0

### Authors
Zachary White - Programmer Analyst
