// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.helper;

import org.lfenergy.compas.sitipe.SitipeProperties;
import org.lfenergy.compas.sitipe.data.entity.BayTypical;
import org.lfenergy.compas.sitipe.data.entity.SystemVersion;
import org.lfenergy.compas.sitipe.data.repository.BayTypicalRepository;
import org.lfenergy.compas.sitipe.data.repository.SystemVersionRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

import static java.util.Arrays.asList;

@ApplicationScoped
@Transactional
public class SystemVersionHelper {

    private final SystemVersionRepository systemVersionRepository;
    private final BayTypicalRepository bayTypicalRepository;

    private final SitipeProperties sitipeProperties;
    @Inject
    public SystemVersionHelper(
        final SystemVersionRepository systemVersionRepository,
        final BayTypicalRepository bayTypicalRepository,
        final SitipeProperties sitipeProperties
    ) {
        this.systemVersionRepository = systemVersionRepository;
        this.bayTypicalRepository = bayTypicalRepository;

        this.sitipeProperties = sitipeProperties;
    }

    public SystemVersion createAndStoreSystemVersion(final Long id, final String version) {
        final SystemVersion systemVersion = new SystemVersion();

        systemVersion.setId(id);
        systemVersion.setVersion(version);

        systemVersion.setComment("TEST");
        systemVersion.setDescription("TEST");

        systemVersion.setAccessId(UUID.randomUUID().toString());

        systemVersion.setReferenceAccessId(UUID.randomUUID().toString());

        systemVersion.setLockedBy("");
        systemVersion.setLockedOn(0L);
        systemVersion.setModifiedOn(0L);

        systemVersionRepository.persistAndFlush(systemVersion);

        return systemVersion;
    }

    public SystemVersion assignBayTypicalToSystemVersion(final Long systemVersionId, final BayTypical bayTypical) {
        final List<String> assignedBayTypicals = new ArrayList<>();
        assignedBayTypicals.add(bayTypical.getAccessId().toString());
        final SystemVersion systemVersion = systemVersionRepository.findById(systemVersionId);

        Optional
            .ofNullable(systemVersion.getAssignedBayTypicals())
            .ifPresent((a) -> assignedBayTypicals.addAll(asList(a.split(","))));

        systemVersion.setAssignedBayTypicals(
            String.join(
                ",",
                assignedBayTypicals
            )
        );


        systemVersionRepository.persistAndFlush(systemVersion);

        return systemVersion;
    }

    public BayTypical createAndStoreBayTypical(Integer id) {
        final BayTypical bayTypical = new BayTypical();

        bayTypical.setId(id);
        bayTypical.setAccessId(UUID.randomUUID().toString());
        bayTypical.setContentVersion("1.0");
        bayTypical.setVersion(sitipeProperties.version());
        bayTypical.setDescription("TEST");

        bayTypicalRepository.persistAndFlush(bayTypical);

        return bayTypical;
    }
}
