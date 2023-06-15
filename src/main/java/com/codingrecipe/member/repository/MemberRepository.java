package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSessionTemplate sql;

    public int save(MemberDTO memberDTO) {
        System.out.println("== save ==");
        System.out.println(memberDTO);
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        System.out.println("== login ==");
        System.out.println(memberDTO);
        return sql.selectOne("Member.login", memberDTO);
    }

    public MemberDTO findById(Long id) {
        System.out.println("== findById ==");
        System.out.println(id);
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        System.out.println("== delete ==");
        System.out.println(id);
        sql.delete("Member.delete",id);
    }

    public List<MemberDTO> findAll() {
        System.out.println("== findAll ==");
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findByEmail(String loginEmail) {
        System.out.println("== findByEmail ==");
        System.out.println(loginEmail);
        return sql.selectOne("Member.findByEmail",loginEmail);
    }

    public int update(MemberDTO memberDTO) {
        System.out.println("== update ==");
        System.out.println(memberDTO);
        return sql.update("Member.update",memberDTO);
    }
}
