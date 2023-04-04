package org.lfenergy.compas.sitipe.rest.v1.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lfenergy.compas.sitipe.data.entity.BayTypical;
import org.lfenergy.compas.sitipe.dto.BayTypicalDTO;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

@ExtendWith(MockitoExtension.class)
class BayTypicalResponseTest {

    @Test
    public void itShouldMapProperties() {
        final BayTypical entity = new BayTypical();

        entity.setId(1);
        entity.setAccessId(UUID.randomUUID().toString());
        entity.setName("NAME");
        entity.setSmrFile("SMR FILE");
        entity.setReleased(1);
        entity.setModifiedOn(2L);
        entity.setLockedOn(3L);
        entity.setLockedBy("LOCKED BY");
        entity.setVersion("1.00");
        entity.setReferenceAccessId(UUID.randomUUID().toString());
        entity.setContentVersion("2.00");

        final BayTypicalDTO bayTypical = new BayTypicalDTO(entity);
        final BayTypicalResponse result = new BayTypicalResponse();

        result.setBayTypicals(asList(new BayTypicalResponse.BayTypicalItem(bayTypical)));

        assertEquals(1, result.getBayTypicals().size());

        assertEquals(entity.getId(), result.getBayTypicals().get(0).getId());
        assertEquals(entity.getName(), result.getBayTypicals().get(0).getName());
        assertEquals(entity.getAccessId(), result.getBayTypicals().get(0).getAccessId());
        assertEquals(entity.getContentVersion(), result.getBayTypicals().get(0).getContentVersion());
        assertEquals(entity.getReleased(), result.getBayTypicals().get(0).getReleased());
        assertEquals(entity.getSmrFile(), result.getBayTypicals().get(0).getSmrFile());
        assertEquals(entity.getModifiedOn(), result.getBayTypicals().get(0).getModifiedOn());
        assertEquals(entity.getLockedOn(), result.getBayTypicals().get(0).getLockedOn());
        assertEquals(entity.getReferenceAccessId(), result.getBayTypicals().get(0).getReferenceAccessId());
        assertEquals(entity.getVersion(), result.getBayTypicals().get(0).getVersion());
        assertEquals(entity.getDescription(), result.getBayTypicals().get(0).getDescription());
        assertEquals(entity.getLockedBy(), result.getBayTypicals().get(0).getLockedBy());
    }

}