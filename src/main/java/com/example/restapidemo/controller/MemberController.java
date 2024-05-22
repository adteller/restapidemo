package com.example.restapidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restapidemo.model.Member;

@RestController
public class MemberController {

    @GetMapping(path = "/test")
    public Member memberTest(){
        Member testMember = new Member();
        testMember.setId(1);
        testMember.setName("James");
        testMember.setAge(15);
        testMember.setDept("Training");

        return testMember;
    }
}
