package com.springbasic.kyh_springbasic.order;

import com.springbasic.kyh_springbasic.annotation.MainDiscountPolicy;
import com.springbasic.kyh_springbasic.discount.DiscountPolicy;
import com.springbasic.kyh_springbasic.member.Member;
import com.springbasic.kyh_springbasic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor                                    //final이 붙은 필수값을 생성자로 만들어준다.
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//  개방폐쇄원칙(OCP) 위반 : 할인정책을 바꾸기 위해서 fix를 rate로 바꾸어줘야한다. 소스코드까지 바꾸어야 하기에 이것은 위반이다.
//  의존관계역전원칙(DIP) 위반 : memberRepository, discountPolicy라는 추상클래스에 의존하지 않고 MemoryMemberRepository, Fix 또는 RateDiscountPolicy에 의존하고 있기에 위반이다.

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    @Autowired            //의존관계 자동 주입을 위해 @Autowired 사용.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
