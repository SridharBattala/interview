package com.sree.programs.datastructures.hashtable;
import java.util.*;
public class TraceJourney {
public static void main(String[] args) {
	HashMap<String,String> map=new HashMap<>();
	map.put("NewYork","Chicago");
	map.put("Boston","Texas");
	map.put("Missouri","NewYork");
	map.put("Texas","Missouri");
	printJourney(map);
}

private static void printJourney(HashMap<String, String> inputMap) {
	//get all values of map
	Collection<String> values=(Collection<String>) inputMap.values();
	//check for source
	String startPoint=null;
	int count=0;
	for(Map.Entry<String,String> entry:inputMap.entrySet()) {
		if(!values.contains(entry.getKey())) {
			count++;
			startPoint=entry.getKey();
		}
	}
	if(count>1) {
		System.out.println("disconnected graph");
	}else {
		String endPoint=inputMap.get(startPoint);
		while(endPoint!=null) {
			System.out.println(startPoint+"-->"+endPoint+", ");
			startPoint=endPoint;
			endPoint=inputMap.get(startPoint);
		}
	}
}
}
