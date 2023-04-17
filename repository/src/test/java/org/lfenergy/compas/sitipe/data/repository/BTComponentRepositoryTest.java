// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.data.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lfenergy.compas.sitipe.data.entity.BTComponent;
import org.lfenergy.compas.sitipe.data.entity.BayTypical;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class BTComponentRepositoryTest {

    private BTComponentRepository sut;

    @BeforeEach
    public void setUp() {
        sut = spy(BTComponentRepository.class);
    }

    @Test
    void itShouldGetBTComponents() {
        final ArgumentCaptor<String> causeArgumentCaptor = ArgumentCaptor.forClass(String.class);
        final ArgumentCaptor<String> typeArgumentCaptor = ArgumentCaptor.forClass(String.class);
        final ArgumentCaptor<String> toolNameArgumentCaptor = ArgumentCaptor.forClass(String.class);

        doReturn(emptyList()).when(sut).list(causeArgumentCaptor.capture(), typeArgumentCaptor.capture(), toolNameArgumentCaptor.capture());

        final String accessId = UUID.randomUUID().toString();

        final List<BTComponent> result = sut.findBayTypicalComponentsByTypicalAccessId(accessId);

        assertEquals("DIGSI 5", toolNameArgumentCaptor.getValue());

        assertEquals("typicalAccessId = ?1 AND toolName = ?2", causeArgumentCaptor.getValue());
        assertEquals(accessId, typeArgumentCaptor.getValue());
        assertEquals(0, result.size());
    }
}