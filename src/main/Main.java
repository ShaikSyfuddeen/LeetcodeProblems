package main;

import java.util.*;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		CountOfSmallerNumbersAfterSelf s = new CountOfSmallerNumbersAfterSelf();
		int[] nums = {5,2,6,1};
		List<Integer> sol = new ArrayList<Integer>();
		sol = s.countSmaller(nums);
		System.out.print("nums : ");
		for(Integer i:nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("res : ");
		for(Integer i:sol) {
			System.out.print(i + " ");
		}
	}

}
