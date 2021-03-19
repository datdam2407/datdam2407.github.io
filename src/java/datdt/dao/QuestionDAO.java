/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdt.dao;

import datdt.dto.QuestionDTO;
import datdt.ult.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author MSI-PC
 */
public class QuestionDAO implements Serializable {

    private Connection con;
    private PreparedStatement pr;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pr != null) {
            pr.close();
        }
        if (con != null) {
            con.close();
        }

    }

   
    public int count() throws Exception {
        try {
            String sql = "select count(*) from Question";
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                return rs.getInt(1); // kq no dem duoc bao nhieu bai no nam o cột đầu tiên
            }
        } finally {
            closeConnection();
        }
        return 0;
    }

    //search controller
    public int countSearchQuestion(String status, String name, String subjectID) throws Exception {
        String sql = null;
        if (name.equals("") && subjectID.equals("")) {
            sql = "Select count(*) From Question Where status = ?";
        }
        if (status.equals("") && subjectID.equals("")) {
            sql = "Select count(*) From Question Where contentQuestion Like ?";
        }
//        With x As(Select ROW_NUMBER() Over (Order By Productname asc) as num,* From tblProduct Where Productname Like '%c%' And CategoryID = 'D' And Quantity > 0 And status = 'active') Select * From x Where num between 1 and 10
//With x As(Select ROW_NUMBER() Over (Order By Productname asc) as num,* From tblProduct Where Productname Like '%T%' And CategoryID = 'D' And Quantity > 0 And status = 'active') Select * From x Where num between 1 And 10

        if (name.equals("") && status.equals("")) {
            sql = "Select count(*) From Question Where subjectID = ?";
        }
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            if (name.equals("") && subjectID.equals("")) {
                pr.setString(1, status);
            }
            if (status.equals("") && subjectID.equals("")) {
                pr.setString(1, "%" + name + "%");
            }
            if (name.equals("") && status.equals("")) {
                pr.setString(1, subjectID);
            }
            rs = pr.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } finally {
            closeConnection();
        }
        return 0;
    }

    public List<QuestionDTO> getAllQuestion() throws NamingException, SQLException, Exception {
        List<QuestionDTO> ls = null;
        String questionID, contentQuestion, subjectID, status, answer_content, answer_correct, QuestionA, QuestionB, QuestionC, QuestionD;
        Date createDate;
        QuestionDTO dto;
        String sql = "Select questionID ,contentQuestion,subjectID ,status,createDate,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD From Question";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            ls = new ArrayList<>();
            while (rs.next()) {
                questionID = rs.getString("questionID");
                contentQuestion = rs.getString("contentQuestion");
                createDate = rs.getDate("createDate");
                subjectID = rs.getString("subjectID");
                status = rs.getString("status");
                answer_content = rs.getString("answer_content");
                answer_correct = rs.getString("answer_correct");
                QuestionA = rs.getString("QuestionA");
                QuestionB = rs.getString("QuestionB");
                QuestionC = rs.getString("QuestionC");
                QuestionD = rs.getString("QuestionD");

                dto = new QuestionDTO(questionID, contentQuestion, createDate, subjectID, status, answer_content, answer_correct, QuestionA, QuestionB, QuestionC, QuestionD);
                ls.add(dto);
            }
        } finally {
            closeConnection();
        }
        return ls;
    }

   
    public QuestionDTO getQuestionByKey(String QuestionID) throws NamingException, SQLException, Exception {
        QuestionDTO ls = null;
        String contentQuestion, subjectID, status, answer_content, answer_correct, QuestionA, QuestionB, QuestionC, QuestionD;
        Date createDate;

        String sql = "Select ProductID, contentQuestion,createDate,subjectID,status,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD From Question where questionID = ?";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setString(1, QuestionID);
            rs = pr.executeQuery();
            while (rs.next()) {

                contentQuestion = rs.getString("contentQuestion");
                createDate = rs.getDate("createDate");
                subjectID = rs.getString("subjectID");
                status = rs.getString("status");
                answer_content = rs.getString("answer_content");
                answer_correct = rs.getString("answer_correct");
                QuestionA = rs.getString("QuestionA");
                QuestionB = rs.getString("QuestionB");
                QuestionC = rs.getString("QuestionC");
                QuestionD = rs.getString("QuestionD");
                ls = new QuestionDTO(QuestionID, contentQuestion, createDate, subjectID, status, answer_content, answer_correct, QuestionA, QuestionB, QuestionC, QuestionD);
            }
        } finally {
            closeConnection();
        }
        return ls;
    }

    public List<QuestionDTO> getAllQuestion(int index, int size) throws NamingException, SQLException, Exception {

        List<QuestionDTO> ls = null;
        String questionID, contentQuestion, subjectID, status, answer_content, answer_correct, QuestionA, QuestionB, QuestionC, QuestionD;
        Date createDate;
        QuestionDTO dto;
        String sql = "With x As(Select ROW_NUMBER() Over (Order By questionID asc) as num,questionID, contentQuestion,createDate,subjectID,status,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD From Question) Select questionID, contentQuestion,createDate,subjectID,status,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD From x Where num between ?*?-(?-1) And ?*?";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setInt(1, index);
            pr.setInt(2, size);
            pr.setInt(3, size);
            pr.setInt(4, index);
            pr.setInt(5, size);
            rs = pr.executeQuery();
            ls = new ArrayList<>();
            while (rs.next()) {
                questionID = rs.getString("questionID");
                contentQuestion = rs.getString("contentQuestion");
                createDate = rs.getDate("createDate");
                subjectID = rs.getString("subjectID");
                status = rs.getString("status");
                answer_content = rs.getString("answer_content");
                answer_correct = rs.getString("answer_correct");
                QuestionA = rs.getString("QuestionA");
                QuestionB = rs.getString("QuestionB");
                QuestionC = rs.getString("QuestionC");
                QuestionD = rs.getString("QuestionD");
                dto = new QuestionDTO(questionID, contentQuestion, createDate, subjectID, status, answer_content, answer_correct, QuestionA, QuestionB, QuestionC, QuestionD);
                ls.add(dto);
            }
        } finally {
            closeConnection();
        }
        return ls;
    }

