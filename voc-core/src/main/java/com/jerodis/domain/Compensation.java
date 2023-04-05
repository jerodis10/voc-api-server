package com.jerodis.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicUpdate
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compensation_id")
    private Long id;

    @Column(nullable = false)
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
