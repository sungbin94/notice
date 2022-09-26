drop table notice;
--�������� ���̺� ����

create table notice(
notice_id number(10),                --�������װԽñ� ��ȣ
notice_title varchar2(150),                --�Խñ� ����
notice_content varchar2(1500),        --�Խñ� ����
write_name varchar2(30),                        --�ۼ���(������)
view_count int default 0,                --��ȸ��
modify_date timestamp default systimestamp        --������
);


--�⺻Ű ����
alter table notice add constraint notice_notice_id_pk primary key(notice_id);

--����������
drop sequence notice_notice_id_seq;
create sequence notice_notice_id_seq;


insert into notice(notice_id, notice_title, notice_content, write_name, view_count)
  values(notice_notice_id_seq.nextval,'����','����','������','0');
  
insert into notice(notice_id, notice_title, notice_content, write_name, view_count)
  values(notice_notice_id_seq.nextval,'������ �Է��ϼ���','������ �Է��ϼ���','������','0');

insert into notice(notice_id, notice_title, notice_content, write_name, view_count)
  values(notice_notice_id_seq.nextval,'������ �Է��ϼ���','������ �Է��ϼ���','������','0');
  
  --��ȸ--
select notice_id, notice_title, notice_content, write_name,view_count,modify_date
  from notice
 where notice_id = 2;
 
 --����--
update notice
   set notice_title = '����',
       notice_content = '����',
       write_name = '������'
       where notice_id = 1;
       
--����--
delete from notice where notice_id = 1;


--��ü����--
delete from notice;

--��ü��ȸ-
select notice_id,notice_title,notice_content,write_name,view_count,modify_date
  from notice;
 
 
 
 