package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.RoomRepository;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Listing;
import com.talentpath.airTNB.models.Photo;
import com.talentpath.airTNB.models.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RoomServiceTest {

    @Autowired
    RoomService roomService;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ListingRepository listingRepository;

    @BeforeEach
    @Transactional
    void setUp() {
        listingRepository.deleteAll();
        listingRepository.reset();
        roomRepository.deleteAll();
        roomRepository.reset();
    }

    @Test
    @Transactional
    void getAllRooms(){
        Room room1 = new Room();
        room1.setType("bedroom");
        room1.setName("bedroom 1");
        Listing listing = new Listing();
        listing.setTitle("listing1");
        room1.setListing(listing);
        roomRepository.saveAndFlush(room1);

        List<Room> allRooms = roomService.getAllRooms();
        Room roomToTest = allRooms.get(0);
        assertEquals(1,roomToTest.getId());
        assertEquals("bedroom", roomToTest.getType());
        assertEquals("bedroom 1", roomToTest.getName());
    }

    @Test
    @Transactional
    void getRoomsByListingId(){
        Listing listing1 = new Listing();
        listing1.setTitle("listing1");
        Listing listing2 = new Listing();
        listing1.setTitle("listing2");
        listingRepository.saveAndFlush(listing1);
        listingRepository.saveAndFlush(listing2);

        Room room1 = new Room();
        room1.setName("bedroom x");
        Room room2 = new Room();
        room2.setName("bedroom y");
        room1.setListing(listing1);
        room2.setListing(listing2);

        try{
            roomService.attachListing(room1, 1);
            roomService.attachListing(room2, 2);

            roomRepository.saveAndFlush(room1);
            roomRepository.saveAndFlush(room2);

            List<Room> rooms1 = roomService.getByListingId(1);
            List<Room> rooms2 = roomService.getByListingId(2);

            assertEquals("bedroom x", rooms1.get(0).getName());
            assertEquals("bedroom y", rooms2.get(0).getName());

        }
        catch (NullListingException ex){
            fail("Failed to attach listing to photo");
        }

    }

}