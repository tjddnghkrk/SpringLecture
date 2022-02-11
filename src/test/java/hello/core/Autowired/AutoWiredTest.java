package hello.core.Autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Testbean.class);

    }

    static class Testbean{

        @Autowired(required = false) //의존관계 없을 시 메소드 자체가 호출안됨
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired //NULL이어도 호출은 되지만 NULL로 들어옴
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired // Null이어도 Optional.empty 반환
        public void setNoBean3(Optional <Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }

    }


}
