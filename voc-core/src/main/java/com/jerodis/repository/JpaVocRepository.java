package com.jerodis.repository;

import com.jerodis.domain.Voc;
import com.jerodis.dto.VocResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jerodis.domain.QVoc.voc;

@Repository
//@RequiredArgsConstructor
public class JpaVocRepository implements VocRepository{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public JpaVocRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public void save(Voc voc) {
//        Voc result = queryFactory.selectFrom(voc)
//                .where(voc.content.eq(pVoc.getContent()), voc.party.eq(pVoc.getParty()))
//                .fetchOne();

//        queryFactory.insert(voc)
//                .columns(voc.content, voc.party)
//                .values(pVoc.getContent(), pVoc.getParty())
//                .execute();

//        queryFactory.insert(voc)
//                .set(voc.party, pVoc.getParty())
//                .set(voc.content, pVoc.getContent())
//                .execute();

        em.persist(voc);
    }

    @Override
    public List<VocResponse> findAll() {
        return queryFactory
                .select(Projections.fields(VocResponse.class,
                        voc.party,
                        voc.content))
                .from(voc)
                .fetch();
    }
}
