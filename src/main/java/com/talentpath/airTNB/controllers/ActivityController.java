package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.NullActivityException;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Activity;
import com.talentpath.airTNB.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    ActivityService service;

    @GetMapping("/getAll")
    public List<Activity> getAllActivities(){return service.getAllActivities();}

    @GetMapping("/getActivitiesByCity/{city}")
    public List<Activity> getActivitiesByCity(@PathVariable String city){return service.getActivitiesByCity(city);}

    @GetMapping("/getActivitiesByCityAndState/{listingId}")
    public List<Activity> getActivitiesByCityAndSTate(@PathVariable Integer listingId) throws NullListingException {
        return service.getActivitiesByCityAndState(listingId);
    }

    @GetMapping("/getActivityById/{id}")
    public Activity getActivityById(@PathVariable Integer id) throws NullActivityException {return service.getActivityById(id);}
}
