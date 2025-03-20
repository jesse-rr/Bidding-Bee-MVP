package com.example.eventmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "event")
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private Long userId;
    private String organizerName;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;
    private BigDecimal entryFee;
    @Enumerated(EnumType.STRING)
    private AuthorizationAccess authorizationAccess;
    @Enumerated(EnumType.STRING)
    private AuctionType auctionType;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ElementCollection
    private List<Long> productListIds;
}