//adminsearchProduct
    public List<QuestionDTO> searchQuestion(String status, String search, String subject, int index, int size) throws NamingException, SQLException, Exception {
        List<QuestionDTO> ls = new ArrayList<>();

        String questionID, contentQuestion, subjectID, answer_content, answer_correct, QuestionA, QuestionB, QuestionC, QuestionD;
        Date createDate;
        QuestionDTO dto;
        String sql = null;

        if (search.equals("") && subject.equals("")) {
            sql = "With x As(Select ROW_NUMBER() Over (Order By createDate asc) as num,questionID, contentQuestion,createDate, subjectID , status ,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD  From Question Where status = ?) Select questionID, contentQuestion,createDate,subjectID,status,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD From x Where num between ?*?-(?-1) And ?*?";
        }
        if (status.equals("") && subject.equals("")) {
            sql = "With x As(Select ROW_NUMBER() Over (Order By createDate asc) as num,questionID, contentQuestion,createDate,subjectID,status,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD  From Question Where contentQuestion Like ?) Select questionID, contentQuestion,createDate,subjectID,status,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD From x Where num between ?*?-(?-1) And ?*?";
        }
        if (search.equals("") && status.equals("")) {
            sql = "With x As(Select ROW_NUMBER() Over (Order By createDate asc) as num,questionID, contentQuestion,createDate,subjectID,status,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD  From Question Where subjectID = ?) Select questionID, contentQuestion,createDate,subjectID,status,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD From x Where num between ?*?-(?-1) And ?*?";
        }
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            if (search.equals("") && subject.equals("")) {
                pr.setString(1, status);
                pr.setInt(2, index);
                pr.setInt(3, size);
                pr.setInt(4, size);
                pr.setInt(5, index);
                pr.setInt(6, size);
            }
            if (status.equals("") && subject.equals("")) {
                pr.setString(1, "%" + search + "%");
                pr.setInt(2, index);
                pr.setInt(3, size);
                pr.setInt(4, size);
                pr.setInt(5, index);
                pr.setInt(6, size);
            }
            if (search.equals("") && status.equals("")) {
                pr.setString(1, subject);
                pr.setInt(2, index);
                pr.setInt(3, size);
                pr.setInt(4, size);
                pr.setInt(5, index);
                pr.setInt(6, size);
            }
            rs = pr.executeQuery();
            ls = new ArrayList<>();
            while (rs.next()) {
                questionID = rs.getString("questionID");
                contentQuestion = rs.getString("contentQuestion");
                createDate = rs.getDate("createDate");
                subjectID = rs.getString("subjectID");
                status = rs.getString("status");
                answer_content = rs.getString("answer_content");
                answer_correct = rs.getString("answer_correct");
                QuestionA = rs.getString("QuestionA");
                QuestionB = rs.getString("QuestionB");
                QuestionC = rs.getString("QuestionC");
                QuestionD = rs.getString("QuestionD");
                dto = new QuestionDTO(questionID, contentQuestion, createDate, subjectID, status, answer_content, answer_correct, QuestionA, QuestionB, QuestionC, QuestionD);
                ls.add(dto);
            }
        } finally {
            closeConnection();
        }
        return ls;
    }
