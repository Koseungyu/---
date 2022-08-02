package com.springbasic.kyh_springbasic.order;

import com.springbasic.kyh_springbasic.discount.DiscountPolicy;
import com.springbasic.kyh_springbasic.discount.FixDiscountPolicy;
import com.springbasic.kyh_springbasic.discount.RateDiscountPolicy;
import com.springbasic.kyh_springbasic.member.Member;
import com.springbasic.kyh_springbasic.member.MemberRepository;
import com.springbasic.kyh_springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//  개방폐쇄원칙(OCP) 위반 : 할인정책을 바꾸기 위해서 fix를 rate로 바꾸어줘야한다. 소스코드까지 바꾸어야 하기에 이것은 위반이다.
//  의존관계역전원칙(DIP) 위반 : memberRepository, discountPolicy라는 추상클래스에 의존하지 않고 MemoryMemberRepository, Fix 또는 RateDiscountPolicy에 의존하고 있기에 위반이다.

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName,itemPrice,discountPrice);
    }
}
