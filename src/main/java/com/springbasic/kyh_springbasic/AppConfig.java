package com.springbasic.kyh_springbasic;

import com.springbasic.kyh_springbasic.discount.DiscountPolicy;
import com.springbasic.kyh_springbasic.discount.FixDiscountPolicy;
import com.springbasic.kyh_springbasic.discount.RateDiscountPolicy;
import com.springbasic.kyh_springbasic.member.MemberRepository;
import com.springbasic.kyh_springbasic.member.MemberService;
import com.springbasic.kyh_springbasic.member.MemberServiceImpl;
import com.springbasic.kyh_springbasic.member.MemoryMemberRepository;
import com.springbasic.kyh_springbasic.order.OrderService;
import com.springbasic.kyh_springbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
         return new OrderServiceImpl(new MemoryMemberRepository(),discountPolicy());
//        return null;
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }

}
