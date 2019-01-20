package com.APIATTENDANCE.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.APIATTENDANCE.application.entity.Geo;

public interface GeoRepository  extends JpaRepository<Geo, Integer>{

}
