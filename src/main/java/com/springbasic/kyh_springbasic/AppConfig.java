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
    //AppConfig를 통해서 MemberServiceImpl에 넣어줌. 결과적으로 MemberServiceImpl에서는
    //private static MemberRepository memberRepository = new MemoryMemberRepository();가 아닌,
    //private final MemberRepository memberRepository;와 생성자를 통해서 주입이 됨. 이것은 의존관계역전원칙, 개방폐쇄원칙을 지키게 되는 것.


//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }

}
