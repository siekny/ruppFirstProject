-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5288
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

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
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`id`, `isbn`, `title`, `image`, `publisher`, `publishedYear`, `qty`, `numBorrow`, `bookInStock`, `price`, `author`, `edition`, `status`) VALUES
	(1, '001', 'Hary Portter', 'harry-porter.jpg', 'Ny', 2017, 10, 0, 0, 12.23, 'Ny', 2, 1),
	(2, '002', 'sleeping Beauty', 'sleeping-beauty.jpg', 'Ny', 2010, 23, 0, 0, 8.23, 'Ny', 3, 1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;

-- Dumping structure for table rupp_project.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `dateofbirth` varchar(15) DEFAULT NULL,
  `dateofmembership` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table rupp_project.users: ~4 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `fullname`, `username`, `password`, `sex`, `address`, `email`, `phone`, `dateofbirth`, `dateofmembership`, `status`) VALUES
	(1, 'five remji', 'Sword', '123', 'M', 'Phnom Penh', 'fiveremji@gmail.com', '012121212', '01-01-2000', '20-12-2000', 1),
	(2, 'leng', 'Akame', '123', 'M', 'Phnom Penh', 'leng@gmail.com', '012121212', '01-01-2000', '12-12-1999', 1),
	(3, 'lenge', 'BoyBoy', '123', 'M', 'Phnom Penh', 'leng@gmail.com', '012121212', '01-01-2000', '10-10-2010', 2),
	(4, 'abc', 'Abcman', '123', 'F', 'Phnom Penh', 'abc@yahoo.com', '012345678', '11-11-1991', '11-11-2011', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table rupp_project.users_info
CREATE TABLE IF NOT EXISTS `users_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT '0',
  `date` varchar(50) DEFAULT '0',
  `action` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table rupp_project.users_info: 0 rows
/*!40000 ALTER TABLE `users_info` DISABLE KEYS */;
INSERT INTO `users_info` (`id`, `userid`, `date`, `action`) VALUES
	(1, 1, '24-02-2019 / 22:21', 'Log-In'),
	(2, 1, '24-02-2019 / 22:21', 'Log-Out'),
	(3, 1, '24-02-2019 / 22:27', 'Log-In'),
	(4, 1, '24-02-2019 / 22:27', 'Log-Out'),
	(5, 2, '24-02-2019 / 22:28', 'Log-In'),
	(6, 2, '24-02-2019 / 22:32', 'Log-In'),
	(7, 2, '24-02-2019 / 22:33', 'Log-Out'),
	(8, 1, '24-02-2019 / 22:38', 'Log-In'),
	(9, 1, '24-02-2019 / 22:38', 'Log-Out'),
	(10, 2, '24-02-2019 / 22:39', 'Log-In'),
	(11, 2, '24-02-2019 / 22:40', 'Log-Out');
/*!40000 ALTER TABLE `users_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
