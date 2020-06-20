package com.sree.programs.patterns.mergeintervals;

import java.util.*;

class InsertInterval {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> output = new LinkedList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int index = 1; index < intervals.size() + 1; index++) {
			boolean isStartBetweenNewInterval = (start >= newInterval.start && start <= newInterval.end);
			boolean isNewStartBetweenInterval = (newInterval.start >= start && newInterval.start <= end);
			if (isStartBetweenNewInterval || isNewStartBetweenInterval) {
				start = Math.min(start, newInterval.start);
				end = Math.max(end, newInterval.end);
				if (index > intervals.size() - 1) {
					break;
				}
				newInterval = intervals.get(index);
			} else {
				output.add(new Interval(start, end));
				if (index > intervals.size() - 1) {
					break;
				}
				start = intervals.get(index).start;
				end = intervals.get(index).end;
			}
		}
		output.add(new Interval(start, end));
		return output;
	}

	public static void main(String[] args) {

		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

	}
}
