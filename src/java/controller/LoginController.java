package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import datdt.dao.LoginDAO;
import datdt.dto.Tool;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MSI-PC
 */
public class LoginController extends HttpServlet {
        private final String ERROR = "error.jsp";
        private final String ADMIN = "TeacherController";
        private final String STUDENT = "StudentController";
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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
         String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            LoginDAO DAO = new LoginDAO();

            String role = DAO.checkLogin(username, Tool.sha256(password));
            HttpSession sse = request.getSession();
            sse.setAttribute("ROLE_LOGIN", role);
            
      
            if (role.equals("failed")) {
                url = ERROR;
                request.setAttribute("ERROR", "Invalid username or pass");

            } else {
               
                if (role.equals("Teacher")) {
                     HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", username);   
                    url = ADMIN;
                } else if (role.equals("Student")) {
                 HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", username); 
                    url = STUDENT;
                } else {
                    request.setAttribute("EROOR", "your role is invalid");
                }

            }
        } catch(Exception e){
            log("error at login: "+e.getMessage());
        } 
        finally{
              request.getRequestDispatcher(url).forward(request, response);

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
