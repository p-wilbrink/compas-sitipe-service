// SPDX-FileCopyrightText: 2023 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0

package org.lfenergy.compas.sitipe.dto;

public class ImportedDataDTO {

    private final String data;

    public ImportedDataDTO(final String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
}
