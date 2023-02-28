// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.rest.v1;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.lfenergy.compas.sitipe.data.entity.BayTypical;
import org.lfenergy.compas.sitipe.rest.v1.model.BayTypicalResponse;
import org.lfenergy.compas.sitipe.service.BayTypicalService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

// @Authenticated
@RequestScoped
@Path("/sitipe/v1")
public class CompasSitipeResource {
    private final BayTypicalService bayTypicalService;

    @Inject
    public CompasSitipeResource(final BayTypicalService bayTypicalService) {
        this.bayTypicalService = bayTypicalService;
    }

    @GET
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    @Blocking
    public Uni<BayTypicalResponse> getHelloWorld() {
        var response = new BayTypicalResponse();

        response.setBayTypicals(
            this.bayTypicalService.getBayTypicals()
                .stream()
                .map(bt -> new BayTypicalResponse.BayTypical(
                    bt.getId(),
                    bt.getAccessId(),
                    bt.getName(),
                    bt.getVersion(),
                    bt.getDescription(),
                    bt.getReleased(),
                    bt.getLockedBy(),
                    bt.getLockedOn(),
                    bt.getModifiedOn(),
                    bt.getSmrFile(),
                    bt.getContentVersion(),
                    bt.getReferenceAccessId()
            )).collect(Collectors.toList())
        );

        return Uni.createFrom().item(response);
    }


}
