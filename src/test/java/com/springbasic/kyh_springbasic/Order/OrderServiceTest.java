package com.springbasic.kyh_springbasic.Order;

import com.springbasic.kyh_springbasic.AppConfig;
import com.springbasic.kyh_springbasic.discount.FixDiscountPolicy;
import com.springbasic.kyh_springbasic.member.*;
import com.springbasic.kyh_springbasic.order.Order;
import com.springbasic.kyh_springbasic.order.OrderService;
import com.springbasic.kyh_springbasic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId= 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
