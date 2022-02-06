package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

//ComponentScan : 자동으로 스프링 빈 등록
@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
//앞서 등록된 에노테이션들도 다 등록되기 때문에 일단 빼기로
public class AutoAppConfig {

}
