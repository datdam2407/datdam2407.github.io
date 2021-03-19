/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datdt.dao.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MSI-PC
 */
public class EditController extends HttpServlet {

    private final String Home = "TeacherController";
    private final String SEARCH = "SearchController";

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

        String Pname1 = request.getParameter("txtQuestionName");
        String status = request.getParameter("cmbStatus");
        String search = request.getParameter("Search");
      
        String Page = request.getParameter("SearchString");
        String txtSubject = request.getParameter("txtSubject");
        String index = request.getParameter("PageIndex");

        String url = Home;
        try {
//            if(){
//                
//            }
            QuestionDAO dao = new QuestionDAO();
            dao.edit(QID, name, SubjectID, status, answer_content, ans_correct, A, B, C, D);

            if (txtSubject.equals("") ) {
                url = Home;
            }

            else if (Page == null) {

                url = SEARCH;
            }
            request.setAttribute("status", status);
            request.setAttribute("name", Pname1);
            request.setAttribute("txtSubject", txtSubject);
            request.setAttribute("PageIndex", index);
            request.setAttribute("search", search);
        } catch (Exception e) {
            log("error at Edit Controller: " + e.getMessage());
        } finally {
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
