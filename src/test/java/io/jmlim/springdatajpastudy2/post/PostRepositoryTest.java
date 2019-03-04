package io.jmlim.springdatajpastudy2.post;

import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void crud() {
        Post post = new Post();
        post.setTitle("hibernate");
        postRepository.save(post.publish());

        Predicate predicate = QPost.post.title.containsIgnoreCase("Hi");
        Optional<Post> one = postRepository.findOne(predicate);
        assertThat(one).isNotEmpty();
    }



   /*  // AbstractAggregateRoot를 Post 가 상속받고 있으므로 이벤트를 직접 구현하지 않아도 됨.
    @Test
    public void event() {
        Post post = new Post();
        post.setTitle("event");
        PostPublishedEvent event = new PostPublishedEvent(post);

        //이벤트를 던지고 이벤트를 던지면 Post리스너에서 잡는다.
        applicationContext.publishEvent(event);
    }*/

    /*@Test
    //@Rollback(false)
    public void crud() {
        Post post = new Post();
        post.setTitle("hibernate");

        //커스텀 메소드..
        assertThat(postRepository.contains(post)).isFalse();

        // 스프링 부트 JPA 에선 이벤트 자동 퍼블리싱 기능을 지원한다.
        // save 할때 자동으로 Aggregate 안에 있던 domainEvents 를 발생시킴 (모아져 있던 이벤트 실행)
        postRepository.save(post.publish());

        assertThat(postRepository.contains(post)).isTrue();

        // postRepository.findMyPost();

        postRepository.delete(post);
        //데이터베이스에 싱크
        postRepository.flush();
    }*/
}