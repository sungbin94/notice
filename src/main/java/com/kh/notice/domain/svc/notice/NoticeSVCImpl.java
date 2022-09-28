package com.kh.notice.domain.svc.notice;

import com.kh.notice.domain.entity.notice.Notice;
import com.kh.notice.domain.dao.notice.NoticeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class NoticeSVCImpl implements NoticeSVC {

  private final NoticeDAO noticeDAO;

  /**
   * 등록
   * @param notice
   * @return
   */
  @Override
  public Notice write(Notice notice) {

    return noticeDAO.save(notice);
  }

  /**
   * 전체조회
   * @return
   */
  @Override
  public List<Notice> findAll() {
    return noticeDAO.selectAll();
  }

  /**
   * 상세조회
   *
   * @param noticeId
   * @return
   */
  @Override
  public Notice findById(Long noticeId) {
    return noticeDAO.findById(noticeId);
  }

  /**
   * 수정
   * @param notice
   * @return
   */
  @Override
  public void modify(Long noticeId, Notice notice) {

    noticeDAO.update(noticeId, notice);
  }

  /**
   * 삭제
   * @param noticeId
   * @return
   */
  @Override
  public int deleteByNoticeId(Long noticeId) {
    return noticeDAO.deleteByNoticeId(noticeId);
  }

  /**
   * 조회수 증가
   * @param noticeId
   * @return
   */
  @Override
  public int increaseCount(Long noticeId) {
    return noticeDAO.updateCount(noticeId);
  }
}