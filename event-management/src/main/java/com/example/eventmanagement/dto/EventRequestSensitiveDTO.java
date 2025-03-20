package com.example.eventmanagement.dto;

import com.example.eventmanagement.model.AuctionType;
import com.example.eventmanagement.model.AuthorizationAccess;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventRequestSensitiveDTO(
        @NotNull
        BigDecimal entryFee,
        @NotNull
        AuthorizationAccess authorizationAccess,
        @NotNull
        AuctionType auctionType,
        @NotNull
        LocalDateTime startTime,
        @NotNull
        LocalDateTime endTime
) {
}
