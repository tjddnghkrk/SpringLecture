package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//관심사를 분리해주는 것.
//배역에 맞는 담당 배우를 선택하는 기획자와 같다.
//전체 구성 (config)를 관리한다.
//역할과 구현이 잘 보이도록 리팩토링 하는 방법은?

//Confit.. Bean 사용하면 스프링 컨테이너에 저장을 해준다.
@Configuration
public class AppConfig { //안쓰는 것들도 넣어줌으로써, 역할과 구현을 알려주기.

    @Bean
    public MemberService memberService(){
        return new MemberServiceimpl(memberRepository()); //여기서 지정을 해줌
    } //생성자 주입

    @Bean
    public MemberRepository memberRepository() { //함수 대체하기 (커맨드, 옵션, 엠)
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
