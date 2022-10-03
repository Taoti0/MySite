-- created mysite_db by zoey he
CREATE DATABASE IF NOT EXISTS `mysite_db`
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

-- create user table by zoey he
CREATE TABLE IF NOT EXISTS `user` (
	`id` bigint(19) UNSIGNED AUTO_INCREMENT,
	`username` VARCHAR(255) UNIQUE NOT NULL COMMENT '用户名',
	`password` VARCHAR(255) NOT NULL COMMENT '密码',
	`nickname` VARCHAR(255) COMMENT '昵称',
	`sex` tinyint(1) DEFAULT 0 COMMENT '0: 无性别 1: 男 2: 女',
	`age` INT(11) COMMENT '年龄',
	`deleted` tinyint(1) DEFAULT 0 NOT NULL COMMENT '0: 否 1: 是',
	`created_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8;
