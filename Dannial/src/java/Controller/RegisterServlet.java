/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.RegisterBean;
import DAO.RegisterDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Dannial Dzulkarnain bin Ahmad Sahmulaili
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public RegisterServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //copying all the input parameter in to local variables
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        RegisterBean registerBean = new RegisterBean();

        registerBean.setFirstname(firstname);
        registerBean.setLastname(lastname);
        registerBean.setAddress(address);
        registerBean.setEmail(email);
        registerBean.setPhone(phone);
        registerBean.setUsername(username);
        registerBean.setPassword(password);

        RegisterDAO registerDAO = new RegisterDAO();

        String customerRegistered = null;
        try {
            customerRegistered = registerDAO.registerCustomer(registerBean);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (customerRegistered.equals("Success")) { //on success, display message to user on homepage

            request.getRequestDispatcher("/Home.jsp").forward(request, response);
        } else {

            request.setAttribute("errMessage", customerRegistered);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }

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
