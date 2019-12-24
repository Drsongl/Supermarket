CREATE DATABASE supermarket2;

USE supermarket2;

-- ���¶����int���ȿ��Ա�ʾ������Ϊ10λ�������ֵ�Ϊ12λ����bigint���Ա�ʾ�����ֹ��ڴ���

CREATE TABLE user_info(
    -- �û���Ϣ�������û��������룬�û�����
    Username varchar(12) not NULL,--�����ֵ���û�ж���   �û���
    "Password" varchar(12) not NULL, --�����ֵ�û�ж���    ����
    Cno int primary key,
    "Type" varchar(2) not NULL --�����ֵ���û�ж���     �û�����
);

CREATE TABLE supplier(
    -- ��Ӧ����Ϣ��
    -- supplier information 'provider'
    -- since we have all-storage, we should have a Prono & Proname for all-storage
    Prono int identity(1,1) PRIMARY KEY,--�����ֵ���û�ж���           ��Ӧ�̱��
    Proname varchar(12) not NULL, --�����ֵ�û�ж���        ��Ӧ������
);

CREATE TABLE product_info(
    -- ��Ʒ��Ϣ��
    -- I add Vno, Vname, Lno, Lname
    Pno int identity(1,1) PRIMARY KEY,   --                           ��Ʒ���
    Pname varchar(30) not NULL unique,  --                 ��Ʒ����
    Sellprice NUMERIC(4,2) not NULL,  --                �ۼ�
    Vno int not NULL,  --                               ������
    Lno int not NULL,  --                               С����
    Shelfno int not NULL, --                            ���ܱ�� 
    -- selfno  �����ۻ�������һ��������1��2��3����һ��������4��5��6����������û��������
    -- we may put shelfno here, not in replenish table, but the problem is shelfno for each supermarket is different.
    Stockout_n int not NULL, -- ��ʾ��Ʒȱ�������� -- ������Ƶ���0��1��������Ǹ���Ʒ�����ߣ��д���һ������
);

/*
�½���һ������Ҫ����Ʒ��������һ����Զ�����ʵ��
*/
CREATE TABLE producttree(
    -- ��Ʒ������ 
    Vno int  not NULL,                                               -- ��Ʒ������
    Vname varchar(20) not NULL,                                        -- ��Ʒ��������
    Lno int PRIMARY KEY,                                               -- ��ƷС����
    Lname varchar(20) not NULL,                                        -- ��ƷС������
);


CREATE TABLE storage(
    -- �ֿ����
    Pno int PRIMARY KEY, -- ��Ʒ���
    Pname varchar(30) not NULL unique, -- ��Ʒ����
    Quantity int not NULL, -- ��Ʒ�������
    
);

CREATE TABLE customer_info (
    -- ��������Ϣ��
    Cno int PRIMARY KEY, -- �����߱�ţ�ѧ��
    Cgrade smallint not NULL, -- �����ߵ��꼶
    Cname varchar(16) not NULL, -- ����������
    Cgender smallint not NULL, -- �������Ա�
);

CREATE TABLE worker_info(
    -- ������Ա��Ϣ��
    Sno int PRIMARY KEY, -- Ա����ţ�ѧ��
    Sjob varchar(6) not NULL, -- �����ֵ����� -- Ա��ְλ
    Sgrade smallint not NULL, -- Ա���꼶
    Sname varchar(16) not NULL, -- Ա������
);

CREATE TABLE replenish(
    -- ��Ӧ��Ϣ��
    -- I delete selfno, add Inum(input product number), 
    Ino int identity(1,1) PRIMARY KEY,                                                                -- �������
    Prono int foreign key references supplier(Prono),                                   -- ��Ӧ�̱��
    Pno int foreign key references product_info(Pno),                                   -- ��Ʒ���
    Inum int not NULL,-- ���������ԣ������ֵ�����                                           -- һ�ν���������
    Grossprice NUMERIC(4,2) not NULL,-- �����ֵ��ж���Ϊdouble���˴�����ʵ���޸�Ϊnumeric     -- ������
    Sno int foreign key references worker_info(Sno),                                -- Ա����� 
    Idate date not NULL,-- Shelfdate the name is misleading, maybe Idate will be better -- ��������
);

