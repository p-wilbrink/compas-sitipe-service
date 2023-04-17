// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.data.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lfenergy.compas.sitipe.data.entity.BayTypical;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BayTypicalRepositoryTest {

    private BayTypicalRepository sut;

    @BeforeEach
    public void setUp() {
        sut = spy(BayTypicalRepository.class);
    }

    @Test
    void itShouldGetBayTypicals() {
        final ArgumentCaptor<String> causeArgumentCaptor = ArgumentCaptor.forClass(String.class);
        final ArgumentCaptor<String> typeArgumentCaptor = ArgumentCaptor.forClass(String.class);

        doReturn(emptyList()).when(sut).list(causeArgumentCaptor.capture(), typeArgumentCaptor.capture());

        final String accessId = UUID.randomUUID().toString();

        final List<BayTypical> result = sut.findByAccessId(accessId);

        assertEquals("accessId", causeArgumentCaptor.getValue());
        assertEquals(accessId, typeArgumentCaptor.getValue());
        assertEquals(0, result.size());
    }
}