//

    public boolean insert(String questionID, String contentQuestion, Date CreateDate, String subjectID, String status, String answer_content, String answer_correct, String QuestionA, String QuestionB, String QuestionC, String QuestionD) throws Exception {
        String sql = "INSERT INTO Question(questionID, contentQuestion,createDate, subjectID , status ,answer_content,answer_correct,QuestionA,QuestionB,QuestionC,QuestionD)OUTPUT inserted.questionID VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareCall(sql);
            pr.setString(1, questionID);
            pr.setString(2, contentQuestion);
            pr.setTimestamp(3, new Timestamp(CreateDate.getTime()));
            pr.setString(4, subjectID);
            pr.setString(5, status);
            pr.setString(6, answer_content);
            pr.setString(7, answer_correct);
            pr.setString(8, QuestionA);
            pr.setString(9, QuestionB);
            pr.setString(10, QuestionC);
            pr.setString(11, QuestionD);

            return pr.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
    }

    public boolean edit(String QuestionID, String contentQuestion, String subjectID, String status, String answer_content, String answer_correct, String QuestionA, String QuestionB, String QuestionC, String QuestionD) throws Exception {
        String sql = "Update Question set contentQuestion = ?, subjectID = ?, status = ? ,answer_content = ? ,answer_correct = ?,QuestionA =? ,QuestionB =? ,QuestionC = ?, QuestionD =? where questionID = ?";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareCall(sql);
            pr.setString(10, QuestionID);
            pr.setString(1, contentQuestion);
            pr.setString(2, subjectID);
            pr.setString(3, status);
            pr.setString(4, answer_content);
            pr.setString(5, answer_correct);
            pr.setString(6, QuestionA);
            pr.setString(7, QuestionB);
            pr.setString(8, QuestionC);
            pr.setString(9, QuestionD);
            return pr.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
    }

    public boolean delete(String questionID) throws Exception {
        String sql = "Update Question set status ='deactive' where questionID = ?";
        boolean check = false;
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setString(1, questionID);

            check = pr.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<QuestionDTO> getAllQuestionBySubject1(String subjectID, int numberOfQuestion) throws Exception {
        List<QuestionDTO> result = null;
        QuestionDTO dto = null;
        String QuestionID, contentQuestion, QuestionA, QuestionB, QuestionC, QuestionD, correctAns;
//        String sql = "Select Q.QuestionID, Q.contentQuestion, Q.SubjectID, Q.status, Q.answer_content,Q.QuestionA,Q.QuestionB,Q.QuestionC,Q.QuestionD From Question Q Inner Join tbl_selectQuestion S On Q.questionID = S.questionID Where S.subjectID = ?";
        String sql = "Select top (?) Q.QuestionID, Q.contentQuestion, Q.SubjectID, Q.QuestionA,Q.QuestionB,Q.QuestionC,Q.QuestionD ,answer_content From Question Q where Q.subjectID= ? and status = 'active' ORDER BY NEWID()";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setString(2, subjectID);
            pr.setInt(1, numberOfQuestion);
            rs = pr.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                QuestionID = rs.getString("QuestionID");
                contentQuestion = rs.getString("contentQuestion");
                subjectID = rs.getString("SubjectID");
                 correctAns = rs.getString("answer_content");
                QuestionA = rs.getString("QuestionA");
                QuestionB = rs.getString("QuestionB");
                QuestionC = rs.getString("QuestionC");
                QuestionD = rs.getString("QuestionD");
               

                dto = new QuestionDTO(QuestionID, contentQuestion, subjectID,correctAns ,QuestionA, QuestionB, QuestionC, QuestionD);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
        

    public List<QuestionDTO> getAllQuestionBySubject(String subjectID) throws Exception {
        List<QuestionDTO> result = null;
        QuestionDTO dto = null;
        String QuestionID, contentQuestion, status, answer_content, QuestionA, QuestionB, QuestionC, QuestionD;
        String sql = "Select Q.QuestionID, Q.contentQuestion, Q.SubjectID, Q.status, Q.answer_content,Q.QuestionA,Q.QuestionB,Q.QuestionC,Q.QuestionD From Question Q Inner Join tbl_selectQuestion S On Q.questionID = S.questionID Where S.subjectID = ?";
//        String sql = "With x As(Select ROW_NUMBER() Over (Order By Q.questionID asc) as num, \n"
//                + "Q.questionID, Q.contentQuestion, Q.SubjectID, Q.status, Q.answer_content,Q.QuestionA,Q.QuestionB,Q.QuestionC,Q.QuestionD \n"
//                + "From Question Q Inner Join tbl_selectQuestion S On Q.questionID = S.questionID )\n"
//                + " Select questionID, contentQuestion, SubjectID,QuestionA,QuestionB,QuestionC,QuestionD From x Where num between ?*?-(?-1) And ?*?";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setString(1, subjectID);
            rs = pr.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                QuestionID = rs.getString("QuestionID");
                contentQuestion = rs.getString("contentQuestion");
                subjectID = rs.getString("SubjectID");
                status = rs.getString("status");
                answer_content = rs.getString("answer_content");
                QuestionA = rs.getString("QuestionA");
                QuestionB = rs.getString("QuestionB");
                QuestionC = rs.getString("QuestionC");
                QuestionD = rs.getString("QuestionD");

                dto = new QuestionDTO(QuestionID, contentQuestion, subjectID, status, answer_content, QuestionA, QuestionB, QuestionC, QuestionD);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
