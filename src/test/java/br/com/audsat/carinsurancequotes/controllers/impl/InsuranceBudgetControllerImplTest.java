package br.com.audsat.carinsurancequotes.controllers.impl;

import br.com.audsat.carinsurancequotes.services.insurance.InsuranceStatusUpdaterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InsuranceBudgetControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InsuranceStatusUpdaterService insuranceStatusUpdaterService;

    @Test
    public void updateInsuranceStatusByIdWithNotFoundResult() throws Exception {
        final MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .patch("/insurances/budgets/{insurance-id}", 0L)
                .param("active", "false");

        final ResultMatcher resultMatcher = MockMvcResultMatchers
                .status()
                .isNotFound();

        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(resultMatcher);
    }

    @Test
    public void updateInsuranceStatusByIdWithNotAcceptableResult() throws Exception {
        final MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .patch("/insurances/budgets/{insurance-id}", 1L)
                .param("active", "true");

        final ResultMatcher resultMatcher = MockMvcResultMatchers
                .status()
                .isNotAcceptable();

        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(resultMatcher);
    }

    @Test
    public void updateInsuranceStatusByIdWithNoContentResult() throws Exception {
        final MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .patch("/insurances/budgets/{insurance-id}", 2L)
                .param("active", "false");

        final ResultMatcher resultMatcher = MockMvcResultMatchers
                .status()
                .isNoContent();

        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(resultMatcher);
    }

}