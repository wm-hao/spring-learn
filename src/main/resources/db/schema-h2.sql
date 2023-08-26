
DROP TABLE IF EXISTS usera;

CREATE TABLE usera(
                     id BIGINT PRIMARY KEY NOT NULL COMMENT '主键ID',
                     name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
                     age INT NULL DEFAULT NULL COMMENT '年龄',
                     email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱'
);
