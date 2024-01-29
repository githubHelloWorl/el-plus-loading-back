Drop database if EXISTS aaa;
CREATE SCHEMA `aaa` DEFAULT CHARACTER SET utf8mb4;

use `aaa`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
    `id` int(11) PRIMARY KEY NOT NULL auto_increment,
    `name` varchar(20),
    `password` varchar(50) ,
    `age` int(10) ,
    `tel` varchar(255)
) auto_increment=1;

INSERT INTO `user` VALUES (1, 'tom', 'tom', 3 , '188666888');
INSERT INTO `user` VALUES (2, 'jerry', 'jerry',  4 , '166888666');
INSERT INTO `user` VALUES (3, 'jock', '123456',  41 , '400618400');
INSERT INTO `user` VALUES (4, '传智播客', 'itcast', 23 , '400617500');

select * from user;
select max(id) from user;




DROP TABLE IF EXISTS `cascader`;
CREATE TABLE `cascader` (
                            `id`     int PRIMARY KEY auto_increment comment '主键',
                            `label`  varchar(255) NOT NULL comment '级联标签',
                            `value`  varchar(255) NOT NULL comment '级联内容',
                            `level`  int NOT NULL comment '当前等级',
                            `pre_id` int NOT NULL comment '是哪个级联下',
                            `children_num` int NOT NULL comment '孩子数量',
);


insert into cascader values(1,'北京','北京',1,0,0);
insert into cascader values(2,'天津','天津',1,0,0);
insert into cascader values(3,'河南','河南',1,0,1);
insert into cascader values(4,'山东','山东',1,0,2);
insert into cascader values(101,'青岛','青岛',2,4,1);
insert into cascader values(102,'聊城','聊城',2,4,0);
insert into cascader values(103,'郑州','郑州',2,3,0);
insert into cascader values(1001,'市北区','市北区',3,101,0);





