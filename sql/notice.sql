drop table notice;
---------
--��������
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
--�⺻Ű����
alter table notice add Constraint notice_notice_id_pk primary key (notice_id);

--������
drop sequence notice_notice_id_seq;
create sequence notice_notice_id_seq;


insert into notice(notice_id, title, content, write,Attachments, count)
  values(notice_notice_id_seq.nextval,'����','����','������','1','1');


  select notice_id, title, content, write, Attachments, count, udate
from notice
order by notice_id desc;

select notice_id, title,content,write,Attachments, count,  udate
from notice
where notice_id = 44;


update notice
set title = '�����̴�' ,
content = '�����̴�' ,
udate   = systimestamp
where notice_id = 1;

delete from notice
where notice_id = 1;

rollback;

SELECT
  * FROM
    notice;
    where notice_id =161;

--��ü����--
delete from notice;

--��ü��ȸ-
select notice_id,notice_title,notice_content,write_name,view_count,modify_date
  from notice;

 
 
 
 