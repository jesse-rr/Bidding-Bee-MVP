package com.example.eventmanagement.service;

import com.example.eventmanagement.dto.EventRequestDTO;
import com.example.eventmanagement.model.Event;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    public Event toEvent(EventRequestDTO request) {
        return Event.builder()
                .description(request.description())
                .userId(request.userId())
                .productListIds(request.productListIds())
                .name(request.name())
                .authorizationAccess(request.authorizationAccess())
                .entryFee(request.entryFee())
                .build();

    }
}
