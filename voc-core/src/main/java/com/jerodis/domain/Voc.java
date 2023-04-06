package com.jerodis.domain;

import com.jerodis.entity.BaseEntity;
import com.jerodis.util.ExistType;
import com.jerodis.util.PartyType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicUpdate
@Table(name = "voc", indexes = { @Index(name = "index_id", columnList = "vocNo") })
public class Voc extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voc_id")
    @Audited(withModifiedFlag = true)
    private Long id;

    @Column(nullable = false, unique = true)
    @Audited(withModifiedFlag = true)
    private String vocNo;

    @Enumerated(EnumType.STRING)
    private PartyType party;

    @Column(nullable = false)
    @Audited(withModifiedFlag = true)
    private String content;

    @Audited(withModifiedFlag = true)
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
        this.issueYn = ExistType.YES.getType();
    }

}
