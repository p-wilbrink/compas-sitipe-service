// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lfenergy.compas.sitipe.data.entity.BTComponent;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BTComponentDTOTest {

    @Test
    public void itShouldMapProperties() {
        final BTComponent entity = new BTComponent();

        entity.setId(1);
        entity.setImportedOn(1L);
        entity.setReferenceAccessId(UUID.randomUUID().toString());
        entity.setLanguage("NL");
        entity.setName("NAME");
        entity.setToolVersion("1.00");
        entity.setIniVersion(2);
        entity.setToolName("TOOL NAME");
        entity.setHasIecInformation(1);
        entity.setTypicalAccessId(UUID.randomUUID().toString());
        entity.setComponentGuid(UUID.randomUUID().toString());
        entity.setAccessId(UUID.randomUUID().toString());

        final BTComponentDTO result = new BTComponentDTO(entity);

        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getImportedOn(), result.getImportedOn());
        assertEquals(entity.getReferenceAccessId(), result.getReferenceAccessId());
        assertEquals(entity.getLanguage(), result.getLanguage());
        assertEquals(entity.getName(), result.getName());
        assertEquals(entity.getToolVersion(), result.getToolVersion());
        assertEquals(entity.getToolName(), result.getToolName());
        assertEquals(entity.getIniVersion(), result.getIniVersion());
        assertEquals(entity.getTypicalAccessId(), result.getTypicalAccessId());
        assertEquals(entity.getComponentGuid(), result.getComponentGuid());
        assertEquals(entity.getHasIecInformation(), result.getHasIecInformation());
        assertEquals(entity.getAccessId(), result.getAccessId());
    }
}