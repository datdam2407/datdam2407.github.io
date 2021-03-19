/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdt.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author MSI-PC
 */
public class QuestionDTO implements Serializable{
    String questionID;
     String contentQuestion  , subjectID  , status , answercontent,answercorrect,QuestionA,QuestionB,QuestionC,QuestionD,Student;
    Date createDate;
  
    public QuestionDTO(String questionID, String contentQuestion, Date createDate, String subjectID, String status) {
        this.questionID = questionID;
        this.contentQuestion = contentQuestion;
        this.subjectID = subjectID;
        this.status = status;
        this.createDate = createDate;
    }

    public QuestionDTO(String questionID, String subjectID) {
        this.questionID = questionID;
        this.subjectID = subjectID;
    }
    
    public QuestionDTO(String questionID, String contentQuestion, Date createDate,String subjectID, String status, String answercontent, String answercorrect, String QuestionA, String QuestionB, String QuestionC, String QuestionD) {
        this.questionID = questionID;
        this.contentQuestion = contentQuestion;
        this.subjectID = subjectID;
        this.status = status;
        this.answercontent = answercontent;
        this.answercorrect = answercorrect;
        this.QuestionA = QuestionA;
        this.QuestionB = QuestionB;
        this.QuestionC = QuestionC;
        this.QuestionD = QuestionD;
        this.createDate = createDate;
    }
    public QuestionDTO(String questionID, String contentQuestion, Date createDate,String subjectID,String answercontent, String answercorrect, String QuestionA, String QuestionB, String QuestionC, String QuestionD) {
        this.questionID = questionID;
        this.contentQuestion = contentQuestion;
        this.subjectID = subjectID;
        this.answercontent = answercontent;
        this.answercorrect = answercorrect;
        this.QuestionA = QuestionA;
        this.QuestionB = QuestionB;
        this.QuestionC = QuestionC;
        this.QuestionD = QuestionD;
        this.createDate = createDate;
    }

    public QuestionDTO(String questionID, String contentQuestion, String subjectID, String status, String answercontent, String QuestionA, String QuestionB, String QuestionC, String QuestionD) {
        this.questionID = questionID;
        this.contentQuestion = contentQuestion;
        this.subjectID = subjectID;
        this.status = status;
        this.answercontent = answercontent;
        this.QuestionA = QuestionA;
        this.QuestionB = QuestionB;
        this.QuestionC = QuestionC;
        this.QuestionD = QuestionD;
    }

    public QuestionDTO(String questionID, String contentQuestion, String subjectID, String QuestionA, String QuestionB, String QuestionC, String QuestionD) {
        this.questionID = questionID;
        this.contentQuestion = contentQuestion;
        this.subjectID = subjectID;
        this.QuestionA = QuestionA;
        this.QuestionB = QuestionB;
        this.QuestionC = QuestionC;
        this.QuestionD = QuestionD;
    }

    public QuestionDTO(String questionID, String contentQuestion, String subjectID, String answercontent, String QuestionA, String QuestionB, String QuestionC, String QuestionD) {
        this.questionID = questionID;
        this.contentQuestion = contentQuestion;
        this.subjectID = subjectID;
        this.answercontent = answercontent;
        this.QuestionA = QuestionA;
        this.QuestionB = QuestionB;
        this.QuestionC = QuestionC;
        this.QuestionD = QuestionD;
    }

    

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getContentQuestion() {
        return contentQuestion;
    }

    public String getAnswercontent() {
        return answercontent;
    }

    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent;
    }

    public String getAnswercorrect() {
        return answercorrect;
    }

    public void setAnswercorrect(String answercorrect) {
        this.answercorrect = answercorrect;
    }

    public String getQuestionA() {
        return QuestionA;
    }

    public void setQuestionA(String QuestionA) {
        this.QuestionA = QuestionA;
    }

    public String getQuestionB() {
        return QuestionB;
    }

    public void setQuestionB(String QuestionB) {
        this.QuestionB = QuestionB;
    }

    public String getQuestionC() {
        return QuestionC;
    }

    public void setQuestionC(String QuestionC) {
        this.QuestionC = QuestionC;
    }

    public String getQuestionD() {
        return QuestionD;
    }

    public void setQuestionD(String QuestionD) {
        this.QuestionD = QuestionD;
    }
    
    public void setContentQuestion(String contentQuestion) {
        this.contentQuestion = contentQuestion;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
     public String toLowerCase() {
        return questionID.toLowerCase();
    }

    public String toUpperCase() {
        return questionID.toUpperCase();
    }

    public String getStudent() {
        return Student;
    }

    public void setStudent(String Student) {
        this.Student = Student;
    }

   
    
}
