package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryM emberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /**
     * OrderService 입장에선 할인에 대한 건 난 모 르겠고, discountPolicy 네가 알아서 하고 결과만 나한테 던져줘!하고 설계한 것
     *  -> 잘된 설계!! (단일 책임 원칙을 잘 지킴)
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
