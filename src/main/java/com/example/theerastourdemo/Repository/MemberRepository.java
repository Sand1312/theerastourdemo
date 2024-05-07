package com.example.theerastourdemo.Repository;

import com.example.theerastourdemo.Entity.Bill;
import com.example.theerastourdemo.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(
        value =" select m from Member as m join Bill as b on b.userId = m.userId " +
                "join Ticket as ti on b.id = ti.billId where ti.tourId = ?1  " //+
               // "join Tour as to on to.id = ti.tourId"
            ,nativeQuery = true
    )
    List<Member> findByIdTourOrderByUserIdDesc(int TourId);

    @Query(
            value =" select m from Member as m where m.roles = ?1"
            ,nativeQuery = true
    )
    List<Member> findAllByRolesId(String roleID);

   // List<Member> findByIdOrderByUserIdDesc(Bill bill);


}