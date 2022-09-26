package com.kh.notice.web;


import com.kh.notice.domain.dao.Notice;
import com.kh.notice.domain.svc.NoticeSVC;
import com.kh.notice.web.form.EditForm;
import com.kh.notice.web.form.MainForm;
import com.kh.notice.web.form.WriteForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

  private final NoticeSVC noticeSVC;

  //
  @GetMapping("/main")
  public String nmainForm() {
    return "notice/nmainForm";
  }

  @PostMapping("/main")
  public String main(MainForm mainForm) {
    log.info("mainForm={}", mainForm);

    Notice notice = new Notice();
    notice.setNoticeId(mainForm.getNoticeId());
    notice.setTitle(mainForm.getTitle());
    notice.setContent(mainForm.getContent());
    notice.setWrite_name(mainForm.getWrite_name());
    noticeSVC.save(notice);

    return "notice/nmainForm";
  }


  @GetMapping("/{id}")
  public String findById() {
    return "notice/notice-writeForm";
  }


  //등록양식
  @GetMapping("/write")
  public String writeForm() {

    return "notice/notice-writeForm";
  }

  @PostMapping("write")
  public String save(WriteForm writeForm) {
    log.info("WriteForm={}", writeForm);

    Notice notice = new Notice();
    notice.setTitle(writeForm.getTitle());
    notice.setContent(writeForm.getContent());
    notice.setContent(writeForm.getContent());

    Notice savedNotice = noticeSVC.save(notice);
    return "redirect:/notice" + savedNotice.getNoticeId();
  }

  //
  @GetMapping("/modify")
  public String editForm(@PathVariable("nid")Long nid, Model model) {

    Notice findednotice = noticeSVC.findById(nid);

    //Product => EditForm 변환
    EditForm editForm = new EditForm();
    editForm.setTitle(findednotice.getTitle());
    editForm.setContent(findednotice.getContent());
    editForm.setWrite_name(findednotice.getWrite_name());

    model.addAttribute("editForm",editForm);

    return "notice/notice-modifyForm";  //상품 수정 view
  }



//
//  //  //개별조회
//  @GetMapping("/{nid}")
//  public String findByNoticeId(
//      @PathVariable("nid") Long nid,
//      Model model
//  ) {
//    Optional<Notice> findedNotice = noticeSVC.findByNoticeId(nid);
//    ItemForm itemForm = new ItemForm();
//    if (!findedNotice.isEmpty()) {
//      BeanUtils.copyProperties(findedNotice.get(), itemForm);
//    }
//    model.addAttribute("form", itemForm);
//    return "notices/notice-viewForm";
//  }
//
//  //수정 양식
//  @GetMapping("/{id}edit")
//  public String itemForm(@PathVariable("id") Long noticeId, Model model) {
//    Optional<Notice> findedNotice = noticeSVC.findByNoticeId(noticeId);
//    SaveForm saveForm = new SaveForm();
//    if (!findedNotice.isEmpty()) {
//      BeanUtils.copyProperties(findedNotice.get(), saveForm);
//    }
//    model.addAttribute("form", saveForm);
//    return "notices/notice-modifyForm";
//  }
//
//
//  //수정
//  @PostMapping("/{id}/edit")
//  public String itemForm(@PathVariable("id") Long noticeId,
//                         @Valid @ModelAttribute("form") ItemForm itemForm,
//                         BindingResult bindingResult,
//                         RedirectAttributes redirectAttributes) {
//    if (bindingResult.hasErrors()) {
//      log.info("bindingResult={}", bindingResult);
//      return "notices/itemForm";
//    }
//
//    redirectAttributes.addAttribute("form", itemForm);
//
//    return "redirect:notices/{id}/notice-modifyForm";
//  }
//
//
//  //
//  @GetMapping("/{id}/del")
//  public String deleteById(@PathVariable("id") Long noticeId) {
//    noticeSVC.deleteByNoticeId(noticeId);
//
//    return "redirect:/notices";
//  }
//
//  //
//  @GetMapping
//  public String findAll(Model model) {
//    List<Notice> notices = noticeSVC.findAll();
//
//    List<Notice> list = new ArrayList<>();
//    notices.stream().forEach(notice -> {
//      BeanUtils.copyProperties(notice, new EditForm());
//      list.add(notice);
//    });
//    model.addAttribute("list", list);
//    return "notices/notice-mainForm";
//  }
//

}
