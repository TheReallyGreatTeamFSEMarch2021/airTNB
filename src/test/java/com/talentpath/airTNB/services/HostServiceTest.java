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
import java.util.ArrayList;
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
        listing.setCity("Houston");
        host.setListings(List.of(listing));
        hostRepository.saveAndFlush(host);
    }

    @Test
    void getAllHosts() {
        List<Host> list = hostService.getAllHosts();
        assertEquals(1,list.get(0).getId());
    }

    @Test
    void getHostById() {
    }

    @Test
    void addHost() {
    }
}