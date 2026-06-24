package com.seppe.backend.dto.imports;

public record ImportResponse(
        String message,
        int importedRows
) {
}
