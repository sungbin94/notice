package com.kh.notice.domain.svc;

import com.kh.notice.domain.dao.Notice;

import java.util.List;

public interface NoticeSVC {
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

  /**
   *
   * @param view_count
   * @param notice
   */
  void update(Long view_count, Notice notice);
}
