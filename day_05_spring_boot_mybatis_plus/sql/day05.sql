-- master 数据库
CREATE DATABASE IF NOT EXISTS mybatis DEFAULT CHARSET utf8mb4;
USE mybatis;

CREATE TABLE IF NOT EXISTS teacher (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    teacher_name VARCHAR(255),
    gender       VARCHAR(255),
    age          INT,
    deleted      INT DEFAULT 0
);

INSERT INTO teacher (teacher_name, gender, age) VALUES
('张三', '男', 30),
('李四', '女', 25),
('张五', '男', 35),
('王五张', '男', 40),
('李老师', '女', 28);

CREATE TABLE IF NOT EXISTS student (
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255),
    age    INT,
    gender VARCHAR(255),
    tid    INT
);

INSERT INTO student (name, age, gender, tid) VALUES
('学生A', 20, '男', 1),
('学生B', 22, '女', 2),
('学生C', 25, '男', 3),
('学生D', 30, '女', 4),
('李同学', 18, '男', 1),
('李明', 19, '女', 2);

CREATE TABLE IF NOT EXISTS bank (
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255),
    money   INT,
    version INT DEFAULT 0
);

INSERT INTO bank (name, money) VALUES
('张三', 1000),
('李四', 2000);

CREATE TABLE IF NOT EXISTS goods (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    create_time DATETIME,
    update_time DATETIME,
    status      INT
);

INSERT INTO goods (name, create_time, update_time, status) VALUES
('商品1', NOW(), NOW(), 0),
('商品2', NOW(), NOW(), 1),
('商品3', NOW(), NOW(), 0);

-- slave 数据库
CREATE DATABASE IF NOT EXISTS mybatis_plus DEFAULT CHARSET utf8mb4;
USE mybatis_plus;

CREATE TABLE IF NOT EXISTS emp (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    addr VARCHAR(255)
);

INSERT INTO emp (name, addr) VALUES
('王某某', '北京'),
('李某某', '上海');
