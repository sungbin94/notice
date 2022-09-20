package com.kh.notice.domain.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Notice {
  private Long noticeId;              // --공지사항게시글 번호
  private String title;               //--게시글 제목
  private String content;             //--게시글 내용
  private String write_name;          //--작성자(관리자)
  private Long view_count;            //--조회수
  private LocalDateTime modify_date;  //--수정일


  public Notice(String title, String content, String write_name) {
    this.title = title;
    this.content = content;
    this.write_name = write_name;
  }

  public void updateView_count(Long view_count) {
    this.view_count = view_count;
  }
}

