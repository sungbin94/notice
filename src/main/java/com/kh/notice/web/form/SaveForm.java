package com.kh.notice.web.form;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SaveForm {
  private Long noticeId;
  private String title;
  private String content;
  private String write_name;

  public SaveForm() {

  }
}
