package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Room;
import com.talentpath.airTNB.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/getAll")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/getByListingId/{listingId}")
    public List<Room> getByListingId(@PathVariable Integer listingId){
        return roomService.getByListingId(listingId);
    }

    @PostMapping("/add/{listingId}")
    public Room addRoom(@PathVariable Integer listingId, @RequestBody Room toAdd) throws NullListingException {
        toAdd = roomService.attachListing(toAdd, listingId);
        return roomService.addRoom(toAdd);
    }
}
