package com.jerodis.repository;

import com.jerodis.domain.Compensation;
import com.jerodis.dto.CompensationDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jerodis.domain.QCompensation.compensation;

@Repository
public class JpaCompensationRepository implements CompensationRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public JpaCompensationRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public void save(Compensation compensation) {
        em.persist(compensation);
    }

    @Override
    public List<CompensationDto> findAll() {
        return queryFactory
                .select(Projections.fields(CompensationDto.class,
                        compensation.amount))
                .from(compensation)
                .fetch();
    }
}
