<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Items</title>
        <style>
            table, td, th {
                border: solid thin gray;
                border-collapse: collapse;
            }

            td, th {
                padding: 10px;
            }

            th {
                text-align: left;
                background-color: midnightblue;
                color: white;
            }

            tr:hover {
                background-color: lightblue;
            }
            
            .add{
                margin-bottom: 10px;
                padding: 10px 0;
            }
        </style>
    </head>
    <body>
        <h1>Menu Items</h1>

        <div class="add">
        <form action="AddServlet">
            <input type="text" name="category" placeholder="category" required>
            <input type="text" name="description" placeholder="description" required>
            <input type="number" name="price" placeholder="price" required>
            <br><button type="submit">Add</button>
        </form>
        </div>
        
        <table>
            <tr><th>ID</th><th>Category</th><th>Description</th><th>Price</th><th></th><th></th></tr>

            <c:forEach items="${theMenuItems}" var="temp">
                <tr>
                    <td>${temp.id}</td>
                    <td>${temp.category}</td>
                    <td>${temp.description}</td>
                    <td>${temp.price}</td>
                    <td>
                        <form action="DeleteServlet">
                            <input type="hidden" name="id" value="${temp.id}">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                    <td>
                        <form action="UpdateServlet">
                            <input type="hidden" name="id" value="${temp.id}">
                            <input type="hidden" name="category" value="${temp.category}">
                            <input type="hidden" name="description" value="${temp.description}">
                            <input type="hidden" name="price" value="${temp.price}">
                            <button type="submit">Update</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
