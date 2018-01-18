package com.place.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.place.dao.PlaceDao;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	PlaceDao placeDao;

	@Override
	public String getName(long id) {
		return placeDao.getName(id);
	}

}
