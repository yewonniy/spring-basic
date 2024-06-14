package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;


public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    private MemberRepository memberRepository() { // 역할
        return new MemoryMemberRepository(); // 구현체
    }

    public OrderService orderService() { // 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 구현
    }

    private DiscountPolicy discountPolicy() { // 역할
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // 구현
    }


}
