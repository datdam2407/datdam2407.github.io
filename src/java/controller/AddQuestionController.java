/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datdt.dao.QuestionDAO;
import datdt.dto.QuestionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MSI-PC
 */
public class AddQuestionController extends HttpServlet {

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
                String QID = request.getParameter("txtQuestionID");
                String name = request.getParameter("txtName");
                String SubjectID = request.getParameter("cmbSub");
                String answer_content = request.getParameter("txtAnsCon");
                String ans_correct = request.getParameter("txtCorrect");
                String A = request.getParameter("txtA");
                String B = request.getParameter("txtB");
                String C = request.getParameter("txtC");
                String D = request.getParameter("txtD");
                   HttpSession sse = request.getSession();
                  String role = (String) sse.getAttribute("ROLE_LOGIN");
                
                try {
                    if(role.equals("Teacher")){
                        
                    QuestionDAO dao = new QuestionDAO();
                    List<QuestionDTO> ls = dao.getAllQuestion();
                    request.setAttribute("listID", ls);
                   
                    dao.insert(QID, name, new Date(),SubjectID, "active", answer_content, ans_correct, A, B, C, D);
           
        }   
                }
                catch (Exception e) {
            log("error at Add Controller: " +e.getMessage());
        }
                finally{
                    response.sendRedirect("Teacher");
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
