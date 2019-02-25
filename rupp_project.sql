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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dumping data for table rupp_project.books: ~2 rows (approximately)
DELETE FROM `books`;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`id`, `isbn`, `title`, `image`, `publisher`, `publishedYear`, `qty`, `numBorrow`, `bookInStock`, `price`, `author`, `edition`, `status`) VALUES
	(14, '001', 'Book Gif', '2019_Feb_25_09_41_54book.gif', '0', 0, 122, 3, 119, 12.21, 'ny', 3, 0),
	(16, '0021', 'Screenshort testing', '2019_Feb_26_12_21_53ajaxupdate.PNG', '0', 0, 21, 0, 2, 2.11, 'nana ny', 4, 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table rupp_project.borrows: ~2 rows (approximately)
DELETE FROM `borrows`;
/*!40000 ALTER TABLE `borrows` DISABLE KEYS */;
INSERT INTO `borrows` (`id`, `student_id`, `studentName`, `studentCurrentPhone`, `book_id`, `bookISBN`, `borrowQTY`, `borrowedDate`, `returnDate`, `overDays`, `fine`, `status_removed`) VALUES
	(27, '001', 'ny', '09876543', 14, '14', 2, 'Feb-25-2019', 'Feb-25-2019', 0, 0, 1),
	(28, '002', 'siekny', '098765432', 14, '14', 3, 'Feb-25-2019', '0', 0, 0, 1);
/*!40000 ALTER TABLE `borrows` ENABLE KEYS */;

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
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `fullname`, `username`, `password`, `sex`, `address`, `email`, `phone`, `dateofbirth`, `dateofmembership`, `status`) VALUES
	(1, 'five remji', 'Sword', '123', 'M', 'Phnom Penh', 'fiveremji@gmail.com', '012121212', '01-01-2000', '20-12-2000', 1),
	(2, 'leng', 'Akame', '123', 'M', 'Phnom Penh', 'leng@gmail.com', '012121212', '01-01-2000', '12-12-1999', 1),
	(3, 'lenge', 'BoyBoy', '123', 'M', 'Phnom Penh', 'leng@gmail.com', '012121212', '01-01-2000', '10-10-2010', 2),
	(4, 'abc', 'Abcmaan', '123', 'F', 'Phnom Penh', 'abc@yahoo.com', '012345678', '11-11-1991', '11-11-2011', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table rupp_project.users_info
CREATE TABLE IF NOT EXISTS `users_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT '0',
  `date` varchar(50) DEFAULT '0',
  `action` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table rupp_project.users_info: 109 rows
DELETE FROM `users_info`;
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
	(11, 2, '24-02-2019 / 22:40', 'Log-Out'),
	(12, 4, '25-02-2019 / 20:45', 'Log-In'),
	(13, 4, '25-02-2019 / 20:45', 'Log-Out'),
	(14, 1, '25-02-2019 / 20:46', 'Log-In'),
	(15, 4, '25-02-2019 / 20:53', 'Log-In'),
	(16, 4, '25-02-2019 / 21:02', 'Log-In'),
	(17, 4, '25-02-2019 / 21:05', 'Log-In'),
	(18, 4, '25-02-2019 / 21:27', 'Log-Out'),
	(19, 1, '25-02-2019 / 21:27', 'Log-In'),
	(20, 1, '25-02-2019 / 21:29', 'Log-Out'),
	(21, 4, '25-02-2019 / 21:29', 'Log-In'),
	(22, 4, '25-02-2019 / 21:29', 'Log-Out'),
	(23, 1, '25-02-2019 / 21:30', 'Log-In'),
	(24, 1, '25-02-2019 / 21:30', 'Log-Out'),
	(25, 4, '25-02-2019 / 21:30', 'Log-In'),
	(26, 4, '25-02-2019 / 21:30', 'Log-Out'),
	(27, 1, '25-02-2019 / 21:30', 'Log-In'),
	(28, 1, '25-02-2019 / 21:30', 'Log-Out'),
	(29, 4, '25-02-2019 / 21:30', 'Log-In'),
	(30, 1, '25-02-2019 / 21:35', 'Log-In'),
	(31, 4, '25-02-2019 / 21:38', 'Log-In'),
	(32, 4, '25-02-2019 / 21:40', 'Log-In'),
	(33, 4, '25-02-2019 / 21:40', 'Log-Out'),
	(34, 1, '25-02-2019 / 21:40', 'Log-In'),
	(35, 4, '25-02-2019 / 21:49', 'Log-In'),
	(36, 4, '25-02-2019 / 21:50', 'Log-In'),
	(37, 4, '25-02-2019 / 21:58', 'Log-In'),
	(38, 4, '25-02-2019 / 21:58', 'Log-Out'),
	(39, 4, '25-02-2019 / 22:01', 'Log-In'),
	(40, 4, '25-02-2019 / 22:03', 'Log-In'),
	(41, 4, '25-02-2019 / 22:04', 'Log-In'),
	(42, 4, '25-02-2019 / 22:07', 'Log-In'),
	(43, 4, '25-02-2019 / 22:08', 'Log-In'),
	(44, 4, '25-02-2019 / 22:08', 'Log-Out'),
	(45, 4, '25-02-2019 / 22:09', 'Log-In'),
	(46, 4, '25-02-2019 / 22:09', 'Log-Out'),
	(47, 4, '25-02-2019 / 22:10', 'Log-In'),
	(48, 4, '25-02-2019 / 22:10', 'Log-Out'),
	(49, 4, '25-02-2019 / 22:14', 'Log-In'),
	(50, 4, '25-02-2019 / 22:14', 'Log-Out'),
	(51, 4, '25-02-2019 / 22:15', 'Log-In'),
	(52, 4, '25-02-2019 / 22:15', 'Log-Out'),
	(53, 1, '25-02-2019 / 22:16', 'Log-In'),
	(54, 1, '25-02-2019 / 22:17', 'Log-Out'),
	(55, 1, '25-02-2019 / 22:17', 'Log-In'),
	(56, 1, '25-02-2019 / 22:18', 'Log-In'),
	(57, 1, '25-02-2019 / 22:18', 'Log-Out'),
	(58, 4, '25-02-2019 / 22:18', 'Log-In'),
	(59, 4, '25-02-2019 / 22:18', 'Log-Out'),
	(60, 4, '25-02-2019 / 22:18', 'Log-In'),
	(61, 4, '25-02-2019 / 22:21', 'Log-In'),
	(62, 4, '25-02-2019 / 22:21', 'Log-Out'),
	(63, 4, '25-02-2019 / 22:21', 'Log-In'),
	(64, 4, '25-02-2019 / 22:21', 'Log-Out'),
	(65, 4, '25-02-2019 / 22:30', 'Log-In'),
	(66, 4, '25-02-2019 / 22:33', 'Log-Out'),
	(67, 1, '25-02-2019 / 22:33', 'Log-In'),
	(68, 1, '25-02-2019 / 22:35', 'Log-Out'),
	(69, 1, '25-02-2019 / 22:35', 'Log-In'),
	(70, 4, '25-02-2019 / 22:39', 'Log-In'),
	(71, 4, '25-02-2019 / 22:39', 'Log-Out'),
	(72, 1, '25-02-2019 / 22:39', 'Log-In'),
	(73, 1, '25-02-2019 / 22:40', 'Log-Out'),
	(74, 4, '25-02-2019 / 22:43', 'Log-In'),
	(75, 4, '25-02-2019 / 22:59', 'Log-In'),
	(76, 4, '25-02-2019 / 23:02', 'Log-Out'),
	(77, 4, '25-02-2019 / 23:11', 'Log-In'),
	(78, 4, '25-02-2019 / 23:12', 'Log-In'),
	(79, 4, '25-02-2019 / 23:13', 'Log-In'),
	(80, 4, '25-02-2019 / 23:13', 'Log-Out'),
	(81, 1, '25-02-2019 / 23:14', 'Log-In'),
	(82, 1, '25-02-2019 / 23:15', 'Log-In'),
	(83, 1, '25-02-2019 / 23:17', 'Log-In'),
	(84, 4, '25-02-2019 / 23:18', 'Log-In'),
	(85, 4, '25-02-2019 / 23:19', 'Log-Out'),
	(86, 1, '25-02-2019 / 23:19', 'Log-In'),
	(87, 4, '25-02-2019 / 23:21', 'Log-In'),
	(88, 4, '25-02-2019 / 23:21', 'Log-Out'),
	(89, 4, '25-02-2019 / 23:22', 'Log-In'),
	(90, 4, '25-02-2019 / 23:23', 'Log-In'),
	(91, 4, '25-02-2019 / 23:24', 'Log-Out'),
	(92, 1, '25-02-2019 / 23:24', 'Log-In'),
	(93, 1, '25-02-2019 / 23:24', 'Log-Out'),
	(94, 1, '25-02-2019 / 23:26', 'Log-In'),
	(95, 1, '25-02-2019 / 23:27', 'Log-In'),
	(96, 1, '25-02-2019 / 23:28', 'Log-In'),
	(97, 1, '25-02-2019 / 23:29', 'Log-In'),
	(98, 4, '25-02-2019 / 23:30', 'Log-In'),
	(99, 4, '25-02-2019 / 23:30', 'Log-In'),
	(100, 4, '25-02-2019 / 23:31', 'Log-Out'),
	(101, 1, '25-02-2019 / 23:31', 'Log-In'),
	(102, 4, '25-02-2019 / 23:31', 'Log-In'),
	(103, 4, '25-02-2019 / 23:32', 'Log-Out'),
	(104, 4, '25-02-2019 / 23:40', 'Log-In'),
	(105, 4, '25-02-2019 / 23:40', 'Log-Out'),
	(106, 1, '25-02-2019 / 23:40', 'Log-In'),
	(107, 1, '25-02-2019 / 23:42', 'Log-In'),
	(108, 1, '25-02-2019 / 23:46', 'Log-In'),
	(109, 1, '26-02-2019 / 00:19', 'Log-In');
/*!40000 ALTER TABLE `users_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
