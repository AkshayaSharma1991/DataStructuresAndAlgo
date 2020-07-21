/**
 * 
 */
package com.gfg.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author akshayas
 *
 */
public class NMeetingInOneRoom {
	public static void main(String[] args) {
		int[] start = { 1, 3, 0, 5, 8, 5 };
		int[] end = { 2, 4, 6, 7, 9, 9 };
		selectMeetings(start, end, start.length);
	}

	static void selectMeetings(int[] start, int[] end, int n) {
		Meeting[] meetings = new Meeting[n];
		for (int i = 0; i < n; i++) {
			meetings[i] = new Meeting(i + 1, start[i], end[i]);
		}
		Arrays.sort(meetings, new MeetingComparator());

		int i = 0;
		System.out.print(meetings[0].position);

		for (int j = i + 1; j < n; j++) {
			if (meetings[j].start >= meetings[i].end) {
				System.out.print(" " + meetings[j].position);
				i = j;
			}
			
		}

	}

}

class Meeting {
	int position;
	int start;
	int end;

	public Meeting(int position, int start, int end) {
		this.end = end;
		this.start = start;
		this.position = position;
	}

	public String toString() {
		return position + "," + start + "," + end;
	}
}

class MeetingComparator implements Comparator<Meeting> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Meeting o1, Meeting o2) {
		return o1.end - o2.end;
	}

}