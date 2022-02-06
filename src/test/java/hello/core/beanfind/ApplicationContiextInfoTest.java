package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContiextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean(){
       String[] beandDefinitionNames =  ac.getBeanDefinitionNames();
        for (String beandDefinitionName : beandDefinitionNames) {
            Object bean = ac.getBean(beandDefinitionName);
            System.out.println("name = " + beandDefinitionName + " object = " + bean);
        }
    }    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean(){
       String[] beandDefinitionNames =  ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beandDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //ROLE_INFRA .. 스프링이 내부에서 실행하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION)
            {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean) ;


            }
        }
    }
}
