CREATE DATABASE  IF NOT EXISTS `phoenix` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `phoenix`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: phoenix
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `annual-schedule`
--

DROP TABLE IF EXISTS `annual-schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annual-schedule` (
  `year` int(11) NOT NULL,
  `assingedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`year`),
  KEY `id_annual_schedule` (`assingedBy`),
  CONSTRAINT `id_as` FOREIGN KEY (`assingedBy`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annual-schedule`
--

LOCK TABLES `annual-schedule` WRITE;
/*!40000 ALTER TABLE `annual-schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `annual-schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program-slot`
--

DROP TABLE IF EXISTS `program-slot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program-slot` (
`id` int NOT NULL AUTO_INCREMENT,
  `duration` time NOT NULL,
  `dateAndTimeOfProgram` datetime NOT NULL,
  `programName` varchar(45) DEFAULT NULL,
  `presenter` varchar(40) DEFAULT NULL,
  `producer` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dateAndTimeOfProgram_UNIQUE` (`dateAndTimeOfProgram`),
  KEY `name_program_slot` (`programName`),
  KEY `id_idx` (`presenter`),
  KEY `producer_idx` (`producer`),
  CONSTRAINT `presenter` FOREIGN KEY (`presenter`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `producer` FOREIGN KEY (`producer`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `name` FOREIGN KEY (`programName`) REFERENCES `radio-program` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program-slot`
--

LOCK TABLES `program-slot` WRITE;
/*!40000 ALTER TABLE `program-slot` DISABLE KEYS */;
/*!40000 ALTER TABLE `program-slot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radio-program`
--

DROP TABLE IF EXISTS `radio-program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `radio-program` (
  `name` varchar(45) NOT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `typicalDuration` time DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radio-program`
--

LOCK TABLES `radio-program` WRITE;
/*!40000 ALTER TABLE `radio-program` DISABLE KEYS */;
INSERT INTO `radio-program` VALUES ('charity','president charity show for unfortunate','00:30:00'),('dance floor','dance show','00:30:00'),('news','full news broadcasted four times a day','00:30:00'),('noose','black comedy show','00:30:00'),('opinions','discuss, debate or share opinions regarding a theme or subject','00:30:00'),('ppk','phu chu kang comedy show','00:30:00'),('short news','summarised 5 minutes broadcasted every 2 hours','00:05:00'),('top 10','countdown music play of top 10 songs of the week','01:00:00'),('your choice','audinece ask for music album song of thier choice','01:00:00');
/*!40000 ALTER TABLE `radio-program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role` varchar(255) NOT NULL,
  `accessPrivilege` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('admin','system administrator'),('manager','station manager'),('presenter','radio program presenter'),('producer','program producer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `role_index` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('catbert','catbert','catbert, the hr','admin:manager'),('dilbert','dilbert','dilbert, the hero','presenter:producer'),('dogbert','dogbert','dogbert, the CEO','producer:admin'),('pointyhead','pointyhead','pointyhead, the manager','manager'),('wally','wally','wally, the bludger','producer');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weekly-schedule`
--

DROP TABLE IF EXISTS `weekly-schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weekly-schedule` (
  `startDate` datetime NOT NULL,
  `assignedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`startDate`),
  UNIQUE KEY `startDate_UNIQUE` (`startDate`),
  KEY `id_assigned_by` (`assignedBy`),
  CONSTRAINT `id_ws` FOREIGN KEY (`assignedBy`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weekly-schedule`
--

LOCK TABLES `weekly-schedule` WRITE;
/*!40000 ALTER TABLE `weekly-schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `weekly-schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-17 12:06:10
