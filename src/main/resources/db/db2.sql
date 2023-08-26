CREATE TABLE admin(
                      id BIGINT PRIMARY KEY NOT NULL COMMENT '主键ID',
                      name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
                      age INT NULL DEFAULT NULL COMMENT '年龄',
                      email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱'
);
INSERT INTO admin (id, name, age, email) VALUES
                                             (1, 'Jone', 18, 'test1@baomidou.com'),
                                             (2, 'Jack', 20, 'test2@baomidou.com'),
                                             (3, 'Tom', 28, 'test3@baomidou.com'),
                                             (4, 'Sandy', 21, 'test4@baomidou.com'),
                                             (5, 'Billie', 24, 'test5@baomidou.com');

update admin set name = concat('admin-',name) where age < 100;