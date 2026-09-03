CREATE DATABASE IF NOT EXISTS day05_practice DEFAULT CHARSET utf8mb4;
USE day05_practice;

CREATE TABLE IF NOT EXISTS employee (
    id             INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    emp_name       VARCHAR(50)  NOT NULL COMMENT '员工姓名',
    login_name     VARCHAR(50)  NOT NULL COMMENT '登录账号',
    login_password VARCHAR(100) NOT NULL COMMENT '登录密码',
    age            INT          DEFAULT NULL COMMENT '年龄',
    gender         VARCHAR(10)  DEFAULT NULL COMMENT '性别',
    addr           VARCHAR(200) DEFAULT NULL COMMENT '地址',
    dept_name      VARCHAR(50)  DEFAULT NULL COMMENT '部门名称',
    status         TINYINT      DEFAULT 0 COMMENT '0工作 1休息 2离职',
    deleted        TINYINT      DEFAULT 0 COMMENT '是否删除: 0否 1是'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='员工表';

INSERT INTO employee (emp_name, login_name, login_password, age, gender, addr, dept_name, status) VALUES
('张三', 'zhangsan', '123456', 25, '男', '北京市', '研发部', 0),
('李四', 'lisi', '123456', 35, '男', '吉林市', '市场部', 0),
('王五', 'wangwu', '123456', 28, '女', '长春市', '市场部', 0),
('赵六', 'zhaoliu', '123456', 45, '男', '长春市', '研发部', 0),
('孙七', 'sunqi', '123456', 22, '女', '吉林市', '市场部', 0),
('周八', 'zhouba', '123456', 55, '男', '北京市', '销售部', 0),
('吴九', 'wujiu', '123456', 62, '男', '上海市', '研发部', 0),
('郑十', 'zhengshi', '123456', 30, '女', '北京市', '市场部', 0),
('钱十一', 'qian11', '123456', 48, '男', '吉林市', '销售部', 0),
('孙十二', 'sun12', '123456', 65, '男', '长春市', '研发部', 0);
