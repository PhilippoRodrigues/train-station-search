package com.philippo.trainstation.api.controller;

import com.philippo.trainstation.domain.model.Station;
import com.philippo.trainstation.domain.repository.StationRepository;
import com.philippo.trainstation.domain.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stations")
public class StationController {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private StationService stationService;

    @GetMapping("/by-name")
    @Cacheable(value="nameCache", key="#name")
    public List<Station> stationsByName(String name){
        return stationRepository.findByNameStartingWith(name);
    }
}
