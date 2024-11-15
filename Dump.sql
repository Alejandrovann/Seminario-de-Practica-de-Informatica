-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: Ortiz
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

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
-- Table structure for table `insumos`
--

DROP TABLE IF EXISTS `insumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insumos` (
  `codigo` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nro_panol` int DEFAULT NULL,
  `fabricante` varchar(255) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `stock_min` int DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `nro_panol` (`nro_panol`),
  CONSTRAINT `insumos_ibfk_1` FOREIGN KEY (`nro_panol`) REFERENCES `panol` (`nro_panol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumos`
--

LOCK TABLES `insumos` WRITE;
/*!40000 ALTER TABLE `insumos` DISABLE KEYS */;
INSERT INTO `insumos` VALUES (108,'eslinga 25\"',103,'eslingar',50,70,'pedido'),(109,'guantes anticorte',103,'guantex',50,10,'activo'),(1135,'ferrita_1/2\"',102,'otomils',50,25,'activo'),(1165,'etiqueta50x40',106,'zebra',800,200,'activo'),(1166,'carbónico 110',103,'zebra',50,10,'activo'),(2230,'guardamotor3p_10A',101,'sheneider',2,1,'bloqueado'),(2234,'contactor3p_25A',101,'siemens',5,1,'activo'),(2235,'fusible10A',105,'trv',15,5,'activo'),(3255,'manguera neum 1/8\"',101,'festo',500,50,'activo');
/*!40000 ALTER TABLE `insumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `nro_movimiento` int NOT NULL,
  `legajo` int DEFAULT NULL,
  `codigo` int DEFAULT NULL,
  `puesto_trabajo` varchar(255) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`nro_movimiento`),
  KEY `legajo` (`legajo`),
  KEY `codigo` (`codigo`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`legajo`) REFERENCES `usuarios` (`legajo`),
  CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`codigo`) REFERENCES `insumos` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,1490,1165,'mair 763',1,'2024-05-03 15:54:46'),(2,1510,1135,'conformadora 322',1,'2024-05-03 15:54:46'),(3,1509,108,'mair 764',10,'2024-05-03 15:54:46'),(4,1487,109,'bewo01',2,'2024-05-03 15:54:46'),(5,1595,1166,'mair382',1,'2024-05-03 15:54:46');
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panol`
--

DROP TABLE IF EXISTS `panol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `panol` (
  `nro_panol` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nro_panol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panol`
--

LOCK TABLES `panol` WRITE;
/*!40000 ALTER TABLE `panol` DISABLE KEYS */;
INSERT INTO `panol` VALUES (101,'Pañol Familia 25.40','Módulo 3A','Online'),(102,'Pañol Familia 50.80','Módulo 4B','Online'),(103,'Pañol Familia 76.20','Módulo 6C','Online'),(105,'Pañol Corte','Módulo 30A','Online'),(106,'Pañol PerfilC','Módulo 34B','Online');
/*!40000 ALTER TABLE `panol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `legajo` int NOT NULL,
  `tipo_usuario` varchar(255) DEFAULT NULL,
  `nro_panol` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  PRIMARY KEY (`legajo`),
  KEY `nro_panol` (`nro_panol`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`nro_panol`) REFERENCES `panol` (`nro_panol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1487,'Operador',105,'Diego','Marshall','1999-05-02'),(1490,'Operador',101,'Diego','Valverde','2002-06-19'),(1505,'Administrador',101,'Diego','Baigorria','2001-06-19'),(1509,'Operador',103,'Gabriel','Ocampo','2005-07-20'),(1510,'Operador',102,'Nestor','Molina','2003-01-06'),(1595,'Operador',106,'Mario','Lima','1995-01-04');
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
