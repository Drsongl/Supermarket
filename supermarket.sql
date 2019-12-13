CREATE DATABASE supermarket;
USE supermarket;

/* public information*/
CREATE SCHEMA general;
use SCHEMA general

use SCHEMA general
use SCHEMA general
use SCHEMA general


-- 以下定义的int长度可以表示最大的数为10位，数据字典为12位，但bigint可以表示的数又过于大了

CREATE TABLE user_info(
    -- 用户信息表，包括用户名，密码，用户类型
    Username int PRIMARY KEY,--数据字典中没有定义
    "Password" char(12) not NULL, --数据字典没有定义
    User_type char(2) not NULL --数据字典中没有定义
);

CREATE TABLE supplier(
    -- 供应商信息表
    -- supplier information 'provider'
    -- since we have all-storage, we should have a Prono & Proname for all-storage
    Prono int PRIMARY KEY,--数据字典中没有定义
    Proname char(12) not NULL, --数据字典没有定义
);

CREATE TABLE sub(
    -- 超市信息表/仓库信息表
    Subno int PRIMARY KEY, -- 超市编号/仓库编号,数据字典中无
    Subname char(12) unique, -- 超市名称/仓库名称，数据字典中无
    Subloc char(20) not NULL, -- 超市位置/仓库位置，数据字典中无
);

CREATE TABLE product_info(
    -- 商品信息表
    -- I add Vno, Vname, Lno, Lname
    Pno int PRIMARY KEY,
    Pname char(30) not NULL unique,
    Sellprice NUMERIC(4,2) not NULL,
    Vno int not NULL,
    Lno int not NULL,
    Shelfno int not NULL, -- selfno  可以累积，比如一个超市是1，2，3，另一个超市是4，5，6，这样，就没有问题了
    -- we may put shelfno here, not in replenish table, but the problem is shelfno for each supermarket is different.
    --Stockout_n int not NULL 表示商品缺货报警线
);

/*
新建了一个表，主要是商品分类树是一个相对独立的实体
*/
CREATE TABLE producttree(
    -- 商品分类树 
    Vno int not NULL,
    Vname char(20) not NULL,
    Lno int not NULL,
    Lname char(20) not NULL,
    PRIMARY KEY (Vno, Lno),
);

CREATE TABLE all_replenish(
    -- 总仓库供应表
    -- I delete selfno, add Inum(input product number), 
    Ino int PRIMARY KEY,
    Prono int foreign key references supplier(Prono),
    Pno int foreign key references product_info(Pno),
    Inum int not NULL,-- 新增的属性，数据字典中无
    Grossprice NUMERIC(4,2) not NULL,-- 数据字典中定义为double，此处考虑实际修改为numeric
    Sno int foreign key references all_worker_info(Sno),
    Idate date not NULL,-- Shelfdate the name is misleading, maybe Idate will be better
);

CREATE TABLE all_replace(
    -- 总仓库调出表
    -- 仓库调货出去，包括商品编号，数量，调货目的地（超市编号）
    Pno int PRIMARY KEY,
    Re_Quantity int not NULL,
    Subno int foreign key REFERENCES sub(Subno),
);

CREATE TABLE all_storage(
    -- 总仓库库存表
    Pno int PRIMARY KEY,
    Pname char(30) not NULL unique,
    All_Quantity int not NULL,
    -- 安澜设计的是0、1，我想的是该商品报警线，有待进一步交流
);

CREATE TABLE customer_info (
    -- 消费者信息表
    Cno int PRIMARY KEY,
    Cgrade smallint not NULL,
    Cname char(16) not NULL,
    Cgender smallint not NULL,
);

CREATE TABLE all_worker_info(
    -- 工作人员信息表
    Sno int PRIMARY KEY,
    Sjob char(4) not NULL, -- 数据字典中无
    Sgrade smallint not NULL,
    Sname char(16) not NULL,
);


/* private infomation for each supermarket */
CREATE SCHEMA super1;
USE super1;

CREATE TABLE traffic_info (
    -- 交易数据 transaction data
    Tno int PRIMARY KEY,
    Ttime date not NULL,
    Gno int not NULL,
    Pno int unique not NULL foreign key references general.product_info(Pno),
    Cno int unique not NULL foreign key references customer_info(Cno),
    Sno int unique not NULL foreign key references worker_info(sno),
);

CREATE TABLE replenish(
    -- 该超市的进货信息表
    -- I delete selfdate, selfno, add Inum(input product number)
    Ino int PRIMARY KEY,
    Prono int foreign key references general.supplier(Prono),
    Pno int foreign key references general.product_info(Pno),
    Inum int not NULL,-- 新增的属性，数据字典中无
    Grossprice NUMERIC(4,2) not NULL,-- 数据字典中定义为double，此处考虑实际修改为numeric
    Sno int foreign key references worker_info(Sno),
    Idate date not NULL,-- the name is misleading, maybe Idate will be better
);

CREATE TABLE storage(
    -- 该超市的库存信息表
    Pno int PRIMARY KEY,
    Pname char(30) not NULL unique,
    Quantity int not NULL,
    -- Stockout_Flag int not NULL,-- 安澜设计的是0、1，我想的是该商品报警线，有待进一步交流
);

CREATE TABLE require_info (
    -- 消费者建议
    Ono int PRIMARY KEY,
    Cno int not NULL foreign key references general.customer_info(Cno),
    Pno int not NULL foreign key references general.product_info(Pno),
    Oname char(50) not NULL,
    Ontime date not NULL,
    Offtime date not NULL,
    Ostatus smallint not NULL,
    Sno int foreign key references worker_info(Sno),
);

CREATE TABLE worker_info(
    -- 工作人员信息表
    Sno int PRIMARY KEY,
    Sjob char(4) not NULL, -- 数据字典中无
    Sgrade smallint not NULL,
    Sname char(16) not NULL,
);

CREATE TABLE shelf(
    -- 货架信息表
    Shelfno int PRIMARY KEY,
    Vno int not NULL,
    Shelfloc char(10), --数据字典中无
    Sno int foreign key references worker_info(Sno),
);