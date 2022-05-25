CREATE DATABASE IF NOT EXISTS hibernate;
USE hibernate;

CREATE TABLE IF NOT EXISTS tags
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name varchar(255)
);

CREATE TABLE IF NOT EXISTS posts
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	content varchar(255),
    writer_id int
);

CREATE TABLE IF NOT EXISTS posts_tags
(
	Post_id int not null,
    tags_id int not null
);

CREATE TABLE IF NOT EXISTS writers
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name varchar(255)
);
