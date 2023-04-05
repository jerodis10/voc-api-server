package com.jerodis.controller;

import com.jerodis.dto.VocResponse;
import com.jerodis.service.VocService;
import com.jerodis.util.PartyType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = VocController.class)
class VocControllerTest {

    @MockBean
    private VocService vocService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("FindVoc test")
    void FindVocTest() throws Exception {
        // given
        VocResponse vocResponse = new VocResponse(PartyType.CARRIER, "content", 1L, "name");
        List<VocResponse> result = List.of(vocResponse);

        given(vocService.vocFindAll()).willReturn(result);

        // when then
        mockMvc.perform(get("/voc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{\"party\":\"CARRIER\",\"content\":\"content\",\"amount\":1,\"name\":\"name\"}]"
                ))
                .andDo(print());
    }
}