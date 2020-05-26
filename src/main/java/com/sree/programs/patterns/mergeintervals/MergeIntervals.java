package com.sree.programs.patterns.mergeintervals;

import java.util.*;

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		// base case
		if (intervals.size() < 2) {
			return intervals;
		}
		// start solution
		List<Interval> output = new LinkedList<>();
		// sort the intevals
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		// loop the intervals
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (end > current.start) {
				end = Math.max(current.end, end);
			} else {
				output.add(new Interval(start, end));
				start = current.start;
				end = current.end;
			}
		}
		// add the last inteval
		output.add(new Interval(start, end));
		return output;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(2, 7));
		input.add(new Interval(5, 8));
		input.add(new Interval(10, 12));
		input.add(new Interval(13, 17));
		input.add(new Interval(15, 18));
		System.out.print("Merged intervals: ");
		for (Interval interval : MergeIntervals.merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

	}
}
