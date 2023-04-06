package com.jerodis.repository;

import com.jerodis.domain.Compensation;
import com.jerodis.domain.Penalty;
import com.jerodis.dto.CompensationDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

import static com.jerodis.domain.QCompensation.compensation;
import static com.jerodis.domain.QPenalty.penalty;
import static com.jerodis.domain.QVoc.voc;

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

    @Override
    public void penaltySave(Penalty penalty) {
        em.persist(penalty);
    }

    @Override
    public Optional<Penalty> findOne(String vocNo) {
        return Optional.ofNullable(queryFactory
                .selectFrom(penalty)
                .join(penalty.voc, voc).on(voc.vocNo.eq(vocNo))
                .fetchOne());
    }

    @Override
    public void updatePenalty(String vocNo) {
        Penalty findPenalty = queryFactory
                .selectFrom(penalty)
                .join(penalty.voc, voc).on(voc.vocNo.eq(vocNo))
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .fetchOne();

        findPenalty.changePenalty();
    }
}
