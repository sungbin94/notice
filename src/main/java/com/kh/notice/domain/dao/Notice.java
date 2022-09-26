package com.kh.notice.domain.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table
public class Notice{

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notice_id")
  private Long noticeId;              // --공지사항게시글 번호
  private String title;               //--게시글 제목
  private String content;             //--게시글 내용
  private String write_name;          //--작성자(관리자)
  private int count;

}

