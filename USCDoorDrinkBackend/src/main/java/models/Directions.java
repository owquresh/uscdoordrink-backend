package models;

import java.util.List;

import com.google.maps.model.LatLng;

public class Directions {
	private String distance;
	private String duration;
	private List<LatLng> path;
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<LatLng> getPath() {
		return path;
	}
	public void setPath(List<LatLng> path) {
		this.path = path;
	}
	public Directions(String distance, String duration, List<LatLng> path) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.path = path;
	}
	
	
}
