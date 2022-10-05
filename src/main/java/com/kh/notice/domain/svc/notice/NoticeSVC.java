package com.kh.notice.domain.svc.notice;

import com.kh.notice.domain.entity.notice.Notice;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NoticeSVC {
  //등록
  Notice write(Notice notice);

  //전체조회
  List<Notice> findAll();


  //상세
  Notice read(Long noticeId);

  /**
   * 게시글 수정
   *
   * @param noticeId 게시글 번호
   * @param notice    게시글 수정 내용
   */
  Notice update(Long noticeId, Notice notice);

  Notice update(Long noticeId, Notice notice, List<MultipartFile> files);

  //삭제
  void delete(Long noticeId);

}
