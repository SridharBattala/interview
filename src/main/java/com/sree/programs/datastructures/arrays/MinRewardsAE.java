package com.sree.leave.programs.datastructures.arrays;


import java.util.Arrays;
import java.util.stream.*;




/**
 * Sample input: [8,4,2,1,3,6,7,9,5]
 * sample output: [4,3,2,1,2,3,4,5,1] 25
 * @author sridharbattala
 *
 */
public class MinRewardsAE {
public static void main(String args[]) {
	System.out.println(minRewards(new int[] {8,4,2,1,3,6,7,9,5}));
}
public static int minRewards(int[] scores) {
    int[] rewards = new int[scores.length];
    Arrays.fill(rewards, 1);
    for (int i = 1; i < scores.length; i++) {
      if (scores[i] > scores[i - 1]) rewards[i] = rewards[i - 1] + 1;
    }
    for (int i = scores.length - 2; i >= 0; i--) {
      if (scores[i] > scores[i + 1]) {
        rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
      }
    }
    return IntStream.of(rewards).sum();
  }
}
