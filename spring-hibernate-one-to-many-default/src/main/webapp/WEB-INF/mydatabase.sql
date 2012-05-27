-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 17, 2011 at 01:43 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mydatabase`
--

--
-- Dumping data for table `CREDIT_CARD`
--

INSERT INTO `CREDIT_CARD` (`ID`, `NUMBER`, `TYPE`) VALUES
(1, '5162 6060 9949 0150', 'MasterCard'),
(2, '4916 6904 4775 9328', 'Visa'),
(3, '5565 5022 2072 6872', 'MasterCard'),
(4, '4485 6328 4051 8159', 'Visa'),
(5, '5226 0970 9242 2313', 'MasterCard'),
(6, '5130 8051 3184 9683', 'MasterCard');

--
-- Dumping data for table `PERSON`
--

INSERT INTO `PERSON` (`ID`, `FIRST_NAME`, `LAST_NAME`, `MONEY`) VALUES
(1, 'Kevin', 'Lyons', 10000),
(2, 'Robert', 'Campbell', 20000),
(3, 'William', 'Chappell', 15000);

--
-- Dumping data for table `PERSON_CREDIT_CARD`
--

INSERT INTO `PERSON_CREDIT_CARD` (`PERSON_ID`, `creditCards_ID`) VALUES
(1, 1),
(2, 2),
(2, 3),
(3, 4),
(3, 5),
(3, 6);
