package com.place.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PlaceDaoImpl implements PlaceDao {

	@Override
	public String getName(long id) {
		return "places is called";
	}

}
