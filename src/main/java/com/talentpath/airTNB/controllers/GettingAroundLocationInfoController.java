package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.models.GettingAroundLocationInfo;
import com.talentpath.airTNB.services.GettingAroundLocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/gettingAroundLocInfo")
public class GettingAroundLocationInfoController {
    @Autowired
    GettingAroundLocationInfoService gettingAroundLocationInfoServ;

    @GetMapping("/getGettingArdInfosByLocationId/{locationId}")
    public List<GettingAroundLocationInfo> getGettingArdInfosByLocationId(@PathVariable Integer locationId){
        return gettingAroundLocationInfoServ.getGettingAroundLocationInfosByLocationId(locationId);
    }

    @GetMapping("/getById/{id}")
    public GettingAroundLocationInfo getGettingArdInfoById(@PathVariable Integer id){
        return gettingAroundLocationInfoServ.gettingAroundLocationInfoById(id);
    }

    @PostMapping("/add/{locationId}")
    public GettingAroundLocationInfo addGettingAroundLocationInfo(@RequestBody String gettingAroundLocInfo, @PathVariable Integer locationId) throws NullLocationException {
        return gettingAroundLocationInfoServ.addGettingArdLocationInfo(gettingAroundLocInfo, locationId);
    }
}
