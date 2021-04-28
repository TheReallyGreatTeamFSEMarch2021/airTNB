package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ActivityRepository;
import com.talentpath.airTNB.models.Activity;
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
public class ActivityTests {

    @Autowired
    ActivityRepository activityRepo;

    @BeforeEach
    @Transactional
    void setup(){
        activityRepo.deleteAll();
        activityRepo.reset();
        Activity activity = new Activity();
        activity.setCity("Houston");
        activity.setRegion("Texas");
        activityRepo.saveAndFlush(activity);
    }

    @Test
    @Transactional
    void getAllActivities(){
        List<Activity> activities = activityRepo.findAll();
        assertEquals(1, activities.size());

        Activity politicsTour = new Activity();
        politicsTour.setCity("Washington DC");
        politicsTour.setPrice(75);
        activityRepo.saveAndFlush(politicsTour);

        Activity tourFacebook = new Activity();
        tourFacebook.setCity("Menlo Park");
        tourFacebook.setPrice(30);
        activityRepo.saveAndFlush(tourFacebook);

        activities = activityRepo.findAll();
        assertEquals(3, activities.size());
        assertEquals("Washington DC", activities.get(1).getCity());
        assertEquals(75, activities.get(1).getPrice());
        assertEquals("Menlo Park", activities.get(2).getCity());
        assertEquals(30, activities.get(2).getPrice());
    }

    @Test
    @Transactional
    void getActivityById(){
        List<Activity> activities = activityRepo.findAll();
        assertEquals(1,activities.get(0).getId());

        Activity activity1 = new Activity();
        activityRepo.saveAndFlush(activity1);
        Activity activity2 = new Activity();
        activityRepo.saveAndFlush(activity2);

        activities = activityRepo.findAll();
        assertEquals(2,activities.get(1).getId());
        assertEquals(3,activities.get(2).getId());
    }

    @Test
    @Transactional
    void getActivityByCity(){
        Activity activity2 = new Activity();
        activity2.setCity("Houston");
        activity2.setPrice(22);
        activityRepo.saveAndFlush(activity2);

        Activity activity3 = new Activity();
        activity3.setCity("Houston");
        activity3.setPrice(33);
        activityRepo.saveAndFlush(activity3);

        Activity activity4 = new Activity();
        activity4.setCity("Houston");
        activity4.setPrice(44);
        activityRepo.saveAndFlush(activity4);

        Activity activity5 = new Activity();
        activity5.setCity("San Francisco");
        activity5.setPrice(99);
        activityRepo.saveAndFlush(activity5);

        Activity activity6 = new Activity();
        activity6.setCity("San Francisco");
        activity6.setPrice(909);
        activityRepo.saveAndFlush(activity6);

        Activity activity7 = new Activity();
        activity7.setCity("Salt Lake City");
        activity7.setPrice(15);
        activityRepo.saveAndFlush(activity7);

        Activity activity8 = new Activity();
        activity8.setCity("Sacramento");
        activity8.setPrice(77);
        activityRepo.saveAndFlush(activity8);

        Activity activity9 = new Activity();
        activity9.setCity("Sacramento");
        activity9.setPrice(88);
        activityRepo.saveAndFlush(activity9);

        List<Activity> activitiesInHouston = activityRepo.findByCity("Houston");

        assertEquals(4,activitiesInHouston.size());
        assertEquals(22, activitiesInHouston.get(1).getPrice());
        assertEquals(33, activitiesInHouston.get(2).getPrice());
        assertEquals(44, activitiesInHouston.get(3).getPrice());

        List<Activity> activitiesInSF = activityRepo.findByCity("San Francisco");
        assertEquals(2, activitiesInSF.size());

        List<Activity> activitiesInSLC = activityRepo.findByCity("Salt Lake City");
        assertEquals(1, activitiesInSLC.size());

        List<Activity> activitiesInSac = activityRepo.findByCity("Sacramento");
        assertEquals(2, activitiesInSac.size());



    }
}

