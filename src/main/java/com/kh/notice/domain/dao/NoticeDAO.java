package com.kh.notice.domain.dao;

import java.util.List;

public interface NoticeDAO {

  /**
   * 등록
   * @param notice
   * @return
   */
  Notice save(Notice notice);

  /**
   * @param noticeId
   * @return
   */
  Notice findById(Long noticeId);
  /**
   *
   * @param noticeId
   * @param notice
   */
  void update(long noticeId, Notice notice);

  /**
   *
   * @param noticeId
   */
  void delete(Long noticeId);

  /**
   *
   * @return
   */
  List<Notice> findAll();

  /**
   *
   */
  void deleteAll();


}
