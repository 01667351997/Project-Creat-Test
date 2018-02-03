package model;

import information.TracNghiem;
import information.TuLuan;
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
public class SinhDeTLVaTN extends SinhDe{
    
    @Override
    public boolean sinhDeTLVaTN(ArrayList<TracNghiem> listTest, ArrayList<TuLuan> listTest1){
        
        XWPFParagraph doan = document.createParagraph();
        String phan = "I. Phần Trắc Nghiệm ";
        XWPFRun doanrun = doan.createRun();
        doanrun.setBold(true);
        doanrun.setText(phan);
        
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
        
        XWPFParagraph doan1 = document.createParagraph();
        String phan1 = "II. Phần Tự Luận ";
        XWPFRun doanrun1 = doan1.createRun();
        doanrun1.setBold(true);
        doanrun1.setText(phan1);
           
        for(int i = 0; i <listTest1.size();i ++){
            // tao cau
           XWPFParagraph para = document.createParagraph();
           String cau = "Câu "+(i+1)+": ";
           XWPFRun pararun = para.createRun();
           pararun.setBold(true);
           pararun.setText(cau);
           // Tao de bai
           XWPFParagraph para1 = document.createParagraph();
           para1.setAlignment(ParagraphAlignment.LEFT);
           String dataPara1 = listTest1.get(i).getDeBai();
           XWPFRun pararun1 = para1.createRun();
           pararun1.setText(dataPara1);
           // Tao goi y
           XWPFParagraph para2 = document.createParagraph();
           para2.setAlignment(ParagraphAlignment.LEFT);
           
           String dataPara2 = "Gợi ý: "; 
                  dataPara2 += listTest1.get(i).getGoiY();
           XWPFRun pararun2 = para2.createRun();
           pararun2.setText(dataPara2);
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
