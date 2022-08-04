package com.springbasic.kyh_springbasic;

import com.springbasic.kyh_springbasic.member.MemberRepository;
import com.springbasic.kyh_springbasic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//빈을 자동적으로 끌고 오기 위한 @ComponentScan.
@ComponentScan(
//        basePackages = "com.springbasic.kyh_springbasic.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
