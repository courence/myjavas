package practice.concurrency.javaConcurrencyInPractice.chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DelegatingVehicleTracker {
	private final ConcurrentMap<String,Point> locations;
	private final Map<String,Point> unmodifiableMap;
	
	public DelegatingVehicleTracker(Map<String,Point> points){
		locations = new ConcurrentHashMap<String,Point>(points);
		unmodifiableMap = Collections.unmodifiableMap(locations);
	}
	
	public Map<String,Point> getLocations(){
		return unmodifiableMap;
	}
	
	public Point getLocation(String id){
		return locations.get(id);
	}
	
	public boolean setLocation(String id,int x,int y){
		if (locations.replace(id,new Point(x,y))==null){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		Map<String,Point> map = new HashMap<String,Point>();
		map.put("test", new Point(1,1));
		DelegatingVehicleTracker t = new DelegatingVehicleTracker(map);
		System.out.println(t.getLocation("test").x);
		t.setLocation("test", 2, 2);
		System.out.println(t.getLocation("test").x);
		System.out.println(t.getLocations().get("test").x);
	}
}
