/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdt.dao;

import datdt.dto.SubjectDTO;
import datdt.ult.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MSI-PC
 */
public class SubjectDAO implements Serializable{
     private Connection con;
    private PreparedStatement pr;
    private ResultSet rs;

    public SubjectDAO() {
    }

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

    public List<SubjectDTO> getAllSubject() throws Exception {
        List<SubjectDTO> rss;
        SubjectDTO dto;
        String id, name;
        int Remain;
        boolean status;
        Date starting;
        String sql = "Select subjectID, subjectname, status,starting,Remain From tbl_Subject";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            rss = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("subjectID");
                name = rs.getString("subjectname");
                status = rs.getBoolean("status");
                starting = rs.getDate("starting");
                Remain = rs.getInt("Remain");
                dto = new SubjectDTO(id, name, status, starting, Remain);
                rss.add(dto);
            }
        } finally {
            closeConnection();
        }
        return rss;
    }
     public SubjectDTO getSubjectbysubID(String subjectID) throws Exception {
        SubjectDTO dto = null;
        String name;
        int Remain;
        boolean status;
        Date starting;
        String sql = "Select subjectname, status,starting,Remain From tbl_Subject where subjectID = ?";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setString(1, subjectID);
            rs = pr.executeQuery();
            while (rs.next()) {
                name = rs.getString("subjectname");
                status = rs.getBoolean("status");
                starting = rs.getDate("starting");
                Remain = rs.getInt("Remain");
                dto = new SubjectDTO(name, status, starting, Remain);
            }
        } finally {
            closeConnection();
        }
         return dto;
        
    }

    public String getID(String name) throws Exception {
        String sql = "Select subjectID From tbl_Subject Where subjectname = ?";
        try {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setString(1, name);
            rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getString("subjectID");
            }
        } finally {
            closeConnection();
        }
        return "";
    }
    public List<SubjectDTO> getAllSubjectByUsername(String email) throws Exception
    {
        List<SubjectDTO> result = null;
        SubjectDTO dto = null;
        String subjectID, subjectname;
        int Remain;
        Date starting;
       
        String sql = "Select S.subjectID, S.subjectname,S.starting, S.Remain from tbl_RegisterSubject R INNER JOIN tbl_Subject S ON R.subjectID = S.subjectID WHERE R.email = ? ";
        try
        {
            con = DBHelper.makeConnection();
            pr = con.prepareStatement(sql);
            pr.setString(1, email);
            rs = pr.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) 
            {                
                subjectID = rs.getString("subjectID");
                subjectname = rs.getString("subjectname");
                starting = rs.getDate("starting");
                Remain = rs.getInt("Remain");
                dto = new SubjectDTO(subjectID, subjectname, starting, Remain);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }
}

