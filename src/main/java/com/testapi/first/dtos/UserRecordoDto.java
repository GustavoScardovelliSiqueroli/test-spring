package com.testapi.first.dtos;

import jakarta.validation.constraints.NotNull;

public record UserRecordoDto(@NotNull String username, @NotNull String password) {
}