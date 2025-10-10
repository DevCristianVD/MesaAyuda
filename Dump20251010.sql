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
-- Table structure for table `tb_departamento`
--

DROP TABLE IF EXISTS `tb_departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_departamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `abreviacion` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_departamento`
--

LOCK TABLES `tb_departamento` WRITE;
/*!40000 ALTER TABLE `tb_departamento` DISABLE KEYS */;
INSERT INTO `tb_departamento` VALUES (1,'Finanzas','FN'),(2,'Recursos Humanos','RH');
/*!40000 ALTER TABLE `tb_departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estados`
--

DROP TABLE IF EXISTS `tb_estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estados`
--

LOCK TABLES `tb_estados` WRITE;
/*!40000 ALTER TABLE `tb_estados` DISABLE KEYS */;
INSERT INTO `tb_estados` VALUES (1,'Abierto'),(2,'Cerrado');
/*!40000 ALTER TABLE `tb_estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_historial_ticket`
--

DROP TABLE IF EXISTS `tb_historial_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_historial_ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_ticket` int NOT NULL,
  `id_usuario` int NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `fecha` datetime NOT NULL,
  `id_prioridad` int NOT NULL,
  `id_status` int DEFAULT NULL,
  `tiempo_invertido` varchar(20) DEFAULT NULL,
  `asignado` varchar(100) DEFAULT NULL,
  `ultima_actualizacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_historial_ticket_tb_ticket1_idx` (`id_ticket`),
  KEY `fk_historial_ticket_tb_prioridades1_idx` (`id_prioridad`),
  KEY `fk_historial_ticket_tb_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_historial_ticket_tb_prioridades1` FOREIGN KEY (`id_prioridad`) REFERENCES `tb_prioridades` (`id`),
  CONSTRAINT `fk_historial_ticket_tb_ticket1` FOREIGN KEY (`id_ticket`) REFERENCES `tb_ticket` (`id`),
  CONSTRAINT `fk_historial_ticket_tb_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_historial_ticket`
--

LOCK TABLES `tb_historial_ticket` WRITE;
/*!40000 ALTER TABLE `tb_historial_ticket` DISABLE KEYS */;
INSERT INTO `tb_historial_ticket` VALUES (1,10,4,'ya funciona','2025-10-10 12:42:06',3,1,'','yo','2025-10-10T12:42:06.316490300'),(2,10,4,'ya funciona todo','2025-10-10 13:15:20',3,1,'2 horas','','2025-10-10T13:15:20.846111500');
/*!40000 ALTER TABLE `tb_historial_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_prioridades`
--

DROP TABLE IF EXISTS `tb_prioridades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_prioridades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `valor` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_prioridades`
--

LOCK TABLES `tb_prioridades` WRITE;
/*!40000 ALTER TABLE `tb_prioridades` DISABLE KEYS */;
INSERT INTO `tb_prioridades` VALUES (1,'Alta',3),(2,'Media',2),(3,'Baja',1);
/*!40000 ALTER TABLE `tb_prioridades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_roles`
--

DROP TABLE IF EXISTS `tb_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `permiso_registrar` tinyint NOT NULL,
  `permiso_seguimiento` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_roles`
--

LOCK TABLES `tb_roles` WRITE;
/*!40000 ALTER TABLE `tb_roles` DISABLE KEYS */;
INSERT INTO `tb_roles` VALUES (2,'administrador',2,2),(3,'Estudiante',1,1),(4,'Maestro',1,1);
/*!40000 ALTER TABLE `tb_roles` ENABLE KEYS */;
UNLOCK TABLES;

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
  `tiempo_invertido` varchar(20) DEFAULT NULL,
  `ultima_actualizacion` datetime DEFAULT NULL,
  `asignado` varchar(100) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ticket`
--

LOCK TABLES `tb_ticket` WRITE;
/*!40000 ALTER TABLE `tb_ticket` DISABLE KEYS */;
INSERT INTO `tb_ticket` VALUES (2,'TK-2','2025-09-23 20:28:55',1,4,1,1,'no funciona','impresora',NULL,NULL,NULL),(3,'TK-3','2025-09-26 11:29:28',1,4,1,2,'en el jardin x se esta tirando el agua','agua tirandose ',NULL,NULL,NULL),(4,'TK-4','2025-09-26 21:45:23',1,4,1,3,'Se derramaron liquidos en el piso','Limpieza',NULL,NULL,NULL),(10,'TK-10','2025-10-10 11:11:13',2,4,1,3,'verificacion de fucnionamiento','prueba','2 horas','2025-10-10 13:15:21','');
/*!40000 ALTER TABLE `tb_ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_tb_ticket_folio` BEFORE INSERT ON `tb_ticket` FOR EACH ROW BEGIN
    
    IF NEW.folio IS NULL OR NEW.folio = '' THEN
        SET NEW.folio = CONCAT('TK-', 
            (SELECT AUTO_INCREMENT
             FROM information_schema.TABLES
             WHERE TABLE_SCHEMA = DATABASE()
             AND TABLE_NAME = 'tb_ticket'));
    END IF;

    
    IF NEW.registrado IS NULL THEN
        SET NEW.registrado = NOW();
    END IF;

    
    IF NEW.id_status IS NULL THEN
        SET NEW.id_status = 1;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) NOT NULL,
  `password_usuario` blob NOT NULL,
  `id_rol` int NOT NULL,
  `inhabilitado` tinyint NOT NULL,
  `id_departamento` int DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usuario_roles_idx` (`id_rol`),
  KEY `fk_usuario_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_usuario_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `tb_departamento` (`id`),
  CONSTRAINT `fk_usuario_roles` FOREIGN KEY (`id_rol`) REFERENCES `tb_roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=ascii;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (4,'Cristian','Vargas','Deniz','sencris',_binary 'Pm&JR‚g”Q:\È\ì',3,0,NULL);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tec'
--

--
-- Dumping routines for database 'tec'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-10 13:51:02
