package br.org.catolicasc.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryDTO(@NotNull String name) {
}
