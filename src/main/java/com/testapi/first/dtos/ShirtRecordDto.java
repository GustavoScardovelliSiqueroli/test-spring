package com.testapi.first.dtos;

import jakarta.validation.constraints.NotNull;

public record ShirtRecordDto(@NotNull String name, @NotNull Float price) {
    
}
