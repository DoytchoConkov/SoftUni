#2
INSERT INTO `addresses` (`address`,`town`,`country`,`user_id`)
SELECT u.`username`,u.`password`,u.`ip`,u.`age` FROM users AS u WHERE u.gender='m';

#3
UPDATE `addresses`
SET country=(CASE
WHEN LEFT(country,1)='B' THEN 'Blocked'
WHEN LEFT(country,1)='T' THEN 'Test'
WHEN LEFT(country,1)='P' THEN 'In Progress'
END
)
WHERE LEFT(country,1) IN ('B','T','P');

#4
DELETE FROM `addresses`
WHERE `id`%3=0;

#5
SELECT `username`,`gender`,`age` FROM `users` ORDER BY `age` DESC;

#6
SELECT p.`id`,p.`date` AS `date_and_time`,p.`description`, COUNT(p.`id`) AS `commentsCount`
FROM photos AS p
JOIN comments AS c
ON p.`id`=c.`photo_id`
GROUP BY `id`
ORDER BY `commentsCount` DESC
LIMIT 5;

#7
SELECT CONCAT(u.`id`,' ',u.`username`), u.`email`
FROM users AS u
JOIN user_photos as up
ON up.`user_id`=u.`id`
JOIN photos AS p
ON p.`id`=up.`photo_id`
WHERE u.`id`=p.`id`
ORDER BY u.`id`;

#8
SELECT p.`id`, COUNT(l.`id`) AS `likes_count`, COUNT(c.`id`) AS `comments-count`
FROM photos AS p
JOIN comments AS c
ON c.`photo_id`=p.`id`
JOIN likes AS l
ON l.`photo_id`=p.`id`
ORDER BY `likes_count` DESC,`comments-count` DESC;

#9
SELECT CONCAT(LEFT(`description`,30),'...'),`date`
FROM photos
WHERE DAY(`date`)=10
ORDER BY `date`;

#10
DELIMITER $$
CREATE FUNCTION `udf_users_photos_count` (username VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (
SELECT COUNT(*)
FROM users AS u
JOIN user_photos AS up
ON up.`user_id`=u.`id`
WHERE u.`username`=username
GROUP BY u.`username`
);
END $$
DELIMITER ;

#11
DELIMITER $$
CREATE PROCEDURE `udp_modify_user` (address VARCHAR(30), town VARCHAR(30))
BEGIN
 UPDATE `users` AS u
 SET u.age=u.age+10
 WHERE (SELECT id 
 FROM users AS u1
 JOIN addresses AS a
 ON a.`user_id`=u1.`id`
 WHERE a.`address`=address AND a.`town`=town
 )>0;
END $$
DELIMITER ;


