package com.kh.notice.web;


import com.kh.notice.domain.dao.Notice;
import com.kh.notice.domain.svc.NoticeSVC;
import com.kh.notice.web.form.AddForm;
import com.kh.notice.web.form.DetailForm;
import com.kh.notice.web.form.EditForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

  private final NoticeSVC noticeSVC;

  //등록화면
  @GetMapping("")
  public String addForm(@ModelAttribute AddForm addForm) {
    return "notice/nmainForm";
  }

  //등록처리
  @PostMapping("")
  public String add(@ModelAttribute AddForm addForm,
                    RedirectAttributes redirectAttributes,
                    Model model) {

    log.info("AddForm={}", addForm);

    Notice notice = new Notice();
    notice.setTitle(addForm.getTitle());
    notice.setContent(addForm.getContent());
    notice.setWrite_name(addForm.getWrite_name());

    Notice writeNotice = noticeSVC.write(notice);
    redirectAttributes.addAttribute("noticeId", writeNotice.getNoticeId());

    return "redirect:/notice/nmainForm";
  }

  //  상세화면
  @GetMapping("/{noticeId}/detail")
  public String detailForm(@PathVariable Long noticeId, Model model) {

    Notice notice = noticeSVC.findByNoticeId(noticeId);

    DetailForm detailForm = new DetailForm();
    detailForm.setNoticeId(notice.getNoticeId());
    detailForm.setTitle(notice.getTitle());
    detailForm.setContent(notice.getContent());
    detailForm.setWrite_name(notice.getWrite_name());

    model.addAttribute("detailForm", detailForm);

    return "notice/notice-viewForm";
  }


  //수정화면
  @GetMapping("/{noticeId}")
  public String editForm(@PathVariable Long noticeId, Model model) {

    Notice notice = noticeSVC.findByNoticeId(noticeId);

    EditForm editForm = new EditForm();
    editForm.setNoticeId(notice.getNoticeId());
    editForm.setTitle(notice.getTitle());
    editForm.setContent(notice.getContent());
    editForm.setWrite_name(notice.getWrite_name());

    model.addAttribute("editForm", editForm);

    return "notice/notice-modifyForm";
  }
}
