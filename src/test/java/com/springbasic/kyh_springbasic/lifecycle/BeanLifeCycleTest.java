package com.springbasic.kyh_springbasic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetwworkClient client = ac.getBean(NetwworkClient.class);
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig{
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetwworkClient netwworkClient(){
            NetwworkClient netwworkClient = new NetwworkClient();
            netwworkClient.setUrl("http://hello-spring.dev");
            return netwworkClient;
        }
    }
}
