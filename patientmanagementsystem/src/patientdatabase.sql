-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 20, 2019 at 05:08 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `patientdatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `id` char(11) NOT NULL,
  `name` char(255) NOT NULL,
  `address` char(255) NOT NULL,
  `doa` char(255) NOT NULL,
  `injury` char(255) NOT NULL,
  `doctor` char(255) NOT NULL,
  `medicalprocedures` char(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`id`, `name`, `address`, `doa`, `injury`, `doctor`, `medicalprocedures`) VALUES
('1', 'Seppo Kivinen', 'Kissalankuja 4, 20540 Turku', '11.1.2019', 'Broken spine', 'Jarmo Ahomansikka', 'Surgery'),
('2', 'Hilla Virtanen', 'Hillankuja 5a 20540 Turku', '17.1.2019', 'Appendictis', 'John Johnson', 'Surgery');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
