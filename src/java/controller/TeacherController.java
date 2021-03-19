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
import javax.servlet.http.HttpSession;

/**
 *
 * @author MSI-PC
 */
public class TeacherController extends HttpServlet {

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
        String index = request.getParameter("PageIndex");
        String Page = request.getParameter("SearchString");
        HttpSession session = request.getSession();
        String Qname = (String) session.getAttribute("txtName");
        

        try {
            
            if (index == null) {
                index = "1";
            }
            int pageSize = 5;
            int endPage = 0;
            SubjectDAO subjectDAO = new SubjectDAO();
            QuestionDAO dao = new QuestionDAO();
           
            int count = dao.count();
            endPage = count / pageSize;
            if (count % pageSize != 0) {
                endPage++;
            }
            List<QuestionDTO> ListQuestion = dao.getAllQuestion(Integer.parseInt(index), pageSize);
            List<SubjectDTO> ListSubject = subjectDAO.getAllSubject();

            List<QuestionDTO> ls = dao.getAllQuestion();
            session.setAttribute("listID", ls);
            request.setAttribute("listQuestion", ListQuestion);
            request.setAttribute("end1", endPage);
            request.setAttribute("ListSubject", ListSubject);
            request.setAttribute("PageIndex", index);
            request.setAttribute("SearchString", Page);
            session.setAttribute("questionname", Qname);

           

        } catch (Exception e) {
            log("Error at pageProductServlet" + e.getMessage());
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
