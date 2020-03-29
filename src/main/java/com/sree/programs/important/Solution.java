package com.sree.leave.programs.important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
	public static void main(String a[]) {
		//System.out.println(minimumTime(6,Arrays.asList(1,2,5,10,35,89)));
		List<List<Integer>> outPut=optimalUtilization(7000, 
				Arrays.asList(Arrays.asList(1,2000),Arrays.asList(2,4000),Arrays.asList(3,6000)),
				Arrays.asList(Arrays.asList(1,2000)));
		for(int i=0;i<outPut.size();i++) {
			System.out.println(outPut.get(i).toString());
		}
	} 
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	static int  minimumTime(int numOfParts, List<Integer> parts)
    {
		List<Integer> coutingParts=new ArrayList<>();
        parts=parts.stream().sorted().collect(Collectors.toList());
        System.out.println(parts.toString());
        int tempCount=0;
        for(int i=0;i<numOfParts-1;i++){
        	tempCount=parts.get(0)+parts.get(1);
        	coutingParts.add(tempCount);
            parts.remove(0);
            parts.remove(0);
            parts.add(0,tempCount);
            
        }
        return coutingParts.stream().mapToInt(Integer::intValue).sum();
  
    }
	static List<List<Integer>>  optimalUtilization(int maxTravelDist, 
            List<List<Integer>> forwardRouteList,
            List<List<Integer>> returnRouteList)
	{
		List<List<Integer>> combinedRouteList=new ArrayList<>();
		boolean matchFound=false;
		int tempDiff=0,minDiff=7000;
		for(int i=0;i<forwardRouteList.size();i++) {
			for(int j=0;j<returnRouteList.size();j++) {
				List<Integer> combinedRoute=new ArrayList<>();
				combinedRoute.add(0,forwardRouteList.get(i).get(0));
				combinedRoute.add(1,returnRouteList.get(j).get(0));
				combinedRoute.add(2,forwardRouteList.get(i).get(1)+returnRouteList.get(j).get(1));
				tempDiff=maxTravelDist-(forwardRouteList.get(i).get(1)+returnRouteList.get(j).get(1));
				if(tempDiff==0) {
					matchFound=true;
					combinedRoute.add(3,tempDiff);

				}else if(tempDiff>0 && tempDiff<minDiff)
				{
					minDiff=tempDiff;
					combinedRoute.add(3,minDiff);

				}else {
					combinedRoute.add(3,tempDiff);
				}
				combinedRouteList.add(combinedRoute);
			}
		}
		//[[1, 1, 4000, 3000], [2, 1, 6000, 1000], [3, 1, 8000, -1000]]
		System.out.println(minDiff);
		final int tempMinDiff=minDiff;
		if(matchFound) {
			return combinedRouteList.stream().filter(list->{ 
				 if(list.get(3)==0) {
					list.remove(2);
					list.remove(3);
					return true;
				}
				 return false;
						}).collect(Collectors.toList());
		}else {
			return combinedRouteList.stream().filter(list->{ 
				 if(list.get(3)==tempMinDiff) {
					list.remove(2);
					list.remove(3);
					return true;
				}
				 return false;
						}).collect(Collectors.toList());
		}
		
				
			

}
}
