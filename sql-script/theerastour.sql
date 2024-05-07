DROP DATABASE IF EXISTS `eras_tour`;
CREATE DATABASE `eras_tour`;
use `eras_tour`;

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
                            `id` BIGINT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(100) DEFAULT NULL,
                            `address` VARCHAR(100) DEFAULT NULL,
                            `outline` VARCHAR(100) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists `tour`;
create table `tour`(
                       `id` bigint not null,
                       `name` varchar(50) default null,
                       `type` varchar(45) default null,
                       `description` varchar(100) default null,
                       `location_id` bigint default null,
                       `tour_date` date default null,
                       `tour_time` DATETIME,
                       `tour_timestamp` TIMESTAMP,
                       `total_tickets` INT,
                       `sold_tickets` INT DEFAULT 0,
                       primary key(`id`),
                       CONSTRAINT check_tickets CHECK (`sold_tickets` <= `total_tickets`),
                       constraint `tour_fk` foreign key (`location_id`) references `location`(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=latin1;

drop table if exists `member`;
CREATE TABLE `member` (
                          `user_id` varchar(50) NOT NULL,
                          `pw` char(68) NOT NULL,
                          `active` tinyint NOT NULL,
                          `first_name` varchar(45) DEFAULT NULL,
                          `last_name` varchar(45) DEFAULT NULL,
                          `email` varchar(45) DEFAULT NULL,
                          `address` varchar(100) default null,
                          PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `member` (`user_id`, `pw`, `active`)
VALUES
    ('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
    ('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
    ('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);

CREATE TABLE `roles` (
                         `user_id` varchar(50) NOT NULL,
                         `role` varchar(50) NOT NULL,
                         UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
                         CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `member` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `roles`
VALUES
    ('john','ROLE_EMPLOYEE'),
    ('mary','ROLE_EMPLOYEE'),
    ('mary','ROLE_MANAGER'),
    ('susan','ROLE_EMPLOYEE'),
    ('susan','ROLE_MANAGER'),
    ('susan','ROLE_ADMIN');

drop table if exists `bill`;
create table `bill`(
                       `id` bigint not null,
                       `total_tickets` int default null,
                       `total_price` double default null,
                       `user_id` varchar(50) not null,
                       `status` tinyint default null,
                       primary key(`id`),
                       constraint `member_fk` foreign key (`user_id`) references `member`(`user_id`)
)engine=InnoDB AUTO_INCREMENT=10000 default charset=latin1;

drop table if exists `ticket`;
create table `ticket`(
                         `id` bigint not null,
                         `type` varchar(50) default null,
                         `price` double default null,
                         `tour_id` bigint not null,
                         `bill_id` bigint default null,
                         `status` tinyint default null,
                         primary key (id,tour_id),
                         constraint `ticket_tour_fk` foreign key (`tour_id`) references `tour`(`id`),
                         constraint `ticket_bill_fk` foreign key(`bill_id`) references `bill`(`id`)
) engine=InnoDB AUTO_INCREMENT=100000 default charset=latin1;


