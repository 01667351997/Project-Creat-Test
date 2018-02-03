package controller;

import information.InfoAccount;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IOAccount;

/**
 *
 * @author binhminh
 */
public class ControlAccount {
    
    
    public int checkLogin(String userName, String passWord){
        int id = -1;
        try {    
            ArrayList<InfoAccount> accounts = new ArrayList<InfoAccount>();
            IOAccount ioAccount = new IOAccount();
            accounts = ioAccount.getInforAccount();
                 
            for(InfoAccount iAccount : accounts){
                if(userName.equals(iAccount.getUserName()) && passWord.equals(iAccount.getPassWord())){
                    id = iAccount.getId();
                    break;
                }      
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
    public int themAccount(String userName, String passWord, String role, String sdt, String hovaten, String khoa){
        int check =0;
        InfoAccount account = new InfoAccount();
        account.setUserName(userName);
        account.setPassWord(passWord);
        account.setRole(role);
        account.setSdt(sdt);
        account.setHovaten(hovaten);
        account.setKhoa(khoa);
        
        IOAccount ioAccount = new IOAccount();
        // Them cau hoi
        check = ioAccount.writeAccount(account);
        return check;
    }
    
    public int xoaAccount(int id){
        int check = 0;
        IOAccount ioAccount = new IOAccount();
        check = ioAccount.deleteAccount(id);
        return check;
    }
    
    public ArrayList getAccounts() {
        ArrayList accounts = new ArrayList();
        IOAccount ioAccount = new IOAccount();
        try {
            accounts = ioAccount.getInforAccount();
            
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return accounts;
    }
}
