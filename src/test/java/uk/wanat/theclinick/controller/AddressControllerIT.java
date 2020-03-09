package uk.wanat.theclinick.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import uk.wanat.theclinick.model.Address;
import uk.wanat.theclinick.service.AddressServiceImpl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressServiceImpl addressService;


    @Test
    void putAddAddressReturnsHttpStatusOk() throws Exception {
        //given
        Address addressBuilder = Address.builder().street("20 Deans Yd").city("London").postcode("SW1P 3PA").build();
        //when
        when(addressService.create(addressBuilder)).thenReturn(expectedAddress());

        mockMvc.perform(
                put("/address/{id}/addAddress", "1")
                        .sessionAttr("address", addressBuilder))
                .andExpect(status().isOk());
    }

    private Address expectedAddress() {
        Address address = Address.builder().street("20 Deans Yd").city("London").postcode("SW1P 3PA").build();
        return address;
    }

}