CREATE DATABASE supermarket;
USE supermarket;

-- 以下定义的int长度可以表示最大的数为10位，数据字典为12位，但bigint可以表示的数又过于大了

CREATE TABLE user_info(
    -- 用户信息表，包括用户名，密码，用户类型
    Uno int identity(1,1) PRIMARY KEY,
    Username varchar(12) not NULL,--数据字典中没有定义   用户名
    "Password" varchar(12) not NULL, --数据字典没有定义    密码
    Cno int UNIQUE,
    "Type" varchar(2) not NULL --数据字典中没有定义     用户类型
);

CREATE TABLE supplier(
    -- 供应商信息表
    -- supplier information 'provider'
    -- since we have all-storage, we should have a Prono & Proname for all-storage
    Prono int identity(1,1) PRIMARY KEY,--数据字典中没有定义           供应商编号
    Proname varchar(12) not NULL, --数据字典没有定义        供应商名称
);

CREATE TABLE product_info(
    -- 商品信息表
    -- I add Vno, Vname, Lno, Lname
    Pno int identity(1,1) PRIMARY KEY,   --                           商品编号
    Pname varchar(30) not NULL unique,  --                 商品名称
    Sellprice NUMERIC(4,2) not NULL,  --                售价
    Vno int not NULL,  --                               大类编号
    Lno int not NULL,  --                               小类编号
    Shelfno int not NULL, --                            货架编号 
    -- selfno  可以累积，比如一个超市是1，2，3，另一个超市是4，5，6，这样，就没有问题了
    -- we may put shelfno here, not in replenish table, but the problem is shelfno for each supermarket is different.
    Stockout_n int not NULL, -- 表示商品缺货报警线 -- 安澜设计的是0、1，我想的是该商品报警线，有待进一步交流
);

/*
新建了一个表，主要是商品分类树是一个相对独立的实体
*/
CREATE TABLE producttree(
    -- 商品分类树 
    Vno int identity(1,1) not NULL,                                               -- 商品大类编号
    Vname varchar(20) not NULL,                                        -- 商品大类名称
    Lno int PRIMARY KEY,                                               -- 商品小类编号
    Lname varchar(20) not NULL,                                        -- 商品小类名称
);

CREATE TABLE replenish(
    -- 供应信息表
    -- I delete selfno, add Inum(input product number), 
    Ino int identity(1,1) PRIMARY KEY,                                                                -- 进货编号
    Prono int foreign key references supplier(Prono),                                   -- 供应商编号
    Pno int foreign key references product_info(Pno),                                   -- 商品编号
    Inum int not NULL,-- 新增的属性，数据字典中无                                           -- 一次进货的数量
    Grossprice NUMERIC(4,2) not NULL,-- 数据字典中定义为double，此处考虑实际修改为numeric     -- 进货价
    Sno int foreign key references worker_info(Sno),                                -- 员工编号 
    Idate date not NULL,-- Shelfdate the name is misleading, maybe Idate will be better -- 进货日期
);


CREATE TABLE storage(
    -- 仓库库存表
    Pno int PRIMARY KEY, -- 商品编号
    Pname varchar(30) not NULL unique, -- 商品名称
    Quantity int not NULL, -- 商品库存数量
    
);

CREATE TABLE customer_info (
    -- 消费者信息表
    Cno int PRIMARY KEY, -- 消费者编号，学号
    Cgrade smallint not NULL, -- 消费者的年级
    Cname varchar(16) not NULL, -- 消费者姓名
    Cgender smallint not NULL, -- 消费者性别
);

CREATE TABLE worker_info(
    -- 工作人员信息表
    Sno int PRIMARY KEY, -- 员工编号，学号
    Sjob varchar(6) not NULL, -- 数据字典中无 -- 员工职位
    Sgrade smallint not NULL, -- 员工年级
    Sname varchar(16) not NULL, -- 员工姓名
);


CREATE TABLE traffic_info (
    -- 交易数据 transaction data
    Tno int identity(1,1) PRIMARY KEY,
    Ttime datetime not NULL,
    Gno int not NULL,
    Pno int unique not NULL foreign key references product_info(Pno),
    Cno int unique not NULL foreign key references customer_info(Cno),
    Sno int unique not NULL foreign key references worker_info(sno),
);

CREATE TABLE require_info (
    -- 消费者建议
    Ono int identity(1,1) PRIMARY KEY,
    Cno int not NULL foreign key references customer_info(Cno),
    Oname varchar(50) not NULL,
    Ontime date not NULL,
    Offtime date,
    Ostatus smallint not NULL,
    Sno int foreign key references worker_info(Sno),
);

CREATE TABLE shelf(
    -- 货架信息表
    Shelfno int identity(1,1) PRIMARY KEY,
    Vno int not NULL,
    Shelfloc varchar(10), --数据字典中无
    Sno int foreign key references worker_info(Sno),
);


---插入值
-----supplier
insert 
into supplier(Proname)
values ('旺仔')

