#1
CREATE DATABASE `instd`;
USE `instd`;
CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(30) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`gender` CHAR(1) NOT NULL,
`age` INT NOT NULL,
`job_title` VARCHAR(40) NOT NULL,
`ip` VARCHAR(30) NOT NULL
);
CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address` VARCHAR(30) NOT NULL,
`town` VARCHAR(30) NOT NULL,
`country` VARCHAR(50) NOT NULL,
`user_id` INT NOT NULL,
CONSTRAINT fk_addresses_users
FOREIGN KEY (`user_id`)
REFERENCES users(`id`)
);
CREATE TABLE `photos`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`description` TEXT NOT NULL,
`date` DATETIME NOT NULL,
`views` INT NOT NULL
);
CREATE TABLE `comments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT fk_comments_photos
FOREIGN KEY (`photo_id`)
REFERENCES photos(`id`)
);
CREATE TABLE `user_photos`(
`user_id` INT NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT fk_users_photos_users
FOREIGN KEY (`user_id`)
REFERENCES users(`id`),
CONSTRAINT fk_users_photos_photos
FOREIGN KEY (`photo_id`)
REFERENCES photos(`id`)
);
CREATE TABLE `likes`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`user_id` INT,
`photo_id` INT,
CONSTRAINT fk_likes_users
FOREIGN KEY (`user_id`)
REFERENCES users(`id`),
CONSTRAINT fk_likes_photos
FOREIGN KEY (`photo_id`)
REFERENCES photos(`id`)
);