package util;

import com.google.gson.Gson;

/**
 * 
 * @author omar
 * Singleton class used to manage global GSON instance
 */
public class GsonGlobal {
	private Gson gson = new Gson();
	
	private static GsonGlobal gsonUtil = new GsonGlobal();
	
	private GsonGlobal() {
		
	}
	
	public static GsonGlobal getInstance() {
		return gsonUtil;
	}
	
	
	public Gson getGson() {
		if(gson==null) {
			gson=new Gson();
		}
		return gson;
	}
	
	
	public <T> String toJson(final T t) {
		if(t==null) {
			return "";
		}
		return getGson().toJson(t);
	}
	
	
}
