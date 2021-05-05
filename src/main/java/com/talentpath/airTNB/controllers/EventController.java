package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.models.Event;
import com.talentpath.airTNB.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    EventService eventServ;

    @GetMapping("/getByListingId/{listingId}")
    public List<Event> getEventsByListingId(@PathVariable Integer listingId) {
        List<Event> events = eventServ.getAllByListing(listingId);
        return events;
    }

    @GetMapping
    @RequestMapping("{id}")
    public Event get(@PathVariable Integer id) {
        return eventServ.getEvent(id);
    }

    @PostMapping
    public Event add(@RequestBody final Event event) {
        return eventServ.addEvent(event);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        eventServ.deleteEvent(id);
    }

}
