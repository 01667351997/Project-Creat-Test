/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author binhminh
 */
public class MySQLConnUtils {
    
    // Sua Lai userName va password cho phu hop voi mysql cua moi may
    private static final String hostName = "localhost";
    private static final String userName = "root";
    private static final String password = "123";
    
    
    //=============================================================================================
    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
        
        String dbName = "TaiKhoan";
 
        return getMySQLConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getMySQLConnection(int n) throws SQLException, ClassNotFoundException {
        
        String dbName = null;
        
        if(n==1){
            dbName = "Mon";
        }else{
            dbName = "MonToan";
        }

        return getMySQLConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getMySQLConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName+"?useUnicode=true&characterEncoding=UTF-8" ;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
