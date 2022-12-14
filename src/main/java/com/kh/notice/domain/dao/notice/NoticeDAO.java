package com.kh.notice.domain.dao.notice;

import com.kh.notice.domain.entity.notice.Notice;

import java.util.List;

public interface NoticeDAO {

  /**
   * 목록
   * @return
   */
  List<Notice>  foundAll();
  List<Notice>  findAll(int startRec, int endRec);


  /**
   * 검색
   * @param filterCondition 분류,시작레코드번호,종료레코드번호,검색유형,검색어
   * @return
   */
  List<Notice>  findAll(BbsFilterCondition filterCondition);


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

  /**
   * 전체건수
   * @return 게시글 전체건수
   */
  int totalCount();
  int totalCount(BbsFilterCondition filterCondition);



}