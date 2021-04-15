package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.RoomRepository;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    ListingService listingService;

    @Autowired
    RoomRepository roomRepo;

    public List<Room> getAllRooms(){
        return roomRepo.findAll();
    }

    public Room addRoom(Room toAdd){
        return roomRepo.saveAndFlush(toAdd);
    }

    public Room attachListing(Room room, Integer listingId) throws NullListingException {
        room.setListing(listingService.getListingById(listingId));
        return room;
    }
}
