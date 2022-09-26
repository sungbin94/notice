package com.kh.notice.web.form;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemForm {
  private Long noticeId;             //공시사항번호
  private String title;             //제목
  private String content;           //내용
  private String write_name;       //작성자
}

