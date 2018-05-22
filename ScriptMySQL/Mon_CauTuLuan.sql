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
-- Table structure for table `CauTuLuan`
--

DROP TABLE IF EXISTS `CauTuLuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CauTuLuan` (
  `id` int(11) NOT NULL,
  `chuong` int(11) NOT NULL,
  `deBai` text NOT NULL,
  `goiY` text NOT NULL,
  `doKho` varchar(30) NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CauTuLuan`
--

LOCK TABLES `CauTuLuan` WRITE;
/*!40000 ALTER TABLE `CauTuLuan` DISABLE KEYS */;
INSERT INTO `CauTuLuan` VALUES (1,1,'lập trình thực hiện các công việc sau:\n1. Nhập 1 mảng gồm các số nguyên bất kì từ bàn phím\n2. Việc nhập mảng sẽ dừng lại khi số lượng phần tử bằng 7 hoặc khi nhập vào một số 0\n3. In mảng vừa nhập ra màn hình dưới dạng một dãy số\n4. Sắp xếp mảng vừa nhập theo thứ tự tăng dần vào in ra màn hình','có một số đề sẽ thay đổi về điều kiện dừng nhập mảng','easy',3),(2,2,'Lập trình thực hiện các công việc sau:\n1. Nhập 3 số thực a,b,c bất kì\n2. Giải phương trình bậc 2:	a*x^2+b*x+c=0\n3. Thông báo kết quả ra màn hình','Tính cả nghiệm a=0 và trường hợp nghiệm phức','medium',3),(3,3,'Lập trình thực hiện các công việc sau:\n1. Nhập một số nguyên N (0<N<1000) từ bàn phím\n2. Tìm và in ra các số hoàn thiện trong khoảng (0;N)\n3. Tính tổng các số vừa tìm được và thông báo ra màn hình','Số hoàn thiện (Số hoàn chỉnh, số hoàn hảo) là các số nguyên dương mà tổng các ước bằng chính nó','hard',3),(4,3,'Lập trình thực hiện các công việc sau :\n1. Nhập 2 số nguyên M,N (1<M, N <2000) từ bàn phím\n2. Kiểm tra xem M, N có phải cặp số thân thiết không, in kết quả ra màn hình','Cặp số thân thiết là số này bằng tổng các ước số kia và ngược lại','easy',3),(5,3,'Lập trình thực hiện các công việc sau :\n1. Nhập 2 số nguyên M,N (1<M, N <2000) từ bàn phím\n2. Kiểm tra xem M, N có phải cặp số hứa hôn không, in kết quả ra màn hình','Cặp số thân thiết là số này lớn hơn  tổng các ước số kia 1 đơn vị và ngược lại','easy',3),(6,6,'Lập trình thực hiện các công việc sau: \n                 1. Nhập 1 số nguyên M (0< M <1000) từ bàn phím \n                  2. Liệt kê ra các số tự mãn trong khoảng từ 0 đến N','Số tự mãn là 1 số dương mà tổng lập phương các chữ số của nó bằng chính nó','hard',3);
/*!40000 ALTER TABLE `CauTuLuan` ENABLE KEYS */;
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
