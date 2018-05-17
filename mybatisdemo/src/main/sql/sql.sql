USE mybatis;
-- 删除表
DROP TABLE if EXISTS items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;

-- 重建表
CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT );
CREATE TABLE orders(id INT PRIMARY KEY AUTO_INCREMENT, orderno VARCHAR(20), uid INT);
CREATE TABLE items(id INT PRIMARY KEY AUTO_INCREMENT, itemname VARCHAR(20), oid INT);

-- 插入用户
INSERT INTO users(name, age) VALUES ('tom', 12);
INSERT INTO users(name, age) VALUES ('tomas', 13);

-- 插入订单
INSERT INTO orders(orderno, uid) VALUES ('No001', 1);
INSERT INTO orders(orderno, uid) VALUES ('No002', 1);
INSERT INTO orders(orderno, uid) VALUES ('No003', 2);
INSERT INTO orders(orderno, uid) VALUES ('No004', 2);

-- 插入订单项
INSERT INTO items(itemname, oid) VALUES ('item001', 1);
INSERT INTO items(itemname, oid) VALUES ('item002', 1);
INSERT INTO items(itemname, oid) VALUES ('item003', 2);
INSERT INTO items(itemname, oid) VALUES ('item004', 2);
INSERT INTO items(itemname, oid) VALUES ('item005', 3);
INSERT INTO items(itemname, oid) VALUES ('item006', 3);

-- 查询
SELECT * FROM users;
SELECT * FROM orders;
SELECT * FROM items;

-- 左外连接
SELECT u.id uid, u.name uname, u.age uage, o.id oid, o.orderno oorderno, i.id iid, i.itemname iitemname FROM users u
  LEFT OUTER JOIN orders o ON o.uid = u.id
  LEFT OUTER JOIN items i ON o.id = i.oid;

