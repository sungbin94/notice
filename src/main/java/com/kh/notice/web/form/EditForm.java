package com.kh.notice.web.form;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EditForm {
  private String title;
  private String content;
  private String write_name;
}
