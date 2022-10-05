package com.kh.notice.web;


import com.kh.notice.domain.entity.notice.Notice;
import com.kh.notice.domain.paging.FindCriteria;
import com.kh.notice.domain.svc.notice.NoticeSVC;
import com.kh.notice.web.form.notice.DetailForm;
import com.kh.notice.web.form.notice.EditForm;
import com.kh.notice.web.form.notice.WriteForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

  private final NoticeSVC noticeSVC;

  @Autowired
  @Qualifier("fc10")
  private FindCriteria fc;


  //공지사항 목록화면
  @GetMapping
  public String list(Model model) {

    List<Notice> list = noticeSVC.findAll();

    log.info("리스트 : {}", list);

    model.addAttribute("listForm", list);

    return "notice/noticeMainForm";
  }

  //글쓰기화면
  @GetMapping("/write")
  public String write(Model model) {
    model.addAttribute("WriteForm", new WriteForm());

    return "notice/noticeWriteForm";
  }

  //글쓰기 처리
  @PostMapping("/write")
  public String write(@ModelAttribute WriteForm writeForm, RedirectAttributes redirectAttributes, BindingResult bindingResult) {

    Notice notice = new Notice();
    BeanUtils.copyProperties(writeForm, notice);
    log.info("notice : {}", notice);

    Notice write = noticeSVC.write(notice);

    Notice byId = noticeSVC.read(write.getNoticeId());
    Long noticeId = byId.getNoticeId();
    redirectAttributes.addAttribute("id",noticeId);

    return "redirect:/notice/{id}";
  }

  //조회화면
  @GetMapping("/{id}")
  public String read(@PathVariable("id") Long noticeId, DetailForm detailForm, Model model) {
    Notice readNotice = noticeSVC.read(noticeId);

    BeanUtils.copyProperties(readNotice, detailForm);

    model.addAttribute("detailForm", detailForm);

    return "notice/noticeViewForm";
  }

  //수정화면
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") Long noticeId, Model model) {

    Notice modifyNotice = noticeSVC.read(noticeId);

    EditForm editForm = new EditForm();
    BeanUtils.copyProperties(modifyNotice, editForm);

    model.addAttribute("editForm", editForm);

    return "notice/noticeModifyForm";
  }

  //수정처리
  @PostMapping("/edit/{id}")
  public String edit(@PathVariable("id") Long noticeId,
                     @Valid @ModelAttribute("editForm") EditForm editForm,
                     BindingResult bindingResult,
                     RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      log.info("bindingResult={}", bindingResult);
      return "notice/noticeModifyForm";
    }
    Notice notice = new Notice();
    BeanUtils.copyProperties(editForm, notice);
    noticeSVC.update(noticeId, notice);

    redirectAttributes.addAttribute("id", noticeId);
    return "redirect:/notice/{id}";
  }

  //삭제
  @GetMapping("/{id}/del")
  public String delete(@PathVariable("id") Long noticeId) {

    noticeSVC.delete(noticeId);

    return "redirect:/notice";
  }

  //검증 오류 메시지
  private Map<String, String> getErrMsg(BindingResult bindingResult) {
    Map<String, String> errmsg = new HashMap<>();

    bindingResult.getAllErrors().stream().forEach(objectError -> {
      errmsg.put(objectError.getCodes()[0], objectError.getDefaultMessage());
    });

    return errmsg;
  }

}




























