package com.kh.notice.domain.entity.notice;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table
public class Notice{

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notice_id")
  private Long noticeId;           // --공지사항게시글 번호
  private String title;            //--게시글 제목
  private String content;          //--게시글 내용
  private String write;           //--작성자(관리자)
  private Long count;             //조회수
  private LocalDateTime udate;   //게시글 작성일(수정일)

}

