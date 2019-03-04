package io.jmlim.springdatajpastudy2;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * SimpleJpaRepository 는  Spring data Jpa 가 제공하는 가장 밑단에 있는 구현체이다.
 */
public class SimpleMyRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

    private EntityManager entityManager;

    public SimpleMyRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }

    /**
     * 만약 더 빠른 findAll 을 만들고 싶은경우..오버라이딩
     * @return
     */
    @Override
    public List<T> findAll() {
        return super.findAll();
    }
}
