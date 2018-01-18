package com.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.place.entity.Place;
import com.place.service.PlaceService;

@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	PlaceService placeService;

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Place getPlaceNameById(@PathVariable long id) {
		Place place = new Place();
		place.setName(placeService.getName(id));
		return place;
	}
}
