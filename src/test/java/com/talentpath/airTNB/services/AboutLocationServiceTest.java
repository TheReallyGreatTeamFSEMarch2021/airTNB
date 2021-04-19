package com.talentpath.airTNB.services;

import com.talentpath.airTNB.models.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AboutLocationServiceTest {
    @Autowired
    AboutLocationService aboutLocationServ;

    @Autowired
    Location location;



}
