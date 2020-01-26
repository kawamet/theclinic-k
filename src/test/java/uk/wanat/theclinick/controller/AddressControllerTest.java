package uk.wanat.theclinick.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import uk.wanat.theclinick.model.Address;
import uk.wanat.theclinick.service.AddressServiceImpl;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AddressServiceImpl addressService;


    @BeforeEach
    void printApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name).getClass().getName())
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void putAddAddressReturnsHttpStatusOk() throws Exception {
        //given
        Address address = new Address("20 Deans Yd", "SW1P 3PA", "London");
        address.setId(1l);
        //when
        when(addressService.create(address)).thenReturn(expectedAddress());

        mockMvc.perform(
                put("/address/{id}/addAddress", "1")
                        .requestAttr("address", address))
                .andExpect(status().isOk());
    }

    private Address expectedAddress() {
        Address address = new Address("Singapore Roda", "W13 0FD", "Lonon");
        return address;
    }

}