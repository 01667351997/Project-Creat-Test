package model;

import java.util.ArrayList;

/**
 *
 * @author binhminh
 */
public interface IIODatabase {
    
    // Lay 1 tap cac cau hoi
    public ArrayList readTapCauHoi();
    
    // Them 1 cau hoi
    public int writeCauHoi(ArrayList l,int number, int userID);
    
    // Xoa 1 cau hoi
    public int deleteCauHoi(int id,int userID);
}
