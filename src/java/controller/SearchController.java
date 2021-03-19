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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSI-PC
 */
public class SearchController extends HttpServlet {

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
   
        String status = request.getParameter("cmbStatus");
        String isSearch = request.getParameter("Search");
        String Pname = request.getParameter("txtQuestionName");
        String txtSubject = request.getParameter("txtSubject");
        String index = request.getParameter("PageIndex");
        try {
            int pageSize = 5;
            int endPage = 0; // dung for chay tu 1 toi endPage
             SubjectDAO subjectDAO = new SubjectDAO();
            QuestionDAO dao = new QuestionDAO();

            if (!status.equals("")) {
                Pname = "";
                txtSubject = "";
            } else if (!Pname.equals("")) {
                status = "";
                txtSubject = "";
            } else {
                status = "";
                Pname = "";
            }
            String subjectID = subjectDAO.getID(txtSubject);
            int count = dao.countSearchQuestion(status, Pname, subjectID);
            System.out.println(count);
            endPage = count / pageSize;

            if (count % pageSize != 0) {
                endPage++;
            }
            List<QuestionDTO> ListSQuestion = dao.searchQuestion(status, Pname, subjectID, Integer.parseInt(index), pageSize);
            
            List<SubjectDTO> ListSubject = subjectDAO.getAllSubject();
            request.setAttribute("searchQuestion", ListSQuestion);
            request.setAttribute("end", endPage);
            request.setAttribute("status", status);
         
            request.setAttribute("name", Pname);
            request.setAttribute("txtSubject", txtSubject);
            request.setAttribute("Search", isSearch);
            request.setAttribute("PageIndex", index);
            
                request.setAttribute("ListSubject", ListSubject);
        } catch (Exception e) {
            log("ERROR AT SearchController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("teacher.jsp").forward(request, response);
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
