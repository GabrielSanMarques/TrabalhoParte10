-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_gestao
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `projetobeneficio`
--

DROP TABLE IF EXISTS `projetobeneficio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projetobeneficio` (
  `beneficio_cod_custo` int unsigned NOT NULL,
  `beneficio_usuario_id_usuario` int NOT NULL,
  `projeto_cod_projeto` int NOT NULL,
  PRIMARY KEY (`beneficio_cod_custo`,`beneficio_usuario_id_usuario`,`projeto_cod_projeto`),
  KEY `fk_beneficio_has_projeto_projeto1_idx` (`projeto_cod_projeto`),
  KEY `fk_beneficio_has_projeto_beneficio1_idx` (`beneficio_cod_custo`,`beneficio_usuario_id_usuario`),
  CONSTRAINT `fk_beneficio_has_projeto_beneficio1` FOREIGN KEY (`beneficio_cod_custo`, `beneficio_usuario_id_usuario`) REFERENCES `beneficio` (`cod_beneficio`, `usuario_cod_usuario`),
  CONSTRAINT `fk_beneficio_has_projeto_projeto1` FOREIGN KEY (`projeto_cod_projeto`) REFERENCES `projeto` (`cod_projeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-13 23:24:49
