/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datdt.dao.QuestionDAO;
import datdt.dao.SubjectDAO;
import datdt.dto.QuestionDTO;
import datdt.dto.SubjectDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MSI-PC
 */
public class QuizController extends HttpServlet {

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
        String ID = request.getParameter("txtsubjectID");

       

        HttpSession session = request.getSession();



        try {

//        HttpSession session = request.getSession();
//        String Qname = (String) session.getAttribute("txtName");
//        String[] QID = request.getParameterValues("txtQuestionID");
//
//        try {
//                HttpSession session = request.getSession();
            QuestionDAO dao = new QuestionDAO();
            SubjectDTO subject = (SubjectDTO) session.getAttribute("subject");
            SubjectDAO subdao = new SubjectDAO();
            subject = subdao.getSubjectbysubID(ID);
            List<QuestionDTO> listQuestion = (List<QuestionDTO>) session.getAttribute("listQuestion");          
            int numberOfQuestion = 10;

//            listQuestion = dao.getAllQuestionBySubject1(ID, Integer.parseInt(Qnum));
            listQuestion = dao.getAllQuestionBySubject1(ID , numberOfQuestion);
                    
        

            session.setAttribute("listQuestion", listQuestion);
            session.setAttribute("subject", subject);
            session.setAttribute("subjectID", ID);
      

        } catch (Exception e) {
            log("ERROR at QuizController" + e.getMessage());
        } finally {
            request.getRequestDispatcher("UpdateQuizController").forward(request, response);
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
