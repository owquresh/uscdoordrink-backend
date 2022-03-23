package util;

import com.google.maps.GeoApiContext;


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
	
	
	
}
