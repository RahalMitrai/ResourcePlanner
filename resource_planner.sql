-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 26, 2019 at 12:39 AM
-- Server version: 5.7.25-0ubuntu0.18.04.2
-- PHP Version: 7.2.15-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rp_db1`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `title` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_attribute`
--

CREATE TABLE `employee_attribute` (
  `id` bigint(20) NOT NULL,
  `label` varchar(50) DEFAULT NULL,
  `default_value` varchar(1000) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_number`
--

CREATE TABLE `employee_number` (
  `employee_attribute_id` bigint(20) NOT NULL,
  `value` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_varchar`
--

CREATE TABLE `employee_varchar` (
  `employee_attribute_id` bigint(20) NOT NULL,
  `value` varchar(10000) DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id` bigint(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `ref_id` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `title`, `ref_id`) VALUES
(37, 'abc', '1c1b0130-f772-4e59-a3d4-e48a8fdf29a9'),
(39, 'abc', '28368ce3-359d-416d-9dd3-131a71ee1530'),
(40, 'abc', '78519160-d977-45d4-bdf2-fdcf243ce839'),
(41, 'abc', '4959002e-1540-407c-9a20-bdc397c6b5c2'),
(42, 'abc', 'ae7a9cae-69a4-4164-a828-e0c05a382ec9');

-- --------------------------------------------------------

--
-- Table structure for table `project_attribute`
--

CREATE TABLE `project_attribute` (
  `id` bigint(20) NOT NULL,
  `label` varchar(50) DEFAULT NULL,
  `default_value` varchar(1000) DEFAULT NULL,
  `data_type` varchar(50) DEFAULT NULL,
  `ref_id` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_attribute`
--

INSERT INTO `project_attribute` (`id`, `label`, `default_value`, `data_type`, `ref_id`) VALUES
(45, 'attribute', 'abfgtc', 'NUMBER', 'a4b180e7-428f-43c6-b27d-e033e21745c0'),
(46, 'attribute1', 'abfgtc', 'NUMBER', '62a1cfbd-7429-448d-a397-9fbd93a80a98'),
(48, 'email', 'defaupppop@gmail.com', 'VARCHAR', '58c39e47-986b-415b-89e9-a67a644dec73'),
(49, 'attribute4', 'abfgtc', 'VARCHAR', '147cbf33-816d-450c-83db-a0ac4022a6dd');

-- --------------------------------------------------------

--
-- Table structure for table `project_number`
--

CREATE TABLE `project_number` (
  `project_attribute_id` bigint(20) NOT NULL,
  `value` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_number`
--

INSERT INTO `project_number` (`project_attribute_id`, `value`, `project_id`, `id`) VALUES
(46, 4, 37, 15),
(45, 3, 37, 16),
(46, 4, 39, 17),
(45, 3, 39, 18),
(46, 4, 40, 19),
(45, 3, 40, 20),
(46, 4, 42, 21),
(45, 3, 42, 22);

-- --------------------------------------------------------

--
-- Table structure for table `project_varchar`
--

CREATE TABLE `project_varchar` (
  `project_attribute_id` bigint(20) NOT NULL,
  `value` varchar(1000) DEFAULT NULL,
  `project_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_varchar`
--

INSERT INTO `project_varchar` (`project_attribute_id`, `value`, `project_id`, `id`) VALUES
(48, 'value', 37, 34),
(49, 'value2', 37, 35),
(48, 'value', 39, 36),
(49, 'value2', 39, 37),
(48, 'value', 40, 38),
(49, 'value2', 40, 39),
(48, 'value', 42, 40),
(49, 'value2', 42, 41);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `employee_attribute`
--
ALTER TABLE `employee_attribute`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee_number`
--
ALTER TABLE `employee_number`
  ADD PRIMARY KEY (`employee_attribute_id`,`employee_id`),
  ADD KEY `fk_Number_employee_id` (`employee_id`);

--
-- Indexes for table `employee_varchar`
--
ALTER TABLE `employee_varchar`
  ADD PRIMARY KEY (`employee_attribute_id`,`employee_id`),
  ADD KEY `fk_Varchar_employee_id` (`employee_id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `project_attribute`
--
ALTER TABLE `project_attribute`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `project_number`
--
ALTER TABLE `project_number`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Number_project_attribute_id` (`project_attribute_id`),
  ADD KEY `fk_Number_project_id` (`project_id`);

--
-- Indexes for table `project_varchar`
--
ALTER TABLE `project_varchar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Varchar_project_attribute_id` (`project_attribute_id`),
  ADD KEY `fk_Varchar_project_id` (`project_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee_attribute`
--
ALTER TABLE `employee_attribute`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `project_attribute`
--
ALTER TABLE `project_attribute`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT for table `project_number`
--
ALTER TABLE `project_number`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `project_varchar`
--
ALTER TABLE `project_varchar`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee_number`
--
ALTER TABLE `employee_number`
  ADD CONSTRAINT `fk_Number_employee_attribute_id` FOREIGN KEY (`employee_attribute_id`) REFERENCES `employee_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Number_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `employee_varchar`
--
ALTER TABLE `employee_varchar`
  ADD CONSTRAINT `fk_Varchar_employee_attribute_id` FOREIGN KEY (`employee_attribute_id`) REFERENCES `employee_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Varchar_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `project_number`
--
ALTER TABLE `project_number`
  ADD CONSTRAINT `fk_Number_project_attribute_id` FOREIGN KEY (`project_attribute_id`) REFERENCES `project_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Number_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `project_varchar`
--
ALTER TABLE `project_varchar`
  ADD CONSTRAINT `fk_Varchar_project_attribute_id` FOREIGN KEY (`project_attribute_id`) REFERENCES `project_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Varchar_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
