package com.kh.notice.web.form.notice;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class WriteForm {
  private Long noticeId;
  @Length(min = 1, max = 50)
  private String title;
  private String content;
  private String attachments;

}
