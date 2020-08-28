package com.sree.programs.patterns.mergeintervals;

import java.util.*;

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		return Arrays.asList();
	}

	// [1,8] [10,12] [13,18]
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
