package com.kh.notice.web.form;


import lombok.Data;

@Data
public class MainForm {
  private Long noticeId;
  private String title;
  private String content;
  private String write_name;
}
