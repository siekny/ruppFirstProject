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
CREATE DATABASE IF NOT EXISTS `rupp_project` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `rupp_project`;

-- Dumping structure for table rupp_project.books
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(50) DEFAULT '0',
  `title` varchar(50) DEFAULT '0',
  `image` varchar(200) DEFAULT '0',
  `qty` int(10) DEFAULT '0',
  `numBorrow` int(10) DEFAULT '0',
  `bookInStock` int(10) DEFAULT '0',
  `price` double DEFAULT '0',
  `author` varchar(50) DEFAULT '0',
  `edition` int(5) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table rupp_project.books: ~2 rows (approximately)
DELETE FROM `books`;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`id`, `isbn`, `title`, `image`, `qty`, `numBorrow`, `bookInStock`, `price`, `author`, `edition`) VALUES
	(1, '001', 'Hary Portter', 'harry-porter.jpg', 10, 0, 10, 12.23, 'Ny', 2),
	(2, '002', 'sleeping Beauty', 'sleeping-beauty.jpg', 23, 0, 23, 8.23, 'Ny', 3);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;

-- Dumping structure for table rupp_project.borrows
CREATE TABLE IF NOT EXISTS `borrows` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(50) NOT NULL DEFAULT '0',
  `studentName` varchar(50) NOT NULL DEFAULT '0',
  `studentCurrentPhone` varchar(255) DEFAULT '0',
  `book_id` int(11) DEFAULT '0',
  `bookISBN` varchar(255) NOT NULL DEFAULT '0',
  `borrowQTY` tinyint(2) NOT NULL DEFAULT '0',
  `borrowedDate` varchar(50) DEFAULT '0',
  `returnDate` varchar(50) DEFAULT '0',
  `overDays` int(3) DEFAULT '0',
  `fine` int(11) DEFAULT '0',
  `status_removed` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table rupp_project.borrows: ~3 rows (approximately)
DELETE FROM `borrows`;
/*!40000 ALTER TABLE `borrows` DISABLE KEYS */;
INSERT INTO `borrows` (`id`, `student_id`, `studentName`, `studentCurrentPhone`, `book_id`, `bookISBN`, `borrowQTY`, `borrowedDate`, `returnDate`, `overDays`, `fine`, `status_removed`) VALUES
	(3, '1', 'siekny', '087654321', 1, '001', 3, 'Feb-19-2019\r\n', 'Feb-21-2019', 0, 0, 1),
	(20, '001', 'meny', '09876543', 2, '2', 1, 'Feb-21-2019', '0', 0, 0, 1),
	(22, '003', 'vatey', '09876532', 2, '2', 2, 'Feb-21-2019', '0', 0, 0, 1);
/*!40000 ALTER TABLE `borrows` ENABLE KEYS */;

-- Dumping structure for table rupp_project.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `dateofbirth` varchar(50) DEFAULT NULL,
  `typeofmembership` varchar(50) DEFAULT NULL,
  `dateofmembership` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table rupp_project.users: ~3 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `fullname`, `username`, `password`, `sex`, `address`, `email`, `phone`, `dateofbirth`, `typeofmembership`, `dateofmembership`, `status`) VALUES
	(1, 'LIM SOKDY', 'Sokdy', 'Sokdy', 'M', 'st.XXX', 'sokdylim@gmail.com', '012603890', '02-02-2000', 'Admin', '14-2-2019', 1),
	(6, 'Hello', 'hi', 'hi', 'f', 'jd', 'j', 'j', 'j', 'j', 'j', 2),
	(7, 'yo', 'yo', 'hello', 'y', 'o', 'y', 'o', 'o', 'yo', 'h', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
