create table tbl_member(
	userid varchar(50) not null,
	userpw varchar(50) not null,
	username varchar(50) not null,
	email varchar(100),
	regdate timestamp default now(),
	updatedate timestamp default now(),
	primary key(userid)
);

select * from tbl_member;
select * from tbl_member where userid = 'userid';
select * from tbl_member where userid = 'userid' and userpw = 'userpw';

insert into tbl_member(userid, userpw, username, email)
		values('km', '22', 'testname', 'testemail');
		
update tbl_member set userpw='pp', username='nn',email='mai'  where userid='userid';


/*--------------------------------*/
create table tbl_board(
	bno INT not null AUTO_INCREMENT,
	title varchar(200) not null,
	content text null,
	writer varchar(50) not null,
	regdate timestamp not null default now(),
	viewcnt int default 0,
	primary key (bno)
);
select * from tbl_board;
insert into tbl_board(bno, title, content, writer, regdate)
		values(502, 'ttt', 'ccc', 'www', now());

insert into tbl_board(title, content, writer)
(select title, content, writer from tbl_board);



select count(*) from tbl_board;

create table tbl_reply(
	rno int not null auto_increment,
	bno int not null default 0,
	replytext varchar(1000) not null,
	replyer varchar(50) not null,
	regdate timestamp not null default now(),
	updatedate timestamp not null default now(),
	primary key(rno)
);

alter table tbl_reply add constraint fk_board
foreign key(bno) references tbl_board(bno);/*나중에는 외래키 사용*/

select * from tbl_reply;


select * from tbl_reply where bno = 502
		order by rno desc;		
		limit 5010, 10;
		
alter table tbl_board add column replycnt int default 0;

update tbl_board set replycnt = (
	select count(rno) from tbl_reply
	where bno = tbl_board.bno
);

create table tbl_attach(
	fullName varchar(150) not null,
	bno int not null,
	regdate timestamp default now(),
	primary key(fullName)
);

alter table tbl_attach add constraint fk_board_attach
foreign key (bno) references tbl_board (bno);

select * from tbl_attach;

select * from project;
