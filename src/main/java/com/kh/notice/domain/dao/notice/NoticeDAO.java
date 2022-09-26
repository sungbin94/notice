package com.kh.notice.domain.dao.notice;

import com.kh.notice.domain.entity.Notice;

import java.util.List;

public interface NoticeDAO {

  //등록
  Notice create(Notice notice);

  //전체조회
  List<Notice> selectAll();

  //상세
  Notice selectOne(Long noticeId);

  //수정
  Notice update(Notice notice);

  //삭제
  int delete(Long noticeId);

  //조회수증가
  int updateCount(Long noticeId);

}
