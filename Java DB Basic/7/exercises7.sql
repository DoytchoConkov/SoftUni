#1
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above_35000` ()
BEGIN
 SELECT first_name, last_name
 FROM employees
 WHERE salary>35000
 ORDER BY first_name, last_name,employee_id;
END $$
DELIMITER ;
CALL usp_get_employees_salary_above_35000;

#2
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above` (number INT)
BEGIN
 SELECT first_name, last_name
 FROM employees
 WHERE salary>=number
 ORDER BY first_name, last_name,employee_id;
END $$
DELIMITER ;
CALL usp_get_employees_salary_above(48100);

#3
DELIMITER $$
CREATE PROCEDURE `usp_get_towns_starting_with` (start_str VARCHAR(30))
BEGIN
 SELECT `name`
 FROM towns
 WHERE `name` LIKE concat(start_str,'%')
 ORDER BY `name`;
END $$
DELIMITER ;
CALL usp_get_towns_starting_with('b');

#4
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_from_town` (town VARCHAR(30))
BEGIN
 SELECT e.first_name, e.last_name
 FROM employees AS e
 JOIN addresses AS a
 ON e.address_id=a.address_id
 JOIN towns AS t
 ON t.town_id=a.town_id
 WHERE t.name=town
 ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;
CALL usp_get_employees_from_town('Sofia');

#5
DELIMITER $$
CREATE FUNCTION `ufn_get_salary_level` (sal DECIMAL(19,2))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
RETURN (
CASE 
WHEN sal <30000 THEN 'Low'
WHEN sal BETWEEN 30000 AND 50000 THEN 'Average'
WHEN sal > 50000 THEN  'High'
END);
END $$
DELIMITER ;
SELECT 13500.00,ufn_get_salary_level(13500.00) AS `salary_Level`;
SELECT 43300.00,ufn_get_salary_level(43300.00) AS `salary_Level`;
SELECT 125500.00,ufn_get_salary_level(125500.00) AS `salary_Level`;

#6
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_by_salary_level` (salary_level VARCHAR(30))
BEGIN
 SELECT first_name, last_name
 FROM employees 
 WHERE ufn_get_salary_level(salary)=salary_level
 ORDER BY first_name DESC, last_name DESC;
END $$
DELIMITER ;

CALL usp_get_employees_by_salary_level('high');

