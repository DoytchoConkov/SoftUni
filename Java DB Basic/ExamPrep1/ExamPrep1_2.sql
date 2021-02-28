#2
INSERT INTO `coaches` (`first_name`,`last_name`,`salary`,`coach_level`)   
SELECT p.`first_name`,p.`last_name`,p.`salary`, CHAR_LENGTH(p.`first_name`)  
FROM players AS p 
WHERE p.`age`>=45;

#3
UPDATE `coaches` AS c
SET c.`coach_level`=c.`coach_level`+1
WHERE (SELECT player_id FROM players_coaches AS pc WHERE pc.coach_id=c.id )>0 AND LEFT(`first_name`,1)='a';

#4
DELETE FROM `player`
WHERE age>=45;

#5
SELECT first_name,age,salary FROM players ORDER BY salary DESC;

#6
SELECT id, CONCAT(first_name,' ',last_name) AS full_name, age, position, hire_date 
FROM players
WHERE hire_date IS NULL
ORDER BY age;

#7
SELECT t.`name`,t.`established`,t.`fan_base` , COUNT(p.`id`) AS `count_of_players`
FROM teams AS t
JOIN players AS p
ON p.team_id=t.id
GROUP BY t.`name`
ORDER BY `count_of_players` DESC;

#8
SELECT MAX(sk.`speed`) AS `max_speed`, t.`name`
FROM towns AS t
JOIN stadiums AS s
ON s.town_id=t.id
JOIN teams AS te
ON te.stadium_id=s.id
JOIN players AS p
ON p.team_id=t.id
JOIN skills_data AS sk
ON sk.id=p.skills_data_id
WHERE te.name<>'Devify'
GROUP BY t.name
ORDER BY `max_speed` DESC,t.`name`;

#9
SELECT c.`name`, SUM(p.`salary`) AS `total_sum_of_salaries`, COUNT(p.`id`) AS `total_count_of_players`
FROM coutries AS c
LEFT JOIN towns AS t
ON t.country_id=c.id
LEFT JOIN stadiums AS s
ON s.town_id=t.id
LEFT JOIN teams AS te
ON te.stadium_id=s.id
LEFT JOIN players AS p
ON p.team_id=te.id
GROUP BY c.`name`
ORDER BY `total_count_of_players` DESC, c.`name`;

#10
DELIMITER $$
CREATE FUNCTION `udf_stadium_players_count` (stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (
SELECT COUNT(*) 
FROM stadiums AS s
JOIN team AS t
ON t.stadium_id=s.id
JOIN players AS p
ON p.team_id=t.id
WHERE s.`name`=stadium_name
GROUP BY s.`name`
);
END $$
DELIMITER ;

#11
DELIMITER $$
CREATE PROCEDURE `udp_find_playmaker` (min_drible_points INT, team_name VARCHAR(45))
BEGIN
 SELECT CONCAT(p.first_name, ' ',p.last_name),p.age,p.salary,sk.dribbling,sk.speed,team_name
 FROM players AS p
 JOIN skills_data AS sk
 ON p.skills_data_id=sk.id
 JOIN teams as t
 ON p.team_id=t.id
 WHERE sk.dribbling>min_drible_points AND t.`name`=team_name 
 ORDER BY sk.speed DESC
 LIMIT 1;
END $$
DELIMITER ;



