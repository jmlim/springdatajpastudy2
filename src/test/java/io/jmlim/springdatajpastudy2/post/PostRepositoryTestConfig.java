package io.jmlim.springdatajpastudy2.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Configuration
public class PostRepositoryTestConfig {


/*    @Bean
    public PostListener postListener() {
        return new PostListener();
    }*/

    /*
    리스너 클래스 자체를 만들고 싶지 않을 경우
     */
    @Bean
    public ApplicationListener<PostPublishedEvent> postListener() {
        return event -> {
            System.out.println("--------------------------------------");
            System.out.println(event.getPost().getTitle() + " is published !!");
            System.out.println("--------------------------------------");
        };
    }
}