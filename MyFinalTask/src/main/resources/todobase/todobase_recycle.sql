-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: todobase
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `recycle`
--

DROP TABLE IF EXISTS `recycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recycle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  `createDate` date NOT NULL,
  `state` tinyint(1) NOT NULL,
  `userName` varchar(40) DEFAULT NULL,
  `fileName` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recycle`
--

LOCK TABLES `recycle` WRITE;
/*!40000 ALTER TABLE `recycle` DISABLE KEYS */;
INSERT INTO `recycle` VALUES (196,'adsfnhgbdv','2020-03-15',0,'PuvLuk',''),(197,'Final Task finished','2020-03-15',0,'PavLuk',''),(198,NULL,'2020-03-15',0,NULL,NULL),(199,'adsfnhgbdv','2020-03-15',0,'PuvLuk',''),(200,NULL,'2020-03-15',0,NULL,NULL),(201,NULL,'2020-03-15',0,NULL,NULL),(202,'Final Task finished','2020-03-15',1,'PavLuk',''),(203,NULL,'2020-03-15',0,NULL,NULL),(204,'Final Task finished','2020-03-15',0,'PavLuk',''),(205,'Final Task finished','2020-03-15',0,'PavLuk',''),(206,'adsfnhgbdv','2020-03-15',0,'PuvLuk',''),(207,NULL,'2020-03-15',0,NULL,NULL),(208,NULL,'2020-03-15',0,NULL,NULL),(209,'Final Task finished','2020-03-15',0,'PavLuk',''),(210,'adsfnhgbdv','2020-03-15',0,'PuvLuk',''),(211,NULL,'2020-03-15',0,NULL,NULL),(212,'Final Task finished','2020-03-15',0,'PavLuk','');
/*!40000 ALTER TABLE `recycle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-16  4:09:45
