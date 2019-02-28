-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 28, 2019 at 05:30 PM
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
-- Table structure for table `employee_attribute_value`
--

CREATE TABLE `employee_attribute_value` (
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
(42, 'abc', 'ae7a9cae-69a4-4164-a828-e0c05a382ec9'),
(44, 'abc', '5c78a40b-e1da-4df5-95a2-b243af4e0a47'),
(45, 'abc', '4279c8ea-59eb-4546-a6c6-3e3bec6f7d85'),
(46, 'Kipstor', 'c83b628f-f044-47df-accf-22e18b15ded8'),
(47, 'Kipstor', '3e226cc8-8cbc-411f-9449-a5cb70406676'),
(48, 'Kipstor', 'ea45ca97-b2de-463e-8377-f8a7b7caeda8'),
(49, 'Kipstor', 'cfba14c4-b80a-4253-a73a-63af8f8e1380'),
(50, 'abcdee', '67314b13-171a-40f6-b663-b8e363b54553'),
(51, 'abcdee', 'bfb82956-e51b-4796-a580-5e0346ae098e'),
(52, 'abcdee', '06e77d5b-15de-447a-9f55-1f793b3a7dd1'),
(53, 'abcdee', 'c0dc6786-4a17-46f0-8e60-ba9940e23605'),
(54, 'abcdee', 'e13e136e-97ce-4105-afe8-bc5b5c805eaf'),
(55, 'abcdee', '3ed9c50f-74d4-4355-80b9-910c6999a82a');

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
(49, 'attribute4', 'abfgtc', 'VARCHAR', '147cbf33-816d-450c-83db-a0ac4022a6dd'),
(50, 'attribute4', 'abfgtc', 'VARCHAR', '81c62614-4975-4600-ad9c-55f889855b62'),
(51, 'region_create_test', 'UK', 'VARCHAR', '9102049c-6749-4b39-ac08-9d03c228a2f1'),
(54, 'region_update_test_updated', 'UK', 'VARCHAR', '0eb9b5fb-b29c-47eb-ac57-5b7f43db8cb8'),
(55, 'region_update_test_updated', 'UK', 'VARCHAR', '0eb9b5fb-b29c-47eb-ac57-5b7f43db8cb8'),
(56, 'region_update_test_updated', 'UK', 'VARCHAR', '45fb72e0-02d0-400b-949f-040f3047bd8b'),
(57, 'region_update_test_updated', 'UK', 'VARCHAR', '45fb72e0-02d0-400b-949f-040f3047bd8b'),
(58, 'region_create_test', 'UK', 'VARCHAR', '434078d6-1c03-4ed8-a8f4-798bf683a0cb'),
(60, 'region_update_test_updated', 'UK', 'VARCHAR', '2d402191-6720-4044-9c62-2976eb8a2752'),
(61, 'region_update_test_updated', 'UK', 'VARCHAR', '2d402191-6720-4044-9c62-2976eb8a2752'),
(62, 'attribute_label1', 'default_val1', 'VARCHAR', '0df1446a-7bde-42a8-be82-8b44d409808c'),
(63, 'attribute_label1', 'default_val1', 'VARCHAR', '3a7fae54-7043-44ac-8757-81ea9bc12d3d'),
(64, 'attribute_label1', '1', 'NUMBER', '9f2927ee-069e-4957-869f-eceb6094ff0d'),
(65, 'attribute_label1', '2015-01-01', 'DATE', '35faade6-c678-45d4-b8a9-106dda7e77bd'),
(66, 'attribute_label1', 'default_val1', 'VARCHAR', '3f1d4ff4-34f3-49a8-b90a-8ce27e732624'),
(67, 'attribute_label1', 'default_val1', 'VARCHAR', '189e3d7c-72d5-4985-80f7-d779007a4c82'),
(68, 'attribute_label1', '1', 'NUMBER', '78f63956-4619-4525-b504-37c5da69ace9'),
(69, 'attribute_label1', '2015-01-01', 'DATE', '7c31fc36-737b-4722-b87a-9bb81e11d171'),
(70, 'attribute_label1', 'default_val1', 'VARCHAR', 'f76aba5b-b550-4224-a402-db1e66b2a99d'),
(71, 'attribute_label1', 'default_val1', 'VARCHAR', '024958b1-c3e9-4aa5-9c24-a392cb00e78c'),
(72, 'attribute_label1', '1', 'NUMBER', 'c4d4be0f-f562-47bc-9cde-572e999a7c5f'),
(73, 'attribute_label1', '2015-01-01', 'DATE', '6787b3a1-48f5-4db9-bb55-7645bb83cf28'),
(74, 'attribute_label1', 'default_val1', 'VARCHAR', '078d50b2-38f9-4215-800e-5050d2a12b30'),
(75, 'attribute_label1', 'default_val1', 'VARCHAR', 'db7aa2fe-d0c5-488c-8293-23e45da7510a'),
(76, 'attribute_label1', '1', 'NUMBER', 'f04ed031-e78d-4008-8069-86ca830b9d29'),
(77, 'attribute_label1', '2015-01-01', 'DATE', 'f8d5ecda-8b0c-4733-870b-cd0fba7260b1'),
(78, 'attribute_label1', 'default_val1', 'VARCHAR', '0eb60741-8620-4d8a-8377-ea112683c0a9'),
(79, 'attribute_label1', 'default_val1', 'VARCHAR', 'd99d101d-b373-49e7-bca7-f12766ac24b6'),
(80, 'attribute_label1', '1', 'NUMBER', '253a1367-9730-40d5-b08e-11e871ff8287'),
(81, 'attribute_label1', '2015-01-01', 'DATE', '4902a7bc-40ca-475b-b7c8-abd4abf69083'),
(82, 'attribute_label1', 'default_val1', 'VARCHAR', '9ccce88a-97e3-4703-9eb4-ebd070a61e7f'),
(83, 'attribute_label1', 'default_val1', 'VARCHAR', '9f5376f4-488b-43cc-95cb-c20d16634418'),
(84, 'attribute_label1', '1', 'NUMBER', 'db8c9f09-4b4f-4de5-afdc-50b5160253b4'),
(85, 'attribute_label1', '2015-01-01', 'DATE', 'ac71c8fd-2c44-490c-a78e-74d614bf05cf'),
(86, 'attribute_label1', 'default_val1', 'VARCHAR', 'cd760223-1d95-45f0-92c1-2f3e61880819'),
(87, 'attribute_label1', 'default_val1', 'VARCHAR', '38a82921-10aa-4e33-b6c9-8c2c9d6757e5'),
(88, 'attribute_label1', '1', 'NUMBER', '0753bd97-925c-4c08-816d-9cbefbf340a7'),
(89, 'attribute_label1', '2015-01-01', 'DATE', '04ef0c83-5512-430b-a370-db901766626c'),
(90, 'attribute_label1', 'default_val1', 'VARCHAR', '0ef711ea-a14e-436c-bae2-a5ad31002ea9'),
(91, 'attribute_label1', 'default_val1', 'VARCHAR', '98e2af90-b8c3-41ac-88a1-1b11db8a4466'),
(92, 'attribute_label1', '1', 'NUMBER', 'a7b985b1-ba58-4369-be35-51dadc5141da'),
(93, 'attribute_label1', '2015-01-01', 'DATE', 'f82682ea-8ea9-4d79-824d-c62d00a36a00'),
(94, 'attribute4', 'abfgtc', 'VARCHAR', '1a6b0617-7e69-41db-99b9-f2b1c308eed9');

-- --------------------------------------------------------

--
-- Table structure for table `project_attribute_value`
--

CREATE TABLE `project_attribute_value` (
  `project_attribute_id` bigint(20) NOT NULL,
  `value` varchar(1000) DEFAULT NULL,
  `project_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_attribute_value`
--

INSERT INTO `project_attribute_value` (`project_attribute_id`, `value`, `project_id`) VALUES
(82, 'value1', 47),
(83, 'value2', 47),
(84, '100', 47),
(85, '2015-01-01', 47),
(86, 'value1', 48),
(86, 'IUYTYY', 51),
(86, 'IUYTYY', 52),
(86, 'DINETH_SUCESS', 53),
(86, 'DINETH_SUCESS', 54),
(86, 'DINETH_SUCESS', 55),
(87, 'value2', 48),
(87, 'dsadsadsadasdasdas', 51),
(87, 'dsadsadsadasdasdas', 52),
(87, 'dsadsadsadasdasdas', 53),
(87, 'dsadsadsadasdasdas', 54),
(87, 'dsadsadsadasdasdas', 55),
(88, '100', 48),
(88, '1000', 51),
(88, '1000', 52),
(88, '1000', 53),
(88, '1000', 54),
(88, '1000', 55),
(89, '2015-01-01', 48),
(90, 'value1BDCF', 49),
(91, 'value2BCDF', 49),
(92, '10099', 49),
(93, '2015-01-31', 49);

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
-- Indexes for table `employee_attribute_value`
--
ALTER TABLE `employee_attribute_value`
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
-- Indexes for table `project_attribute_value`
--
ALTER TABLE `project_attribute_value`
  ADD PRIMARY KEY (`project_attribute_id`,`project_id`),
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
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT for table `project_attribute`
--
ALTER TABLE `project_attribute`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee_attribute_value`
--
ALTER TABLE `employee_attribute_value`
  ADD CONSTRAINT `fk_Varchar_employee_attribute_id` FOREIGN KEY (`employee_attribute_id`) REFERENCES `employee_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Varchar_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `project_attribute_value`
--
ALTER TABLE `project_attribute_value`
  ADD CONSTRAINT `fk_Varchar_project_attribute_id` FOREIGN KEY (`project_attribute_id`) REFERENCES `project_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Varchar_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
