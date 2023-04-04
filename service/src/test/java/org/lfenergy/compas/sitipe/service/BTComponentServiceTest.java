package org.lfenergy.compas.sitipe.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lfenergy.compas.sitipe.data.entity.BTComponent;
import org.lfenergy.compas.sitipe.data.repository.BTComponentRepository;
import org.lfenergy.compas.sitipe.dto.BTComponentDTO;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BTComponentServiceTest {

    @Mock
    private BTComponentRepository btComponentRepository;

    private BTComponentService sut;



    @BeforeEach
    public void setUp() {
        sut = new BTComponentService(btComponentRepository);
    }

    @Test
    public void itShouldReturnListOfBTComponents() {
        final BTComponent btComponent1 = new BTComponent();
        btComponent1.setId(1);

        final BTComponent btComponent2 = new BTComponent();
        btComponent2.setId(2);

        final String accessId = UUID.randomUUID().toString();

        when(btComponentRepository.findBayTypicalComponentsByTypicalAccessId(accessId))
            .thenReturn(asList(btComponent1, btComponent2));

        final List<BTComponentDTO> result = sut.getBTComponentsByBayTypicalAccessId(accessId);

        assertEquals(2, result.size());
        assertTrue(asList(btComponent1.getId(), btComponent2.getId()).contains(result.get(0).getId()));
        assertTrue(asList(btComponent1.getId(), btComponent2.getId()).contains(result.get(1).getId()));
    }

    @Test
    public void itShouldReturnEmptyListWhenNoBTComponentsFound() {
        final String accessId = UUID.randomUUID().toString();

        when(btComponentRepository.findBayTypicalComponentsByTypicalAccessId(accessId))
            .thenReturn(emptyList());

        final List<BTComponentDTO> result = sut.getBTComponentsByBayTypicalAccessId(accessId);

        assertEquals(0, result.size());
    }
}