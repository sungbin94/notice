package com.kh.notice.domain.svc;

import com.kh.notice.domain.dao.Notice;
import com.kh.notice.domain.dao.NoticeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeSVCImpl implements NoticeSVC {

  private final NoticeDAO noticeDAO;


  /**
   * 등록
   *
   * @param notice
   * @return
   */
  @Override
  public Notice save(Notice notice) {
    return noticeDAO.save(notice);
  }

  @Override
  public Notice findById(Long noticeId) {

    return noticeDAO.findById(noticeId);
  }



  //수정
  @Override
  public void update(long noticeId, Notice notice) {
    noticeDAO.delete(noticeId);
  }

  @Override
  public int deleteByNoticeId(Long noticeId) {
    return 0;
  }


  //삭제
  @Override
  public void delete(Long noticeId) {
    noticeDAO.delete(noticeId);
  }

  //목록
  @Override
  public List<Notice> findAll() {
    return noticeDAO.findAll();
  }

  //전체삭제
  @Override
  public void deleteAll() {
    noticeDAO.deleteAll();

  }



}
