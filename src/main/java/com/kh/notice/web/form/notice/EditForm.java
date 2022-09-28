package com.kh.notice.web.form.notice;


import lombok.Data;

@Data
public class EditForm {
  private Long noticeId;
  private String title;
  private String content;
  private String write;
}
