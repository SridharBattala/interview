package com.sree.programs.patterns.mergeintervals;

import java.util.LinkedList;
import java.util.List;

public class IntervalsIntersection {
	private static class Interval {
		  int start;
		  int end;

		  public Interval(int start, int end) {
		    this.start = start;
		    this.end = end;
		  }
		};
		private static Interval[] merge(Interval[] input1, Interval[] input2) {
			List<Interval> output =new LinkedList<Interval>();
			int i=0,j=0;
			while(input1.length>0 && input2.length>0) {
				if((input1[i].start<=input2[j].start && input1[i].end>=input2[j].end)
					|| (input1[i].start>=input2[j].start && input1[i].end<=input2[j].end)){
						output.add(new Interval(Math.max(input1[i].start, input2[j].start),Math.min(input1[i].end, input2[j].end)));
					}
				if(input1[i].end<input1[j].end) {
					i++;
				}else {
					j++;
				}
			}
			return output.toArray(new Interval[output.size()]);
		}
		public static void main(String[] args) {
		    Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
		    Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
		    Interval[] result = IntervalsIntersection.merge(input1, input2);
		    System.out.print("Intervals Intersection: ");
		    for (Interval interval : result)
		      System.out.print("[" + interval.start + "," + interval.end + "] ");
		    System.out.println();
		}
		
}
