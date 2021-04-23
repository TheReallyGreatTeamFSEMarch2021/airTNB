package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.GettingAroundLocationInfoRepository;
import com.talentpath.airTNB.daos.LocationRepository;
import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.models.GettingAroundLocationInfo;
import com.talentpath.airTNB.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GettingAroundLocationInfoService {
    @Autowired
    GettingAroundLocationInfoRepository gettingAroundLocationInfoRepo;

    @Autowired
    LocationRepository locationRepo;

    public List<GettingAroundLocationInfo> getGettingAroundLocationInfosByLocationId(Integer locationId){
        return gettingAroundLocationInfoRepo.findByLocationId(locationId);
    }

    public GettingAroundLocationInfo addGettingArdLocationInfo(String gettingArdInfotoAdd, Integer locationId) throws NullLocationException {
        Optional<Location> location = locationRepo.findById(locationId);
        GettingAroundLocationInfo toAdd = new GettingAroundLocationInfo();
        if(location.isPresent()){
            toAdd.setLocation(location.get());
            toAdd.setGettingAroundInfoStr(gettingArdInfotoAdd);
            return gettingAroundLocationInfoRepo.saveAndFlush(toAdd);
        }else{
            throw new NullLocationException("In addGettingArdLocationInfo() in GettingArdLocationInfoService class. Can't find location with id: " + locationId);
        }
    }

    public GettingAroundLocationInfo gettingAroundLocationInfoById(Integer id){
        return gettingAroundLocationInfoRepo.getOne(id);
    }

}
