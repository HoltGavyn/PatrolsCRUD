package com.gavynholt.crud.rest;

import com.gavynholt.crud.entity.Location;
import com.gavynholt.crud.entity.PostOrder;
import com.gavynholt.crud.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class LocationsRestController {

    @Autowired
    private LocationService locationService;

    @GetMapping("locations")
    public List<Location> getLocations() {

        return locationService.getLocations();
    }

    @GetMapping("locations/{locationId}")
    public Location getLocationById(@PathVariable int locationId) {

        return locationService.getLocationById(locationId);
    }

    @PostMapping("locations")
    public Location addNewLocation(@RequestBody Location locationToAdd) {

        locationToAdd.setId(0);

        locationService.addNewLocation(locationToAdd);

        return locationToAdd;
    }

    @PutMapping("locations")
    public Location updateLocation(@RequestBody Location locationToUpdate) {

        locationService.updateLocation(locationToUpdate);

        return locationService.getLocationById(locationToUpdate.getId());
    }

    @DeleteMapping("locations/{locationId}")
    public String deleteLocation(@PathVariable(value="locationId") int locationId) {

        locationService.deleteLocation(locationId);

        return "Successfully deleted location with id: " + locationId;
    }

    @GetMapping("postorders/location/{locationId}")
    public List<PostOrder> getPostOrders(@PathVariable(value="locationId") int locationId) {

        return locationService.getPostOrders(locationId);
    }

    @GetMapping("postorders/{postOrderId}")
    public PostOrder getPostOrder(@PathVariable(value="postOrderId") int postOrderId) {

        return locationService.getPostOrderById(postOrderId);
    }

    @PostMapping("postorders/location/{locationId}")
    public PostOrder addPostOrderToLocation(@PathVariable(value="locationId") int locationId, @RequestBody PostOrder postOrderToAdd) {

        postOrderToAdd.setId(0);

        Location postOrderLocation = locationService.getLocationById(locationId);
        postOrderToAdd.setLocation(postOrderLocation);

        locationService.addPostOrder(postOrderToAdd);

        return postOrderToAdd;
    }

    @PutMapping("postorders/{locationId}")
    public PostOrder updatePostOrder(@PathVariable(value="locationId") int locationId, @RequestBody PostOrder postOrderToUpdate) {

        Location postOrderLocation = locationService.getLocationById(locationId);
        postOrderToUpdate.setLocation(postOrderLocation);

        locationService.updatedPostOrder(postOrderToUpdate);

        return postOrderToUpdate;
    }

    @DeleteMapping("postorders/{postOrderId}")
    public ResponseEntity<String> deletePostorder(@PathVariable(value="postOrderId") int postOrderId) {

        locationService.deletePostOrder(postOrderId);

        return new ResponseEntity<String>("Successfully delete post order with id: " + postOrderId, HttpStatus.OK);
    }
}
