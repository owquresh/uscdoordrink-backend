package util;

import java.io.IOException;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;


/**
 * 
 * @author omar
 * Singleton class that is used to manage Google Maps API instances
 */
public class MapGlobal {

	private GeoApiContext context = new GeoApiContext.Builder()
			.apiKey("AIzaSyDBt46uNvgChSrlb6rwA_4ETq4h4P6qdxA")
			.build();
	
	
	private static MapGlobal mapGlobal = new MapGlobal();
	
	private MapGlobal() {
		
	}
	
	public static MapGlobal getInstance() {
		return mapGlobal;
	}
	
	public GeoApiContext getContext() {
		return context;
	}
	
	public LatLng geoCode(String address) {
		GeocodingResult[] result = null;
		
		try {
			result = GeocodingApi.geocode(getContext(), address).await();
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LatLng location = result[0].geometry.location;
		
		System.out.println(location.lat);
		System.out.println(location.lng);
		
		return location;
		
	}
	
	
}
