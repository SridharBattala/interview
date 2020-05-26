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
		// base case
		if (meetings == null || meetings.size() == 0) {
			return 0;
		}
		// start solution
		// sort the meeting with start
		Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
		// create min heap
		PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
		int minRooms = 0;
		for (Meeting meeting : meetings) {
			while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
				minHeap.poll();
			}
			minHeap.offer(meeting);
			minRooms = Math.max(minRooms, minHeap.size());
		}
		return minRooms;
	}

}
