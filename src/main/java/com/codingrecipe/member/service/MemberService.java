package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    // 저장소(DB)연결
    private final MemberRepository memberRepository;

    // 회원가입
    public int save(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    // 로그인
    public boolean login(MemberDTO memberDTO) {
        MemberDTO issetMemberDTO = memberRepository.login(memberDTO);
        return issetMemberDTO != null;
    }

    // 검색 : id
    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    // 회원 삭제
    public void delete(Long id) {
        memberRepository.delete(id);
    }

    // 회원 리스트
    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    public MemberDTO findByEmail(String loginEmail) {
        return memberRepository.findByEmail(loginEmail);
    }

    public boolean update(MemberDTO memberDTO) {
        int updateResult = memberRepository.update(memberDTO);
        return updateResult == 1;
    }

    public String emailCheck(String email) {
        MemberDTO memberDTO = memberRepository.findByEmail(email);
        return (memberDTO == null) ? "ok" : "no";
    }
}
