package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.InvalidIdException;
import com.talentpath.airTNB.models.Host;
import com.talentpath.airTNB.services.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/host")
public class HostController {

    @Autowired
    HostService hostService;

    @GetMapping("/getAll")
    public List<Host> getAllHosts(){
        return hostService.getAllHosts();
    }

    @GetMapping("/getById/{id}")
    public Host getHostById(@PathVariable Integer id) throws InvalidIdException {
        return hostService.getHostById(id);
    }

    @PostMapping("/add")
    public Host addHost(@RequestBody Host toAdd){
        return hostService.addHost(toAdd);
    }
}
