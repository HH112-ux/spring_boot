CREATE DATABASE IF NOT EXISTS day04 DEFAULT CHARSET utf8mb4;
USE day04;

CREATE TABLE emp (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    addr VARCHAR(255),
    dept VARCHAR(255),
    age  INT
);

INSERT INTO emp (name, addr, dept, age) VALUES
('张三', '北京', '研发部', 25),
('李四', '上海', '市场部', 30),
('王五', '广州', '研发部', 28),
('赵六', '深圳', '人事部', 35),
('孙七', '杭州', '市场部', 27);
