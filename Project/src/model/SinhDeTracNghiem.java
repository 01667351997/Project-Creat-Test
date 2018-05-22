/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import information.TracNghiem;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/**
 *
 * @author binhminh
 */
public class SinhDeTracNghiem extends SinhDe{

    @Override
    public boolean sinhDeTN(ArrayList<TracNghiem> listTest){
        
        // Tao tieu de cho bai kiem tra
        
        for(int i = 0; i <listTest.size();i ++){
            // tao cau
           XWPFParagraph para = document.createParagraph();
           String cau = "Câu "+(i+1)+": ";
           XWPFRun pararun = para.createRun();
           pararun.setBold(true);
           pararun.setText(cau);
           // Tao de bai
           XWPFParagraph para1 = document.createParagraph();
           para1.setAlignment(ParagraphAlignment.LEFT);
           String dataPara1 = listTest.get(i).getDeBai();
           XWPFRun pararun1 = para1.createRun();
           pararun1.setText(dataPara1);
           // Phuong an
            for (int j = 1; j <= 4; j++) {
                XWPFParagraph para2 = document.createParagraph();
                para2.setAlignment(ParagraphAlignment.BOTH);
                String dataPara2 = null;
               switch (j) {
                   case 1:
                       dataPara2 = "A. ";
                       dataPara2 += listTest.get(i).getA();
                       break;
                   case 2:
                       dataPara2 = "B. ";
                       dataPara2 += listTest.get(i).getB();
                       break;
                   case 3:
                       dataPara2 = "C. ";
                       dataPara2 += listTest.get(i).getC();
                       break;
                   default:
                       dataPara2 = "D. ";
                       dataPara2 += listTest.get(i).getD();
                       break;
               }
                
                XWPFRun pararun2 = para2.createRun();
                pararun2.setText(dataPara2);
            }
           
        }
        
        // Tao cuoi trang
        taoCuoiTrang(document);

        //Bước 4: Ghi dữ liệu ra file word
        

        try {
            FileOutputStream out = new FileOutputStream("src/test/data.docx");

            document.write(out);
            
            out.close();
            
            document.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        

        return true;
    }

    
    
}
