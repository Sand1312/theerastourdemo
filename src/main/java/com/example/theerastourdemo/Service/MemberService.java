package com.example.theerastourdemo.Service;

import com.example.theerastourdemo.Entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll();
    Member save(Member theMember);
}
