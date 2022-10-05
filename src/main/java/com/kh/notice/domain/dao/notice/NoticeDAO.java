package com.kh.notice.domain.dao.notice;

import com.kh.notice.domain.entity.notice.Notice;

import java.util.List;

public interface NoticeDAO {

  //등록
  Notice save(Notice notice);

  //전체조회
  List<Notice> selectAll();


  //조회
  Notice read(Long noticeId);

  /**
   * 게시글 수정
   *
   * @param noticeId 게시글 번호
   * @param notice    게시글 수정 내용
   */
  int update(Long noticeId, Notice notice);

  //삭제
  int delete(Long noticeId);

  /**
   * 조회수 증가
   * @param noticeId 게시글 번호
   * @return 수정건수
   */
  int increaseViewCount(Long noticeId);



}