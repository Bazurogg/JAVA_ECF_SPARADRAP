-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           8.0.39 - MySQL Community Server - GPL
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Listage de la structure de la base pour sparadrap
CREATE DATABASE IF NOT EXISTS `sparadrap` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sparadrap`;

-- Listage de la structure de table sparadrap. customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int NOT NULL,
  `cu_firstname` varchar(50) NOT NULL DEFAULT '',
  `cu_lastname` varchar(50) NOT NULL DEFAULT '',
  `cu_address` varchar(150) NOT NULL DEFAULT '',
  `cu_postalCode` varchar(30) NOT NULL DEFAULT '',
  `cu_city` varchar(150) NOT NULL DEFAULT '',
  `cu_phoneNumber` varchar(70) NOT NULL DEFAULT '',
  `cu_email` varchar(150) NOT NULL DEFAULT '',
  `cu_birthDate` date NOT NULL,
  `cu_socialSecurityNumber` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `cu_email` (`cu_email`),
  UNIQUE KEY `cu_socialSecurityNumber` (`cu_socialSecurityNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table sparadrap. doctor
CREATE TABLE IF NOT EXISTS `doctor` (
  `doctor_id` int NOT NULL,
  `doc_firstname` varchar(50) NOT NULL DEFAULT '',
  `doc_lastname` varchar(50) NOT NULL DEFAULT '',
  `doc_address` varchar(150) NOT NULL DEFAULT '',
  `doc_postalCode` varchar(30) NOT NULL DEFAULT '',
  `doc_city` varchar(150) NOT NULL DEFAULT '',
  `doc_phoneNumber` varchar(150) NOT NULL DEFAULT '',
  `doc_email` varchar(150) NOT NULL DEFAULT '',
  `doc_agreementId` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`doctor_id`),
  UNIQUE KEY `doc_email` (`doc_email`),
  UNIQUE KEY `doc_agreementId` (`doc_agreementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table sparadrap. specialist
CREATE TABLE IF NOT EXISTS `specialist` (
  `specialist_id` int NOT NULL,
  `spe_firstname` varchar(50) NOT NULL DEFAULT '',
  `spe_lastname` varchar(50) NOT NULL DEFAULT '',
  `spe_address` varchar(150) NOT NULL DEFAULT '',
  `spe_postalCode` varchar(30) NOT NULL DEFAULT '',
  `spe_city` varchar(150) NOT NULL DEFAULT '',
  `spe_phoneNumber` varchar(150) NOT NULL DEFAULT '',
  `spe_email` varchar(150) NOT NULL DEFAULT '',
  `spe_speciality` varchar(150) NOT NULL DEFAULT '',
  PRIMARY KEY (`specialist_id`),
  UNIQUE KEY `spe_email` (`spe_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Les données exportées n'étaient pas sélectionnées.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
