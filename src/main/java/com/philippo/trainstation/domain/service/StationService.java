package com.philippo.trainstation.domain.service;

import com.philippo.trainstation.domain.model.Station;
import com.philippo.trainstation.domain.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    StationRepository stationRepository;

//    @Cacheable()
//    public List<Station> stationsByName(String name){
//        return stationRepository.findByNameContaining(name);
//    }
}
