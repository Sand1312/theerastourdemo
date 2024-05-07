package com.example.theerastourdemo;

import com.example.theerastourdemo.Entity.Member;
import com.example.theerastourdemo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TheerastourdemoApplication {
    private MemberService memberService;
    public static void main(String[] args) {
        SpringApplication.run(TheerastourdemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hello World");
            in();
        };
    }

    public void in(){
        //@Autowired
       //  MemberService memberService;

        List<Member> members = memberService.findAllMemberByRole("ROLE_EMPLOYEE");
        System.out.println(members);

    }






}
