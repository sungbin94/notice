package com.kh.notice.domain.dao.notice;

import com.kh.notice.domain.entity.notice.Notice;

import java.util.List;

public interface NoticeDAO {

  //등록
  Notice save(Notice notice);

  //전체조회
  List<Notice> selectAll();


  //조회
  Notice findById(Long noticeId);

  //수정
  void update(Long noticeId,Notice notice);

  //삭제
  int deleteByNoticeId(Long noticeId);

  //조회수증가
  int updateCount(Long noticeId);

}