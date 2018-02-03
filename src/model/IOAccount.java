package model;

import information.InfoAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author binhminh
 */
public class IOAccount {

    public ArrayList<InfoAccount> getInforAccount() throws SQLException, ClassNotFoundException {
        ArrayList accounts = new ArrayList<InfoAccount>();
        Connection connec = model.MySQLConnUtils.getMySQLConnection();
        Statement stament = connec.createStatement();
        String sql = "Select * from InfoAccount";
        ResultSet rs = stament.executeQuery(sql);
        InfoAccount iAccount;
        while (rs.next()) {
            iAccount = new InfoAccount();
            iAccount.setId(rs.getInt(1));
            iAccount.setUserName(rs.getString(2));
            iAccount.setPassWord(rs.getString(3));
            iAccount.setRole(rs.getString(4));
            iAccount.setSdt(rs.getString(5));
            iAccount.setHovaten(rs.getString(6));
            iAccount.setKhoa(rs.getString(7));
            accounts.add(iAccount);
        }
        connec.close();
        return accounts;
    }

    public int writeAccount(InfoAccount account) {
        int kt = 0;
        Connection connec = null;
        PreparedStatement stament = null;
        try {
            connec = MySQLConnUtils.getMySQLConnection();
            //Statement stament = connec.createStatement();
            String sql = "insert into InfoAccount values (?,?,?,?,?,?,?)";
            stament = connec.prepareStatement(sql);
            stament.setString(1, String.valueOf(account.getId()));
            stament.setString(2, account.getUserName());
            stament.setString(3, account.getPassWord());
            stament.setString(4, account.getRole());
            stament.setString(5, account.getSdt());
            stament.setString(6, account.getHovaten());
            stament.setString(7, account.getKhoa());
            // Kiem tra xem dang ki thanh cong hay chua
            kt = stament.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                stament.close();
                connec.close();
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }

        return kt;
    }
    
    
    public int deleteAccount(int id){
        int kt = 0;
        Connection connec = null;
        PreparedStatement stament = null;
        try {
            connec = MySQLConnUtils.getMySQLConnection();
            //Statement stament = connec.createStatement();
            String sql = "delete From InfoAccount where id = ?";
            stament = connec.prepareStatement(sql);
            stament.setInt(1, id);
            // Kiem tra xem Xoa thanh cong hay chua
            kt = stament.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                stament.close();
                connec.close();
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }

        return kt;
    }
    
}
