/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdt.dao;

import datdt.dto.LoginDTO;
import datdt.ult.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author MSI-PC
 */
public class LoginDAO {
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

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        String sql = "Select role from tbl_account where email = ? AND password = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
                
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
            rs = pr.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }
     


 private List<LoginDTO> accountList;

    public List<LoginDTO> getAccountList() {
        return accountList;
    }

     
     public boolean  createAccount(String email, String name, String password, String role, String status) throws NamingException, SQLException, Exception{
        PreparedStatement ps = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            //2. creat SQL String
            if (con != null) {
                String sql = "Insert Into tbl_account(email, name, password, role ,status) "
                        +"Values(?,?,?,?,?)";
                //3. Creat Statement
                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, name);
                ps.setString(3, password);
                ps.setString(4, role);
                ps.setString(5, status);
                //4. Execute Query
                int row = ps.executeUpdate();
                if(row > 0) {
                    return true;
                }
            }//end if connection is connected
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}

