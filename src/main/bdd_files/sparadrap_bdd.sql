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
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `cu_firstname` varchar(50) NOT NULL DEFAULT '',
  `cu_lastname` varchar(50) NOT NULL DEFAULT '',
  `cu_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `cu_postalCode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `cu_city` varchar(150) NOT NULL DEFAULT '',
  `cu_phoneNumber` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `cu_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `cu_birthDate` date NOT NULL,
  `cu_socialSecurityNumber` varchar(20) NOT NULL DEFAULT '',
  `doctor_id` int DEFAULT NULL,
  `healthInsurance_id` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `cu_email` (`cu_email`),
  UNIQUE KEY `cu_socialSecurityNumber` (`cu_socialSecurityNumber`),
  KEY `FK_customer_doctor` (`doctor_id`),
  KEY `FK_customer_health_insurance` (`healthInsurance_id`),
  CONSTRAINT `FK_customer_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`),
  CONSTRAINT `FK_customer_health_insurance` FOREIGN KEY (`healthInsurance_id`) REFERENCES `health_insurance` (`healthInsurance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sparadrap.customer : ~18 rows (environ)
INSERT INTO `customer` (`customer_id`, `cu_firstname`, `cu_lastname`, `cu_address`, `cu_postalCode`, `cu_city`, `cu_phoneNumber`, `cu_email`, `cu_birthDate`, `cu_socialSecurityNumber`, `doctor_id`, `healthInsurance_id`) VALUES
	(1, 'Alicia', 'DUPONT', '123 Rue de Paris', '75001', 'Paris', '0600000001', 'alice.dupont@mail.com', '1985-03-12', '1234567890123', NULL, NULL),
	(2, 'Bob', 'Martin', '456 Rue de Lyon', '69001', 'Lyon', '0600000002', 'bob.martin@mail.com', '1978-07-04', '9876543210987', NULL, NULL),
	(3, 'Charlotte', 'DURAND', '789 Avenue de Nice', '06000', 'Nice', '0600000003', 'clara.durand@mail.com', '1990-11-24', '1234598765432', NULL, NULL),
	(4, 'David', 'Moreau', '101 Boulevard Saint-Germain', '75005', 'Paris', '0600000004', 'david.moreau@mail.com', '1969-06-01', '9988776655443', NULL, NULL),
	(5, 'Eva', 'Lopez', '202 Rue de Bordeaux', '33000', 'Bordeaux', '0600000005', 'eva.lopez@mail.com', '1995-01-15', '1122334455667', NULL, NULL),
	(6, 'Fabrice', 'Garnier', '10 Rue des Fleurs', '75012', 'Paris', '0600000006', 'fabrice.garnier@mail.com', '1982-08-19', '9988771122334', NULL, NULL),
	(7, 'Géraldine', 'Roche', '35 Rue Victor Hugo', '13001', 'Marseille', '0600000007', 'geraldine.roche@mail.com', '1988-10-07', '1112223334445', NULL, NULL),
	(8, 'Henri', 'Lemoine', '50 Boulevard des Capucines', '34000', 'Montpellier', '0600000008', 'henri.lemoine@mail.com', '1970-12-29', '3334445556667', NULL, NULL),
	(9, 'Isabelle', 'Morin', '12 Rue de la Liberté', '44000', 'Nantes', '0600000009', 'isabelle.morin@mail.com', '1993-09-05', '7778889991112', NULL, NULL),
	(10, 'Julien', 'Bernard', '28 Rue Saint-Michel', '31000', 'Toulouse', '0600000010', 'julien.bernard@mail.com', '1984-04-22', '6665554443332', NULL, NULL),
	(11, 'Karine', 'Perrin', '78 Avenue Jean Jaurès', '67000', 'Strasbourg', '0600000011', 'karine.perrin@mail.com', '1976-11-18', '5556667778889', NULL, NULL),
	(12, 'Louis', 'Girard', '5 Rue Pasteur', '59000', 'Lille', '0600000012', 'louis.girard@mail.com', '1968-07-10', '4445556667773', NULL, NULL),
	(13, 'Marie', 'Leclerc', '90 Rue des Acacias', '76000', 'Rouen', '0600000013', 'marie.leclerc@mail.com', '1980-02-16', '3332221110004', NULL, NULL),
	(14, 'Nicolas', 'Fabre', '15 Boulevard des Anglais', '06300', 'Nice', '0600000014', 'nicolas.fabre@mail.com', '1992-05-30', '2221110009995', NULL, NULL),
	(15, 'Olivier', 'Renaud', '25 Rue des Pyrénées', '64000', 'Nancy', '0600000015', 'olivier.renaud@mail.com', '1987-06-25', '9998887776666', NULL, NULL),
	(22, 'Mathieu', 'HOUSE', '77 Pizza King Street', '54000', 'Laxou', '0637666776', 'm.house@testmail.com', '2000-08-04', '789456123789', NULL, NULL),
	(23, 'Fabien', 'THEBEST', '12 avenue de Colmar', '68200', 'Mulhouse', '0692422666', 'fabulous974@gmail.com', '1985-12-23', '123456798132', NULL, NULL),
	(24, 'test', 'CRUD', 'test adresse', '97438', 'testville', '0262530746', 'testmail@mail.fr', '1999-01-03', '12345678945613', NULL, NULL);

