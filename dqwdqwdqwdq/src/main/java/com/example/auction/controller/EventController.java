package com.example.auction.controller;

import com.example.eventmanagement.dto.EventRequestDTO;
import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/events")
public class EventController {

    private final EventService eventService;

    @PostMapping("/add")
    public void addEvent(
            @RequestBody @Valid EventRequestDTO request
    ) {
        eventService.addEvent(request);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<List<Event>> getEventByName(
        @PathVariable(value = "name") String name
    ) {
        return ResponseEntity.ok(eventService.getEventByName(name));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(
            @PathVariable(value = "id") Long eventId 
    ) {
        return ResponseEntity.ok(eventService.getEventById(eventId));
    }

    @PutMapping("/alter/{id}")
    public void alterEventById(
            @PathVariable(value = "id") Long eventId,
            @RequestBody @Valid EventRequestDTO request
    ) {
        eventService.alterEventById(eventId, request);
    }
}
