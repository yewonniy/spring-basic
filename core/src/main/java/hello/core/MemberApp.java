package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        /* *
         * 파라미터 첫 번째는 AppConfig에 있는 메서드 명, 두번째 꺼는 반환 타입. 스프링 컨테이너에서 "merberService" 이름을 주고 거기서 꺼내온다.
         * 스프링 컨테이너에는 appConfig의 메서드명이 키로, return 값(new 어쩌구 객체)이 value로 저장되어 있다.
         */

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("memberA = " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
