package com.kh.notice.web.form.notice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WriteForm {
  private Long noticeId;
  private String title;
  private String content;
  private String write;
  private Long count;
  private LocalDateTime udate;
}
