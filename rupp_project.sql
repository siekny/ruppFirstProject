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


-- Dumping database structure for rupp_project
CREATE DATABASE IF NOT EXISTS `rupp_project` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rupp_project`;

-- Dumping structure for table rupp_project.books
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(50) DEFAULT '0',
  `title` varchar(50) DEFAULT '0',
  `image` varchar(200) DEFAULT '0',
  `publisher` varchar(50) DEFAULT '0',
  `publishedYear` int(6) DEFAULT '0',
  `qty` int(10) DEFAULT '0',
  `numBorrow` int(10) DEFAULT '0',
  `bookInStock` int(10) DEFAULT '0',
  `price` double DEFAULT '0',
  `author` varchar(50) DEFAULT '0',
  `edition` int(5) DEFAULT '0',
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table rupp_project.books: ~2 rows (approximately)
DELETE FROM `books`;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`id`, `isbn`, `title`, `image`, `publisher`, `publishedYear`, `qty`, `numBorrow`, `bookInStock`, `price`, `author`, `edition`, `status`) VALUES
	(1, '001', 'Harry Potter', 'harry-porter.jpg', 'Ny', 2017, 10, 0, 0, 12.23, 'Ny', 2, 1),
	(2, '002', 'sleeping Beauty', 'sleeping-beauty.jpg', 'Ny', 2010, 23, 2, 0, 8.23, 'Ny', 3, 1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
