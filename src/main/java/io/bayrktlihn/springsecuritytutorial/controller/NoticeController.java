package io.bayrktlihn.springsecuritytutorial.controller;

import io.bayrktlihn.springsecuritytutorial.model.Notice;
import io.bayrktlihn.springsecuritytutorial.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @PostMapping("notices")
    public List<Notice> getNotices() {
        return noticeRepository.findAllActiveNotices();
    }

}
