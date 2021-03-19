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
public class RegisterDTO implements Serializable {

    String ResultID;
    String subjectID;
    float point;
    Date date;
    String email;

    public RegisterDTO(String ResultID, String subjectID, float point, Date date, String email) {
        this.ResultID = ResultID;
        this.subjectID = subjectID;
        this.point = point;
        this.date = date;
        this.email = email;
    }

    public RegisterDTO(String ResultID, String subjectID, float point, Date date) {
        this.ResultID = ResultID;
        this.subjectID = subjectID;
        this.point = point;
        this.date = date;
    }

    public RegisterDTO(String ResultID, float point, Date date) {
        this.ResultID = ResultID;
        this.point = point;
        this.date = date;
    }

    public String getResultID() {
        return ResultID;
    }

    public void setResultID(String ResultID) {
        this.ResultID = ResultID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
