package io.jmlim.springdatajpastudy2.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    //@Rollback(false)
    public void crud() {
        Post post = new Post();
        post.setTitle("hibernate");

        //커스텀 메소드..
        assertThat(postRepository.contains(post)).isFalse();

        postRepository.save(post);

        assertThat(postRepository.contains(post)).isTrue();

        // postRepository.findMyPost();

        postRepository.delete(post);
        //데이터베이스에 싱크
        postRepository.flush();
    }
}