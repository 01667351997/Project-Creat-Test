-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: Mon
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CauTracNghiem`
--

DROP TABLE IF EXISTS `CauTracNghiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CauTracNghiem` (
  `id` int(11) NOT NULL,
  `chuong` int(11) NOT NULL,
  `deBai` varchar(500) NOT NULL,
  `A` varchar(200) NOT NULL,
  `B` varchar(200) NOT NULL,
  `C` varchar(200) NOT NULL,
  `D` varchar(200) NOT NULL,
  `dapAn` varchar(10) NOT NULL,
  `doKho` varchar(30) NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`id`,`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CauTracNghiem`
--

LOCK TABLES `CauTracNghiem` WRITE;
/*!40000 ALTER TABLE `CauTracNghiem` DISABLE KEYS */;
INSERT INTO `CauTracNghiem` VALUES (1,1,'Hệ thống các chương trình đảm nhận chức năng làm môi trường trung gian giữa người sử dụng và  phần cứng của máy tính được gọi là?','Phần cứng','Hệ điều hành','Các loại trình dịch trung gian','Tất cả đều đúng','B','easy',3),(2,1,'Kết quả của biểu thức 2*3+4/2 > 3 && 3<5 || 10<9 sẽ bằng?','0','1','Không có kết quả nào ở trên','Biểu thức viết sai, không tính được kết quả','B','easy',3),(3,1,'Cho các số nguyên không dấu A = FA(16), B = 153(8), C = 200(10)\nHãy sắp xếp A, B, C theo thứ tự tăng dần','A, B, C','B, C, A','A, C, B','B, A, C','B','easy',3),(4,1,'Trong các mạng LAN, WAN, MAN, GAN mạng nào có quy mô lớn nhất?','LAN (Local Area Network)','WAN(Wide Area Network)','GAN(Global Area Network)','MAN(Metropolitan Area Network)','C','easy',3),(5,1,'Điền dòng lệnh thích hợp vào dấu (…) trong đoạn chương trình sau để thực hiện thao tác kiểm tra xem người dùng đã nhập đúng giá trị là số nguyên dương nhỏ hơn 10 hay chưa, nếu chưa yêu cầu nhập cho đến khi nào đúng thì thôi.\nvoid main(){\n	int n;\n	do{\n	printf(“Nhap vao mot so nguyen duong nho hon 10”);\n	scanf(“%d”,&n);\n	}….;\n}','while (n<10)','while (n<10 & n>=0)','while (n<=0 || n>=10)','while (n>=0 || n<=10)','B','easy',3),(6,1,'Giá trị số nhị phân 110101010 khi chuyển sang hệ thập lục phân (hệ cơ số đếm 16) sẽ bằng?','1AA','D50','FAA','D5A','A','easy',3),(7,1,'Cách biểu diễn số âm trong máy tính là?','Thêm dấu – vào trước giá trị nhị phân dương tương ứng','Đảo các bit của giá trị nhị phân dương tương ứng','Sử dụng mã bù 2','Sử dụng mã bù 10','A','easy',3),(8,1,'Hãy cho biết sau đoạn lệnh sau biến a nhận giá trị bằng bao nhiêu?\nint a,b,c;\nb=10;c=20;\na=b>c?100:200;','a = 0','a = -1','a = 100','a = 200','D','easy',3),(9,1,'Hãy cho biết sau khi chạy xong đoạn chương trình sau kết quả ta thu được mảng a như thế nào?\nvoid main(){ \nint a[10];\nint temp;\nint i;\n	for(i=0;i<10;i++){\n	  printf(“Nhap gia tri cho so  a[%d]”,i);\n	scanf(“%d”,&a[i]);\n	}\n	temp=a[0];\n	for(i=1;i<10;i++)\n	     if(a[i] > temp) temp =a[i];\n	 a[0]=temp;\n       }','Phần tử đầu tiên của mảng a được thay bằng phần tử nhỏ nhất trong mảng','Mảng a sắp xếp theo thứ tự tăng dần','Mảng a sắp xếp theo thứ tự giảm dần Phần tử đầu tiên của mảng a được tha','Phần tử đầu tiên của mảng a được thay bằng phần tử lớn nhất trong mảng','D','medium',3),(10,1,'Các thao tác xử lý của máy tính gồm (a) Nhận lệnh tiếp theo, (b) Nhận dữ liệu nếu cần, (c) Giải mã lệnh, (d) Thực hiện lệnh. Trình tự thực hiện hợp lý là?','a, b, c, d','a, c, b, d','c, b, d, a','d, b, a, c','B','easy',3),(11,2,'Sau khi thực hiện các câu lệnh sau một cách tuần tự\nint a=5,c=2;\nfloat b=11;\nint d=3;\nd= (int)b++/c%5;\nGiá trị của biến d sẽ là :','0','1','6','5','D','medium',3),(12,2,'Với khai báo biến M sau\nint M[4][5] = { 10, 2, -3, 17, 82, 9, 0, 5, 8, -7, 32, 20, 1, 0, 14, 0, 0, 8, 7, 6 };\ngiá trị của M[1][2] là','0','5','8','2','B','medium',3),(13,2,'Chức năng chính của tập các thanh ghi là?','Điều khiển nhận lệnh','Vận chuyển thông tin giữa các thành phần trong máy tính','Chứa các thông tin phục vụ cho hoạt động của CPU','Không có câu trả lời nào ở trên là đúng','C','medium',3),(14,2,'Lệnh đúng để in 2 biến số thực x, y ra màn hình theo quy cách sau\nDòng 1 :  In giá trị x, căn lề trái, chiếm 10 vị trí trong đó có 2 vị trí cho phần thập phân\nDòng 2 : In giá trị y, căn lề phải, chiếm 6 vị trí trong đó có 3 vị trí cho phần thập phân','printf(“%-10.2f \\n%6.3f”,x,y);','printf(“%-10.3f \\n%6.4f”,x,y);','printf(“%10.2f ”,x) ; printf(“%-6.3f ”,y) ;','printf(“%10.2f ”,x) ; printf(“\\n%-6.3f ”,y) ;','A','medium',3),(15,2,'Cho biết kết quả trên màn hình của lệnh sau  (Với □ là ký tự space):\nprintf(\"%5.2f \", 3.454) ;','3.4','3.45','3.454','3.5','B','medium',3),(16,2,'Trong các khai báo sau, khai báo nào không có lỗi?','#define MAX=10','#define MAX 10','#define MAX 10;','const int MAX 10;','B','easy',3),(17,2,'Khẳng định nào sau đây về mạng máy tính là đúng','Mạng máy tính là tập hợp các thiết bị tính toán được nối với nhau','Các thiết bị kết nối với nhau trong mạng để chia sẻ thông tin','Các máy tính trong mạng được kết nối với nhau thông qua dây, sóng radio hoặc hồng nngoại','Tất cả các khẳng định trên','D','medium',3),(18,2,'Giá trị của biến m sau khi thực hiện đoạn chương trình sau là?\nfloat A[4]={1.1,1.2,1.3,1.4};\nint i; float m=0; \nfor(i=0;i<=2;i++) \n      if(m<A[i]) m=A[i];','0','1.1','1.3','1.4','C','medium',3),(19,2,'Câu 19. Cần nhập vào từ bàn phím n số nguyên với n cũng được nhập từ bàn phím. Khai báo nào đúng nhất cho mảng A  để lưu trữ n số nguyên này','int A[n];','int A[100];','int A[int n];','int A[]={1,2,3};','B','hard',3),(20,2,'Dòng lệnh khai báo nào sau đây là đúng với cú pháp khai báo nguyên mẫu hàm trong C của hàm tìm giá trị lớn nhất trong 3 số a,b,c','function max(int a, int b, int c);','int max(int a, int b, int c);','max(int a, int b, int c);','max()','B','medium',3),(21,3,'Hãy cho biết kết quả sau khi chạy đoạn chương trình sau\nvoid main(){\n		char *s1, *s2;\n		s1 = “Xin chao ”;\n		s2 = “cac ban”;\n		s1 = strcat(s1,s2);\n		printf(“%s”,s1);\n}','Xin chao','cac ban','chao cac ban','Xin chao cac ban','D','hard',3),(22,3,'Hãy cho biết sau khi thực hiện đoạn chương trình sau kết quả thu được là như thế nào?\nvoid main(){			int  i;\n	char  temp;		\n	char s[20] = “Xin chao ban than”;	\n	for(i=0;i<8;i++){				\n		temp =s[i];				\n		s[i] = s[i+9];\n		s[i+9] = temp;\n	}\n	printf(“%s”,s);\n}','Xin chao ban than','chao ban than Xin','ban than Xin chao','than Xin chao ban','C','hard',3),(23,3,'Trong các thiết bị sau, thiết bị nào là thiết bị ra?','Con chuột','Bàn phím','Máy quét','Máy chiếu','D','hard',3),(24,3,'Sau khi thực hiện các câu lệnh sau một cách tuần tự\nint a=5,c=2;\nfloat b=11;\nint d=3;\nd= (int)b/c%5;\ngiá trị của biến d sẽ bằng?','5','3','0','1','C','hard',3),(25,3,'Một số nguyên có dấu biểu diễn dưới dạng số nhị phân 8 bit là 01010101. Giá trị của số đó là?','1100.1011','1100.01011','1010.1011','1010.1011','A','hard',3),(26,3,'Sau khi thực hiện các lệnh sau một cách tuần tự\nint i;\nchar str[] = {\"helloworld!\"};\nchar words[10];    	\nfor(i=0;i<strlen(str)/2;i++)    	       \nwords[i]=str[i+1];\nwords[i-1]=\'\\0\';   		\nprintf(\"%s\\n\",words);\nNội dung màn hình sẽ là?','ellow','hello','ello','hhell','A','hard',3),(27,5,'hello everyone','hi','nice to meet you','5','66','C','hard',3);
/*!40000 ALTER TABLE `CauTracNghiem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-05 19:55:25
