package io.jmlim.springdatajpastudy2.post;

import java.util.List;

public interface PostCustomRepository<T> {
    /**
     * - 스프링 데이터 리포지토리 인터페이스에 기능 추가.
     * @return
     */
    List<Post> findMyPost();

    /**
     * 스프링 데이터 리포지토리의 기본 기능 덮어쓰기 가능.
     * 내가 구현한것이 우선순위가 높다.
     * */
    void delete(T entity);
}
