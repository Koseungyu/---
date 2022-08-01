package com.springbasic.kyh_springbasic.discount;

import com.springbasic.kyh_springbasic.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
