-- phpMyAdmin SQL Dump
-- version 3.5.8.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 18, 2016 at 12:15 AM
-- Server version: 5.5.37-log
-- PHP Version: 5.3.28

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `worawaluns_droid`
--

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE IF NOT EXISTS `Customer` (
  `CustomerID` int(5) NOT NULL AUTO_INCREMENT,
  `CustomerEmail` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `CustomerPic` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `CustomerUsername` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `CustomerPassword` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `CustomerFullname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `CustomerTel` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `CustomerStatus` int(1) NOT NULL COMMENT '1 คนธรรมดา 2 แอดมิน',
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=22 ;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`CustomerID`, `CustomerEmail`, `CustomerPic`, `CustomerUsername`, `CustomerPassword`, `CustomerFullname`, `CustomerTel`, `CustomerStatus`) VALUES
(1, 'admin@hotmail.com', '', 'admin', '12345', 'Aukkaraya Buranajunyakul', '0848890989', 2),
(2, 'arin@hotmail.com', '', 'a', '12345', 'Arin Jungiiz', '0988900987', 1),
(3, 'eeeee', 'img/Screen Shot 2016-12-17 at 1.34.08 PM.png', 'dddtest', '444444', 'test', '0000000000', 1),
(4, 'nansuju@hotmail.com', '', 'nansuju', '123456', 'Supalak Changkwian', '0899877654', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Menu`
--

CREATE TABLE IF NOT EXISTS `Menu` (
  `MenuID` int(10) NOT NULL AUTO_INCREMENT,
  `MenuPic` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MenuName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `MenuPrice` int(5) NOT NULL,
  `MenuDescription` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MenuCal` int(5) NOT NULL,
  PRIMARY KEY (`MenuID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=26 ;

--
-- Dumping data for table `Menu`
--

INSERT INTO `Menu` (`MenuID`, `MenuPic`, `MenuName`, `MenuPrice`, `MenuDescription`, `MenuCal`) VALUES
(1, 'https://images.pexels.com/photos/134574/pexels-photo-134574.jpeg?w=940&h=650&auto=compress&cs=tinysrgb', 'Strawberry Low fat pudding', 89, 'พุดดิ้ง สตรอเบอรรี่ มากับความเข้มข้นกับสตรอเบอรรี่เต็มๆ อร่อยและที่สำคัญไม่อ้วนด้วยนะ', 220),
(2, 'https://s-media-cache-ak0.pinimg.com/564x/ba/bf/93/babf938cc0e63dbf36e9abad4dcd13fe.jpg', 'Strawberry Choco cake', 99, 'ช็อกโกแลตเค้กเนื้อเนียนนุ่ม สอดใส้ด้วยสตอเบอรี่สด และราดด้วยซอสช็อกโกแลตสูตรพิเศษของทางร้านเราที่ทำมาจากช็อกโกแลตแคลอรี่ต่ำ ตกแต่งด้วยสตอเบอรี่ลูกโต', 350),
(3, 'https://s-media-cache-ak0.pinimg.com/564x/a1/3b/8f/a13b8f49609530b1770a0b7f1015a555.jpg', 'Giant Donut Cake', 79, 'โดนัทเนื้อนุ่มสอดไส้ครีมสตอเบอรี่ ราดด้วยครีมสตอเบอรี่หวานน้อยสูตรเด็ดจากทางร้าน โรยด้วยเกล็ดน้ำตาลไอซิง', 200),
(4, 'https://s-media-cache-ak0.pinimg.com/564x/b2/92/d9/b292d9925135952aa44e74b2d17305f2.jpg', 'Role strawberry Cake', 79, 'โรลเค้กสตอเบอรี่ครีมนมสด สอดไส้แยมและเนื้อครีมสดจากสตอเบอรี่แท้ เนื้อครีมหวานน้อยและแคลอรี่ต่ำ ตกแต่งด้วยสตอเบอรี่สด', 260),
(5, 'https://s-media-cache-ak0.pinimg.com/564x/19/74/e8/1974e80b8321328613283423ca8a0e8e.jpg', 'Blueberry Chessecake', 89, 'บลูเบอรี่ชีสเค้ก สูตรพิเศษจากทางร้าน เอาใจคนรักชีสและบลุเบอรี่ ด้วยเนื้อเค้กที่นุ่มละมุนลิ้น และ ซอสบลูเบอรี่ที่หวานอมเปรี้ยวที่อร่อยเข้ากันอย่างลงตัว', 240),
(6, 'https://s-media-cache-ak0.pinimg.com/564x/b9/2d/f8/b92df8d4554207c81780c1b5ca6ea8bd.jpg', 'Matcha Chantilly Cakes', 89, 'เนื้อเค้กจากชาเขียวแท้ ส่งตรงจากญี่ปุ่นให้รสชาตที่อ่อนละมุนนุ่มลิ้น สอดไส้ด้วยราสเบอรี่ให้ความหวานซ่อนเปรี้ยวที่ลงตัว', 290),
(7, 'https://s-media-cache-ak0.pinimg.com/564x/a0/31/e1/a031e122582a686e7f903a0944075eb7.jpg', 'Cheesecake Pops', 59, 'ชีสเค้กป๊อบ อร่อยพอดีคำ กับเนื้อเค้กที่นุ่มละมุดผสมเนื้อสตอเบอรี่และครีมนมสด', 140),
(8, 'https://s-media-cache-ak0.pinimg.com/564x/e7/07/49/e70749634382576415721ca9fa5f1e66.jpg', 'Birthday Cheesecake', 79, 'เค้กนมสดสีพลาสเทล เอาใจสาวหวาน ครีมนมสดเนื้อละเอียดพร้อมละลายในปาก และ สีสันน่ารักๆ จากเนื้อเค้ก ที่ได้มาจากสีของผลไม้สด', 260),
(9, 'https://s-media-cache-ak0.pinimg.com/564x/42/87/4e/42874ee6fd64afdec4e0652f2d326164.jpg', 'Blueberry Creme', 79, 'บลูเบอรี่ชีสเค้ก เนื้อเค้กทำจากบลูเบอรี่เข้มข้น ราดด้วยซอสโยเกิร์ต สีสันสวยงามและมีประโยชน์สุด ๆ จากคุณประโยชน์ของบลูเบอรี่', 230),
(10, 'https://s-media-cache-ak0.pinimg.com/564x/36/9e/ba/369eba943c96cf7dfbf5dd5d97206f33.jpg', 'mini cake', 69, 'มินิเค้กสตอเบอรี่ เนื้อเค้กทำจากเนื้อสตอเบอรี่และตกแต่งด้วยครีมนมสด โรยด้วยสตอเบอรี่สดผลโต', 210),
(14, 'img/Screen Shot 2016-12-17 at 1.34.08 PM.png', 'สวัสดีจ้าา', 43534, 'หกดวกหมดสกหวมดวกหสมด', 213);

-- --------------------------------------------------------

--
-- Table structure for table `Orders`
--

CREATE TABLE IF NOT EXISTS `Orders` (
  `OrdersID` int(11) NOT NULL AUTO_INCREMENT,
  `OrdersDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `OrdersTotal` int(6) NOT NULL,
  `CustomerID` int(5) NOT NULL,
  `OrdersStatus` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`OrdersID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Orders`
--

INSERT INTO `Orders` (`OrdersID`, `OrdersDate`, `OrdersTotal`, `CustomerID`, `OrdersStatus`) VALUES
(1, '2016-12-17 16:06:30', 150, 1, 'Processing'),
(2, '2016-12-17 16:06:34', 500, 2, 'Processing');

-- --------------------------------------------------------

--
-- Table structure for table `OrdersDetail`
--

CREATE TABLE IF NOT EXISTS `OrdersDetail` (
  `OdetailID` int(5) NOT NULL AUTO_INCREMENT,
  `MenuName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `OdetailAmount` int(5) NOT NULL,
  `OdetailPrice` int(5) NOT NULL,
  `OdetailTotal` int(6) NOT NULL,
  `OrdersID` int(11) NOT NULL,
  PRIMARY KEY (`OdetailID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `OrdersDetail`
--

INSERT INTO `OrdersDetail` (`OdetailID`, `MenuName`, `OdetailAmount`, `OdetailPrice`, `OdetailTotal`, `OrdersID`) VALUES
(2, 'Coke', 1, 25, 25, 1),
(3, 'Orange', 2, 25, 75, 1),
(4, 'Uniqo', 1, 300, 300, 2),
(5, 'Chapx', 2, 100, 200, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
