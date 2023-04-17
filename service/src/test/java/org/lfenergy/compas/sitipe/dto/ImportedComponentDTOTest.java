// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lfenergy.compas.sitipe.data.entity.ImportedComponent;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ImportedComponentDTOTest {

    @Test
    public void itShouldMapProperties() {
        final ImportedComponent entity = new ImportedComponent();
        entity.setId(1);
        entity.setType("TYPE");
        entity.setContentVersion("CONTENT VERSION");
        entity.setAccessId(UUID.randomUUID().toString());
        entity.setComponentAccessId(UUID.randomUUID().toString());

        final ImportedComponentDTO result = new ImportedComponentDTO(entity);

        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getType(), result.getType());
        assertEquals(entity.getContentVersion(), result.getContentVersion());
        assertEquals(entity.getAccessId(), result.getAccessId());
        assertEquals(entity.getComponentAccessId(), result.getComponentAccessId());
    }
}