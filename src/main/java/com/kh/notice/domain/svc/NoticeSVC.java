package com.kh.notice.domain.svc;

import com.kh.notice.domain.dao.Notice;

import java.util.List;

public interface NoticeSVC {
  //등록
  Notice write(Notice notice);
  //전체조회
  List<Notice> findAll();
  //상세
  Notice findByNoticeId(Long noticeId);
  //수정
  Notice modify(Notice notice);
  //삭제
  int remove(Long noticeId);
  //조회수증가
  int increaseCount(Long noticeId);
}

