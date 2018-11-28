/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.MenuItemAccessor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuItem;

/**
 *
 * @author Zach
 */
public class AddServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            ResultSet rs = MenuItemAccessor.selectMax();

            while (rs.next()) {
                int id = rs.getInt(1) + 1;
                String category = request.getParameter("category");
                String description = request.getParameter("description");
                double price = Double.parseDouble(request.getParameter("price"));
                boolean veg;
                try {
                    int vegetarian = Integer.parseInt(request.getParameter("vegetarian"));
                    
                    if (vegetarian == 1) {
                        veg = true;
                    } else {
                        veg = false;
                    }
                    
                    MenuItem newItem = new MenuItem(id, category, description, price, veg);

                    boolean added = MenuItemAccessor.addItem(newItem);

                    System.out.println(id);
                    System.out.println(veg);

                    // forward to Display Servlet
                    String path = "/DisplayServlet";
                    RequestDispatcher rd = request.getRequestDispatcher(path);
                    rd.forward(request, response);
                    
                } catch (Exception ex) {
                    veg = false;
                    
                    MenuItem newItem = new MenuItem(id, category, description, price, veg);

                    boolean added = MenuItemAccessor.addItem(newItem);

                    // forward to Display Servlet
                    String path = "/DisplayServlet";
                    RequestDispatcher rd = request.getRequestDispatcher(path);
                    rd.forward(request, response);
                }

            }

        } catch (SQLException ce) {
            System.err.println(ce);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
