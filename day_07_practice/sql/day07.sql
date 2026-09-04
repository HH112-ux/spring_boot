-- A库：db1 用户表
CREATE DATABASE IF NOT EXISTS db1 DEFAULT CHARACTER SET utf8mb4;
USE db1;

CREATE TABLE IF NOT EXISTS user (
    id          BIGINT(19)      PRIMARY KEY COMMENT '雪花算法主键',
    name        VARCHAR(50)     COMMENT '用户名',
    password    VARCHAR(100)    COMMENT '密码',
    status      INT             DEFAULT 0  COMMENT '状态：0正常 1停用',
    create_time DATETIME        COMMENT '注册时间',
    update_time DATETIME        COMMENT '更新时间'
) COMMENT '用户表';

INSERT INTO user (id, name, password, status, create_time, update_time) VALUES
(1, '张三', '123456', 0, NOW(), NOW()),
(2, '李四', '654321', 0, NOW(), NOW()),
(3, '王五', '888888', 1, NOW(), NOW());

-- B库：db2 用户账户表
CREATE DATABASE IF NOT EXISTS db2 DEFAULT CHARACTER SET utf8mb4;
USE db2;

CREATE TABLE IF NOT EXISTS user_account (
    id      BIGINT(19)  PRIMARY KEY COMMENT '雪花算法主键',
    name    VARCHAR(50) COMMENT '用户名',
    balance INT         DEFAULT 0  COMMENT '余额',
    version INT         DEFAULT 0  COMMENT '版本号'
) COMMENT '用户账户表';

INSERT INTO user_account (id, name, balance, version) VALUES
(1, '张三', 1000, 0),
(2, '李四', 2000, 0),
(3, '王五', 3000, 0);
