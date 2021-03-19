/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class UpdateQuizController extends HttpServlet {

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
        String time = request.getParameter("timeleft");
        String index = request.getParameter("quizIndex");
        String action = request.getParameter("doQuiz");
        String QID = request.getParameter("questionID");
        String content = request.getParameter("content");
        String listAnswer = request.getParameter("Student");

        HttpSession session = request.getSession();
        List<QuestionDTO> listQuestion = (List<QuestionDTO>) session.getAttribute("listQuestion");
        SubjectDTO dto = (SubjectDTO) session.getAttribute("subject");
        if (QID == null) {
            QID = " ";
        }
        
        if (listAnswer != null) {
            for (QuestionDTO question : listQuestion) {
                if (question.getQuestionID().equals(QID)) {
                    question.setStudent(listAnswer);
                }
            }
        }
        
        if (index == null) {
            index = "0";
        }
        
        int indexQ = Integer.parseInt(index);//0

        String url = "quiz.jsp";
        try {

            if (time == null) {
                time = String.valueOf(dto.getRemain()); 
                request.setAttribute("time", Integer.parseInt(time) * 60); //300s
            } else {
                // update time
                // s =  min * 60 = n(s) + s 1 04minute59second 
                int Second = Integer.parseInt(time.substring(0, time.indexOf("minute"))) * 60 + Integer.parseInt(time.substring(7, time.indexOf("second")));
//                  System.out.println(Second);
                request.setAttribute("time", Second);
                // lưu answer 
//                 listQuestion.get(Integer.parseInt(index)).setStudent(request.getParameter("Student"));
                //get question
                if (indexQ != 0 && action.equals(" ")) {
                    indexQ -= 1;
                }
                //update question
                if (action.equals("Next")) {
                    indexQ++;

                    // update question
                } else if (action.equals("Previous")) {

                    indexQ--;
                } //finished
                
                else if (action.equals("Submit")) {
                    url = "GradeController";
                } else if (!action.equals(" ")) {
                    indexQ = Integer.parseInt(action) - 1;
                    }

            }
            String QuestionID = listQuestion.get(indexQ).getQuestionID(),
                    QuestionA = listQuestion.get(indexQ).getQuestionA(),
                    QuestionB = listQuestion.get(indexQ).getQuestionB(),
                    QuestionC = listQuestion.get(indexQ).getQuestionC(),
                    QuestionD = listQuestion.get(indexQ).getQuestionD(),
                    savedAnswer = listQuestion.get(indexQ).getStudent();
                    content = listQuestion.get(indexQ).getContentQuestion();
                    
            request.setAttribute("quizsize", dto.getQuizQuestion());
            request.setAttribute("IndexQuestion", indexQ);
            request.setAttribute("txtAnswerA", QuestionA);
            request.setAttribute("txtAnswerB", QuestionB);
            request.setAttribute("txtAnswerC", QuestionC);
            request.setAttribute("txtAnswerD", QuestionD);
            request.setAttribute("Student", savedAnswer);
            request.setAttribute("questionID", QuestionID);
            request.setAttribute("content", content);
            request.setAttribute("quizIndex", String.valueOf(indexQ));

        } catch (Exception e) {
            log("error at Updatequiz Controller: " + e.getMessage());
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
