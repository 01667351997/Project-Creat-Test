package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author binhminh
 */
public class IOSQL {
    public int numberSQL(String nameTable, int userID){
        int n = 0;
        try{
            Connection connec = MySQLConnUtils.getMySQLConnection(1);
            Statement stament = connec.createStatement();
            String  sql = "Select id from "+nameTable+" where userID = "+userID;
            ResultSet rs = stament.executeQuery(sql.toString().trim());
            while(rs.next()){
                n++;
                if(n!=rs.getInt(1)){
                    stament.close();
                    connec.close();
                    return n;
                }   
            }
            stament.close();
            connec.close();
        }catch(ClassNotFoundException e){
            e.getMessage();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return n+1;
    }
    
    
    public String readName(int ID){
        int check = 0;
        try{
            Connection connec = model.MySQLConnUtils.getMySQLConnection();
            Statement stament = connec.createStatement();
            String sql = "Select id, hovaten from InfoAccount";
            ResultSet result = stament.executeQuery(sql);
            while(result.next()){
                if(result.getInt(1)==ID){
                    return result.getString(2);
                }
                
            }
            result.close();
            stament.close();
            connec.close();
        }catch( ClassNotFoundException e){
            e.getMessage();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
