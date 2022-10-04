drop table notice;
---------
--공지사항
---------
create table notice(
    notice_id    number(8),
    title          varchar2(150),
    content     Varchar2(1500),
    write         varchar2(30),
    Attachments  varchar2(1),
    count        number(5) default 0,
    udate       timestamp default systimestamp
);
--기본키생성
alter table notice add Constraint notice_notice_id_pk primary key (notice_id);

--시퀀스
drop sequence notice_notice_id_seq;
create sequence notice_notice_id_seq;


insert into notice(notice_id, title, content, write,Attachments, count)
  values(notice_notice_id_seq.nextval,'제목','내용','관리자','1','1');


  select notice_id, title, content, write, Attachments, count, udate
from notice
order by notice_id desc;

select notice_id, title,content,write,Attachments, count,  udate
from notice
where notice_id = 44;


update notice
set title = '제목이다' ,
content = '내용이다' ,
udate   = systimestamp
where notice_id = 1;

delete from notice
where notice_id = 1;

rollback;

SELECT
  * FROM
    notice;
    where notice_id =161;

--전체삭제--
delete from notice;

--전체조회-
select notice_id,notice_title,notice_content,write_name,view_count,modify_date
  from notice;

 
 
 
 