package com.gavynholt.crud.dao;

import com.gavynholt.crud.entity.Location;

import java.util.List;

public interface LocationDAO {

    public List<Location> getLocations();

    public Location getLocation(int locationId);
}
