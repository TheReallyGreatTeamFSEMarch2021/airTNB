package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.EventRepository;
import com.talentpath.airTNB.models.Event;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    EventRepository eventDao;

    public List<Event> getAllEvents() {
        return eventDao.findAll();
    }

    public Event addEvent(Event event) {

        return eventDao.saveAndFlush(event);
    }

    public void deleteEvent(Integer id) {
        eventDao.deleteById(id);
    }

    public Event getEvent(Integer id) {
        Optional<Event> event = eventDao.findById(id);
        if (event.isPresent()) return event.get();
        return null;
    }

    public Event editEvent(Event event, Integer id) {
        Event current = eventDao.getOne(id);
        BeanUtils.copyProperties(event,current,"id");
        return eventDao.saveAndFlush(current);
    }
    public List<Event> getAllByListing(Integer id) {
        return eventDao.findBylistingId(id);
    }
}
