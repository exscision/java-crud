<%-- 
    Document   : updateItem
    Created on : 27-Nov-2018, 3:07:20 PM
    Author     : Zach
--%>

<%@page import="model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Item</title>
    </head>
    <body>

        <%
            session = request.getSession();

            MenuItem newItem = (MenuItem) session.getAttribute("newItem");

            out.print("<form action='UpdateSelectedServlet'><h1> Update Item </h1>");
            out.println("<input type='hidden' name='id' value='" + newItem.getId() + "'><br><br>");
            out.print("<h> Category </h>");
            out.println("<input type='text' name='category' value='" + newItem.getCategory() + "'><br><br>");
            out.print("<h> Description </h>");
            out.println("<input type='text' name='description' value='" + newItem.getDescription() + "'><br><br>");
            out.print("<h> Price </h>");
            out.println("<input type='number' name='price' value='" + newItem.getPrice() + "'><br><br>");
            out.println("<button type='submit'>Submit</button></form>");
            

            session.setAttribute("newItem", "");
        %>
    </body>
</html>
