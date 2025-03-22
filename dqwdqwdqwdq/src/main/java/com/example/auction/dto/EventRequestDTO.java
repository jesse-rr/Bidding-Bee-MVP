package com.example.eventmanagement.dto;

import com.example.eventmanagement.model.AuctionType;
import com.example.eventmanagement.model.AuthorizationAccess;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record EventRequestDTO(
        @NotNull
        Long userId,
        @NotNull
        String name,
        @NotNull
        String description,
        BigDecimal entryFee,
        @NotNull
        AuthorizationAccess authorizationAccess,
        @NotNull
        AuctionType auctionType,
        List<Long> productListIds,
        @NotNull
        LocalDateTime startDate,
        @NotNull
        LocalDateTime endDate
) {
}
