/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import information.TracNghiem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binhminh
 */
public class IOTracNghiem implements IODatabase{

    @Override
    public ArrayList<TracNghiem> readTapCauHoi() {
        ArrayList<TracNghiem> l = new ArrayList<>();
        try {
            Connection connec = MySQLConnUtils.getMySQLConnection(1);
            Statement stament = connec.createStatement();
            String sql = "Select id, chuong, debai, a,b,c,d, dapan, dokho, userID from CauTracNghiem";
            ResultSet rs = stament.executeQuery(sql);
            while(rs.next()){
                TracNghiem tn = new TracNghiem();
                tn.setId(rs.getInt(1)); //0
                tn.setChuong(rs.getInt(2));
                tn.setDeBai(rs.getString(3));
                tn.setA(rs.getString(4));
                tn.setB(rs.getString(5));
                tn.setC(rs.getString(6));
                tn.setD(rs.getString(7));
                tn.setDapAn(rs.getString(8));
                tn.setDoKho(rs.getString(9));
                tn.setUserID(rs.getInt(10)); 
                l.add(tn);
            }
            
            connec.close();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public int writeCauHoi(ArrayList l, int number, int userID) {
        int check = 0;
        try {
            Connection connec = model.MySQLConnUtils.getMySQLConnection(1);
            String sql = "Insert into CauTracNghiem value (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stament = connec.prepareStatement(sql);
            stament.setInt(1, number);
            stament.setString(2, (String) l.get(0));
            stament.setString(3, (String) l.get(1));
            stament.setString(4, (String) l.get(2));
            stament.setString(5, (String) l.get(3));
            stament.setString(6, (String) l.get(4));
            stament.setString(7, (String) l.get(5));
            stament.setString(8, (String) l.get(6));
            stament.setString(9, (String) l.get(7));
            stament.setInt(10, userID);
            check = stament.executeUpdate();
            stament.close();
            connec.close();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int deleteCauHoi(int id, int userID) {
        int check = 0;
        try{
            Connection connec = model.MySQLConnUtils.getMySQLConnection(1);
            String sql = "Delete From CauTracNghiem where id = ? AND userID = ?";
            PreparedStatement stament = connec.prepareStatement(sql);
            stament.setInt(1, id);
            stament.setInt(2, userID);
            check = stament.executeUpdate();
            stament.close();
            connec.close();
        }catch(ClassNotFoundException e){
            e.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(IOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
}
