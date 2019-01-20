package com.APIATTENDANCE.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.APIATTENDANCE.application.entity.Place;


public interface PlaceRepository extends JpaRepository<Place, Integer>{

}
