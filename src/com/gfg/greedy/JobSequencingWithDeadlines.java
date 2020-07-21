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
public class JobSequencingWithDeadlines {
	public static void main(String[] args) {
		Job arr[] = { new Job('a', 2, 100), new Job('b', 1, 19), new Job('c', 2, 27), new Job('d', 1, 25),
				new Job('e', 3, 15) };
		sequenceJobs(arr, arr.length);

	}

	static void sequenceJobs(Job[] arr, int n) {
		Arrays.sort(arr, new JobSorter());

		int[] result = new int[n];
		boolean[] slot = new boolean[n];

		Arrays.fill(slot, false);
		for (int i = 0; i < n; i++) {
			for (int j = arr[i].deadline - 1; j >= 0; j--) {
				if (slot[j] == false) {
					slot[j] = true;
					result[j] = i;
					break;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (slot[i]) {
				System.out.print(" " + arr[result[i]].id);
			}
		}
	}
}

class Job {
	char id; // Job Id
	int deadline; // Deadline of job
	int profit;

	public Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	public String toString() {
		return id + "," + deadline + "," + profit;
	}
}

class JobSorter implements Comparator<Job> {
	@Override
	public int compare(Job o1, Job o2) {
		return (o2.profit - o1.profit);
	}

}
