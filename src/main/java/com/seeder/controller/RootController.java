package com.seeder.controller;

import com.seeder.domain.Member;
import com.seeder.naver.NaverClient;
import com.seeder.naver.dto.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/")
@Controller
public class RootController {

    @Autowired
    NaverClient naverClient;

    @GetMapping()
    public String index(Model model){
        List<PlaceDto> places = naverClient.searchPopularPlace();
        model.addAttribute("places", places);
        return "index";
    }
}
