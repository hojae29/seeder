package com.seeder.service;

import com.seeder.domain.Member;
import com.seeder.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void add(Member member){
        memberRepository.add(member);
    }

}
