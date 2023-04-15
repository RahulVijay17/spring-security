package com.spring.security.controller;

import com.spring.security.model.Notice;
import com.spring.security.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@AllArgsConstructor
public class NoticesController {

    private NoticeRepository noticeRepository;

   /* @GetMapping("/notices")
    public String getNotices() {
        return "Here are the notices details from the DB";
    }*/

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotice(){
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices!=null){
            return ResponseEntity.ok()
                    .cacheControl(CacheControl
                    .maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        }else {
            return null;
        }
    }
}
