CREATE DATABASE supermarket;
USE supermarket;

-- 以下定义的int长度可以表示最大的数为10位，数据字典为12位，但bigint可以表示的数又过于大了

CREATE TABLE user_info(
    -- 用户信息表，包括用户名，密码，用户类型
    Username int PRIMARY KEY,--数据字典中没有定义       用户名
    "Password" char(12) not NULL, --数据字典没有定义    密码
    User_type char(2) not NULL --数据字典中没有定义     用户类型
);

CREATE TABLE supplier(
    -- 供应商信息表
    -- supplier information 'provider'
    -- since we have all-storage, we should have a Prono & Proname for all-storage
    Prono int PRIMARY KEY,--数据字典中没有定义           供应商编号
    Proname char(12) not NULL, --数据字典没有定义        供应商名称
);

CREATE TABLE product_info(
    -- 商品信息表
    -- I add Vno, Vname, Lno, Lname
    Pno int PRIMARY KEY,   --                           商品编号
    Pname char(30) not NULL unique,  --                 商品名称
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
    Vno int not NULL,                                               -- 商品大类编号
    Vname char(20) not NULL,                                        -- 商品大类名称
    Lno int not NULL,                                               -- 商品小类编号
    Lname char(20) not NULL,                                        -- 商品小类名称
    PRIMARY KEY (Vno, Lno),
);

CREATE TABLE replenish(
    -- 供应信息表
    -- I delete selfno, add Inum(input product number), 
    Ino int PRIMARY KEY,                                                                -- 进货编号
    Prono int foreign key references supplier(Prono),                                   -- 供应商编号
    Pno int foreign key references product_info(Pno),                                   -- 商品编号
    Inum int not NULL,-- 新增的属性，数据字典中无                                           -- 一次进货的数量
    Grossprice NUMERIC(4,2) not NULL,-- 数据字典中定义为double，此处考虑实际修改为numeric     -- 进货价
    Sno int foreign key references all_worker_info(Sno),                                -- 员工编号 
    Idate date not NULL,-- Shelfdate the name is misleading, maybe Idate will be better -- 进货日期
);


CREATE TABLE storage(
    -- 总仓库库存表
    Pno int PRIMARY KEY, -- 商品编号
    Pname char(30) not NULL unique, -- 商品名称
    Quantity int not NULL, -- 商品库存数量
    
);

CREATE TABLE customer_info (
    -- 消费者信息表
    Cno int PRIMARY KEY, -- 消费者编号
    Cgrade smallint not NULL, -- 消费者的年级
    Cname char(16) not NULL, -- 消费者姓名
    Cgender smallint not NULL, -- 消费者性别
);

CREATE TABLE worker_info(
    -- 工作人员信息表
    Sno int PRIMARY KEY, -- 员工编号
    Sjob char(4) not NULL, -- 数据字典中无 -- 员工职位
    Sgrade smallint not NULL, -- 员工年级
    Sname char(16) not NULL, -- 员工姓名
);


CREATE TABLE traffic_info (
    -- 交易数据 transaction data
    Tno int PRIMARY KEY,
    Ttime date not NULL,
    Gno int not NULL,
    Pno int unique not NULL foreign key references general.product_info(Pno),
    Cno int unique not NULL foreign key references customer_info(Cno),
    Sno int unique not NULL foreign key references worker_info(sno),
);

CREATE TABLE require_info (
    -- 消费者建议
    Ono int PRIMARY KEY,
    Cno int not NULL foreign key references customer_info(Cno),
    Oname char(50) not NULL,
    Ontime date not NULL,
    Offtime date not NULL,
    Ostatus smallint not NULL,
    Sno int foreign key references worker_info(Sno),
);

CREATE TABLE shelf(
    -- 货架信息表
    Shelfno int PRIMARY KEY,
    Vno int not NULL,
    Shelfloc char(10), --数据字典中无
    Sno int foreign key references worker_info(Sno),
);