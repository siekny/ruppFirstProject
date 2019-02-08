-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.36-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for rupp_database
CREATE DATABASE IF NOT EXISTS `rupp_database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rupp_database`;

-- Dumping structure for table rupp_database.food
CREATE TABLE IF NOT EXISTS `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foodID` varchar(50) DEFAULT '0',
  `name` varchar(50) DEFAULT '0',
  `price` double DEFAULT '0',
  `category` varchar(50) DEFAULT '0',
  `image` varchar(255) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Dumping data for table rupp_database.food: ~3 rows (approximately)
DELETE FROM `food`;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` (`id`, `foodID`, `name`, `price`, `category`, `image`) VALUES
	(14, '001', 'Yummy Food', 21.34, 'Food', '2019_Feb_08_08_19_581.jpg'),
	(16, '002', 'Coca cola', 0.8, 'Drink', '2019_Feb_08_10_11_532.jpg'),
	(17, '003', 'Khmer Food', 12.45, 'Food', '2019_Feb_08_09_42_481.jpg');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;

-- Dumping structure for table rupp_database.tables
CREATE TABLE IF NOT EXISTS `tables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tableID` varchar(50) DEFAULT '0',
  `numSeats` int(11) DEFAULT '0',
  `status` tinyint(1) DEFAULT '0',
  `createdBy` varchar(50) DEFAULT '0',
  `createdAt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- Dumping data for table rupp_database.tables: ~2 rows (approximately)
DELETE FROM `tables`;
/*!40000 ALTER TABLE `tables` DISABLE KEYS */;
INSERT INTO `tables` (`id`, `tableID`, `numSeats`, `status`, `createdBy`, `createdAt`) VALUES
	(18, '0005', 2, 1, 'Siekny', 'Feb 03, 2019'),
	(21, '0009', 8, 1, 'Siekny', 'Feb 05, 2019');
/*!40000 ALTER TABLE `tables` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
