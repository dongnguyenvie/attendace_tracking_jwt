package com.APIATTENDANCE.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APIATTENDANCE.application.entity.Track;
import com.APIATTENDANCE.application.entity.User;
import com.APIATTENDANCE.application.entity.format.JsonFormat;
import com.APIATTENDANCE.application.entity.format.TrackingFomat;
import com.APIATTENDANCE.application.repository.TrackRepository;
import com.APIATTENDANCE.application.repository.UserRepository;
import com.APIATTENDANCE.application.util.UtilMess;

@Service
public class TrackService {

	@Autowired
	TrackRepository trackServer;

	@Autowired
	UserRepository userServer;

	public Object FilterTrackUserTime(TrackingFomat track) {
		try {
			List<Track> lstTrack = trackServer.SQLFilterTrackUserTime(track.getUs_id(), track.getTimeFrom(),
					track.getTimeTo());
			return lstTrack;
		} catch (Exception e) {

			return UtilMess.dialog(false, e.getMessage());
		}

	}

	public List<Track> GetAll() {
		List<Track> lstTrack = trackServer.findAll();
		for (int i = 0; i < lstTrack.size(); i++) {
			lstTrack.get(i).setUser(null);
		}
		return lstTrack;
	}

	// Get List Tracking by us_id
	public Object GetListTrackByIdTime(TrackingFomat track) {
		try {
			List<Track> lstTrack = trackServer.SQLFilterTrackUserTime(track.getUs_id(), track.getTimeFrom(),
					track.getTimeTo());
			return lstTrack;
		} catch (Exception e) {
			return UtilMess.dialog(false, e.getMessage());
		}
	}

	// Delete List Tracking by us_id
	public Object DeleteListTrackByUserId(TrackingFomat trackF) {
		try {
			User user = userServer.getOne(trackF.getUs_id());
			if (user.getUs_password() == null)
				throw new NullPointerException();
			user.setCompany(null);
			user.setPlace(null);
			user.setUserFrequency(null);

			List<Track> lstTrack = user.getTrack();
			if (lstTrack != null) {
				for (Track track : lstTrack) {
					trackServer.deleteById(track.getTrack_id());
				}
			}
			return UtilMess.dialog(true, "Success");
		} catch (Exception e) {
			return UtilMess.dialog(false, e.getMessage());
		}
	}

	// Add list tracking by us_id
	public Object AddListTracking(List<TrackingFomat> lstTrack) {

		for (TrackingFomat track : lstTrack) {
			User us = null;
			try {
				us = userServer.getOne(track.getUs_id());
				if (us.getUs_password() == null)
					throw new NullPointerException();
			} catch (Exception e) {
				return UtilMess.dialog(false, "not found us_id");
			}

			Track trackz = new Track();

			try {

				trackz.setUser(us);
				trackz.setTrack_position_time(track.getPosition_time());
				trackz = trackServer.save(trackz);
				// set id trackz
				if (track.getWifi() != null) {
					for (int i = 0; i < track.getWifi().size(); i++) {
						track.getWifi().get(i).setTrack(trackz);
					}
					trackz.setWifi_live(track.getWifi());
				}
				if (track.getSat() != null) {
					for (int i = 0; i < track.getSat().size(); i++) {
						track.getSat().get(i).setTrack(trackz);
					}
					trackz.setSat_live(track.getSat());
				}
				if (track.getBluetooth() != null) {
					for (int i = 0; i < track.getBluetooth().size(); i++) {
						track.getBluetooth().get(i).setTrack(trackz);
					}
					trackz.setBlue_live(track.getBluetooth());
				}
				if (track.getCell() != null) {
					track.getCell().setTrack(trackz);
					trackz.setCell_live(track.getCell());
				}
				if (track.getLocation() != null) {
					track.getLocation().setTrack(trackz);
					trackz.setLocation_live(track.getLocation());
				}
				if (track.getSensor() != null) {
					track.getSensor().setTrack(trackz);
					trackz.setSensor_live(track.getSensor());
				}

				// update
				trackz = trackServer.save(trackz);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return JsonFormat.message(true, "success");
	}

}
