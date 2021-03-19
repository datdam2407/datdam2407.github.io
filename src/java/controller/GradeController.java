/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datdt.dao.RegisteredSubjectDetailDAO;
import datdt.dto.QuestionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MSI-PC
 */
public class GradeController extends HttpServlet {

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
            HttpSession session = request.getSession();
            List<QuestionDTO> listQuestion = (List<QuestionDTO>) session.getAttribute("listQuestion");
            String ID = (String) session.getAttribute("subjectID");
            String username = (String) session.getAttribute("LOGIN_USER");
            RegisteredSubjectDetailDAO dao = new RegisteredSubjectDetailDAO();

          
            
             if (username == null) {
            username = " ";
                 }
        
            String lastID =dao.getLastResultID(username);
            String RegisteredSubjectID ;

            if(lastID != null){
                String [] tmp = lastID.split("-");
                RegisteredSubjectID = username + "-" + (Integer.parseInt(tmp[1])+1);
            }else {
                RegisteredSubjectID = username + "-1";
            }
            int count = 0;
             for (QuestionDTO question : listQuestion) {
                if(question.getAnswercontent().equals(question.getStudent()))
                    count++;
            }
            
//            for (QuestionDTO listAnswer : listQuestion) {
//
//                if (listAnswer.getStudent().equals("404")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("2")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("OPTIONS")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("specify response headers (Content-Type, Set-Cookie, etc.)")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("Request line returns the User-Agent along with the Accept header                                           ")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("number of Bytes")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("a text or HTML response")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("session-config")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("web.xml")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("/WEB-INF/ lib                                           ")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("cookies")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("POST")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("service()")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("getContentLength()")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("True")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("doPost(ServletRequest, ServletResponse)")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("All of the others.")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("error-page")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals(" To use session, the client browser must support cookies.()")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("WEB-INF/classes/com/abc")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("/WEB-INF")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("action                                                                                      ")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals("request.getSession().setAttribute(name, value).;                                           ")) {
//                    count++;
//                } else if (listAnswer.getStudent().equals(" Initialization code in servlets is executed every time the program is made to run                                           ")) {
//                    count++;
//                }else if (listAnswer.getStudent().equals("DOM")) {
//                    count++;
//                }
//
//            }

            float grade = 0;
            grade = (float) count * 10 / listQuestion.size();
//            System.out.println(grade);
          
            dao.createRegisteredSubjectDetails(RegisteredSubjectID, grade, ID, new Date(),username);

            request.setAttribute("mark", (float) Math.round(grade * 100) / 100);
            request.setAttribute("correct", count);
            session.removeAttribute("listQuestion");
            session.removeAttribute("subject");
            
        } catch (Exception e) {
            log("ERROR at QuizGradedController" + e.getMessage());

        } finally {
            request.getRequestDispatcher("quiz_result.jsp").forward(request, response);

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
