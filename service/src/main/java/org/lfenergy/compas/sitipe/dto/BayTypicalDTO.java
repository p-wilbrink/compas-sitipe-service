// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.dto;

import org.lfenergy.compas.sitipe.data.entity.BayTypical;

public class BayTypicalDTO {

    private final Integer id;
    private final String accessId;

    private final String description;

    private final String contentVersion;

    private final String lockedBy;

    private final Long lockedOn;

    private final Long modifiedOn;

    private final String name;

    private final String referenceAccessId;

    private final String smrFile;

    private final String version;

    private final int released;

    public BayTypicalDTO(
            final BayTypical entity
    ) {
        this.id = entity.getId();
        this.accessId = entity.getAccessId();
        this.description = entity.getDescription();
        this.contentVersion = entity.getContentVersion();
        this.lockedBy = entity.getLockedBy();
        this.lockedOn = entity.getLockedOn();
        this.modifiedOn = entity.getModifiedOn();
        this.name = entity.getName();
        this.referenceAccessId = entity.getReferenceAccessId();
        this.smrFile = entity.getSmrFile();
        this.version = entity.getVersion();
        this.released = entity.getReleased();
    }

    public Integer getId() {
        return id;
    }

    public String getAccessId() {
        return accessId;
    }

    public String getDescription() {
        return description;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public Long getLockedOn() {
        return lockedOn;
    }

    public Long getModifiedOn() {
        return modifiedOn;
    }

    public String getName() {
        return name;
    }

    public String getReferenceAccessId() {
        return referenceAccessId;
    }

    public String getSmrFile() {
        return smrFile;
    }

    public String getVersion() {
        return version;
    }

    public int getReleased() {
        return released;
    }
}
