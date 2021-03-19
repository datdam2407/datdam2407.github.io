/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdt.dao;

import datdt.dto.RegisterDTO;
import datdt.ult.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author MSI-PC
 */
public class RegisteredSubjectDetailDAO implements Serializable{
    private Connection conn;
    private PreparedStatement pr;
    private ResultSet rs;

    public RegisteredSubjectDetailDAO() {
    }
    
    private void closeConnection() throws Exception
    {
        if(rs != null)
            rs.close();
        if(pr != null)
            pr.close();
        if(conn != null)
            conn.close();
    }
    
    public boolean createRegisteredSubjectDetails(String RegisterSubID, float point, String subjectID, Date date,String email)throws SQLException, ClassNotFoundException, NamingException, Exception{
    {
        boolean check = false;
        try 
        {
            String sql = "Insert Into tbl_RegisterSubjectdetail(ResultID, point,subjectID,date,email) Values(?,?,?,?,?)";
            conn = DBHelper.makeConnection();
            pr = conn.prepareStatement(sql);
            pr.setString(1, RegisterSubID);
            pr.setFloat(2, point);
            pr.setString(3, subjectID);
            pr.setTimestamp(4, new Timestamp(date.getTime()));
 pr.setString(5, email);

            check = pr.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    }
     public void getAllHistoryByEmail(String email) throws SQLException, Exception{
       
        List<RegisterDTO> ls = new ArrayList<>();
        
        try {
            String sql = "select ResultID, subjectID, point, date"
                    + "from tbl_RegisterSubjectdetail "
                    + "where email = ?";
            conn = DBHelper.makeConnection();
            pr= conn.prepareStatement(sql);
            pr.setString(1, email);
            rs = pr.executeQuery();
            while(rs.next()){
                String id = rs.getString("ResultID");
                String subjectID = rs.getString("subjectID");
                float point = rs.getFloat("point");
                Date date = rs.getDate("date");
                
                RegisterDTO rDTO = new RegisterDTO(subjectID, subjectID, point, date);
                ls.add(rDTO);
            }
        } finally {
           closeConnection();
        }
    }
      public List<RegisterDTO> getOder(String subjectID) throws Exception {
        String ResultID;
        float point;
        Date date;
        
        List<RegisterDTO> ls = new ArrayList<>();
        try {
            String sql = " Select  ResultID, point, date from tbl_RegisterSubjectdetail where subjectID = ?";
   
            conn = DBHelper.makeConnection();
            pr = conn.prepareStatement(sql);
            pr.setString(1, subjectID);
            rs = pr.executeQuery();
            while (rs.next()){
                ResultID = rs.getString("ResultID");
                point = rs.getFloat("point");
                date = rs.getDate("date");
                RegisterDTO rDTO = new RegisterDTO(ResultID, point, date);
                ls.add(rDTO);
            }
         
        } finally {
            closeConnection();
        }
        return ls;
    }
       public String getLastResultID(String email) 
            throws Exception{
      
        String id = null;
        try {
            String sql = "select ResultID from tbl_RegisterSubjectdetail where email = ? order by ResultID desc";
            conn = DBHelper.makeConnection();
            pr = conn.prepareStatement(sql);
            pr.setString(1, email);
            rs = pr.executeQuery();
            if(rs.next()){
                id = rs.getString("resultID");
            }
        }finally{
            closeConnection();
        }
        return id;
    }
    
}

