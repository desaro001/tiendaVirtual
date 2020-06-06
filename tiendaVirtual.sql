-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: tiendavirtual
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
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `imagen` varchar(25) DEFAULT NULL,
  `destacado` varchar(2) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES (1,'CHA-Bolongaro001','Bolongaro Trevor: Chaqueta De Plumón con Capucha, Hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_01.jpg','SI',115),(2,'POL-Lacoste001','Polo Lacoste ,65% Poliéster,35% Poliuretano,Cierre:Zip,Estilo del cuello: cuello -congregado,Manga larga','polo_04.jpg','SI',65),(3,'PAN-Zara001','Pantalon Zara Man ,35% algodon,65% Poliuretano,Cierre:Zip,ajuste Fit','pant_04.jpg','NO',40),(4,'PAN-Levis001','Pantalon vaquero Levi,s ,35% algodon,65% Poliuretano,Cierre:Zip,ajuste Fit','pant_07.jpg','NO',40),(5,'CHA-Columbia001','Columbia Powder Lite Hooded Chaqueta De Plumón con Capucha, Hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_04.jpg','NO',75),(6,'POL-Burberry001','Polo Burberry, ,70% Poliéster,30% Poliuretano,Cierre:Zip,Estilo del cuello: cuello congregado,Manga corta','polo_02.jpg','SI',65),(7,'CHA-Bolongaro001','Bolongaro Trevor: Chaqueta De Plumón con Capucha, Hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_01.jpg','SI',115),(8,'POL-Gucci001','Polo Gucci, ,70% Poliéster,30% Poliuretano,Cierre:Zip,Estilo del cuello: cuello congregado,Manga corta','polo_07.jpg','SI',55),(9,'CHA-Newera001','New Era Chaqueta De cuero Hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_03.jpg','NO',125),(10,'CHA-Hetrego001','Hetrego, plumífero de Hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_06.jpg','SI',125),(11,'PAN-H&M001','Pantalon H&M Hombre ,65% algodon,35% Poliuretano,Cierre:Zip,ajuste Fit','pant_05.jpg','SI',45),(12,'PAN-Dockers001','Pantalon Dockers Hombre ,70% algodon,30% Poliuretano,Cierre:Zip,ajuste Fit','pant_06.jpg','SI',55),(13,'POL-Lacoste002','Polo Lacoste, ,75% Poliéster,25% Poliuretano,Cierre:Zip,Estilo del cuello: cuello congregado,Manga corta','polo_03.jpg','SI',75),(14,'PAN-RalphLauren001','Pantalon Ralph Lauren  Hombre ,70% algodon,30% Poliuretano,Cierre:Zip,ajuste Fit','pant_02.jpg','SI',75),(15,'POL-Desigual001','Polo Desigual, ,65% Poliéster,35% Poliuretano,Cierre:Zip,Estilo del cuello: cuello congregado,Manga corta','polo_01.jpg','NO',35),(16,'CHA-H&M002','H&M Chaqueta De cuero hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_08.jpg','NO',145),(17,'POL-Versace001','Polo Versace, ,80% Poliéster,20% Poliuretano,Cierre:Zip,Estilo del cuello: cuello congregado,Manga corta','polo_05.jpg','NO',45),(18,'PAN-Timberland001','Pantalon Timberland  Hombre ,65% algodon,35% Poliuretano,Cierre:Zip,ajuste Fit','pant_03.jpg','NO',55),(19,'PAN-MaximoDutti001','Pantalon Máximo Dutti  Hombre ,80% algodon,20% Poliuretano,Cierre:Zip,ajuste Fit','pant_01.jpg','SI',65),(20,'CHA-FredMello001','Fred Mello, cazadora de hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_07.jpg','SI',85),(21,'POL-CalvinKlein001','Polo Calvin Klein de hombre , ,65% Poliéster,35% Poliuretano,Cierre:Zip,Estilo del cuello: cuello congregado,Manga corta','polo_06.jpg','NO',65),(22,'PAN-TommyHilfinger001','Pantalon Tommy Hilfinger  Hombre ,75% algodon,25% Poliuretano,Cierre:Zip,ajuste Fit','pant_08.jpg','SI',55),(23,'CHA-HelmutLang001','Helmut Lang, cazadora de hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_02.jpg','SI',85),(24,'CHA-Herno001','Herno, plumífero de hombre ,Cierre:Zip,Estilo del cuello: cuello congregado','abrigo_05.jpg','SI',105);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articuloscesta`
--

DROP TABLE IF EXISTS `articuloscesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `articuloscesta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCesta` int NOT NULL,
  `idArticulo` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id1` (`idCesta`),
  KEY `id2` (`idArticulo`),
  CONSTRAINT `id1` FOREIGN KEY (`idCesta`) REFERENCES `cestas` (`id`),
  CONSTRAINT `id2` FOREIGN KEY (`idArticulo`) REFERENCES `articulos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articuloscesta`
--

LOCK TABLES `articuloscesta` WRITE;
/*!40000 ALTER TABLE `articuloscesta` DISABLE KEYS */;
INSERT INTO `articuloscesta` VALUES (8,7,6,1,65,NULL),(9,7,8,1,55,NULL),(10,8,7,1,115,NULL),(11,8,8,1,55,NULL),(12,8,10,1,125,NULL),(13,9,11,1,45,NULL),(14,9,6,1,65,NULL);
/*!40000 ALTER TABLE `articuloscesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cestas`
--

DROP TABLE IF EXISTS `cestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `cestas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `importe` double DEFAULT NULL,
  `idUsuario` int DEFAULT NULL,
  `fecha` date NOT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuario_idx` (`idUsuario`),
  CONSTRAINT `idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cestas`
--

LOCK TABLES `cestas` WRITE;
/*!40000 ALTER TABLE `cestas` DISABLE KEYS */;
INSERT INTO `cestas` VALUES (7,120,13,'2020-04-12','p'),(8,295,13,'2020-04-12','p'),(9,110,14,'2020-04-12','p');
/*!40000 ALTER TABLE `cestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `estatus` varchar(1) DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (13,'Arturo ramirez Camino','arturorc001@outlook.es','DESARO','desaro','R','2020-04-10'),(14,'Arturo ramirez Camino','arturorc001@outlook.es','DESARO02','desaro','R','2020-04-10'),(15,'Julian Perez Ruiz','julian01@outlook.es','JULIAN01','desaro','R','2020-04-11');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-13 12:35:43
