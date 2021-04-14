package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.PhotoRepository;
import com.talentpath.airTNB.models.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public List<Photo> getByListingId(Integer listingId) {
        return photoRepository.findAllByListingId(listingId);
    }

    public Photo addPhoto(Photo toAdd) {
        return photoRepository.saveAndFlush(toAdd);
    }
}
