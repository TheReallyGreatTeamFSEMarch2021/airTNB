package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.models.Photo;
import com.talentpath.airTNB.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/getAll")
    public List<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/getByListingId/{listingId}")
    public List<Photo> getByListingId(@PathVariable Integer listingId){
        return photoService.getByListingId();
    }

}
