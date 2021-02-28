#1
CREATE DATABASE  `minions`;

#2
CREATE TABLE  `minions` (
`id` INT PRIMARY KEY AUTO_INCREMENT ,
`name` VARCHAR(45) NOT NULL,
`age` INT 
);
CREATE TABLE `towns`(
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL
);

#3.1 ?
ALTER TABLE `towns` 
CHANGE COLUMN `town_id` `id` INT NOT NULL AUTO_INCREMENT ;

#3.2
ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`);

#4
INSERT INTO `towns` (`name`) VALUES  ('Sofia'),('Plovdiv'),('Varna');
INSERT INTO `minions` (`name`,`age`,`town_id`) VALUES ('Kevin',22,1),('Bob',15,3),('Steward',NULL,2);

#5
TRUNCATE TABLE `minions`;

#6
DROP TABLE `minions`,`towns`;

#7
CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DECIMAL(2, 2),
`weight` DECIMAL(2, 2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

--   INSERT INTO `people` (`name`, .....

#8
CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30)UNIQUE NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` BOOLEAN
);

#9
ALTER TABLE`users` 
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY (`id`, `username`);

#10


#11
ALTER TABLE `users` 
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME NULL DEFAULT NOW() ;

#12

#13
CREATE DATABASE `movies`;

CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(45),
`notes` TEXT
);

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genres_name` VARCHAR(45),
`notes` TEXT
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(45),
`notes` TEXT
);

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(45),
`director_id` INT,
`copyrightyear` DATE,
`lengmoviesht` DOUBLE,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE,
`notes` TEXT
);

ALTER TABLE `movies` 
ADD CONSTRAINT `fk_director_id`
  FOREIGN KEY (`director_id`)
  REFERENCES `movies`.`directors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_category_id`
  FOREIGN KEY (`category_id`)
  REFERENCES `movies`.`categories` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_genery_id`
  FOREIGN KEY (`genre_id`)
  REFERENCES `movies`.`genres` (`id`);
  
  #14
  CREATE SCHEMA `car_rental` ;
  
  CREATE TABLE `categories` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `category_name` VARCHAR(45) NOT NULL,
  `daily_rate` DOUBLE NOT NULL,
  `weekly_rate` DOUBLE NULL,
  `mountly_rate` DOUBLE NULL,
  `weekend_rate` DOUBLE NULL);
  
  CREATE TABLE `cars` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `plate_number` VARCHAR(20) NOT NULL,
  `manufacturecarsr` VARCHAR(20) NOT NULL,
  `model` VARCHAR(20) NOT NULL,
  `car_year` DATE NOT NULL,
  `category_id` INT NOT NULL,
  `doors` INT NOT NULL,
  `picture` BLOB NULL,
  `condition` VARCHAR(20) NOT NULL,
  `available` TINYINT NOT NULL);
  ALTER TABLE `car_rental`.`cars` 
ADD CONSTRAINT `fk_category_id`
  FOREIGN KEY (`category_id`)
  REFERENCES `car_rental`.`categories` (`id`);
  
  CREATE TABLE `employees` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `notes` TEXT NULL);
  
  CREATE TABLE `custumers` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `driver_license_number` VARCHAR(45) NOT NULL,
  `full_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `zip_code` VARCHAR(45) NOT NULL,
  `notes` TEXT NULL);


CREATE TABLE `car_rental`.`rental_orders` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `employee_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `car_id` INT NOT NULL,
  `tank_level` DOUBLE NOT NULL,
  `kilometrage_start` DOUBLE NOT NULL,
  `kilometrage_end` DOUBLE NOT NULL,
  `total_kilometrage` DOUBLE NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `total_days` INT NOT NULL,
  `rate_applied` DOUBLE NOT NULL,
  `tax_rate` DOUBLE NOT NULL,
  `order_status` VARCHAR(45) NOT NULL,
  `notes` TEXT NULL,
  INDEX `fk_employee_id_idx` (`employee_id` ASC) VISIBLE,
  INDEX `fk_customer_id_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_car_id_idx` (`car_id` ASC) VISIBLE,
  CONSTRAINT `fk_employee_id`
    FOREIGN KEY (`employee_id`)
    REFERENCES `car_rental`.`employees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `car_rental`.`custumers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_car_id`
    FOREIGN KEY (`car_id`)
    REFERENCES `car_rental`.`cars` (`id`));
    
    
    #15
    CREATE DATABASE `hotel`;
    
    CREATE TABLE `employees`(
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `title` VARCHAR(20) NOT NULL,
    `notes` TEXT
    );
    
    CREATE TABLE `customers` (
    `acount_number` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
      `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `phone_number` VARCHAR(15),
    `emergency_name`VARCHAR(30) ,
    `emergency_number`VARCHAR(15) ,
    `notes` TEXT
    );
    
    CREATE TABLE `room_status` (
    `room_status` VARCHAR(40) PRIMARY KEY,
    `notes` TEXT
    );
    
      CREATE TABLE `room_types` (
    `room_types` VARCHAR(40) PRIMARY KEY,
    `notes` TEXT
    );
    
     CREATE TABLE `bed_types` (
    `bed_types` VARCHAR(40) PRIMARY KEY,
    `notes` TEXT
    );
    
    CREATE TABLE `rooms` (
    `room_number` INT PRIMARY KEY AUTO_INCREMENT,
    `room_type` VARCHAR(40) NOT NULL,
    `bed_type` VARCHAR(40) NOT NULL,
    `rate` DOUBLE NOT NULL,
     `room_status` VARCHAR(40) NOT NULL,
     `notes` TEXT    
    );
    ALTER TABLE `hotel`.`rooms` 
ADD CONSTRAINT `fk_room_type`
  FOREIGN KEY (`room_type`)
  REFERENCES `hotel`.`room_types` (`room_types`),
ADD CONSTRAINT `fk_room_status`
  FOREIGN KEY (`room_status`)
  REFERENCES `hotel`.`room_status` (`room_status`),
ADD CONSTRAINT `fk_bed_type`
  FOREIGN KEY (`bed_type`)
  REFERENCES `hotel`.`bed_types` (`bed_types`);
  
  #16 
  CREATE DATABASE `softuni`;
  
  CREATE TABLE `towns` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(30) NOT NULL
  );
  
   CREATE TABLE `address` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `address_text` VARCHAR(100) NOT NULL,
  `town_id` INT NOT NULL
  );
  
   CREATE TABLE `departments` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(30) NOT NULL
  );
  
   CREATE TABLE `employees` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `first_name` VARCHAR(30) NOT NULL,
  `middle_name` VARCHAR(30) NOT NULL,
  `last_name` VARCHAR(30) NOT NULL,
  `job_title` VARCHAR(30) NOT NULL,
  `deparment_id` INT NOT NULL,
  `hire_date` DATE NOT NULL,
  `salary` DOUBLE,
  `address_id` INT NOT NULL
  );
  ALTER TABLE `softuni`.`employees` 
ADD CONSTRAINT `fk_deparment_id`
  FOREIGN KEY (`deparment_id`)
  REFERENCES `softuni`.`departments` (`id`),
ADD CONSTRAINT `fk_addres_id`
  FOREIGN KEY (`address_id`)
  REFERENCES `softuni`.`address` (`id`)
    