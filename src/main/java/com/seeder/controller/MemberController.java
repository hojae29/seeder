package com.seeder.controller;

import com.seeder.domain.Member;
import com.seeder.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> register(Member member){
        memberService.add(member);
        return ResponseEntity.ok("인증되었습니다.");
    }

}
