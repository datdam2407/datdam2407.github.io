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
public class SubjectDTO implements Serializable{
    String subjectID, subjectname;
    boolean status;
    Date starting;
    int remain;
    int QuizQuestion = 10;
    
    public SubjectDTO(String subjectID, String subjectname, boolean status) {
        this.subjectID = subjectID;
        this.subjectname = subjectname;
        this.status = status;
    }

    public SubjectDTO(String subjectID, String subjectname, boolean status, Date starting, int remain) {
        this.subjectID = subjectID;
        this.subjectname = subjectname;
        this.status = status;
        this.starting = starting;
        this.remain = remain;
    }
    
    public SubjectDTO(String subjectID, String subjectname) {
        this.subjectID = subjectID;
        this.subjectname = subjectname;
    }

    public SubjectDTO(String subjectID, String subjectname, Date starting, int remain) {
        this.subjectID = subjectID;
        this.subjectname = subjectname;
        this.starting = starting;
        this.remain = remain;
    }

    public SubjectDTO(String subjectname, boolean status, Date starting, int remain) {
        this.subjectname = subjectname;
        this.starting = starting;
        this.status = status;

        this.remain = remain;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }
    

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuizQuestion() {
        return QuizQuestion;
    }

    public void setQuizQuestion(int QuizQuestion) {
        this.QuizQuestion = 10;
    }
    
}
