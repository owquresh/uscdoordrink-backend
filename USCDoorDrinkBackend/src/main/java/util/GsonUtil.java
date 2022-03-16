package util;

import com.google.gson.Gson;

public class GsonUtil {
	private static final Gson gson = new Gson();
	
	public static String toJson(String json, Object obj) {
		if(obj.equals(null)) {
			return "";
		}
		return gson.toJson(obj);
	}
}
