package com.seeder.controller;

import com.seeder.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<String> register(Member member){
        System.out.println(member);

        return ResponseEntity.ok("인증되었습니다.");
    }

}
