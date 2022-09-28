package com.kh.notice.domain.svc.notice;

import com.kh.notice.domain.entity.notice.Notice;

import java.util.List;

public interface NoticeSVC {
  //등록
  Notice write(Notice notice);

  //전체조회
  List<Notice> findAll();


  //상세
  Notice findById(Long noticeId);


  //수정
  void modify(Long noticeId, Notice notice);

  //삭제
  int deleteByNoticeId(Long noticeId);

  //조회수증가
  int increaseCount(Long noticeId);


}
