CREATE TABLE `project` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);

CREATE TABLE `project_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label` varchar(50) DEFAULT NULL,
  `default_value` varchar(1000) DEFAULT NULL,
   `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `project_varchar` (
  `project_attribute_id` bigint(20) NOT NULL,
  `value` varchar(10000) DEFAULT NULL,
  `project_id` bigint(20)  NOT NULL,
  PRIMARY KEY (`project_attribute_id`,`project_id`),
  CONSTRAINT `fk_Varchar_project_attribute_id` FOREIGN KEY (`project_attribute_id`) REFERENCES `project_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_Varchar_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `project_number` (
  `project_attribute_id` bigint(20) NOT NULL,
  `value` bigint(20) DEFAULT NULL,
  `project_id` bigint(20)  NOT NULL,
  PRIMARY KEY (`project_attribute_id`,`project_id`),
  CONSTRAINT `fk_Number_project_attribute_id` FOREIGN KEY (`project_attribute_id`) REFERENCES `project_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_Number_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);

CREATE TABLE `employee_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label` varchar(50) DEFAULT NULL,
  `default_value` varchar(1000) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `employee_varchar` (
  `employee_attribute_id` bigint(20) NOT NULL,
  `value` varchar(10000) DEFAULT NULL,
  `employee_id` bigint(20)  NOT NULL,
  PRIMARY KEY (`employee_attribute_id`,`employee_id`),
  CONSTRAINT `fk_Varchar_employee_attribute_id` FOREIGN KEY (`employee_attribute_id`) REFERENCES `employee_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_Varchar_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `employee_number` (
  `employee_attribute_id` bigint(20) NOT NULL,
  `value` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20)  NOT NULL,
  PRIMARY KEY (`employee_attribute_id`,`employee_id`),
  CONSTRAINT `fk_Number_employee_attribute_id` FOREIGN KEY (`employee_attribute_id`) REFERENCES `employee_attribute` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_Number_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

