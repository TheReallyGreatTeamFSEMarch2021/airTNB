package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.GettingAroundInfoRepository;
import com.talentpath.airTNB.models.GettingAroundInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GettingAroundInfoService {
    @Autowired
    GettingAroundInfoRepository gettingAroundInfoRepo;

    public List<GettingAroundInfo> gettingAroundInfos(Integer locationId){
        return gettingAroundInfoRepo.findByLocationId(locationId);
    }
}

