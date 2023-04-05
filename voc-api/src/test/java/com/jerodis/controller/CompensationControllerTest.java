package com.jerodis.controller;

import com.jerodis.dto.CompensationResponse;
import com.jerodis.service.CompensationService;
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
@WebMvcTest(controllers = CompensationController.class)
class CompensationControllerTest {

    @MockBean
    private CompensationService compensationService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("findVocTest")
    void findVocTest() throws Exception {
        // given
        CompensationResponse compensationResponse = new CompensationResponse(1L);
        List<CompensationResponse> result = List.of(compensationResponse);

        given(compensationService.compensationFindAll()).willReturn(result);

        // when then
        mockMvc.perform(get("/comp")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{\"amount\":1}]"
                ))
                .andDo(print());

    }
}