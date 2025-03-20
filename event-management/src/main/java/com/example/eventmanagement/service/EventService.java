package com.example.eventmanagement.service;

import com.example.eventmanagement.dto.EventRequestDTO;
import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.dto.EventRequestSensitiveDTO;
import com.example.eventmanagement.model.EventStatus;
import com.example.eventmanagement.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public List<Event> getEventByName(String name) {
        log.info("GETTING EVENTS BY NAME LIKE :: {}",name);
        return eventRepository.findEventsByNameLikeOrderByName(name);
    }

    public void addEvent(EventRequestDTO request) {
        log.info("ADDING EVENT BY DTO :: {}",request);
        if (request.auctionType().isReserveType() && Duration.between(request.startDate(), request.endDate()).toMinutes() < 1440) {
            throw new RuntimeException("CANNOT ADD RESERVE-EVENT IF DURATION BETWEEN DATES IS LESS THAN 24h");
        }
        eventRepository.save(eventMapper.toEvent(request));
    }

    public void alterEventById(Long eventId, EventRequestDTO request) {
        Event event = getEventById(eventId);
        if (event.getEventStatus().equals(EventStatus.OPEN)) {
            throw new RuntimeException("CANNOT ALTER EVENT WHEN OPEN");
        }
        if (event.getAuctionType().isReserveType() && Duration.between(event.getStartDate(), event.getEndDate()).toMinutes() < 1440) {
            throw new RuntimeException("CANNOT ALTER RESERVE-EVENT WHEN 24h FOR OPEN - ID :: "+eventId)
        }
        event.setName(request.name());
        event.setDescription(request.description());
        event.setAuthorizationAccess(request.authorizationAccess());

        // TODO SEND EVENT WAS CHANGED
    }

    public Event getEventById(Long eventId) {
        log.info("GETTING EVENTS BY ID :: {}",eventId);
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("EVENT NOT FOUND WITH ID :: "+eventId));
    }

    public void alterEventSensitiveDataById(Long eventId, EventRequestSensitiveDTO request) {
        Event event = getEventById(eventId);

    }

    private void checks() {

    }
}
