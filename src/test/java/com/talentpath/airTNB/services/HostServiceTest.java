package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.HostRepository;
import com.talentpath.airTNB.models.Host;
import com.talentpath.airTNB.models.Listing;
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
class HostServiceTest {

    @Autowired
    HostService hostService;
    @Autowired
    HostRepository hostRepository;

    @BeforeEach
    @Transactional
    void setUp() {
        hostRepository.deleteAll();
        hostRepository.reset();
        Host host = new Host();
        host.setSuperHost(true);
        host.setDescription("a host");
        host.setVerified(true);
        Listing listing = new Listing();
        listing.setTitle("a listing");
        listing.setHost(host);
        host.setListings(List.of(listing));
        hostRepository.saveAndFlush(host);
    }

    @Test
    @Transactional
    void getAllHosts() {
        List<Host> list = hostService.getAllHosts();
        Host test = list.get(0);
        assertNotNull(test);
        assertEquals(1,test.getId());
        assertEquals("a host",test.getDescription());
        assertTrue(test.isSuperHost());
        assertTrue(test.isVerified());
        assertEquals("a listing",test.getListings().get(0).getTitle());
    }

    @Test
    @Transactional
    void getHostById() {
        try {
            Host test = hostService.getHostById(1);
            assertNotNull(test);
            assertEquals(1,test.getId());
            assertEquals("a host",test.getDescription());
            assertTrue(test.isSuperHost());
            assertTrue(test.isVerified());
            assertEquals("a listing",test.getListings().get(0).getTitle());
        }
        catch (Exception e) {
            fail("Exception caught during goldent path test: " +e.getClass() + " " + e.getMessage());
        }
    }

    @Test
    @Transactional
    void addHost() {
        Host host = new Host();
        host.setSuperHost(false);
        host.setDescription("another host");
        host.setVerified(true);
        Listing listing = new Listing();
        listing.setTitle("another listing");
        listing.setHost(host);
        host.setListings(List.of(listing));
        hostService.addHost(host);

        try {
            host = hostService.getHostById(2);
            assertNotNull(host);
            assertEquals(2,host.getId());
            assertEquals("another host",host.getDescription());
            assertFalse(host.isSuperHost());
            assertTrue(host.isVerified());
            assertEquals("another listing",host.getListings().get(0).getTitle());

        }
        catch (Exception e) {
            fail("Exception caught during golden path test: " + e.getClass() + " " + e.getMessage());
        }
    }
}