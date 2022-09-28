package com.kh.notice.web;


import com.kh.notice.domain.entity.notice.Notice;
import com.kh.notice.domain.svc.notice.NoticeSVC;
import com.kh.notice.web.form.notice.DetailForm;
import com.kh.notice.web.form.notice.EditForm;
import com.kh.notice.web.form.notice.ListForm;
import com.kh.notice.web.form.notice.WriteForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

  private final NoticeSVC noticeSVC;

  //공지사항 목록화면
  @GetMapping
  public String list(ListForm listForm, Model model) {

    List<Notice> list = noticeSVC.findAll();

    BeanUtils.copyProperties(list,listForm);

    model.addAttribute("listForm",listForm);

    return "notice/noticeMainForm";
  }

  //글쓰기화면
  @GetMapping("/write")
  public String write(Model model) {
    model.addAttribute("ItemForm", new WriteForm());
    return "notice/noticeWriteForm";
  }

  //글쓰기 처리
  @PostMapping("/write")
  public String write(@ModelAttribute WriteForm writeForm) {

    Notice notice = new Notice();
    BeanUtils.copyProperties(writeForm, notice);
    log.info("notice : {}", notice);

    noticeSVC.write(notice);

    return "notice/noticeViewForm";
  }

  //조회화면
  @GetMapping("/{id}")
  public String article(@PathVariable("id") Long noticeId, DetailForm detailForm, Model model) {
    Notice readNotice = noticeSVC.findById(noticeId);

    BeanUtils.copyProperties(detailForm, readNotice);

    model.addAttribute("detailForm", detailForm);

    return "notice/noticeViewForm";
  }

  //수정화면
  @GetMapping("/{id}/edit")
  public String edit(@PathVariable("id") Long noticeId, Model model) {

    Notice modifyNotice = noticeSVC.findById(noticeId);

    EditForm editForm = new EditForm();
    BeanUtils.copyProperties(editForm, modifyNotice);

    model.addAttribute("editForm", editForm);

    return "notice/noticeModifyForm";
  }

  //수정처리
  @PostMapping("/{id}/edit")
  public String edit(@PathVariable("id") Long noticeId, EditForm editForm) {

    Notice notice = new Notice();
    BeanUtils.copyProperties(editForm, notice);

    noticeSVC.modify(noticeId, notice);

    return "redirect:/notice/" + noticeId;
  }

  //삭제
  @GetMapping("/{id}/del")
  public String delete(@PathVariable("id") Long noticeId) {

    noticeSVC.deleteByNoticeId(noticeId);

    return "redirect:/notice/noticeMainForm";
  }
}




























