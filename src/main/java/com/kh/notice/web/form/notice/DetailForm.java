package com.kh.notice.web.form.notice;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DetailForm {
  private Long noticeId;             //공시사항번호
  private String title;             //제목
  private String content;           //내용
  private String write;       //작성자
}