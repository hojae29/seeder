package com.seeder.repository;

import com.seeder.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSession sql;

    public void add(Member member){
        sql.insert("member.add", member);
    }
}
