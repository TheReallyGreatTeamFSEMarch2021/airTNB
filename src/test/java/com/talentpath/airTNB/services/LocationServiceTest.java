package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.LocationRepository;
import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.exceptions.NullLocationFieldException;
import com.talentpath.airTNB.models.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.tree.ExpandVetoException;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LocationServiceTest {

    @Autowired
    LocationService locationServ;

    @Autowired
    LocationRepository locationRepo;

    @Autowired
    ListingRepository listingRepo;

    @BeforeEach
    void deleteAllItems(){
        locationRepo.deleteAll();
    }

    @Test
    void test(){
    }

    //getAll
    //getById
    //add

    //golden path test for add
    @Test
    void addLocation() throws NullLocationException {
        List<Location> locations = locationServ.getAllLocations();
        assertEquals(0, locations.size());

        //Arrange
        Location location = new Location();
        location.setCity("TestCity1");
        location.setState("TestState1");
        BigDecimal lat = new BigDecimal(12.35);
        BigDecimal longitude = new BigDecimal(19.23);
        location.setLatitude(lat);
        location.setLongitude(longitude);

        try{
            //Assert
            locationServ.addLocation(location);
            //Act
            locations = locationServ.getAllLocations();
            assertEquals(1, locations.size());
            Location location1 = locations.get(0);
            assertEquals("TestCity1", location1.getCity());
            assertEquals("TestState1", location1.getState());
            assertEquals(12.35, location1.getLatitude().doubleValue());
            assertEquals(19.23, location1.getLongitude().doubleValue());
        }catch(Exception e){
            fail("In golden path test for addLocation, shouldn't be any excpetions: " + e.getMessage());
        }

    }

    //locationToAdd can't be null
    @Test
    public void addNullLocation() throws NullLocationException {
        //Arrange
        Location locationToAdd = null;
        try {
            //Assert
            locationServ.addLocation(locationToAdd);
            fail("In addNullLocationMethod, can't add null location.");
        }catch(NullLocationException ex){
            System.out.println("In addNullLocationMethod, failed correctly, caught NullLocationException. " + ex.getMessage());
        }catch(Exception ex){
            fail("In addNullLocationMethod, shouldn't have caught any other exception.");
        }
    }

    //fields city, state, latitude, and longitude can't be null
    @Test
    public void addLocationWithNullCity(){
        //Arrange
        Location locationToAdd = new Location();
        locationToAdd.setState("TestState1");
        BigDecimal lat = new BigDecimal(12.35);
        BigDecimal longitude = new BigDecimal(19.23);
        locationToAdd.setLatitude(lat);
        locationToAdd.setLongitude(longitude);
        //Act
        try {
            //Assert
            locationServ.addLocation(locationToAdd);
            fail("In test addLocationWithNullCity, shouldn't be able to add location with null city");
        }catch(NullLocationFieldException ex){
            System.out.println("In test addLocationWithNullCity, trying to add location with null city, correctly failed NullLocationFieldException. " + ex.getMessage());
        }catch(Exception e){
            fail("In addLocationWithNullCit, shouldn't be any more exceptions: " + e.getMessage());
        }
    }

    //fields city, state, latitude, and longitude can't be null
    @Test
    public void addLocationWithNullState(){
        //Arrange
        Location locationToAdd = new Location();
        locationToAdd.setCity("TestCity1");
        BigDecimal lat = new BigDecimal(12.35);
        BigDecimal longitude = new BigDecimal(19.23);
        locationToAdd.setLatitude(lat);
        locationToAdd.setLongitude(longitude);
        //Act
        try {
            //Assert
            locationServ.addLocation(locationToAdd);
            fail("In test addLocationWithNullState, shouldn't be able to add location with null state");
        }catch(NullLocationFieldException ex){
            System.out.println("In test addLocationWithNullState, trying to add location with null state, correctly failed NullLocationFieldException. " + ex.getMessage());
        }catch(Exception e){
            fail("In addLocationWithNullState, shouldn't be any more exceptions: " + e.getMessage());
        }
    }

    //fields city, state, latitude, and longitude can't be null
    @Test
    public void addLocationWithNullLatitude(){
        //Arrange
        Location locationToAdd = new Location();
        locationToAdd.setCity("TestCity1");
        locationToAdd.setState("TestState1");
        BigDecimal longitude = new BigDecimal(19.23);
        locationToAdd.setLongitude(longitude);
        //Act
        try {
            //Assert
            locationServ.addLocation(locationToAdd);
            fail("In test addLocationWithNullLatitude, shouldn't be able to add location with null latitude");
        }catch(NullLocationFieldException ex){
            System.out.println("In test addLocationWithNullLatitude, trying to add location with null latitude, correctly failed NullLocationFieldException. " + ex.getMessage());
        }catch(Exception e){
            fail("In addLocationWithNullLatitude, shouldn't be any more exceptions: " + e.getMessage());
        }
    }


    //fields city, state, latitude, and longitude can't be null
    @Test
    public void addLocationWithNullLongitude(){
        //Arrange
        Location locationToAdd = new Location();
        locationToAdd.setCity("TestCity1");
        locationToAdd.setState("TestState1");
        BigDecimal lat = new BigDecimal(12.35);
        locationToAdd.setLatitude(lat);
        //Act
        try {
            //Assert
            locationServ.addLocation(locationToAdd);
            fail("In test addLocationWithNullLongitude, shouldn't be able to add location with null longitude");
        }catch(NullLocationFieldException ex){
            System.out.println("In test addLocationWithNullLongitude, trying to add location with null longitude, correctly failed NullLocationFieldException. " + ex.getMessage());
        }catch(Exception e){
            fail("In addLocationWithNullLongitude, shouldn't be any more exceptions: " + e.getMessage());
        }
    }

    //golden path test for getLocationById
    @Test
    public void getLocationById(){
        List<Location> locations = locationServ.getAllLocations();
        assertEquals(0, locations.size());

        //Arrange
        Location location = new Location();
        location.setCity("TestCity1");
        location.setState("TestState1");
        BigDecimal lat = new BigDecimal(12.35);
        BigDecimal longitude = new BigDecimal(19.23);
        location.setLatitude(lat);
        location.setLongitude(longitude);
        try{
            //Assert
            Location addedLoc = locationServ.addLocation(location);
            Optional<Location> locGrabbed = locationRepo.findById(addedLoc.getId());
            assertEquals(true, locGrabbed.isPresent());
            assertEquals("TestCity1", locGrabbed.get().getCity());
        } catch (Exception e) {
            fail("In golden path test for getLocationById, shouldn't be running into any exceptions");
        }
    }

    //should call NullLocationException if location_id doesn't exist/is negative
    @Test
    public void getLocationWithNonExistentId(){
        List<Location> locations = locationServ.getAllLocations();
        assertEquals(0, locations.size());

        //Arrange
        Location location = new Location();
        location.setCity("TestCity1");
        location.setState("TestState1");
        BigDecimal lat = new BigDecimal(12.35);
        BigDecimal longitude = new BigDecimal(19.23);
        location.setLatitude(lat);
        location.setLongitude(longitude);

        //grabbing a location with nonexistent Id
        try{
            //Assert
            Location addedLoc = locationServ.addLocation(location);
            locationServ.getLocationById(3);
            fail("In getLocationWithNonExistentId, should've caught NullLocationException, can't grab Location with nonExistent id");
        }catch(NullLocationException ex) {
            System.out.println("In getLocationWithNonExistentId, trying to grab Location with nonExistentId, correctly caught NullLocationException");
        }catch(Exception e) {
            fail("In golden path test for getLocationById, shouldn't be running into any exceptions");
        }
    }










}
