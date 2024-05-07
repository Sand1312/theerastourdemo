package com.example.theerastourdemo.Service;

import com.example.theerastourdemo.Entity.Member;
import com.example.theerastourdemo.Entity.Roles;
import com.example.theerastourdemo.Entity.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    List<Member> findAll();
    Member save(Member theMember);
    List<Member> findAllMemberByTour(Tour tour);

    List<Member> findAllMemberByRole(String roles);
}
