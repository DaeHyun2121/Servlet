create table tbl_artist_201905(
	artist_id char(4) primary key,
	artist_name varchar2(20),
	artist_birth char(8),
	artist_gender char(1),
	talent char(1),
	agency varchar2(20)
)

insert into tbl_artist_201905 values ('A001','황스타','19970101','F','1','A엔터테인먼트');
insert into tbl_artist_201905 values ('A002','정스타','19980201','M','2','B엔터테인먼트');
insert into tbl_artist_201905 values ('A003','박스타','19990301','M','3','C엔터테인먼트');

SELECT artist_id,artist_name, artist_birth,decode(artist_gender, 'M','남성','F','여성') artist_gender ,decode(talent, '1','보컬','2','댄스','3','랩') talent,agency  FROM tbl_artist_201905 ORDER BY artist_id;


create table tbl_mento_201905(
	mento_id char(4) primary key,
	mento_name varchar2(20)
)

insert into tbl_mento_201905 values ('J001','이멘토');
insert into tbl_mento_201905 values ('J002','한멘토');
insert into tbl_mento_201905 values ('J003','안멘토');

create table tbl_point_201905(
	serial_no char(4) primary key,
	artist_id varchar2(20),
	mento_id char(8),
	point char(3)
)

insert into tbl_point_201905 values ('P001','A001','J001','84');
insert into tbl_point_201905 values ('P002','A001','J002','54');
insert into tbl_point_201905 values ('P003','A001','J003','74');
insert into tbl_point_201905 values ('P004','A002','J001','80');
insert into tbl_point_201905 values ('P005','A002','J002','89');
insert into tbl_point_201905 values ('P006','A002','J003','87');
insert into tbl_point_201905 values ('P007','A003','J001','100');

DROP TABLE tbl_mento_201905;


SELECT DISTINCT a.artist_id, artist_name, artist_gender, point, RANK() OVER (ORDER BY point DESC) rank, mento_name FROM tbl_artist_201905 a, tbl_mento_201905 b, tbl_point_201905 c WHERE a.artist_id = c.artist_id AND b.mento_id = c.mento_id ORDER BY artist_id;