-- Listage de la structure de table sparadrap. direct_purchase
CREATE TABLE IF NOT EXISTS `direct_purchase` (
  `directPurchase_id` int NOT NULL,
  `dip_purchaseOrderId` varchar(150) NOT NULL DEFAULT '',
  `dip_date` datetime NOT NULL,
  `dip_totalPrice` double NOT NULL DEFAULT '0',
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`directPurchase_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sparadrap.direct_purchase : ~0 rows (environ)

-- Listage de la structure de table sparadrap. doctor
CREATE TABLE IF NOT EXISTS `doctor` (
  `doctor_id` int NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sparadrap.doctor : ~20 rows (environ)
INSERT INTO `doctor` (`doctor_id`, `doc_firstname`, `doc_lastname`, `doc_address`, `doc_postalCode`, `doc_city`, `doc_phoneNumber`, `doc_email`, `doc_agreementId`) VALUES
	(1, 'John', 'Doe', '123 Rue de Rivoli', '75001', 'Paris', '0600000001', 'john.doe@mail.com', 'AG1001'),
	(2, 'Jane', 'Smith', '12 Avenue des Champs-Élysées', '75008', 'Paris', '0600000002', 'jane.smith@mail.com', 'AG1002'),
	(3, 'Robert', 'Johnson', '45 Boulevard Haussmann', '75009', 'Paris', '0600000003', 'robert.johnson@mail.com', 'AG1003'),
	(4, 'Emily', 'Davis', '7 Rue de la Paix', '75002', 'Paris', '0600000004', 'emily.davis@mail.com', 'AG1004'),
	(5, 'Michael', 'Miller', '33 Quai de la Seine', '75019', 'Paris', '0600000005', 'michael.miller@mail.com', 'AG1005'),
	(6, 'Laura', 'Garcia', '88 Avenue de la République', '75011', 'Paris', '0600000006', 'laura.garcia@mail.com', 'AG1006'),
	(7, 'James', 'Martinez', '99 Rue de Rennes', '75006', 'Paris', '0600000007', 'james.martinez@mail.com', 'AG1007'),
	(8, 'Anna', 'Rodriguez', '15 Boulevard Saint-Michel', '75005', 'Paris', '0600000008', 'anna.rodriguez@mail.com', 'AG1008'),
	(9, 'David', 'Hernandez', '28 Rue du Faubourg Saint-Honoré', '75008', 'Paris', '0600000009', 'david.hernandez@mail.com', 'AG1009'),
	(10, 'Sarah', 'Lopez', '66 Avenue Victor Hugo', '75116', 'Paris', '0600000010', 'sarah.lopez@mail.com', 'AG1010'),
	(11, 'Matthew', 'Wilson', '37 Rue des Pyrénées', '75020', 'Paris', '0600000011', 'matthew.wilson@mail.com', 'AG1011'),
	(12, 'Olivia', 'Clark', '20 Rue de Belleville', '75019', 'Paris', '0600000012', 'olivia.clark@mail.com', 'AG1012'),
	(13, 'Daniel', 'Lewis', '5 Rue Saint-Dominique', '75007', 'Paris', '0600000013', 'daniel.lewis@mail.com', 'AG1013'),
	(14, 'Sophia', 'Lee', '43 Avenue de Wagram', '75017', 'Paris', '0600000014', 'sophia.lee@mail.com', 'AG1014'),
	(15, 'Christopher', 'Walker', '18 Rue du Commerce', '75015', 'Paris', '0600000015', 'christopher.walker@mail.com', 'AG1015'),
	(16, 'Isabella', 'Hall', '25 Rue de la Convention', '75015', 'Paris', '0600000016', 'isabella.hall@mail.com', 'AG1016'),
	(17, 'Andrew', 'Young', '11 Rue de Tolbiac', '75013', 'Paris', '0600000017', 'andrew.young@mail.com', 'AG1017'),
	(18, 'Charlotte', 'Allen', '76 Rue d\'Alésia', '75014', 'Paris', '0600000018', 'charlotte.allen@mail.com', 'AG1018'),
	(19, 'Joshua', 'King', '9 Rue Lamarck', '75018', 'Paris', '0600000019', 'joshua.king@mail.com', 'AG1019'),
	(20, 'Mia', 'Wright', '22 Boulevard de Strasbourg', '75010', 'Paris', '0600000020', 'mia.wright@mail.com', 'AG1020');

-- Listage de la structure de table sparadrap. health_insurance
CREATE TABLE IF NOT EXISTS `health_insurance` (
  `healthInsurance_id` int NOT NULL AUTO_INCREMENT,
  `hi_name` varchar(50) NOT NULL DEFAULT '',
  `hi_address` varchar(150) NOT NULL DEFAULT '',
  `hi_postalCode` varchar(30) NOT NULL DEFAULT '',
  `hi_department` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `hi_phoneNumber` varchar(150) NOT NULL DEFAULT '',
  `hi_email` varchar(150) NOT NULL DEFAULT '',
  `hi_coverageRate` decimal(5,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`healthInsurance_id`),
  UNIQUE KEY `hi_email` (`hi_email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sparadrap.health_insurance : ~20 rows (environ)
INSERT INTO `health_insurance` (`healthInsurance_id`, `hi_name`, `hi_address`, `hi_postalCode`, `hi_department`, `hi_phoneNumber`, `hi_email`, `hi_coverageRate`) VALUES
	(1, 'Assurance Santé Plus', '12 Rue de la Santé', '75001', 'Île-de-France', '0102030405', 'contact@assurancesanteplus.com', 90.00),
	(2, 'Mutuelle Familiale', '45 Boulevard Haussmann', '75009', 'Île-de-France', '0607080910', 'support@mutuellefamiliale.fr', 85.00),
	(3, 'Santé Privilège', '78 Avenue des Champs-Élysées', '75008', 'Île-de-France', '0203040506', 'contact@santeprivilege.fr', 95.00),
	(4, 'Mutuelle Générale', '22 Rue de la Paix', '69002', 'Auvergne-Rhône-Alpes', '0506070809', 'info@mutuellegenerale.fr', 80.00),
	(5, 'Assurance Vitale', '10 Place Bellecour', '69002', 'Auvergne-Rhône-Alpes', '0405060708', 'service@assurancevitale.com', 88.00),
	(6, 'Prévoyance Santé', '33 Rue de Rennes', '35000', 'Bretagne', '0708091011', 'contact@prevoyancesante.fr', 92.00),
	(7, 'Mutuelle Horizon', '99 Quai de la Fosse', '44000', 'Pays de la Loire', '0809101112', 'contact@mutuellehorizon.fr', 87.00),
	(8, 'SécuriSanté', '8 Rue Gambetta', '33000', 'Nouvelle-Aquitaine', '0910111213', 'service@securisante.fr', 75.00),
	(9, 'Mutuelle Océane', '15 Boulevard de la Mer', '56100', 'Bretagne', '1011121314', 'support@mutuelleoceane.fr', 89.00),
	(10, 'Assurance Soleil', '5 Avenue de Provence', '13001', 'Provence-Alpes-Côte d\'Azur', '1112131415', 'contact@assurancesoleil.fr', 93.00),
	(11, 'Mutuelle Azur', '18 Rue des Roses', '06000', 'Provence-Alpes-Côte d\'Azur', '1213141516', 'info@mutuelleazur.fr', 90.00),
	(12, 'Assurance Montagne', '72 Rue des Alpes', '74000', 'Auvergne-Rhône-Alpes', '1314151617', 'service@assurancemontagne.com', 88.00),
	(13, 'Prévoyance Médicale', '3 Place des Vosges', '57000', 'Grand Est', '1415161718', 'contact@prevoyancemedicale.fr', 80.00),
	(14, 'Mutuelle Santé Verte', '27 Rue de l\'Écologie', '34000', 'Occitanie', '1516171819', 'support@santeverte.fr', 91.00),
	(15, 'Sécurité Médicale', '50 Rue de la République', '69003', 'Auvergne-Rhône-Alpes', '1617181920', 'info@securitemedicale.fr', 85.00),
	(16, 'Santé Soleil', '6 Allée des Orangers', '83000', 'Provence-Alpes-Côte d\'Azur', '1718192021', 'contact@santesoleil.fr', 94.00),
	(17, 'Assurance Vitalité', '23 Rue des Lumières', '75004', 'Île-de-France', '1819202122', 'service@assurancevitalite.com', 88.00),
	(18, 'Mutuelle Tranquillité', '30 Rue du Repos', '31000', 'Occitanie', '1920212223', 'info@mutuelletranquillite.fr', 86.00),
	(19, 'Prévoyance Harmonie', '88 Avenue de la Concorde', '67000', 'Grand Est', '2021222324', 'support@prevoyanceharmonie.fr', 90.00),
	(20, 'Santé Équilibre', '12 Rue des Mimosas', '80000', 'Hauts-de-France', '2122232425', 'contact@santeequiilibre.fr', 87.00);

-- Listage de la structure de table sparadrap. medicine
CREATE TABLE IF NOT EXISTS `medicine` (
  `medicine_id` int NOT NULL,
  `med_category` enum('Y','N') NOT NULL,
  `med_name` varchar(150) NOT NULL DEFAULT '',
  `med_dateOnSale` date NOT NULL,
  `med_price` double NOT NULL DEFAULT '0',
  `med_quantity` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sparadrap.medicine : ~0 rows (environ)

-- Listage de la structure de table sparadrap. prescription_purchase
CREATE TABLE IF NOT EXISTS `prescription_purchase` (
  `prescriptionPurchase_id` int NOT NULL,
  `presp_purchaseOrderId` varchar(150) NOT NULL DEFAULT '',
  `presp_date` date NOT NULL,
  `presp_totalPrice` double NOT NULL DEFAULT '0',
  `presp_specialistIndication` text NOT NULL,
  `presp_medPosology` text NOT NULL,
  PRIMARY KEY (`prescriptionPurchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sparadrap.prescription_purchase : ~0 rows (environ)

-- Listage de la structure de table sparadrap. purchase_list
CREATE TABLE IF NOT EXISTS `purchase_list` (
  `directPurchase_id` int DEFAULT NULL,
  `prescriptionPurchase_id` int DEFAULT NULL,
  `medicine_id` int DEFAULT NULL,
  KEY `FK_purchase_list_direct_purchase` (`directPurchase_id`),
  KEY `FK_purchase_list_prescription_purchase` (`prescriptionPurchase_id`),
  KEY `FK_purchase_list_medicine` (`medicine_id`),
  CONSTRAINT `FK_purchase_list_direct_purchase` FOREIGN KEY (`directPurchase_id`) REFERENCES `direct_purchase` (`directPurchase_id`),
  CONSTRAINT `FK_purchase_list_medicine` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`medicine_id`),
  CONSTRAINT `FK_purchase_list_prescription_purchase` FOREIGN KEY (`prescriptionPurchase_id`) REFERENCES `prescription_purchase` (`prescriptionPurchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sparadrap.purchase_list : ~0 rows (environ)

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

-- Listage des données de la table sparadrap.specialist : ~0 rows (environ)

-- Listage de la structure de table sparadrap. specialist_list
CREATE TABLE IF NOT EXISTS `specialist_list` (
  `specialist_id` int DEFAULT NULL,
  `prescriptionPurchase_id` int DEFAULT NULL,
  KEY `FK_specialist_list_specialist` (`specialist_id`),
  KEY `FK_specialist_list_prescription_purchase` (`prescriptionPurchase_id`),
  CONSTRAINT `FK_specialist_list_prescription_purchase` FOREIGN KEY (`prescriptionPurchase_id`) REFERENCES `prescription_purchase` (`prescriptionPurchase_id`),
  CONSTRAINT `FK_specialist_list_specialist` FOREIGN KEY (`specialist_id`) REFERENCES `specialist` (`specialist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table sparadrap.specialist_list : ~0 rows (environ)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
