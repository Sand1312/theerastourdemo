package com.example.theerastourdemo.Service;

import com.example.theerastourdemo.Entity.Member;
import com.example.theerastourdemo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository theMemberRepository) {
        memberRepository = theMemberRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member save(Member theMember) {
        return memberRepository.save(theMember);
    }
}
