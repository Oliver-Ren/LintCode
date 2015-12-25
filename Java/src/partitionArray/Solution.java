/**
 * The thought are from 3-way partitioning.
 * Status: Accepted.
 */
public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int i = 0;
	    int j = 0;
	    while (j < nums.length) {
	        if (nums[j] < k) exch(nums, i++, j++);
	        else j++;
	    }
	    return i;
    }
    
    private void exch(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
