package uk.wanat.theclinick.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.wanat.theclinick.model.Address;
import uk.wanat.theclinick.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {

    public static final long ID = 1L;
    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressServiceImpl addressServiceImpl;

    Address returnAddress;

    @BeforeEach
    void setUp() {
        returnAddress = Address.builder().id(ID).build();
    }

    @Test
    void findById() {
        when(addressRepository.findById(anyLong())).thenReturn(Optional.of(returnAddress));

        Optional<Address> addressServiceImplById = addressServiceImpl.findById(1l);

        assertNotNull(addressServiceImplById);

    }

    @Test
    void findFirstById() {
        when(addressRepository.findFirstById(any())).thenReturn(returnAddress);
        Address addressServiceImplFirstById = addressServiceImpl.findFirstById(ID);
        assertEquals(ID, addressServiceImplFirstById.getId());
    }

    @Test
    void findAll() {
        List<Address> returnAddressList = new ArrayList<>();
        returnAddressList.add(Address.builder().id(2L).build());
        returnAddressList.add(Address.builder().id(3L).build());

        when(addressRepository.findAll()).thenReturn(returnAddressList);

        List<Address> addressServiceImplAll = addressServiceImpl.findAll();

        assertNotNull(returnAddressList);
        assertEquals(2L, addressServiceImplAll.size());
    }

    @Test
    void create() {
        Address addressToSave = Address.builder().id(1L).build();

        when(addressRepository.save(any())).thenReturn(returnAddress);

        Address addressSaved = addressServiceImpl.create(addressToSave);

        assertNotNull(addressSaved);
        verify(addressRepository).save(any());
    }


    @Test
    void deleteById() {
        addressServiceImpl.deleteById(1L);
        verify(addressRepository).deleteById(anyLong());
    }
}