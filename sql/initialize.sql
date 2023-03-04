create schema pro_eng_yui_samples;

CREATE TABLE `pro_eng_yui_samples`.`m_worker` (
    `person_id` INT NOT NULL,
    `name` VARCHAR(45) NULL,
    `birth` DATE NULL,
    `note` VARCHAR(100) NULL,
    `LgcDelFlg` TINYINT NULL,
    PRIMARY KEY (`person_id`)
)
COMMENT = 'master table for work persons';

CREATE TABLE `pro_eng_yui_samples`.`t_payment` (
    `person_id` int NOT NULL,
    `payment_id` decimal(20,0) NOT NULL,
    `payed_date` date DEFAULT NULL,
    `amount` decimal(10,0) DEFAULT NULL,
    `note` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`person_id`,`payment_id`),
    UNIQUE KEY `payment_id_UNIQUE` (`payment_id`)
)
COMMENT='transactional data table for payment';

CREATE TABLE `pro_eng_yui_samples`.`m_salary` (
    `pay_rank_id` INT NOT NULL,
    `amount` DECIMAL NOT NULL,
    PRIMARY KEY (`pay_rank_id`)
)
COMMENT = 'based payment amount ';
