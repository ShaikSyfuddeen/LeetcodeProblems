package main;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
	
	/* Problem Statement
	 	Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].
	 	
	 	Example 1:
		Input: nums = [5,2,6,1]
		Output: [2,1,1,0]
		Explanation:
		To the right of 5 there are 2 smaller elements (2 and 1).
		To the right of 2 there is only 1 smaller element (1).
		To the right of 6 there is 1 smaller element (1).
		To the right of 1 there is 0 smaller element.
	 */
	
	/* 	Solution:
	 
	  	The basic idea is to do merge sort to nums[]. To record the result, we need to keep the index of each number in the original array. 
	  	So instead of sort the number in nums, we sort the indexes of each number.
		Example: nums = [5,2,6,1], indexes = [0,1,2,3]
		After sort: indexes = [3,1,0,2]
		
		While doing the merge part, say that we are merging left[] and right[], left[] and right[] are already sorted.
		
		We keep a rightcount to record how many numbers from right[] we have added and keep an array count[] to record the result.
		
		When we move a number from right[] into the new sorted array, we increase rightcount by 1.
		
		When we move a number from left[] into the new sorted array, we increase count[ index of the number ] by rightcount.
	 */
	
	private void merge(int[] nums, int[] indexes, int start, int mid, int end){
		
		int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;    	
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while(left_index <= mid && right_index <= end){
            if(nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index++] = indexes[right_index++];
                rightcount++;
            }else{
                new_indexes[sort_index++] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
        }
        while(left_index <= mid){
            new_indexes[sort_index++] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
        }
        while(right_index <= end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for(int i = start; i <= end; i++){
            indexes[i] = new_indexes[i - start];
        }
		
	}
	
	private void mergeSort(int[] arr, int[] indexes, int start, int end) {
		
		if(start < end) {
			int mid = (end - start)/2 + start;
			
			mergeSort(arr, indexes, start, mid);
			mergeSort(arr, indexes, mid+1, end);
			merge(arr, indexes, start, mid, end);
			
		}
	}

    int[] count;
    //call to method to run
    public List<Integer> countSmaller(int[] nums) {
       List<Integer> res = new ArrayList<Integer>();

       count = new int[nums.length];
       int[] indexes = new int[nums.length];

       for(int i=0; i<nums.length; i++){
           indexes[i] = i;
       }

       mergeSort(nums, indexes, 0, nums.length-1);

       for(int i=0; i<count.length; i++){
           res.add(count[i]);
       }

       return res;
    }
}
