package io.jmlim.springdatajpastudy2.post;

import io.jmlim.springdatajpastudy2.MyRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

//public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post> {
public interface PostRepository extends MyRepository<Post, Long>, QuerydslPredicateExecutor<Post> {
}
