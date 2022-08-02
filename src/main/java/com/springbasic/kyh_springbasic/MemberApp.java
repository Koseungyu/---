package com.springbasic.kyh_springbasic;

import com.springbasic.kyh_springbasic.member.Grade;
import com.springbasic.kyh_springbasic.member.Member;
import com.springbasic.kyh_springbasic.member.MemberService;
import com.springbasic.kyh_springbasic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig의 모든 내용을 컨테이너에 담아 관리 해줌.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //applicationContext 즉, AppConfig에 있는 bean들 중에서 memberService를 불러움.

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findmember = memberService.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("find member = " + findmember.getName());
    }
}
