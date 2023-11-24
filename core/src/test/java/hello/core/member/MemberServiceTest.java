package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest  {

    MemberSe rvice memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(memberA);
        Member findMem = memberService.findMember(1L);

        //then
        Assertions.assertThat(memberA).isEqualTo(findMem);
    }
}
