package com.jerodis.repository;

import com.jerodis.domain.Voc;
import com.jerodis.dto.VocDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.jerodis.domain.QCompensation.compensation;
import static com.jerodis.domain.QVoc.voc;

@Repository
public class JpaVocRepository implements VocRepository{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public JpaVocRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public void save(Voc voc) {
        em.persist(voc);
    }

    @Override
    public List<VocDto> findAll() {
        return queryFactory
                .select(Projections.fields(VocDto.class,
                        voc.vocNo,
                        voc.party,
                        voc.content,
                        compensation.amount))
                .from(compensation)
                .leftJoin(compensation.voc, voc)
                .fetch();
    }

    @Override
    public Optional<Voc> findOne(String vocNo) {
        return Optional.ofNullable(queryFactory
                .selectFrom(voc)
                .where(voc.vocNo.eq(vocNo))
                .fetchOne());
    }
}
