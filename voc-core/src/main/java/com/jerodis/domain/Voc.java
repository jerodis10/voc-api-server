package com.jerodis.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Voc {

    @Id
    @GeneratedValue
    @Column(name = "voc_id")
    private Long id;

    private String party;

    private String content;
}
