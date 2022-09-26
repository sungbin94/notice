package com.kh.notice.web.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
  private Long noticeId;
  private String title;
  private String udate;
  private String ctime;
  private Long count;


}
