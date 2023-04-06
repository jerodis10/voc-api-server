package com.jerodis.domain;

import com.jerodis.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Compensation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compensation_id")
    @Audited(withModifiedFlag = true)
    private Long id;

    @Column(nullable = false)
    @Audited(withModifiedFlag = true)
    private Long amount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "voc_no")
    private Voc voc;


    @Builder
    public Compensation(Long amount) {
        this.amount = amount;
    }

    public void setVoc(Voc voc) {
        this.voc = voc;
        voc.compensations.add(this);
    }

}
