package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() { // 역할
        return new MemberServiceImpl(memberRepository()); //구현
    }

    @Bean
    public MemberRepository memberRepository() { // 역할
        return new MemoryMemberRepository(); // 구현
    }

    @Bean
    public OrderService orderService() { // 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 구현
    }

    @Bean
    public DiscountPolicy discountPolicy() { // 역할
//        return new FixDiscountPolicy(); // 구현 (할인 정책이 바꾸면 딱 여기만 바꾸면 됨)
        return new RateDiscountPolicy();
    }
}
