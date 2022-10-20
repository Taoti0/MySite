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

-- create content_article table by zoey he
CREATE TABLE IF NOT EXISTS `content_article` (
	`id` bigint(19) UNSIGNED AUTO_INCREMENT,
	`user_id` bigint(19) NOT NULL COMMENT '作者ID',
	`author` VARCHAR(20) NOT NULL COMMENT '作者',
	`title` VARCHAR(255) NOT NULL COMMENT '文章标题',
	`content` longtext NOT NULL COMMENT '文章正文',
	`category` int(2) COMMENT '文章分类, 两位: 一号位 {1: 原创, 2: 转载}, 二号位{0: 技术, 1: 游戏, 2: 旅行, 3: 其他}',
	`label` VARCHAR(255) COMMENT '文章标签',
	`deleted` tinyint(1) DEFAULT 0 NOT NULL COMMENT '0: 否 1: 是',
	`created_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8;

-- update content_article add column 'views'
ALTER TABLE `content_article` ADD `views` INT(11) DEFAULT 0 COMMENT '访问量' AFTER `label`
