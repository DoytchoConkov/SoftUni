#1
SELECT `first_name` , `last_name` FROM `employees` WHERE left(`first_name`,2)='Sa';

#2
SELECT `first_name` , `last_name` FROM `employees` WHERE locate('ei',`last_name`,2)>0;

#3
SELECT `first_name`  FROM `employees` WHERE `department_id` IN (3,10) AND year(`hire_date`) BETWEEN 1995 AND 2005;

#4
SELECT `first_name` , `last_name` FROM `employees` WHERE locate('engineer',`job_title`)=0 ;

#5
SELECT `name` FROM `towns` WHERE char_length(`name`) IN (5,6) ORDER BY `name`;

#6
SELECT `town_id`,`name` FROM `towns` WHERE left(`name`,1) IN ('M','K','B','E') ORDER BY `name`;

#7
SELECT `town_id`,`name` FROM `towns` WHERE left(`name`,1) NOT IN ('R', 'B' , 'D') ORDER BY `name`;

#8
CREATE VIEW ` v_employees_hired_after_2000` AS
SELECT `first_name`,`last_name`  FROM `employees` WHERE year(`hire_date`)>2000;
SELECT * FROM ` v_employees_hired_after_2000`;

#9
SELECT `first_name` , `last_name` FROM `employees` WHERE char_length(`last_name`)=5 ;

USE `geography`;

#10
SELECT `country_name`,`iso_code` FROM `countries` WHERE `country_name` LIKE '%a%a%a%' ORDER BY `country_name`;

#11
SELECT p.`peak_name`,r.`river_name`, LOWER(concat(p.`peak_name`,LEFT(r.`river_name`,2))) AS `mix`
FROM `peaks` AS p, `rivers` AS r 
WHERE right(p.`peak_name`,1)=left(r.`river_name`,1)
ORDER BY `mix`;

#12
SELECT `name` , DATE_FORMAT(`start`, '%Y-%m-%d') AS `start` FROM `games` WHERE YEAR(`start`) IN (2011,2012) ORDER BY `start` LIMIT 50;

#13
SELECT `user_name` , substring(`email`,locate('@',`email`)+1) AS `email_provider` FROM `users` ORDER BY `email_provider`;

#14
SELECT `user_name` , `ip_address` FROM `users` WHERE `ip_address` LIKE '___.1%.%.___' ORDER BY `user_name`;

#15
SELECT `name` AS `game` ,
 CASE 
   WHEN hour(`start`)  BETWEEN 0 AND 11 THEN 'Morning'
   WHEN hour(`start`)  BETWEEN 12 AND 17 THEN 'Afternoon'
   ELSE 'Evening'
 END AS `Part of the Day`,
 CASE
    WHEN `duration` BETWEEN 0 AND 3 THEN 'Extra Short'
    WHEN `duration` BETWEEN 4 AND 6 THEN 'Short'
    WHEN `duration` BETWEEN 7 AND 10 THEN 'Long'
    ELSE 'Extra Long'
    END AS `Duration`
 FROM `games`
 ORDER BY `name`;

#16

