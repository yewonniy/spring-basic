package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 모든 빈의 이름을 가져온다
        for (String name : beanDefinitionNames) {
            Object bean = ac.getBean(name);
            System.out.println("name = " + name + ", bean = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기 (우리가 등록한 빈만 출력하기. 스프링 내부 빈 말고)")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 모든 빈의 이름을 가져온다
        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("name = " + name + ", bean = " + beanDefinition);
            }
        }
    }
}
