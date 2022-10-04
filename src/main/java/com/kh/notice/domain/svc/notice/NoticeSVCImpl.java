package com.kh.notice.domain.svc.notice;

import com.kh.notice.domain.common.AttachCode;
import com.kh.notice.domain.dao.notice.NoticeDAO;
import com.kh.notice.domain.entity.notice.Notice;
import com.kh.notice.domain.entity.uploadFile.UploadFile;
import com.kh.notice.domain.svc.uploadFile.UploadFileSVC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class NoticeSVCImpl implements NoticeSVC {

  private final NoticeDAO noticeDAO;
  private final UploadFileSVC uploadFileSVC;


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
  public Notice read(Long noticeId) {
    return noticeDAO.read(noticeId);
  }


  /**
   * 게시글 수정
   *
   * @param noticeId 게시글 번호
   * @param notice    게시글 수정 내용
   */
  @Override
  public Notice update(Long noticeId, Notice notice) {
    noticeDAO.update(noticeId, notice);
    return noticeDAO.read(noticeId);
  }

  @Override
  public Notice update(Long noticeId, Notice notice, List<MultipartFile> files) {
    noticeDAO.update(noticeId, notice);

    return noticeDAO.read(noticeId);
  }

  /**
   * 삭제
   * @param noticeId
   * @return
   */
  @Override
  public void delete(Long noticeId) {
    List<UploadFile> attachFiles = uploadFileSVC.getFilesByCodeWithRid(AttachCode.P0101.name(), noticeId);

    //2)스토리지 파일 삭제
    List<UploadFile> unionFiles = new LinkedList<>();

    unionFiles.addAll(attachFiles);
   noticeDAO.delete(noticeId);
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