drop table notice;
--공지사항 테이블 생성

create table notice(
notice_id number(10),                --공지사항게시글 번호
notice_title varchar2(150),                --게시글 제목
notice_content varchar2(1500),        --게시글 내용
write_name varchar2(30),                        --작성자(관리자)
view_count int default 0,                --조회수
modify_date timestamp default systimestamp        --수정일
);


--기본키 설정
alter table notice add constraint notice_notice_id_pk primary key(notice_id);

--시퀀스생성
drop sequence notice_notice_id_seq;
create sequence notice_notice_id_seq;


insert into notice(notice_id, notice_title, notice_content, write_name, view_count)
  values(notice_notice_id_seq.nextval,'제목','내용','관리자','0');
  
insert into notice(notice_id, notice_title, notice_content, write_name, view_count)
  values(notice_notice_id_seq.nextval,'제목을 입력하세요','내용을 입력하세요','관리자','0');

insert into notice(notice_id, notice_title, notice_content, write_name, view_count)
  values(notice_notice_id_seq.nextval,'제목을 입력하세요','내용을 입력하세요','관리자','0');
  
  --조회--
select notice_id, notice_title, notice_content, write_name,view_count,modify_date
  from notice
 where notice_id = 2;
 
 --수정--
update notice
   set notice_title = '제목',
       notice_content = '내용',
       write_name = '관리자'
       where notice_id = 1;
       
--삭제--
delete from notice where notice_id = 1;


--전체삭제--
delete from notice;

--전체조회-
select notice_id,notice_title,notice_content,write_name,view_count,modify_date
  from notice;
 
 
 
 