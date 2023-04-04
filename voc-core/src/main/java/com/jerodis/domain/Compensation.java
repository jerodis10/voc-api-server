package com.jerodis.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Compensation {

    @Id
    @GeneratedValue
    @Column(name = "compensation_id")
    private Long id;

    private Long amount;


    @Builder
    public Compensation(Long amount) {
        this.amount = amount;
    }
}
