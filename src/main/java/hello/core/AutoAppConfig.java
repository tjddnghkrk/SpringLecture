package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

//ComponentScan : 자동으로 스프링 빈 등록
@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
//ComponentScan 클래스가 붙은 모든 빈을 자동으로 다 등록한다.
//Appconfig와 다르게 @Bean으로 설정한 클래스가 없다!
//@Configuration도 @Component가 붙어있다.
//@ComponentScan을 하면 @Congiguration도 다 자동으로 등록한다.
//앞서 등록된 에노테이션들도 다 등록되기 때문에 일단 빼기로
public class AutoAppConfig {

}
