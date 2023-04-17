// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.dto;

import org.lfenergy.compas.sitipe.data.entity.BTComponent;

public class BTComponentDTO {

    private final Integer id;
    private final String name;
    private final String typicalAccessId;
    private final Long importedOn;
    private final String toolName;
    private final String toolVersion;
    private final int hasIecInformation;
    private final String componentGuid;
    private final String accessId;
    private final String language;
    private final int iniVersion;
    private final String referenceAccessId;

    public BTComponentDTO(
        final BTComponent entity
    ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.typicalAccessId = entity.getTypicalAccessId();
        this.importedOn = entity.getImportedOn();
        this.toolName = entity.getToolName();
        this.toolVersion = entity.getToolVersion();
        this.hasIecInformation = entity.getHasIecInformation();
        this.componentGuid = entity.getComponentGuid();
        this.accessId = entity.getAccessId();
        this.language = entity.getLanguage();
        this.iniVersion = entity.getIniVersion();
        this.referenceAccessId = entity.getReferenceAccessId();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypicalAccessId() {
        return typicalAccessId;
    }

    public Long getImportedOn() {
        return importedOn;
    }

    public String getToolName() {
        return toolName;
    }

    public String getToolVersion() {
        return toolVersion;
    }

    public int getHasIecInformation() {
        return hasIecInformation;
    }

    public String getComponentGuid() {
        return componentGuid;
    }

    public String getAccessId() {
        return accessId;
    }

    public String getLanguage() {
        return language;
    }

    public int getIniVersion() {
        return iniVersion;
    }

    public String getReferenceAccessId() {
        return referenceAccessId;
    }

}
