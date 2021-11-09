package com.philippo.trainstation.domain.repository;

import com.philippo.trainstation.domain.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByNameStartingWith(String name);
}
