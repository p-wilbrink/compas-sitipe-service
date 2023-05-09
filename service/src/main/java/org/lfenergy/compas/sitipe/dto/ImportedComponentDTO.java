// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.dto;

import org.lfenergy.compas.sitipe.data.entity.ImportedComponent;

public class ImportedComponentDTO {

    private final Integer id;
    private final String type;
    private final String contentVersion;
    private final String componentAccessId;
    private final String accessId;

    public ImportedComponentDTO(final ImportedComponent entity) {
        this.id = entity.getId();
        this.type = entity.getType();
        this.contentVersion = entity.getContentVersion();
        this.componentAccessId = entity.getComponentAccessId();
        this.accessId = entity.getAccessId();
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public String getComponentAccessId() {
        return componentAccessId;
    }

    public String getAccessId() {
        return accessId;
    }
}

