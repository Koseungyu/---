package com.springbasic.kyh_springbasic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

//    private static MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired                  //의존관계 자동 주입을 위해 @Autowired 사용.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
            memberRepository.save(member);
        }

    @Override
    public Member findMember(Long memberId) {
            return memberRepository.findById(memberId);
        }

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
