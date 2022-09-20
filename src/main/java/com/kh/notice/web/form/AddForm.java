package com.kh.notice.web.form;

import lombok.Data;

@Data
public class AddForm {
  private String title;       //제목
  private String content;          //내용
  private String write_name;       //작성자
}

