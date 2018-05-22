package model;

import information.TuLuan;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author binhminh
 */
public class SinhDeTuLuan extends SinhDe{

    @Override
    public boolean sinhDeTL(ArrayList<TuLuan> listTest) {
        // Tao tieu de cho bai kiem tra
        //XWPFDocument document = taoTieuDe();
        
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
           // Tao goi y
           XWPFParagraph para2 = document.createParagraph();
           para2.setAlignment(ParagraphAlignment.LEFT);
           
           String dataPara2 = "Gợi ý: "; 
                  dataPara2 += listTest.get(i).getGoiY();
           XWPFRun pararun2 = para2.createRun();
           pararun2.setText(dataPara2);
        }
        
        
        // Tao cuoi trang
        taoCuoiTrang(document);

        //Bước 4: Ghi dữ liệu ra file word
        FileOutputStream out;
        try {
            out = new FileOutputStream("src/test/data.docx");
            
            document.write(out);

            out.close();

            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinhDeTuLuan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SinhDeTuLuan.class.getName()).log(Level.SEVERE, null, ex);
        }

        

        return true;
    }
    
}