insert 
into supplier(Proname)
values ('统一')

insert 
into supplier(Proname)
values ('光明')

insert 
into supplier(Proname)
values ('乐事')
----product
insert 
into product_info(Pname,Sellprice,Vno,Lno,Shelfno,Stockout_n)
values ('QQ糖',4,1,7,7,300)

insert 
into product_info(Pname,Sellprice,Vno,Lno,Shelfno,Stockout_n)
values ('原味薯片70g',5,1,5,6,40)

insert 
into product_info(Pname,Sellprice,Vno,Lno,Shelfno,Stockout_n)
values ('冰红茶',3.5,2,2,5,80)

insert 
into product_info(Pname,Sellprice,Vno,Lno,Shelfno,Stockout_n)
values ('鲜牛奶500ml',7,2,3,2,10)

----customer
insert 
into customer_info(Cno,Cname,Cgrade,Cgender)
values (163071,'束巨酷',4,1)

insert 
into customer_info(Cno,Cname,Cgrade,Cgender)
values (173071,'辛希办',3,2)

----worker
insert 
into worker_info(Sno,Sname,Sgrade,Sjob)
values (163072,'谢程',4,'理货员')

insert 
into worker_info(Sno,Sname,Sgrade,Sjob)
values (183071,'王员工',2,'理货员')

insert 
into worker_info(Sno,Sname,Sgrade,Sjob)
values (163073,'焦武初',4,'经理')

insert 
into worker_info(Sno,Sname,Sgrade,Sjob)
values (173073,'马超市',3,'收银员')

----storage
insert 
into storage(Pname,Pno,Quantity)
values ('QQ糖',1,398)

insert 
into storage(Pname,Pno,Quantity)
values ('冰红茶',2,99)

insert 
into storage(Pname,Pno,Quantity)
values ('鲜牛奶500ml',3,19)

insert 
into storage(Pname,Pno,Quantity)
values ('原味薯片70g',4,50)

----shelf
INSERT
INTO shelf(Vno,Shelfloc,Sno)
VALUES (1,1,163072)

INSERT
INTO shelf(Vno,Shelfloc,Sno)
VALUES (2,5,163072)

INSERT
INTO shelf(Vno,Shelfloc,Sno)
VALUES (3,3,163072)

INSERT
INTO shelf(Vno,Shelfloc,Sno)
VALUES (4,4,183071)

INSERT
INTO shelf(Vno,Shelfloc,Sno)
VALUES (2,6,183071)

INSERT
INTO shelf(Vno,Shelfloc,Sno)
VALUES (1,7,183071)

INSERT
INTO shelf(Vno,Shelfloc,Sno)
VALUES (1,8,163072)

----replenish
INSERT
INTO replenish(Prono,Pno,Inum,Grossprice,Sno,Idate)
VALUES (1,1,400,2.2,163072,'2019-12-20')

INSERT
INTO replenish(Prono,Pno,Inum,Grossprice,Sno,Idate)
VALUES (2,3,100,3,163072,'2019-12-20')

INSERT
INTO replenish(Prono,Pno,Inum,Grossprice,Sno,Idate)
VALUES (3,4,20,5.8,163072,'2019-12-20')

INSERT
INTO replenish(Prono,Pno,Inum,Grossprice,Sno,Idate)
VALUES (4,2,50,3.2,163072,'2019-12-20')

----traffic
INSERT 
INTO traffic_info(Ttime,Gno,Pno,Cno,Sno)
VALUES ('2019-12-20',123,1,163071,173073)

INSERT 
INTO traffic_info(Ttime,Gno,Pno,Cno,Sno)
VALUES ('2019-12-20',123,1,163071,173073)

INSERT 
INTO traffic_info(Ttime,Gno,Pno,Cno,Sno)
VALUES ('2019-12-20',123,3,163071,173073)

INSERT 
INTO traffic_info(Ttime,Gno,Pno,Cno,Sno)
VALUES ('2019-12-20',124,4,173071,173073)

----require
INSERT 
INTO require_info(Oname,Ontime,Ostatus,Offtime,Cno,Sno)
VALUES ('QQ糖口味太少','2019-12-19',1,'2019-12-21',163071,163073)

INSERT 
INTO require_info(Oname,Ontime,Ostatus,Offtime,Cno,Sno)
VALUES ('想买当天的鲜牛奶','2019-12-20',1,'2019-12-21',173071,163073)

----producttree
INSERT
INTO producttree(Vno, Vname, Lno, Lname)
VALUES (1,'食品',7,'糖果')

INSERT
INTO producttree(Vno, Vname, Lno, Lname)
VALUES (1,'食品',5,'膨化食品')

INSERT
INTO producttree(Vno, Vname, Lno, Lname)
VALUES (2,'饮料',2,'茶')

INSERT
INTO producttree(Vno, Vname, Lno, Lname)
VALUES (2,'饮料',3,'牛奶')