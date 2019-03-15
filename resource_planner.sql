-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 15, 2019 at 05:49 PM
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
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_client_details`
--

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oauth_client_details`
--

INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES
('client_id', '', '$2a$10$tPG.GWYmJZuGu7VvJtZQqOEhQchI5j27Ej6AlfRvssFaBYqF9.pcO', 'trust,read,write', 'password,authorization_code,refresh_token,client_credentials,implicit', NULL, '', 3600, 18000, NULL, '1');

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permission`
--

INSERT INTO `permission` (`id`, `name`, `description`) VALUES
(9, 'createProjectAttribute', NULL),
(10, 'readProjectAttribute', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id` varchar(50) NOT NULL,
  `title` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `title`) VALUES
('5c98bdf5-21e9-43ab-a08e-72a082513dc2', 'new_project'),
('fbb253d6-d6b1-48e3-ad5c-661d5df630b7', 'rrrrr');

-- --------------------------------------------------------

--
-- Table structure for table `project_attribute`
--

CREATE TABLE `project_attribute` (
  `id` varchar(50) NOT NULL,
  `label` varchar(50) DEFAULT NULL,
  `default_value` varchar(1000) DEFAULT NULL,
  `data_type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_attribute`
--

INSERT INTO `project_attribute` (`id`, `label`, `default_value`, `data_type`) VALUES
('330b9145-3324-48fa-b2d8-0d3fe3fc7ed3', 'attribute2', 'abfgtc', 'VARCHAR'),
('481a1b13-cb35-4950-ae70-809145044a34', 'attribute1', 'abfgtc', 'VARCHAR'),
('6dd9ff97-2a8f-42dd-a1c1-b83d055a26dc', 'attribute3', 'abfgtc', 'VARCHAR');

-- --------------------------------------------------------

--
-- Table structure for table `project_attribute_value`
--

CREATE TABLE `project_attribute_value` (
  `project_attribute_id` varchar(50) NOT NULL,
  `value` varchar(1000) DEFAULT NULL,
  `project_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_attribute_value`
--

INSERT INTO `project_attribute_value` (`project_attribute_id`, `value`, `project_id`) VALUES
('330b9145-3324-48fa-b2d8-0d3fe3fc7ed3', '1000', '5c98bdf5-21e9-43ab-a08e-72a082513dc2'),
('330b9145-3324-48fa-b2d8-0d3fe3fc7ed3', '1000', 'fbb253d6-d6b1-48e3-ad5c-661d5df630b7'),
('481a1b13-cb35-4950-ae70-809145044a34', 'dsadsadsadasdasdas', '5c98bdf5-21e9-43ab-a08e-72a082513dc2'),
('481a1b13-cb35-4950-ae70-809145044a34', 'dsadsadsadasdasdas', 'fbb253d6-d6b1-48e3-ad5c-661d5df630b7'),
('6dd9ff97-2a8f-42dd-a1c1-b83d055a26dc', 'DINETH_SUCESS_YEEEEE', '5c98bdf5-21e9-43ab-a08e-72a082513dc2'),
('6dd9ff97-2a8f-42dd-a1c1-b83d055a26dc', 'DINETH_SUCESS_YEEEEE', 'fbb253d6-d6b1-48e3-ad5c-661d5df630b7');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `ref_id` varchar(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `ref_id`, `name`, `description`) VALUES
(10, 'dsafds143ewfdsfsdf3fsdvsd', 'testRole', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `role_permission`
--

CREATE TABLE `role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_permission`
--

INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES
(10, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `ref_id` varchar(36) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `ref_id`, `first_name`, `last_name`, `email`, `password`) VALUES
(2, 'dsadsadsad', 'dineth', 'chalitha', 'dineth@gmail.com', '$2a$10$tPG.GWYmJZuGu7VvJtZQqOEhQchI5j27Ej6AlfRvssFaBYqF9.pcO');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(2, 10);

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
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth_client_details`
--
ALTER TABLE `oauth_client_details`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD UNIQUE KEY `title_UNIQUE` (`title`);

--
-- Indexes for table `project_attribute`
--
ALTER TABLE `project_attribute`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `label_UNIQUE` (`label`);

--
-- Indexes for table `project_attribute_value`
--
ALTER TABLE `project_attribute_value`
  ADD PRIMARY KEY (`project_attribute_id`,`project_id`),
  ADD KEY `fk_project_id` (`project_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ref_id_UNIQUE` (`ref_id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Indexes for table `role_permission`
--
ALTER TABLE `role_permission`
  ADD PRIMARY KEY (`role_id`,`permission_id`),
  ADD KEY `fk_role_permission_1_idx` (`role_id`),
  ADD KEY `fk_role_permission_2_idx` (`permission_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ref_id_UNIQUE` (`ref_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `fk_user_role_1_idx` (`user_id`),
  ADD KEY `fk_user_role_2_idx` (`role_id`);

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
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `permission`
--
ALTER TABLE `permission`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
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
  ADD CONSTRAINT `fk_project_attribute_id` FOREIGN KEY (`project_attribute_id`) REFERENCES `project_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `role_permission`
--
ALTER TABLE `role_permission`
  ADD CONSTRAINT `fk_role_permission_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_role_permission_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `fk_user_role_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_role_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
