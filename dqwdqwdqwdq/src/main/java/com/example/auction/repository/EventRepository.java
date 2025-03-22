package com.example.eventmanagement.repository;

import com.example.eventmanagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {


    @Query("SELECT e FROM event e WHERE e.name LIKE %:name% ORDER BY e.name")
    List<Event> findEventsByNameLikeOrderByName(String name);
}
