package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;
    //클라이언트인 OrderserviceImpl 의 코드를 고쳐야 함..
    // DIP : 추상 인터페이스 뿐 아니라 구체(구현) 클래스에도 의존하고 있다.
    // OCP : 변경하지 않고 확장할 수 있다고 했지만, 클라이언트의 코드를 바꿔야한다는 점.
    // 이 문제를 해결하기 위해서는, 누군가 클라이언트에 DiscountPolicy의 구현 객체를 대신 생성하여 주입해주어야 한다.

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
