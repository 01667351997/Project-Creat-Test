package controller;

import information.CauHoi;
import information.TracNghiem;
import information.TuLuan;
import model.IOSQL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.regex.Pattern;
import model.IOTracNghiem;
import model.IOTuLuan;

/**
 *
 * @author binhminh
 */
public class ControlOperation {

    private final IOSQL iosql = new IOSQL(); // agregation
    public IOTuLuan ioTuLuan = new IOTuLuan();
    public final IOTracNghiem ioTracNghiem = new IOTracNghiem();
    private final String nameTableCTN = "CauTracNghiem";
    private final String nameTableCTL = "CauTuLuan";
    public String format = "[0-9]{1,2}";

    public ControlOperation() {
        //don't do anything
    }

    public int themCauTracNghiem(String tField1, String tArea3, String tField3, String tField4, String tField5, String tField6, String jCBox3, String jCBox2, int userID) {
        ArrayList list = new ArrayList();
        int check = 0; //kiem tra xem them co thanh cong 
        int number = 0;
        if (tField1.equals("") | tArea3.equals("") | tField3.equals("") | tField4.equals("") | tField5.equals("") | tField6.equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đủ thông tin", "NOTE", JOptionPane.ERROR_MESSAGE);
        } else if (Pattern.compile(format).matcher(tField1).matches() == false) {
            JOptionPane.showMessageDialog(null, "Bạn phải nhập số vào chương", "NOTE", JOptionPane.ERROR_MESSAGE);
        } else {
            list.add(tField1); // Chuong
            list.add(tArea3); // topic
            list.add(tField3);
            list.add(tField4);
            list.add(tField5);
            list.add(tField6);
            list.add(jCBox3);
            list.add(jCBox2);
            number = iosql.numberSQL(nameTableCTN, userID);
            check = ioTracNghiem.writeCauHoi(list, number, userID);
        }
        if (check != 0) {
            return number;
        }
        return check;
    }

    public int xoaCauTracNghiem(JTable table1, int userID) {
        int r = table1.getSelectedRow();
        int check = 0;
        if (r > -1) {
            check = ioTracNghiem.deleteCauHoi((int) table1.getValueAt(r, 0), userID);
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn 1 hàng để xóa", "NOTE", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    public int themCauTuLuan(String tField7, String tArea1, String tArea2, String jCBox5, int userID) {
        int check = 0;
        int number = 0;
        if ((tField7.equals("")) | (tArea1.equals("")) | (tArea2.equals(""))) {
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đủ thông tin", "NOTE", JOptionPane.ERROR_MESSAGE);
        } else if (Pattern.compile(format).matcher(tField7).matches() == false) {
            JOptionPane.showMessageDialog(null, "Bạn phải nhập số vào chương", "NOTE", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList list = new ArrayList();
            list.add(tField7); //chuong
            list.add(tArea1); //topic
            list.add(tArea2); // goi y
            list.add(jCBox5); //doKho
            number = iosql.numberSQL(nameTableCTL, userID);
            check = ioTuLuan.writeCauHoi(list, number, userID);
        }
        if (check != 0) {
            return number;
        }
        return check;
    }

    public int xoaCauTuLuan(JTable table2, int userID) {
        int r = table2.getSelectedRow();
        int check = 0;
        if (r > -1) {
            check = ioTuLuan.deleteCauHoi((int) table2.getValueAt(r, 0), userID);

        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn 1 hàng để xóa", "NOTE", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    public int suaCauTracNghiem(JTable table1, String tField1, String tArea3, String tField3, String tField4,
            String tField5, String tField6, String jCBox3, String jCBox2, int userID) {
        int r = table1.getSelectedRow();
        int check = 0;
        if (r > -1) {
            ArrayList list = new ArrayList();
            int number = 0;
            if (tField1.equals("") | tArea3.equals("") | tField3.equals("") | tField4.equals("") | tField5.equals("") | tField6.equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đủ thông tin", "NOTE", JOptionPane.ERROR_MESSAGE);
            } else if (Pattern.compile(format).matcher(tField1).matches() == false) {
                JOptionPane.showMessageDialog(null, "Bạn phải nhập số vào chương", "NOTE", JOptionPane.ERROR_MESSAGE);
            } else {
                list.add(tField1); // Chuong
                list.add(tArea3); // topic
                list.add(tField3);
                list.add(tField4);
                list.add(tField5);
                list.add(tField6);
                list.add(jCBox3);
                list.add(jCBox2);
                check = ioTracNghiem.deleteCauHoi((int) table1.getValueAt(r, 0), userID);
                check = ioTracNghiem.writeCauHoi(list, (int) table1.getValueAt(r, 0), userID);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn 1 hàng để sửa", "NOTE", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }
    public int suaCauTuLuan(JTable table, String tfChuong, String afTopic, String afGoiY, String cbDoKho, int userID){
        int r = table.getSelectedRow();
        int check = 0;
        if(r > -1){
            ArrayList list = new ArrayList();
            int number = 0;
            if (tfChuong.equals("") | afTopic.equals("") | afGoiY.equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đủ thông tin", "NOTE", JOptionPane.ERROR_MESSAGE);
            } else if (Pattern.compile(format).matcher(tfChuong).matches() == false) {
                JOptionPane.showMessageDialog(null, "Bạn phải nhập số vào chương", "NOTE", JOptionPane.ERROR_MESSAGE);
            } else {
                list.add(tfChuong);
                list.add(afTopic);
                list.add(afGoiY);
                list.add(cbDoKho);
                check = ioTuLuan.deleteCauHoi((int) table.getValueAt(r, 0), userID);
                check = ioTuLuan.writeCauHoi(list, (int) table.getValueAt(r, 0), userID);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Hãy chọn 1 hàng để sửa", "NOTE", JOptionPane.ERROR_MESSAGE);
        }
        
        return check;
    }

    public CauHoi hienThiCauHoi(JTable table, int userID, int flag) {
        int r = table.getSelectedRow();
        int id = (int) table.getValueAt(r, 0);
        
        if (flag == 1) {
            ArrayList<TracNghiem> list = new ArrayList<>();
            list = ioTracNghiem.readTapCauHoi();
            for (TracNghiem tn : list) {
                if (tn.getId() == id && (userID == tn.getUserID())) {
                    return tn;
                }
            }
        } else if (flag == 2) {
            ArrayList<TuLuan> list = new ArrayList<>();
            list = ioTuLuan.readTapCauHoi();
            for (TuLuan tl : list) {
                if (tl.getId() == id && (userID == tl.getUserID())) {
                    return tl;
                }
            }
        }
        return null;
    }
}
