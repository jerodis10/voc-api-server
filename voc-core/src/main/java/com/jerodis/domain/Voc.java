package com.jerodis.domain;

import com.jerodis.util.PartyType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Voc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voc_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String vocNo;

    @Enumerated(EnumType.STRING)
    private PartyType party;

    @Column(nullable = false)
    private String content;

    private String issueYn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voc")
    List<Compensation> compensations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voc")
    List<Penalty> penalties = new ArrayList<>();

    @Builder
    public Voc(String vocNo, PartyType party, String content) {
        this.vocNo = vocNo;
        this.party = party;
        this.content = content;
    }

    public void changeVoc() {
        this.issueYn = "Y";
    }

}
