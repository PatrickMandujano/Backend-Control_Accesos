-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: InstitutoUniversidad
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `cod_carrera` bigint NOT NULL AUTO_INCREMENT,
  `nom_carrera` varchar(100) NOT NULL,
  `cod_facultad` bigint NOT NULL,
  PRIMARY KEY (`cod_carrera`),
  UNIQUE KEY `UK2l3nsxe8ynuc4sglan7hl8f2g` (`nom_carrera`),
  KEY `FKch0sdhm8r3iy6crdt0m757nbh` (`cod_facultad`),
  CONSTRAINT `FKch0sdhm8r3iy6crdt0m757nbh` FOREIGN KEY (`cod_facultad`) REFERENCES `facultad` (`cod_facultad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'Ingeniería de Sistemas',1),(2,'Ingeniería Electrónica',1),(3,'Administración de Empresas',2),(4,'Educación Inicial',3);
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `id_usuario` bigint NOT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FK87ckc5slykqcg7fqsa6fwd8ps` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `id_usuario` bigint NOT NULL,
  `año_ingreso` int NOT NULL,
  `id_carrera` bigint DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FK2fin1nsqxtvpakah0xmv3jnvg` (`id_carrera`),
  CONSTRAINT `FK2fin1nsqxtvpakah0xmv3jnvg` FOREIGN KEY (`id_carrera`) REFERENCES `carrera` (`cod_carrera`),
  CONSTRAINT `FKglus7iu0lqodtjbbu8yr2nnpo` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facultad`
--

DROP TABLE IF EXISTS `facultad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facultad` (
  `cod_facultad` bigint NOT NULL AUTO_INCREMENT,
  `nom_facultad` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_facultad`),
  UNIQUE KEY `UK2unayci6ln45u2fbiv70k2xno` (`nom_facultad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facultad`
--

LOCK TABLES `facultad` WRITE;
/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
INSERT INTO `facultad` VALUES (2,'Facultad de Ciencias Administrativas'),(3,'Facultad de Educación'),(1,'Facultad de Ingeniería');
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_administrativo`
--

DROP TABLE IF EXISTS `personal_administrativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_administrativo` (
  `id_usuario` bigint NOT NULL,
  `area` varchar(100) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FKhg0ik0pyk79joh8jtcdxrb5u8` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_administrativo`
--

LOCK TABLES `personal_administrativo` WRITE;
/*!40000 ALTER TABLE `personal_administrativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_administrativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punto_control`
--

DROP TABLE IF EXISTS `punto_control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `punto_control` (
  `cod_punto_control` bigint NOT NULL AUTO_INCREMENT,
  `nombre_punto_control` varchar(255) NOT NULL,
  `tipo_punto_control` enum('ENTRADA','SALIDA') NOT NULL,
  PRIMARY KEY (`cod_punto_control`),
  UNIQUE KEY `UKpdrht2rp4agibn3us85tix1wx` (`nombre_punto_control`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punto_control`
--

LOCK TABLES `punto_control` WRITE;
/*!40000 ALTER TABLE `punto_control` DISABLE KEYS */;
INSERT INTO `punto_control` VALUES (1,'Puerta Principal','ENTRADA'),(2,'Puerta Posterior','SALIDA'),(3,'Torno Norte','ENTRADA'),(4,'Torno Sur','SALIDA');
/*!40000 ALTER TABLE `punto_control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_permanencia`
--

DROP TABLE IF EXISTS `registro_permanencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro_permanencia` (
  `cod_reg_acceso` bigint NOT NULL AUTO_INCREMENT,
  `fecha_hora_entrada` datetime(6) NOT NULL,
  `fecha_hora_salida` datetime(6) DEFAULT NULL,
  `punto_entrada_id` bigint NOT NULL,
  `punto_salida_id` bigint DEFAULT NULL,
  `id_usuario` bigint NOT NULL,
  PRIMARY KEY (`cod_reg_acceso`),
  KEY `FK43anb7s3f4aw31vj2us91phpx` (`punto_entrada_id`),
  KEY `FK8swjeiqdqlvto5ag2ayu5yw0y` (`punto_salida_id`),
  KEY `FKgrbx652uc51qhr5fd0o5bqnxw` (`id_usuario`),
  CONSTRAINT `FK43anb7s3f4aw31vj2us91phpx` FOREIGN KEY (`punto_entrada_id`) REFERENCES `punto_control` (`cod_punto_control`),
  CONSTRAINT `FK8swjeiqdqlvto5ag2ayu5yw0y` FOREIGN KEY (`punto_salida_id`) REFERENCES `punto_control` (`cod_punto_control`),
  CONSTRAINT `FKgrbx652uc51qhr5fd0o5bqnxw` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_permanencia`
--

LOCK TABLES `registro_permanencia` WRITE;
/*!40000 ALTER TABLE `registro_permanencia` DISABLE KEYS */;
INSERT INTO `registro_permanencia` VALUES (1,'2025-06-28 22:11:11.901438','2025-06-28 23:22:26.745789',3,2,32),(2,'2025-06-28 22:13:38.847330','2025-06-28 23:05:45.923442',3,4,19),(3,'2025-06-28 22:13:55.879314','2025-06-28 23:06:49.890675',3,4,20),(4,'2025-06-28 22:16:28.576154','2025-06-28 23:12:02.147445',3,4,21),(5,'2025-06-28 22:17:00.338017','2025-06-28 23:12:17.657803',3,4,22),(6,'2025-06-28 22:23:57.703811','2025-06-28 23:12:33.172753',3,4,23),(7,'2025-06-28 22:24:31.561718','2025-06-28 23:12:49.992005',3,4,24),(8,'2025-06-28 22:26:00.658909','2025-06-29 20:07:58.669583',1,4,25),(9,'2025-06-28 22:26:20.131945','2025-06-29 23:08:31.290292',1,4,26),(10,'2025-06-28 22:26:37.692087',NULL,1,NULL,27),(11,'2025-06-28 22:26:56.780871',NULL,1,NULL,28),(12,'2025-06-28 22:28:03.692865',NULL,1,NULL,33),(13,'2025-06-28 22:40:28.965836',NULL,1,NULL,34),(14,'2025-06-28 22:42:49.151232',NULL,1,NULL,35),(15,'2025-06-28 22:46:24.143724',NULL,1,NULL,36),(16,'2025-06-28 22:46:42.116235',NULL,1,NULL,37),(17,'2025-06-28 22:47:01.092908',NULL,1,NULL,38),(18,'2025-06-28 22:47:14.965405',NULL,1,NULL,39),(19,'2025-06-28 22:47:31.043648',NULL,1,NULL,40),(20,'2025-06-28 22:48:01.657599',NULL,1,NULL,41),(21,'2025-06-28 22:48:43.966701',NULL,1,NULL,45),(22,'2025-06-28 22:49:02.126157',NULL,1,NULL,46),(23,'2025-06-28 22:52:57.879732',NULL,1,NULL,47),(24,'2025-06-28 22:53:20.745343',NULL,1,NULL,48),(25,'2025-06-28 22:53:44.541115',NULL,1,NULL,49),(26,'2025-06-28 22:53:58.174870',NULL,1,NULL,50),(27,'2025-06-28 22:54:11.170621',NULL,1,NULL,51),(28,'2025-06-28 22:54:25.569146',NULL,1,NULL,52),(29,'2025-06-28 22:54:41.159010',NULL,1,NULL,53),(30,'2025-06-28 22:54:56.751048',NULL,1,NULL,54),(31,'2025-06-28 23:18:00.478345',NULL,3,NULL,19),(32,'2025-06-28 23:18:31.646654',NULL,3,NULL,20),(33,'2025-06-29 23:10:50.656153','2025-06-29 23:11:43.532248',1,2,32);
/*!40000 ALTER TABLE `registro_permanencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(100) NOT NULL,
  `codigo_acceso` varchar(100) NOT NULL,
  `cod_inst` varchar(100) NOT NULL,
  `dni` varchar(100) NOT NULL,
  `email_inst` varchar(150) NOT NULL,
  `estado` enum('ACTIVO','INACTIVO') DEFAULT NULL,
  `nombres` varchar(100) NOT NULL,
  `rol` enum('ADMINISTRATIVO','ALUMNO','DOCENTE','LIMPIEZA','SEGURIDAD') DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UKgja9frumlj6w4vy7b1s84u2kc` (`codigo_acceso`),
  UNIQUE KEY `UKcghbg1obs9t55e1rxpilwe3d2` (`cod_inst`),
  UNIQUE KEY `UKf2ml6gme51rh5qotawpd7101m` (`email_inst`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (19,'Ramirez','A!2bC#4dE5','D20230001','12345678','l.ramirez@instituto.edu','ACTIVO','Luis','DOCENTE',0),(20,'Pérez','X@9zL!8pQ5','D20230002','23456789','s.perez@instituto.edu','ACTIVO','Sofía','DOCENTE',0),(21,'Gómez','Q$7wT*3kP1','D20230003','34567890','c.gomez@instituto.edu','ACTIVO','Carlos','DOCENTE',0),(22,'Salazar','M&2hY@9zL3','D20230004','45678901','l.salazar@instituto.edu','ACTIVO','Laura','DOCENTE',0),(23,'Cruz','R!4eP#6mN8','D20230005','56789012','m.cruz@instituto.edu','ACTIVO','Mario','DOCENTE',0),(24,'Vargas','V*1jK@5sX9','D20230006','67890123','p.vargas@instituto.edu','ACTIVO','Paola','DOCENTE',0),(25,'Ríos','Z!3mQ#8rL4','D20230007','78901234','j.rios@instituto.edu','ACTIVO','Jorge','DOCENTE',0),(26,'Chávez','K@9wT$5vM2','D20230008','89012345','d.chavez@instituto.edu','ACTIVO','Diana','DOCENTE',0),(27,'Torres','P#2sL!8kV5','D20230009','90123456','r.torres@instituto.edu','ACTIVO','Ricardo','DOCENTE',0),(28,'Fernandez','Q!rT5@xZ7*','D20230010','85296374','m.fernandez@instituto.edu','ACTIVO','María','DOCENTE',0),(29,'Gomez','doc123!@#','D20230011','40404040','sofia.gomez@instituto.edu','INACTIVO','Sofia','DOCENTE',0),(30,'Ruiz','doc456!@#','D20230012','50505050','miguel.ruiz@instituto.edu','INACTIVO','Miguel','DOCENTE',0),(31,'Sánchez','doc789!@#','D20230013','60606060','carla.sanchez@instituto.edu','INACTIVO','Carla','DOCENTE',0),(32,'Morales','A*5bX!7dC2','E20230001','11112222','a.morales@instituto.edu','ACTIVO','Andrea','ALUMNO',0),(33,'Sánchez','F@9mT#2vP4','E20230002','22223333','d.sanchez@instituto.edu','ACTIVO','David','ALUMNO',0),(34,'Herrera','Q!4zX$7nL5','E20230003','33334444','c.herrera@instituto.edu','ACTIVO','Camila','ALUMNO',0),(35,'Mendoza','S*1kP@6vW9','E20230004','44445555','j.mendoza@instituto.edu','ACTIVO','José','ALUMNO',0),(36,'Ruiz','X#3mL!2pT8','E20230005','55556666','v.ruiz@instituto.edu','ACTIVO','Valeria','ALUMNO',0),(37,'Castro','N@7wQ$5sK2','E20230006','66667777','m.castro@instituto.edu','ACTIVO','Martín','ALUMNO',0),(38,'Silva','R!5eT#3vL9','E20230007','77778888','l.silva@instituto.edu','ACTIVO','Lucía','ALUMNO',0),(39,'Cárdenas','B*2pX!9dM4','E20230008','88889999','g.cardenas@instituto.edu','ACTIVO','Gustavo','ALUMNO',0),(40,'Ortega','L@8mT#4vQ1','E20230009','99990000','n.ortega@instituto.edu','ACTIVO','Natalia','ALUMNO',0),(41,'Vega','T#9sK!5pW2','E20230010','10101010','s.vega@instituto.edu','ACTIVO','Sebastián','ALUMNO',0),(42,'Fernandez','alum123!@#','E20230011','10101010','luis.fernandez@instituto.edu','INACTIVO','Luis','ALUMNO',0),(43,'Castro','alum456!@#','E20230012','20202020','ana.castro@instituto.edu','INACTIVO','Ana','ALUMNO',0),(44,'Lopez','alum789!@#','E20230013','30303030','jose.lopez@instituto.edu','INACTIVO','José','ALUMNO',0),(45,'Flores','M@4bX#7vP9','A20230001','12121212','p.flores@instituto.edu','ACTIVO','Patricia','ADMINISTRATIVO',0),(46,'Lopez','C*2pT!5dL7','A20230002','23232323','s.lopez@instituto.edu','ACTIVO','Santiago','ADMINISTRATIVO',0),(47,'Ibáñez','Z!3mP#9vK2','A20230003','34343434','g.ibanez@instituto.edu','ACTIVO','Gabriela','ADMINISTRATIVO',0),(48,'Luna','H@7wX$5pT1','A20230004','45454545','f.luna@instituto.edu','ACTIVO','Felipe','ADMINISTRATIVO',0),(49,'Paredes','K#5sL!3pW9','A20230005','56565656','i.paredes@instituto.edu','ACTIVO','Isabel','ADMINISTRATIVO',0),(50,'Meza','F*1pX!7dL3','A20230006','67676767','o.meza@instituto.edu','ACTIVO','Óscar','ADMINISTRATIVO',0),(51,'Quispe','V@9mT#2pQ4','A20230007','78787878','d.quispe@instituto.edu','ACTIVO','Daniela','ADMINISTRATIVO',0),(52,'Alvarez','Y!4zX$7nP5','A20230008','89898989','r.alvarez@instituto.edu','ACTIVO','Renato','ADMINISTRATIVO',0),(53,'Barrios','N#3mP!8vK2','A20230009','90909090','c.barrios@instituto.edu','ACTIVO','Cecilia','ADMINISTRATIVO',0),(54,'Santos','P@7wX$5pL1','A20230010','11223344','h.santos@instituto.edu','ACTIVO','Hugo','ADMINISTRATIVO',0),(55,'Morales','adm123!@#','AD20230011','70707070','javier.morales@instituto.edu','INACTIVO','Javier','ADMINISTRATIVO',0),(56,'Vargas','adm456!@#','AD20230012','80808080','lucia.vargas@instituto.edu','INACTIVO','Lucia','ADMINISTRATIVO',0),(57,'Salas','adm789!@#','AD20230013','90909090','oscar.salas@instituto.edu','INACTIVO','Oscar','ADMINISTRATIVO',0);
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

-- Dump completed on 2026-05-04 22:47:42
