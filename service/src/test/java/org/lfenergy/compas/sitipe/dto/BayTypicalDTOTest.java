// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lfenergy.compas.sitipe.data.entity.BayTypical;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BayTypicalDTOTest {

    @Test
    void itShouldMapProperties() {
        final BayTypical entity = new BayTypical();
        entity.setId(1);
        entity.setDescription("DESCRIPTION");
        entity.setVersion("1.00");
        entity.setContentVersion("2.00");
        entity.setAccessId(UUID.randomUUID().toString());
        entity.setLockedBy("LOCKED BY");
        entity.setLockedOn(1L);
        entity.setModifiedOn(2L);
        entity.setReferenceAccessId(UUID.randomUUID().toString());
        entity.setSmrFile("SMR FILE");
        entity.setReleased(1);
        entity.setName("NAME");

        final BayTypicalDTO result = new BayTypicalDTO(entity);

        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getDescription(), result.getDescription());
        assertEquals(entity.getVersion(), result.getVersion());
        assertEquals(entity.getContentVersion(), result.getContentVersion());
        assertEquals(entity.getAccessId(), result.getAccessId());
        assertEquals(entity.getLockedBy(), result.getLockedBy());
        assertEquals(entity.getLockedOn(), result.getLockedOn());
        assertEquals(entity.getModifiedOn(), result.getModifiedOn());
        assertEquals(entity.getReferenceAccessId(), result.getReferenceAccessId());
        assertEquals(entity.getSmrFile(), result.getSmrFile());
        assertEquals(entity.getReleased(), result.getReleased());
        assertEquals(entity.getName(), result.getName());
    }
}