CREATE TABLE traffic_info (
    -- �������� transaction data
    Tno int identity(1,1) PRIMARY KEY,
    Ttime datetime not NULL,
    Gno int not NULL,
    Pno int not NULL foreign key references product_info(Pno),
    Cno int not NULL foreign key references customer_info(Cno),
    Sno int not NULL foreign key references worker_info(sno),
);

CREATE TABLE require_info (
    -- �����߽���
    Ono int identity(1,1) PRIMARY KEY,
    Cno int not NULL foreign key references customer_info(Cno),
    Oname varchar(50) not NULL,
    Ontime date not NULL,
    Offtime date,
    Ostatus smallint not NULL,
    Sno int foreign key references worker_info(Sno),
);

CREATE TABLE shelf(
    -- ������Ϣ��
    Shelfno int identity(1,1) PRIMARY KEY,
    Vno int not NULL,
    Shelfloc varchar(10), --�����ֵ�����
    Sno int foreign key references worker_info(Sno),
);


---����ֵ
-----supplier
insert 
into supplier(Proname)
values ('����')

insert 
into supplier(Proname)
values ('ͳһ')

insert 
into supplier(Proname)
values ('����')

insert 
into supplier(Proname)
values ('����')
----product
insert 
into product_info(Pname,Sellprice,Vno,Lno,Shelfno,Stockout_n)
values ('QQ��',4,1,7,7,300)

insert 
into product_info(Pname,Sellprice,Vno,Lno,Shelfno,Stockout_n)
values ('ԭζ��Ƭ70g',5,1,5,6,40)

insert 
into product_info(Pname,Sellprice,Vno,Lno,Shelfno,Stockout_n)
values ('�����',3.5,2,2,5,80)

insert 
into product_info(Pname,Sellprice,Vno,Lno,Shelfno,Stockout_n)
values ('��ţ��500ml',7,2,3,2,10)

----customer
insert 
into customer_info(Cno,Cname,Cgrade,Cgender)
values (163071,'���޿�',4,1)

insert 
into customer_info(Cno,Cname,Cgrade,Cgender)
values (173071,'��ϣ��',3,2)

----worker
insert 
into worker_info(Sno,Sname,Sgrade,Sjob)
values (163072,'л��',4,'���Ա')

insert 
into worker_info(Sno,Sname,Sgrade,Sjob)
values (183071,'��Ա��',2,'���Ա')

insert 
into worker_info(Sno,Sname,Sgrade,Sjob)
values (163073,'�����',4,'����')

insert 
into worker_info(Sno,Sname,Sgrade,Sjob)
values (173073,'����',3,'����Ա')

----storage
insert 
into storage(Pname,Pno,Quantity)
values ('QQ��',1,398)

insert 
into storage(Pname,Pno,Quantity)
values ('�����',2,99)

insert 
into storage(Pname,Pno,Quantity)
values ('��ţ��500ml',3,19)

insert 
into storage(Pname,Pno,Quantity)
values ('ԭζ��Ƭ70g',4,50)

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
VALUES ('QQ�ǿ�ζ̫��','2019-12-19',1,'2019-12-21',163071,163073)

INSERT 
INTO require_info(Oname,Ontime,Ostatus,Offtime,Cno,Sno)
VALUES ('���������ţ��','2019-12-20',1,'2019-12-21',173071,163073)

----producttree
INSERT
INTO producttree(Vno, Vname, Lno, Lname)
VALUES (1,'ʳƷ',7,'�ǹ�')

INSERT
INTO producttree(Vno, Vname, Lno, Lname)
VALUES (1,'ʳƷ',5,'��ʳƷ')

INSERT
INTO producttree(Vno, Vname, Lno, Lname)
VALUES (2,'����',2,'��')

INSERT
INTO producttree(Vno, Vname, Lno, Lname)
VALUES (2,'����',3,'ţ��')

insert
into user_info(Cno, Username,Password,Type)
values(163071, 'student1', '123','3')