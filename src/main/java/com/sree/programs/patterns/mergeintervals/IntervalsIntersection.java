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
		List<Interval> output = new LinkedList<>();
		int i = 0, j = 0;
		while (i < input1.length && j < input2.length) {
			Interval interval1 = input1[i];
			Interval interval2 = input2[j];
			boolean start1BetweenInterval2 = interval1.start >= interval2.start && interval1.start <= interval2.end;
			boolean start2BetweenInterval1 = interval2.start >= interval1.start && interval2.start <= interval1.end;

			if (start1BetweenInterval2 || start2BetweenInterval1) {
				int start = Math.max(interval1.start, interval2.start);
				int end = Math.min(interval1.end, interval2.end);
				output.add(new Interval(start, end));
			}

			if (interval1.end < interval2.end) {
				i++;
			} else {
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
