package io.jmlim.springdatajpastudy2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 모든 리포지토리에 공통적으로 추가하고 싶은 기능이 있을때
 */
@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    /**
     * 인자로 받은 엔티티가 PersistenceContext 에 들어있는지 확인하는 함수.
     * @param entity
     * @return
     */
    boolean contains(T entity);
}
