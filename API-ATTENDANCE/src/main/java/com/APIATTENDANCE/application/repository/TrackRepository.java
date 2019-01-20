package com.APIATTENDANCE.application.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.APIATTENDANCE.application.entity.Track;

public interface TrackRepository  extends JpaRepository<Track, Integer>{
	@Query("SELECT t FROM Track t where t.track_id=?1 ")
	public List<Track> GetTrackByUsID(int id);
	
	@Query("SELECT t FROM Track t INNER JOIN t.user u WHERE u.us_id=?1 AND " + 
			" (t.track_position_time BETWEEN  ?2 AND ?3 ) ORDER BY t.track_position_time ASC")
	public List<Track> SQLFilterTrackUserTime(int id,Timestamp timeFrom, Timestamp timeTo);
	

	
}
