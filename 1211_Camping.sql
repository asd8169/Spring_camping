CREATE DATABASE  IF NOT EXISTS `camping` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `camping`;
-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: camping
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cartNo` int(11) NOT NULL AUTO_INCREMENT,
  `userinfo_userNo` int(11) NOT NULL,
  `product_pNo` int(11) NOT NULL,
  `cartQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartNo`,`userinfo_userNo`,`product_pNo`),
  UNIQUE KEY `cartNo_UNIQUE` (`cartNo`),
  KEY `fk_userinfo_has_product_product4_idx` (`product_pNo`),
  KEY `fk_userinfo_has_product_userinfo4_idx` (`userinfo_userNo`),
  CONSTRAINT `fk_userinfo_has_product_product4` FOREIGN KEY (`product_pNo`) REFERENCES `product` (`pNo`),
  CONSTRAINT `fk_userinfo_has_product_userinfo4` FOREIGN KEY (`userinfo_userNo`) REFERENCES `userinfo` (`userNo`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (34,27,153,1),(35,27,151,2);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `qna_qnaNo` int(11) NOT NULL,
  `qna_userinfo_userNo` int(11) NOT NULL,
  `qna_product_pNo` int(11) NOT NULL,
  `commentContent` text,
  PRIMARY KEY (`qna_qnaNo`,`qna_userinfo_userNo`,`qna_product_pNo`),
  CONSTRAINT `fk_table1_qna1` FOREIGN KEY (`qna_qnaNo`, `qna_userinfo_userNo`, `qna_product_pNo`) REFERENCES `qna` (`qnaNo`, `userinfo_userNo`, `product_pNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderNo` int(11) NOT NULL AUTO_INCREMENT,
  `userinfo_userNo` int(11) NOT NULL,
  `product_pNo` int(11) NOT NULL,
  `orderAddress` varchar(45) DEFAULT NULL,
  `orderQuantity` int(11) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  PRIMARY KEY (`orderNo`,`userinfo_userNo`,`product_pNo`),
  UNIQUE KEY `orderNo_UNIQUE` (`orderNo`),
  KEY `fk_userinfo_has_product_product1_idx` (`product_pNo`),
  KEY `fk_userinfo_has_product_userinfo3_idx` (`userinfo_userNo`),
  CONSTRAINT `fk_userinfo_has_product_product1` FOREIGN KEY (`product_pNo`) REFERENCES `product` (`pNo`),
  CONSTRAINT `fk_userinfo_has_product_userinfo3` FOREIGN KEY (`userinfo_userNo`) REFERENCES `userinfo` (`userNo`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (50,29,149,'강남',2,'2020-12-10'),(53,28,149,'서울특별시 서초구 반포대로14길 58   101  ',1,'2020-12-11'),(54,32,149,'경기도 성남시 분당구 판교로 20   2  ',1,'2020-12-11'),(55,33,149,'서울특별시 서초구 남부순환로297라길 8   4  ',2,'2020-12-11');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pNo` int(11) NOT NULL AUTO_INCREMENT,
  `pName` varchar(50) DEFAULT NULL,
  `pCategory` varchar(20) DEFAULT NULL,
  `pPrice` varchar(10) DEFAULT NULL,
  `pHashtag` text,
  `pFile` varchar(50) DEFAULT NULL,
  `pSubFile` varchar(45) DEFAULT NULL,
  `pStock` int(11) DEFAULT NULL,
  PRIMARY KEY (`pNo`),
  UNIQUE KEY `productNo_UNIQUE` (`pNo`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (146,'바베큐스툴_black','Stools','25000',NULL,'2020120815576314.png','2020120815576314detail.png',100),(149,'밀크박스_green','Storage','15000',NULL,'20201208163510351.jpg','20201208163510351detail.jpg',100),(151,'바베큐스툴_white','Stools','25000',NULL,'202012081636151.jpg','202012081636151detail.jpg',100),(152,'캐리어트레이','Collaboration','15000',NULL,'20201208164716161.jpg','20201208164716161detail.jpg',100),(153,'밀크사이드테이블','Tables','15000',NULL,'2020120816484599.jpg','2020120816484599detail.jpg',100),(155,'밀크박스_purple','Storage','15000',NULL,'2020120817246443.jpg','2020120817246443detail.jpg',50),(156,'릴랙스 체어','Chairs','5000',NULL,'2020120817331310.jpg','2020120817331310detail.jpg',50),(157,'삼양 콜라보','Collaboration','15000',NULL,'20201208171052237.jpg','20201208171052237detail.jpg',10),(164,'밀크체어_2018LTD','Storage','17000',NULL,'2020121192554980.jpg','2020121192554980detail.jpg',100),(165,'2020 캠핑세트LTD','Collaboration','130000',NULL,'20201211101534159.png','20201211101534159detail.png',10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qna`
--

DROP TABLE IF EXISTS `qna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qna` (
  `userinfo_userNo` int(11) NOT NULL,
  `product_pNo` int(11) NOT NULL,
  `qnaNo` int(11) NOT NULL AUTO_INCREMENT,
  `qnaTitle` varchar(10) DEFAULT NULL,
  `qnaContent` text,
  `qnaDate` date DEFAULT NULL,
  `qnaSecret` varchar(10) DEFAULT NULL,
  `qnauserId` varchar(45) DEFAULT NULL,
  `qnaComment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userinfo_userNo`,`product_pNo`,`qnaNo`),
  UNIQUE KEY `qnaNo_UNIQUE` (`qnaNo`),
  KEY `fk_userinfo_has_product_product3_idx` (`product_pNo`),
  KEY `fk_userinfo_has_product_userinfo2_idx` (`userinfo_userNo`),
  CONSTRAINT `fk_userinfo_has_product_product3` FOREIGN KEY (`product_pNo`) REFERENCES `product` (`pNo`),
  CONSTRAINT `fk_userinfo_has_product_userinfo2` FOREIGN KEY (`userinfo_userNo`) REFERENCES `userinfo` (`userNo`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qna`
--

LOCK TABLES `qna` WRITE;
/*!40000 ALTER TABLE `qna` DISABLE KEYS */;
INSERT INTO `qna` VALUES (27,146,20,'제품 문의','의자에 무거운 사람도 앉을 수 있나요?','2020-12-08','y','semi',NULL),(28,149,21,'제품 문의','이거 크기 사이즈가 어떻게 되나요?','2020-12-11',NULL,'tpal',NULL),(28,149,22,'제품 문의','이거 크기 사이즈가 어떻게 되나요?','2020-12-11',NULL,'tpal',NULL),(32,149,23,'결제 문의','얼마이상 구매하면 무료배송인가여?','2020-12-11','y','ckwhdgks',NULL),(33,149,24,'기타 문의','배송이 오래 걸린다는게 사실인가요? ','2020-12-11',NULL,'qkrdlsdn',NULL),(35,149,27,'제품 문의','이거 음식 2인분 이상 들어갈까요?','2020-12-11',NULL,'qkrtpal',NULL);
/*!40000 ALTER TABLE `qna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `reviewNo` int(11) NOT NULL AUTO_INCREMENT,
  `order_orderNo` int(11) NOT NULL,
  `order_userinfo_userNo` int(11) NOT NULL,
  `order_product_pNo` int(11) NOT NULL,
  `reviewContent` text,
  `reviewFile` varchar(100) DEFAULT NULL,
  `reviewDate` date DEFAULT NULL,
  PRIMARY KEY (`reviewNo`,`order_orderNo`,`order_userinfo_userNo`,`order_product_pNo`),
  UNIQUE KEY `reviewNo_UNIQUE` (`reviewNo`),
  KEY `fk_table1_order1` (`order_orderNo`,`order_userinfo_userNo`,`order_product_pNo`),
  CONSTRAINT `fk_table1_order1` FOREIGN KEY (`order_orderNo`, `order_userinfo_userNo`, `order_product_pNo`) REFERENCES `order` (`orderNo`, `userinfo_userNo`, `product_pNo`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (31,50,29,149,'이거 완전 추천합니다.\r\n캠핑 재밌었음 ㅎㅎ ','2020121193754188.jpg','2020-12-11'),(32,53,28,149,'캠핑가서 재밌게 놀았어요\r\n즐거운 추억보냈습니당~~~~','2020121194244455.png','2020-12-11'),(33,54,32,149,'여자친구랑 같이 캠핑가서\r\n잘 썼습니다. 유용해요!!\r\n추천합니당.','2020121194526157.jpg','2020-12-11'),(34,55,33,149,'친구 주려고 일부러 두개 삼\r\n완전 만족했음 ㅎㅎ 굳굳','2020121195134687.jpg','2020-12-11');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `userNo` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(20) DEFAULT NULL,
  `userPw` varchar(20) DEFAULT NULL,
  `userName` varchar(10) DEFAULT NULL,
  `userTelno` varchar(20) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `zipNo` varchar(45) DEFAULT NULL,
  `roadAddrPart1` varchar(45) DEFAULT NULL,
  `addrDetail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userNo`),
  UNIQUE KEY `userId_UNIQUE` (`userNo`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'admin','1234','관리자',NULL,NULL,NULL,NULL,NULL),(27,'semi','123456','홍길동','01012344342','semi777@gmail.com','06675  ','서울특별시 서초구 서초대로 14  ','2  '),(28,'tpal','111','세미','01012344412','tpal1l@naver.com','06654  ','서울특별시 서초구 반포대로14길 58  ','101  '),(29,'song','123456','송예진','01026745461','null@naver.com','13550    ','경기도 성남시 분당구 대왕판교로 311    ','3  '),(31,'jordy','123456','조르디','01048487878','null@gmail.com','06257  ','서울특별시 강남구 도곡로23길 7  ','3  '),(32,'ckwhdgks','123456','차종한','01078785858','ckwhdgks@naver.com','13485  ','경기도 성남시 분당구 판교로 20  ','2  '),(33,'qkrdlsdn','123456','박인우','01034345656','qkrdlsdn@gmail.com','06702  ','서울특별시 서초구 남부순환로297라길 8  ','4  '),(34,'thddPwls','123456','송예진','01078944645','thddPwls@naver.com','08767  ','서울특별시 관악구 난곡로 331  ','2  '),(35,'qkrtpal','123456','박세미','01045458858','qkrtpal@naver.com','04999  ','서울특별시 광진구 면목로 1  ','1  '),(36,'선생님','123456','선생님','01034342342','tjstodsla@gmail.com','06790  ','서울특별시 서초구 동산로16길 34  ','2  '),(37,'cha','123456','차','01012344423','cha@gmail.com','13506  ','경기도 성남시 분당구 성남대로926번길 6  ','3  ');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `wishNo` int(11) NOT NULL AUTO_INCREMENT,
  `userinfo_userNo` int(11) NOT NULL,
  `product_pNo` int(11) NOT NULL,
  PRIMARY KEY (`wishNo`,`userinfo_userNo`,`product_pNo`),
  UNIQUE KEY `wishNo_UNIQUE` (`wishNo`),
  KEY `fk_userinfo_has_product_product2_idx` (`product_pNo`),
  KEY `fk_userinfo_has_product_userinfo1_idx` (`userinfo_userNo`),
  CONSTRAINT `fk_userinfo_has_product_product2` FOREIGN KEY (`product_pNo`) REFERENCES `product` (`pNo`),
  CONSTRAINT `fk_userinfo_has_product_userinfo1` FOREIGN KEY (`userinfo_userNo`) REFERENCES `userinfo` (`userNo`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
INSERT INTO `wishlist` VALUES (29,27,152);
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-11 10:39:16
