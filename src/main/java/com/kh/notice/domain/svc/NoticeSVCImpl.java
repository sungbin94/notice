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

  @Override
  public Notice save(Notice notice) {
    return null;
  }

  @Override
  public Notice findById(Long noticeId) {
    return null;
  }

  @Override
  public void update(long noticeId, Notice notice) {

  }

  @Override
  public void delete(Long noticeId) {

  }

  @Override
  public List<Notice> findAll() {
    return null;
  }

  @Override
  public void deleteAll() {

  }

  @Override
  public void update(Long view_count, Notice notice) {

  }
}
