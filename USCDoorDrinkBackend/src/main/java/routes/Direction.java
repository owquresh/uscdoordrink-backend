package routes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

import models.Directions;
import util.GsonGlobal;
import util.MapGlobal;

/**
 * Servlet implementation class Direction
 */
@WebServlet(name = "Direction", urlPatterns = "/Direction")
public class Direction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Direction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double originLat = Double.parseDouble(request.getParameter("origin_lat"));
		double originLng = Double.parseDouble(request.getParameter("origin_lng"));

		double destLat = Double.parseDouble(request.getParameter("dest_lat"));
		double destLng = Double.parseDouble(request.getParameter("dest_lng"));
		
		String type = request.getParameter("type");
		
		LatLng origin = new LatLng(originLat, originLng);
		LatLng dest = new LatLng(destLat, destLng);
		
		
		TravelMode mode = null;
		switch(type) {
			case "bike":
				mode = TravelMode.BICYCLING;
				break;
			case "car":
				mode = TravelMode.DRIVING;
				break;
			case "walk":
				mode = TravelMode.WALKING;
				break;
				
		}
		
		System.out.println(mode);
		
		ArrayList<LatLng> path = new ArrayList<LatLng>();
		
		DirectionsApiRequest directReq = DirectionsApi.newRequest(MapGlobal.getInstance().getContext())
				.mode(mode)
				.origin(origin)
				.destination(dest)
				.alternatives(false);
		String distance = null;
		String duration = null;
		
		try {
			DirectionsResult result =directReq.await();
			if(result.routes != null && result.routes.length>0) {
				DirectionsRoute route = result.routes[0];
				
				if(route.legs !=null) {
					
					for(int i=0;i<route.legs.length;i++) {
						DirectionsLeg leg = route.legs[i];
						
						if(leg.steps != null) {
							
							long value = leg.distance.inMeters;
							distance = new String(leg.distance.humanReadable);
							duration = new String(leg.duration.humanReadable);
							for(int j=0;j<leg.steps.length;j++) {
								DirectionsStep step = leg.steps[j];
								
								if(step.steps != null && step.steps.length>0) {
									for(int k=0;k<step.steps.length;k++) {
										DirectionsStep step1 = step.steps[k];
										EncodedPolyline points1 = step1.polyline;
										if(points1 != null) {
											List<LatLng> corrds1 = points1.decodePath();
											for(LatLng loc: corrds1) {
												path.add(loc);
											}

										
										}
																			}
								}else{
									EncodedPolyline points = step.polyline;
									List<LatLng> coords = points.decodePath();
									for(LatLng coord: coords) {
										path.add(coord);
									}
								}
							}
						}
					}
				}
				
			}
			
		} catch (ApiException | InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jsonString = null;
		Directions directionJson = new Directions(distance, duration, path);
		
		if(path.size()>0) {
			jsonString = new String(GsonGlobal.getInstance().toJson(directionJson));
		}else {
			jsonString = new String("");
		}
		

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(jsonString);
			out.flush();
		
	}

}
