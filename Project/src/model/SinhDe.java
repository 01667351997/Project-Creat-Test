package model;

import information.TracNghiem;
import information.TuLuan;
import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author binhminh
 */
public abstract class SinhDe {
    //Bước 1: Khởi tạo đối tượng để sinh ra file word
    protected XWPFDocument document = new XWPFDocument();
    
    public XWPFDocument taoTieuDe(){
        

        //Bước 2: Tạo tiêu đề bài viết
        XWPFParagraph titleGraph = document.createParagraph();

        titleGraph.setAlignment(ParagraphAlignment.CENTER);

        String title = "ĐỀ KIỂM TRA";

        XWPFRun titleRun = titleGraph.createRun();

        titleRun.setBold(true);

        titleRun.setText(title);

        XWPFParagraph para1 = document.createParagraph();
        para1.setAlignment(ParagraphAlignment.CENTER);
        String dataPara1 = "Không sử dụng tài liệu dưới mọi hình thức \n";
        dataPara1 += "---------------------------------------------------------";
        XWPFRun para0Run = para1.createRun();
        para0Run.setText(dataPara1);
        
        // Tao khoang trong giua 2 doan
        XWPFParagraph paraBreak0 = document.createParagraph();
        XWPFRun paraBreak0Run = paraBreak0.createRun();
        paraBreak0Run.addBreak();
        return document;
    }
    protected void taoCuoiTrang(XWPFDocument document){
        // Tao khoang trong giua 2 doan
        XWPFParagraph paraBreak0 = document.createParagraph();
        XWPFRun paraBreak0Run = paraBreak0.createRun();
        paraBreak0Run.addBreak();

        // Tao thong bao
        XWPFParagraph para3 = document.createParagraph();
        para3.setAlignment(ParagraphAlignment.CENTER);

        String dataPara3 = "-------------Hết-------------";

        XWPFRun para3Run = para3.createRun();
        para3Run.setText(dataPara3);
    }
    
    public boolean sinhDeTN(ArrayList<TracNghiem> listTest){
        return false;
    }
    
    public boolean sinhDeTL (ArrayList<TuLuan> listTest){
        return false;
    }
    public boolean sinhDeTLVaTN (ArrayList<TracNghiem> listTest,ArrayList<TuLuan> listTest1){
        return false;
    }
}
