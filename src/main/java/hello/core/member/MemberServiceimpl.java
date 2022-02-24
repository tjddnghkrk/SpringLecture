package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceimpl implements MemberService{

    private final MemberRepository memberRepository; //객체에도 의존적이다 ..

    @Autowired //자동 의존관계 주입. memberRepository라는 것을 찾아와서 자동으로 의존관계 주입을 해준다.
    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //오로지 인터페이스만 받는다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findeMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
