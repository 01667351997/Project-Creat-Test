package controller;

import information.CauHoi;
import information.TracNghiem;
import information.TuLuan;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.IODatabase;
import model.IOSQL;
import model.IOTracNghiem;
import model.IOTuLuan;
import model.SinhDe;
import model.SinhDeTLVaTN;
import model.SinhDeTracNghiem;
import model.SinhDeTuLuan;

/**
 *
 * @author binhminh
 */
public class ControlCreateTest {
    
    private final IOSQL iosql = new IOSQL();
    public IOTuLuan ioTuLuan = new IOTuLuan();
    public IOTracNghiem iOTracNghiem =  new IOTracNghiem();
    
    //tinh da hinh vi cau trac nghiem va tu luan deu ke thua tu lop cau hoi
    public CauHoi hienThiCauHoi(int id, int uid,int flag){
        
        if (flag == 1) {
            ArrayList<TracNghiem> list = new ArrayList<>();
            list = iOTracNghiem.readTapCauHoi();
            for (TracNghiem tn : list) {
                if (tn.getId()==id && tn.getUserID()==uid) {
                    return tn;
                }
            }
        }else if(flag==2){
            ArrayList<TuLuan> list = new ArrayList<>();
            list = ioTuLuan.readTapCauHoi();
            for (TuLuan tl : list) {
                if (tl.getUserID()==uid && tl.getId()==id ) {
                    return tl;
                }
            }
        }
        return null;
    }
    public String showName(int uid) {
        return iosql.readName(uid);
    }
    public boolean createTestTuLuan(JTable table3){
        ArrayList<TuLuan> listAll = new ArrayList<>();
        listAll = ioTuLuan.readTapCauHoi();
        ArrayList<TuLuan> listTest = new ArrayList<>();
        for(int i=0;i<table3.getRowCount();i++){
            for(TuLuan tl : listAll){
                if(table3.getValueAt(i, 1).equals(tl.getId()) && table3.getValueAt(i, 2).equals(tl.getUserID())){
                    listTest.add(tl);
                }
            }
        }
        
        SinhDeTuLuan sinhDe = new SinhDeTuLuan();
        sinhDe.taoTieuDe();
        sinhDe.sinhDeTL(listTest);
        
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn mở đề bây giờ?", "Thành Công", JOptionPane.YES_NO_OPTION) == 0) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("src/test/data.docx");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        }
        return true;
    }
    public boolean createTestTracNghiem(JTable table4){
        
        ArrayList<TracNghiem> listAll = new ArrayList<>();
        listAll = iOTracNghiem.readTapCauHoi();
        ArrayList<TracNghiem> listTest = new ArrayList<>();
        for(int i=0;i<table4.getRowCount();i++){
            for(TracNghiem tn : listAll){
                if(table4.getValueAt(i, 1).equals(tn.getId()) && table4.getValueAt(i, 2).equals(tn.getUserID())){
                    listTest.add(tn);
                }
            }
        }
    
        SinhDeTracNghiem sinhDe = new SinhDeTracNghiem();
        sinhDe.taoTieuDe();
        sinhDe.sinhDeTN(listTest);
        
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn mở đề bây giờ?", "Thành Công", JOptionPane.YES_NO_OPTION) == 0) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("src/test/data.docx");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        }
        return true;
    }
    public boolean sinhDeTuLuanVaTracNghiem(JTable table3, JTable table4){
        ArrayList<TuLuan> listAlltl = new ArrayList<>();
        listAlltl = ioTuLuan.readTapCauHoi();
        ArrayList<TuLuan> listTesttl = new ArrayList<>();
        for(int i=0;i<table3.getRowCount();i++){
            for(TuLuan tl : listAlltl){
                if(table3.getValueAt(i, 1).equals(tl.getId()) && table3.getValueAt(i, 2).equals(tl.getUserID())){
                    listTesttl.add(tl);
                }
            }
        }
        ArrayList<TracNghiem> listAll = new ArrayList<>();
        listAll = iOTracNghiem.readTapCauHoi();
        ArrayList<TracNghiem> listTest = new ArrayList<>();
        for(int i=0;i<table4.getRowCount();i++){
            for(TracNghiem tn : listAll){
                if(table4.getValueAt(i, 1).equals(tn.getId()) && table4.getValueAt(i, 2).equals(tn.getUserID())){
                    listTest.add(tn);
                }
            }
        }
        
        SinhDeTLVaTN sinhDe = new SinhDeTLVaTN();
        sinhDe.taoTieuDe();
        sinhDe.sinhDeTLVaTN(listTest, listTesttl);
        
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn mở đề bây giờ?", "Thành Công", JOptionPane.YES_NO_OPTION) == 0) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("src/test/data.docx");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        }
        return true;
    }
}
