/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdt.dto;

import java.io.Serializable;

/**
 *
 * @author MSI-PC
 */
public class LoginCreateError implements Serializable{
    private String usernameLengthErr;
    private String passordLengthErr;
    private String fullNameLengthErr;
    private String confirmNotMatched;
    private String usernameIsExisted;

    public LoginCreateError() {
    }

    public LoginCreateError(String usernameLengthErr, String passordLengthErr, String fullNameLengthErr, String confirmNotMatched, String usernameIsExisted) {
        this.usernameLengthErr = usernameLengthErr;
        this.passordLengthErr = passordLengthErr;
        this.fullNameLengthErr = fullNameLengthErr;
        this.confirmNotMatched = confirmNotMatched;
        this.usernameIsExisted = usernameIsExisted;
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPassordLengthErr() {
        return passordLengthErr;
    }

    public void setPassordLengthErr(String passordLengthErr) {
        this.passordLengthErr = passordLengthErr;
    }

    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    public String getConfirmNotMatched() {
        return confirmNotMatched;
    }

    public void setConfirmNotMatched(String confirmNotMatched) {
        this.confirmNotMatched = confirmNotMatched;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }
    
    
}

