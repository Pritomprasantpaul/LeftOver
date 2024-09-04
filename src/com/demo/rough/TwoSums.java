package com.demo.rough;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

	public static void main(String[] args) {
		int[] nums = new int[] {-10,2,19,15};
		int[] ans = twoSum(nums, 9);
		System.out.println(ans[0] +" "+ ans[1]);
		System.out.println(nums[ans[0]] +" "+ nums[ans[1]]);

	}
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }
}
