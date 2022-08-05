package com.springbasic.kyh_springbasic.scan;

import com.springbasic.kyh_springbasic.AutoAppConfig;
import com.springbasic.kyh_springbasic.member.MemberRepository;
import com.springbasic.kyh_springbasic.member.MemberService;
import com.springbasic.kyh_springbasic.member.MemberServiceImpl;
import com.springbasic.kyh_springbasic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }
}
