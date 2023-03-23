// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.rest.v2;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.lfenergy.compas.sitipe.data.entity.BayTypical;
import org.lfenergy.compas.sitipe.service.BayTypicalService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

// @Authenticated
@RequestScoped
@Path("/v2/baytypicals")
public class BayTypicalResource {

    private final BayTypicalService bayTypicalService;

    @Inject
    public BayTypicalResource(final BayTypicalService bayTypicalService) {
        this.bayTypicalService = bayTypicalService;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Blocking
    public Uni<List<BayTypical>> getAssignedBayTypicals() {
        return Uni.createFrom().item(this.bayTypicalService.getAssignedBayTypicals());
    }

}
