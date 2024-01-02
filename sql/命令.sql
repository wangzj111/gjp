CREATE DATABASE gjp;

USE gjp;

CREATE TABLE sort(
    sid INT PRIMARY KEY AUTO_INCREMENT, -- 分类ID
    sname VARCHAR(100), -- 分类名称
    parent VARCHAR(100), -- 所属分类
    scomment VARCHAR(10000) -- 备注
);
CREATE TABLE ledger(
   lid INT PRIMARY KEY AUTO_INCREMENT, -- 账务ID
   parent VARCHAR(100), -- 所属分类
   money DOUBLE, -- 金额
   sid INT, -- 分类ID（属于什么分类）
   account VARCHAR(100), -- 账户
   createtime DATE, -- 创建时间
   lcomment VARCHAR(1000) -- 备注
);

INSERT INTO
    sort(sid,sname,parent,scomment)
VALUES (1,'服装支出','支出','买衣服'),
       (2,'吃饭支出','支出',''),
       (3,'交通支出','支出',''),
       (4,'住房支出','支出',''),
       (5,'工资收入','收入','fda'),
       (6,'股票收入','收入',''),
       (7,'礼金支出','支出',''),
       (8,'其它支出','支出','');


INSERT INTO
    ledger(lid,parent,money,sid,account,createtime,lcomment)
VALUES (1,'支出',247,2,'交通银行','2022-03-02','家庭聚餐'),
       (2,'收入',12345,5,'现金','2022-03-15','开工资了'),
       (3,'支出',1998,1,'现金','2022-04-02','买衣服'),
       (4,'支出',325,2,'现金','2022-06-18','朋友聚餐'),
       (10,'收入',8000,6,'工商银行','2022-10-28','股票大涨'),
       (11,'收入',5000,6,'工商银行','2022-10-28','股票又大涨'),
       (12,'收入',5000,5,'交通银行','2022-10-28','又开工资了'),
       (13,'支出',5000,7,'现金','2022-10-28','朋友结婚'),
       (14,'支出',1560,8,'现金','2022-10-29','丢钱了'),
       (15,'支出',2300,3,'交通银行','2022-10-29','油价还在涨啊'),
       (16,'支出',1000,2,'工商银行','2022-10-29','又吃饭'),
       (17,'收入',1000,5,'现金','2021-10-30','开资'),
       (18,'支出',2000,3,'现金','2022-10-30','机票好贵'),
       (19,'收入',5000,5,'现金','2022-10-30','又开资');