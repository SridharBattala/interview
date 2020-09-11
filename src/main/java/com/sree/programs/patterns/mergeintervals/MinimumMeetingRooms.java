package com.sree.programs.patterns.mergeintervals;

import java.util.*;

public class MinimumMeetingRooms {
	public static void main(String[] args) {
		List<Meeting> input = new ArrayList<>();
		input.add(new Meeting(4, 5));
		input.add(new Meeting(2, 3));
		input.add(new Meeting(2, 4));
		input.add(new Meeting(3, 5));
		int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);
	}

	private static int findMinimumMeetingRooms(List<Meeting> meetings) {
		if (meetings == null || meetings.size() == 0)
			return 0;

		// sort the meetings by start time
		Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

		int minRooms = 0;
		PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
		for (Meeting meeting : meetings) {
			System.out.println(" meeting=" + meeting.toString() + ", minHeap=" + minHeap.toString());
			// remove all meetings that have ended
			while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end)
				minHeap.poll();
			// add the current meeting into the minHeap
			minHeap.offer(meeting);
			// all active meeting are in the minHeap, so we need rooms for all of them.
			minRooms = Math.max(minRooms, minHeap.size());
		}
		return minRooms;
	}

}
