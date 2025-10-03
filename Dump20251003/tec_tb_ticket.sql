-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: tec
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `tb_ticket`
--

DROP TABLE IF EXISTS `tb_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `folio` varchar(20) DEFAULT NULL,
  `registrado` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_departamento` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  `id_status` int NOT NULL DEFAULT '1',
  `id_prioridad` int NOT NULL,
  `descripcion` text NOT NULL,
  `titulo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `folio_UNIQUE` (`folio`),
  KEY `fk_Ticket_usuario1_idx` (`id_usuario`),
  KEY `fk_Ticket_estados1_idx` (`id_status`),
  KEY `fk_Ticket_prioridades1_idx` (`id_prioridad`),
  KEY `fk_Ticket_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_Ticket_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `tb_departamento` (`id`),
  CONSTRAINT `fk_Ticket_estados1` FOREIGN KEY (`id_status`) REFERENCES `tb_estados` (`id`),
  CONSTRAINT `fk_Ticket_prioridades1` FOREIGN KEY (`id_prioridad`) REFERENCES `tb_prioridades` (`id`),
  CONSTRAINT `fk_Ticket_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ticket`
--

LOCK TABLES `tb_ticket` WRITE;
/*!40000 ALTER TABLE `tb_ticket` DISABLE KEYS */;
INSERT INTO `tb_ticket` VALUES (2,'TK-2','2025-09-23 20:28:55',1,4,1,1,'no funciona','impresora'),(3,'TK-3','2025-09-26 11:29:28',1,4,1,2,'en el jardin x se esta tirando el agua','agua tirandose '),(4,'TK-4','2025-09-26 21:45:23',1,NULL,1,3,'Se derramaron liquidos en el piso','Limpieza');
/*!40000 ALTER TABLE `tb_ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-03 13:44:39
