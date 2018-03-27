

TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI
KHOA CÔNG NGHỆ THÔNG TIN



BÁO CÁO BÀI TẬP LỚN LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG 
ĐỀ TÀI 3: Xây dựng hệ thống tạo đề thi cho giáo viên












    2  II - Phân tích yêu cầu

Yêu cầu về câu hỏi:
    • Hệ thống có khả năng quản lý một ngân hàng câu hỏi gồm cả tự luận và trắc nghiệm
    • Mỗi câu hỏi tự luận gồm đề bài và gợi ý
    • Mỗi câu hỏi trắc nghiệm gồm đề bài, phương án và đáp án
    • Mỗi câu hỏi thuộc 1 môn học nhất định
    • Mỗi câu hỏi quy định độ khó nằm trong chương của môn học
Thao tác của giáo viên:
    • Đăng ký tài khoản
    • Thêm, sửa, xóa câu hỏi( cả tự luận và trắc nghiệm)
    • Đề thi có thể cả tự luận và trắc nghiệm hoặc riêng biệt
    • Sinh đề bằng tay bằng cách chọn các câu hỏi theo độ khó, chương
    • Sinh đề tự động theo độ khó và số lượng chọn trước
    • Đảo các thứ tự câu hỏi trong một đề
    • Xuất đề gồm các câu hỏi ra file word
 
    3 III - Giải quyết bài toán
3.1 Phân tích bài toán
            3.1.1 Sơ đồ Use Case
#
//===============================================================


#


        4.2 Các kỹ thuật sử dụng
            3.1.2 Lập trình cơ sở dữ liệu với JDBC 
+ Với MySQL cần Add JAR to Libraries  : 
	
+ Class Cần để kết nối MySQL:

public class MySQLConnUtils {
public static Connection getMySQLConnection() throws SQLException,   ClassNotFoundException {
		String hostName = "localhost";

		String dbName = "Student"; // thay đổi ứng với name database
		String userName = "root";
		String password = "aelitavio001"; // thay đổi ứng với mật khẩu

		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/"+dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName,password);
		return conn;
	}
}

+ Class truy vấn cơ bản với MySQL:

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	Connection connec =   MySQLConnUtils.getMySQLConnection();
	Statement stament = connec.createStatement();
	String sql = "Select Emp_Id, Emp_no, Emp_Name from EMPLOYEE";  
	ResultSet rs = stament.executeQuery(sql);
	while (rs.next()) {
	          int empId = rs.getInt(1);
	          String empNo = rs.getString(2);
	          String empName = rs.getString("Emp_Name");
	          System.out.println("--------------------");
	          System.out.println("EmpId: " + empId);
	          System.out.println("EmpNo: " + empNo);
	          System.out.println("EmpName: " + empName);
	}
	connec.close();
}
            3.1.3 Xuất dữ liệu ra file word
+ Add JAR to Libraries :
+ Class xuất dữ liệu: 
public static void main(String[] args) {

        try {

            //Bước 1: Khởi tạo đối tượng để sinh ra file word

            XWPFDocument document = new XWPFDocument();

            //Bước 2: Tạo tiêu đề bài viết

            XWPFParagraph titleGraph = document.createParagraph();

            titleGraph.setAlignment(ParagraphAlignment.CENTER);

            String title = "NGUYỄN BÌNH MINH";

            XWPFRun titleRun = titleGraph.createRun();

            titleRun.setBold(true);

            titleRun.setText(title);

           

            //Bước 3: Tạo đoạn văn bản 1 trong tài liệu

            XWPFParagraph para1 = document.createParagraph();

            para1.setAlignment(ParagraphAlignment.BOTH);                

            String dataPara1 = "Hello every one";

            XWPFRun para1Run = para1.createRun();             

            para1Run.setText(dataPara1);

 

            //Bước 4: Ghi dữ liệu ra file word

            FileOutputStream out = new FileOutputStream("src/taofileword/data.docx");

            document.write(out);

            out.close();

            document.close();

        } catch (IOException ex) {

            Logger.getLogger(TaoFileWord.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

            3.1.4 Random ngẫu nhiên không lặp
+ Dùng 1 Vector để kiểm tra mỗi số sau Random 

public class RandomNOLoop {

    	public static void main(String[] args) {
        		Random rd = new Random();
		//random 10 unique number
        		Vector v = new Vector();
        		int iNew = 0;
        		for (int i = 0; i < 10;  ) {
           			 iNew = rd.nextInt(100);
            			if (!v.contains(iNew)){
                			i++;
                			v.add(iNew);
                			System.out.println("Item " + (i) + ":" + iNew);
            			}
        		}
    	}
}

        3.2 Các design pattern đã áp dụng
            3.2.1 Sơ đồ lớp khái quát









            3.2.2 Mô hình MVC (Model – View – Controll)
//
            3.2.3 Kế thừa (Inheritance)
//
            3.2.4 Exception
//

    4 IV - Cài đặt, demo chương trình
        4.1 Cài đặt

        4.2 Demo chương trình
    5 V - Kết luận, đánh giá


//















