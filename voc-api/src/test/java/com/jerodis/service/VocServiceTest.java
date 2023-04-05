package com.jerodis.service;

import com.jerodis.domain.Voc;
import com.jerodis.dto.VocForm;
import com.jerodis.dto.VocResponse;
import com.jerodis.repository.VocRepository;
import com.jerodis.util.PartyType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class VocServiceTest {

    @Autowired
    VocService vocService;

    @Autowired
    VocRepository vocRepository;

    VocForm vocForm;
    String vocNo;

    @BeforeEach
    void setup() {
        vocNo = "aa4";
        vocForm = VocForm.builder()
                .vocNo(vocNo)
                .party(PartyType.CARRIER)
                .content("1")
                .build();
    }

    @Test
    @DisplayName("voc 중복 저장시 예외 발생")
    void vocSaveDuplicate() {
        // given
        Voc voc = Voc.builder()
                .vocNo("aa4")
                .party(PartyType.CARRIER)
                .content("1")
                .build();

        vocRepository.save(voc);

        // when then
        Assertions.assertThatThrownBy(() -> vocService.vocSave(vocForm))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("등록되지 않은 VOC 의 이의제기 여부 저장시 예외 발생")
    void vocUpdateTest() {
        // when then
        Assertions.assertThatThrownBy(() -> vocService.vocUpdate(vocForm))
                .isInstanceOf(IllegalStateException.class);
    }
    
    @Test
    @DisplayName("voc 저장 test")
    void VocSaveTest() {
        // when
        vocService.vocSave(vocForm);
        
        //then
        Optional<Voc> voc = vocRepository.findOne(vocNo);
        assertThat(voc).isPresent();
    }

    @Test
    @DisplayName("voc findAll test")
    void VocFindAllTest() {
        vocService.vocSave(vocForm);

        //then
        List<VocResponse> list = vocService.vocFindAll();
        assertThat(list).hasSize(1);
    }
    
}