/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuong.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuong.product.ProductDAO;
import phuong.product.ProductDTO;
import phuong.product.ProductErrors;

/**
 *
 * @author DELL
 */
public class ShoppingServlet extends HttpServlet {

    private final String SHOPPING_PAGE = "shoppingOnline.jsp";

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
        String url = SHOPPING_PAGE;
        List<ProductDTO> list = null;
        ProductErrors errors = null;
        try {
            ProductDAO dao = new ProductDAO();
            dao.loadProduct();
            list = dao.getProduct();
            request.setAttribute("PRODUCT_LIST", list);
        } catch (NamingException ex) {
            log("ShoppingServlet _Naming" + ex.getMessage());
            if (errors == null){
                errors = new ProductErrors();
            }
            errors.setNamingError("Error about Naming");
            request.setAttribute("SHOPPING_ERROR", errors);
        } catch (SQLException ex) {
            log("ShoppingServlet _SQL" + ex.getMessage());
            if (errors == null){
                errors = new ProductErrors();
            }
            errors.setSqlError("Error about SQL");
            request.setAttribute("SHOPPING_ERROR", errors);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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