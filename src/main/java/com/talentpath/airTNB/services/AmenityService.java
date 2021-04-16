package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.AmenityRepository;
import com.talentpath.airTNB.models.Amenity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenityService {
    @Autowired
    AmenityRepository amenityDao;

    public List<Amenity> getAllAmenity() {
        return amenityDao.findAll();
    }

    public Amenity addAmenity(Amenity amenity) {
        return amenityDao.saveAndFlush(amenity);
    }

    public void deleteAmenity(Integer id) {
        amenityDao.deleteById(id);
    }

    public Amenity getAmenity(Integer id) {
        Optional<Amenity> amenity = amenityDao.findById(id);
        if(amenity.isPresent()) return amenity.get();
        return null;
    }

    public Amenity editAmenity(Amenity amenity, Integer id) {
        Amenity current = amenityDao.getOne(id);
        BeanUtils.copyProperties(amenity,current,"id");
        return amenityDao.saveAndFlush(current);
    }
    public List<Amenity> getAllByListing(Integer id) {
        return amenityDao.findBylistingId(id);
    }

}
