package com.kh.notice.web.form.notice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ListForm {
  private Long noticeId;           // --공지사항게시글 번호
  private String title;            //--게시글 제목
  private String write;           //--작성자(관리자)
  private Long count;             //조회수
  private LocalDateTime udate;   //게시글 작성일(수정일)
}
