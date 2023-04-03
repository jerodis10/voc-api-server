package com.jerodis.repository;

import com.jerodis.domain.Voc;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.jerodis.domain.QVoc.voc;

@Repository
@RequiredArgsConstructor
public class JpaVocRepository implements VocRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public void save(Voc pVoc) {
        queryFactory.insert(voc)
                .columns(voc.content, voc.party)
                .values(pVoc.getContent(), pVoc.getParty())
                .execute();
    }
}
