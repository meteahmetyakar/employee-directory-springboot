CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
    (1, 'Alan', 'Turing', 'alanturing@greentechsolutions.com'),
    (2, 'Grace', 'Hopper', 'gracehopper@innovatechlabs.org'),
    (3, 'Ada', 'Lovelace', 'adalovelace@agroadvances.net'),
    (4, 'John', 'von Neumann', 'johnvonneumann@smartfarmtools.com'),
    (5, 'Linus', 'Torvalds', 'linustorvalds@biotechcreations.co'),
    (6, 'Donald', 'Knuth', 'donaldknuth@futurefarmingsystems.org'),
    (7, 'Tim', 'Berners-Lee', 'timbernerslee@plantgenius.io'),
    (8, 'Margaret', 'Hamilton', 'margarethamilton@precisionagri.tech'),
    (9, 'Vint', 'Cerf', 'vintcerf@soilhealthsolutions.com'),
    (10, 'Steve', 'Wozniak', 'stevewozniak@cropinnovationlabs.com');

