package com.springbasic.kyh_springbasic;

import com.springbasic.kyh_springbasic.member.Grade;
import com.springbasic.kyh_springbasic.member.Member;
import com.springbasic.kyh_springbasic.member.MemberService;
import com.springbasic.kyh_springbasic.member.MemberServiceImpl;
import com.springbasic.kyh_springbasic.order.Order;
import com.springbasic.kyh_springbasic.order.OrderService;
import com.springbasic.kyh_springbasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
        System.out.println("order = " + order.getDiscountPrice());
    }
}