#7
DELIMITER $$
CREATE FUNCTION `ufn_is_word_comprised`(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
DETERMINISTIC
BEGIN
RETURN word REGEXP (concat('^[', set_of_letters, ']+$'));
END $$
DELIMITER ;

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');
SELECT ufn_is_word_comprised('oistmiahf', 'halves');
SELECT ufn_is_word_comprised('bobr', 'Rob');
SELECT ufn_is_word_comprised('pppp', 'Guy');

#8
DELIMITER $$
CREATE PROCEDURE `usp_get_holders_full_name` ()
BEGIN
 SELECT CONCAT(first_name,' ', last_name) AS `full_name`
 FROM account_holders
 ORDER BY full_name,id;
END $$
DELIMITER ;

CALL usp_get_holders_full_name();

#9
DELIMITER $$
CREATE PROCEDURE `usp_get_holders_with_balance_higher_than` (sum DECIMAL(19,2))
BEGIN
 SELECT first_name,last_name 
 FROM account_holders AS ah
 JOIN accounts AS a
 ON a.account_holder_id=ah.id
 GROUP BY ah.id
 HAVING SUM(a.balance)>sum
 ORDER BY first_name,last_name ;
END $$
DELIMITER ;

CALL  usp_get_holders_with_balance_higher_than(7000);

#10
DELIMITER $$
CREATE FUNCTION `ufn_calculate_future_value` (sum DECIMAL(19,2),yearly_interest DECIMAL(19,2),years INT)
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN
RETURN sum*POW((1+yearly_interest/100),years);
END $$
DELIMITER ;

SELECT ufn_calculate_future_value(1000,10,5);

#11
DELIMITER $$
CREATE PROCEDURE `usp_calculate_future_value_for_account` (account_id INT,interest_rate DECIMAL(19,4))
BEGIN
 SELECT account_id, ah.first_name, ah.last_name ,SUM(a.balance) AS `current_balance`,
 ufn_calculate_future_value(SUM(a.balance),interest_rate,5) AS `balance_in_5_years`
 FROM account_holders AS ah
 JOIN accounts AS a
 ON a.account_holder_id=ah.id
 WHERE ah.id=account_id
 GROUP BY ah.id
 ORDER BY first_name,last_name ;
END $$
DELIMITER ;

CALL  usp_calculate_future_value_for_account(1,0.1);

#12
DELIMITER $$
CREATE PROCEDURE `usp_deposit_money`(account_id INT, money_amount DECIMAL (19,2))
BEGIN
 IF money_amount >0 THEN 
  START TRANSACTION;
        UPDATE `accounts` AS a 
        SET a.balance = a.balance + money_amount
        WHERE a.id = account_id;
        IF (SELECT a.balance FROM `accounts` AS a  WHERE a.id = account_id) < 0
            THEN ROLLBACK;
        ELSE COMMIT;
        END IF;
    END IF;
END $$
DELIMITER ;

CALL usp_deposit_money(1, 10);
SELECT a.id AS 'account_id', a.account_holder_id, a.balance
FROM `accounts` AS a
WHERE a.id = 1;

#13
DELIMITER $$
CREATE PROCEDURE `usp_withdraw_money`(account_id INT, money_amount DECIMAL (19,2))
BEGIN
 IF money_amount >0 THEN 
  START TRANSACTION;
        UPDATE `accounts` AS a 
        SET a.balance = a.balance - money_amount
        WHERE a.id = account_id;
        IF (SELECT a.balance FROM `accounts` AS a  WHERE a.id = account_id) < 0
            THEN ROLLBACK;
        ELSE COMMIT;
        END IF;
    END IF;
END $$
DELIMITER ;

CALL usp_withdraw_money(1, 10);
SELECT a.id AS 'account_id', a.account_holder_id, a.balance
FROM `accounts` AS a
WHERE a.id = 1;

#14
DELIMITER $$
CREATE PROCEDURE `usp_withdraw_money`(from_account_id INT, to_account_id INT, money_amount DECIMAL(19, 4))
BEGIN
 IF money_amount >0 
 AND from_account_id<>to_account_id
 AND (SELECT a.id FROM `accounts` AS a WHERE a.id = to_account_id) IS NOT NULL
 AND (SELECT a.id FROM `accounts` AS a WHERE a.id = from_account_id) IS NOT NULL THEN
  START TRANSACTION;
        UPDATE `accounts` AS a 
        SET a.balance = a.balance - money_amount
        WHERE a.id = from_account_id;
        UPDATE `accounts` AS a 
        SET a.balance = a.balance + money_amount
        WHERE a.id = to_account_id;
        IF (SELECT a.balance FROM `accounts` AS a  WHERE a.id = from_account_id) < 0
            THEN ROLLBACK;
        ELSE COMMIT;
        END IF;
    END IF;
END $$
DELIMITER ;

CALL usp_transfer_money(1, 2, 10);
CALL usp_transfer_money(2, 1, 10);

SELECT a.id AS 'account_id', a.account_holder_id, a.balance
FROM `accounts` AS a
WHERE a.id IN (1 , 2);

#15
CREATE TABLE logs(
log_id INT PRIMARY KEY AUTO_INCREMENT, 
account_id INT, 
old_sum DECIMAL(19,4), 
new_sum DECIMAL(19,4));

DELIMITER $$
CREATE TRIGGER `tr_sum_update`
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
 INSERT INTO `logs` (account_id,old_sum,new_sum) 
 VALUES (account_id,OLD.balance,NEW.balance);
END $$
DELIMITER ;

#16
CREATE TABLE notification_emails(
id INT PRIMARY KEY AUTO_INCREMENT, 
recipient INT, 
`subject` VARCHAR(30), 
body VARCHAR(45));
DELIMITER $$
CREATE TRIGGER `tr_sum_update_emailtr_sum_update_emailtr_sum_update_email`
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
 INSERT INTO `logs` (recipient,`subject`,body) 
 VALUES (account_id,CONCAT('Balance change for account: ',account_id),CONCAT('On ',NOW(),' your balance was changed from ',OLD.balance,' to ',NEW.balance));
END $$
DELIMITER ;









