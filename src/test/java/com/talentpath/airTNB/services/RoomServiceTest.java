package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.RoomRepository;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Listing;
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
        roomRepository.deleteAll();
        roomRepository.reset();

        Room room1 = new Room();
        room1.setType("bedroom");
        room1.setName("bedroom 1");

        Listing listing = new Listing();
        listing.setTitle("listing1");
        room1.setListing(listing);
        roomRepository.saveAndFlush(room1);
    }

    @Test
    @Transactional
    void getAllRooms(){
        List<Room> allRooms = roomService.getAllRooms();
        Room roomToTest = allRooms.get(0);
        assertEquals(1,roomToTest.getId());
        assertEquals("bedroom", roomToTest.getType());
        assertEquals("bedroom 1", roomToTest.getName());
    }

    //using the 2(id = 5,6) listings that are already in the test DB
    //will need to be updated if those test listings are removed
    @Test
    @Transactional
    void getRoomsByListingId(){
        Room room2 = new Room();
        room2.setName("bedroom x");

        Room room3 = new Room();
        room3.setName("bedroom y");

        Listing listing1 = new Listing();
        listing1.setTitle("listing1");
        listing1.setId(1);

        Listing listing2 = new Listing();
        listing1.setTitle("listing2");
        listing2.setId(2);

        room2.setListing(listing1);
        room3.setListing(listing2);

        roomRepository.saveAndFlush(room2);
        roomRepository.saveAndFlush(room3);

        List<Room> rooms5 = roomService.getByListingId(1);
        List<Room> rooms6 = roomService.getByListingId(2);

        assertEquals("bedroom x", rooms5.get(0).getName());
        assertEquals("bedroom y", rooms6.get(0).getName());

    }

}