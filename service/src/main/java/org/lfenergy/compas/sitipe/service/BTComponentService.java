// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.service;

import org.lfenergy.compas.sitipe.data.repository.BTComponentRepository;
import org.lfenergy.compas.sitipe.dto.BTComponentDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BTComponentService {

    private final BTComponentRepository btComponentRepository;

    @Inject
    public BTComponentService(
        final BTComponentRepository btComponentRepository
    ) {
        this.btComponentRepository = btComponentRepository;
    }

    public List<BTComponentDTO> getBTComponentsByBayTypicalAccessId(final String accessId) {
        return btComponentRepository.findBayTypicalComponentsByTypicalAccessId(accessId)
            .stream()
            .map(BTComponentDTO::new)
            .toList();
    }

}
