create table jspweb.category(
	cnum int primary key auto_increment,
    cname varchar(100)
);

create table jspweb.product(
	pnum int primary key auto_increment,
    pname varchar(1000),
    pprice int,
    pdiscount float,
    pactive int default 0, /*제품상태 [0:준비중, 1:판매중, 2:재고준비중]*/
    pimg varchar(1000),
    cnum int,
    foreign key (cnum) references category(cnum) on update cascade
);

create table jspweb.stock(
	snum int primary key auto_increment,
	scolor varchar(100),
    ssize varchar(100),
    samount int,
    firstdate datetime default now(),
    updatedate datetime default now() on update now(),
    pnum int,
    foreign key (pnum) references product(pnum) on delete cascade
);


***** DB 생성시 한 명령어( ; 기준 = 커서위치 ) 씩 실행단축키 = ctrl+엔터