package com.jerodis.domain;

import com.jerodis.util.ExistType;
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
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long amount;

    private String penaltyYn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "voc_no")
    private Voc voc;

    @Builder
    public Penalty(String name, Long amount, String penaltyYn) {
        this.name = name;
        this.amount = amount;
        this.penaltyYn = penaltyYn;
    }

    public void setVoc(Voc voc) {
        this.voc = voc;
        voc.penalties.add(this);
    }

    public void changePenalty() {
        this.penaltyYn = ExistType.YES.getType();
    }
}
