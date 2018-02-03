package model;

import information.TuLuan;
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
public class IOTuLuanImpl implements IIODatabase{

    @Override
    public ArrayList<TuLuan> readTapCauHoi() {
        ArrayList<TuLuan> l = new ArrayList<>();
        try{
            Connection connec = MySQLConnUtils.getMySQLConnection(1);
            Statement stament = connec.createStatement();
            String sql = "Select id, chuong, deBai, goiY, dokho, userID from CauTuLuan";
            ResultSet rs = stament.executeQuery(sql);
            while(rs.next()){
                TuLuan tl = new TuLuan();
                tl.setId(rs.getInt(1));
                tl.setChuong(rs.getInt(2));
                tl.setDeBai(rs.getString(3));
                tl.setGoiY(rs.getString(4));
                tl.setDoKho(rs.getString(5));
                tl.setUserID(rs.getInt(6));
                l.add(tl);
            }
            stament.close();
            connec.close();
        }catch(ClassNotFoundException e){
            e.getMessage();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public int writeCauHoi(ArrayList l, int number, int userID) {
        int check = 0;
        try{
            Connection connec = model.MySQLConnUtils.getMySQLConnection(1);
            String sql = "Insert into CauTuLuan value (?,?,?,?,?,?)";
            PreparedStatement stament = connec.prepareStatement(sql);
            stament.setInt(1, number);
            stament.setString(2, (String) l.get(0));
            stament.setString(3, (String) l.get(1));
            stament.setString(4, (String) l.get(2));
            stament.setString(5, (String) l.get(3));
            stament.setInt(6, userID);
            check = stament.executeUpdate();
            stament.close();
            connec.close();
        }catch(ClassNotFoundException e){
            e.getMessage();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int deleteCauHoi(int id, int userID) {
        int check = 0;
        try{
            Connection connec = model.MySQLConnUtils.getMySQLConnection(1);
            String sql = "Delete From CauTuLuan where id = ? AND userID = ?";
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
