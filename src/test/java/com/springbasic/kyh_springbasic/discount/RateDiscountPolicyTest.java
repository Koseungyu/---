package com.springbasic.kyh_springbasic.discount;

import com.springbasic.kyh_springbasic.member.Grade;
import com.springbasic.kyh_springbasic.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

//RateDiscountPolicy 클래스에서 ctrl+shift+T 를 누르면 Test클래스가 만들어짐.
class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다.")
    void vip_o(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 20000);

        //then
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        Member member = new Member(1L,"memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 20000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}