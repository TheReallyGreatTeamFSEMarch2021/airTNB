package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ActivityRepository;
import com.talentpath.airTNB.exceptions.NullActivityException;
import com.talentpath.airTNB.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository repo;

    public List<Activity> getAllActivities(){return repo.findAll();}

    public List<Activity> getActivitiesByCity(String city){return repo.findByCity(city);}

    public Activity getActivityById(Integer id) throws NullActivityException {
        Optional<Activity> activity = repo.findById(id);
        if(activity.isPresent()){
            return activity.get();
        }else{
            throw new NullActivityException("No activity with id: " + id);
        }
    }
}
