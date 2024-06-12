//link --> https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public int removeDuplicates(int[] nums) {
        //simple logic hai
        //first position ke element ko as it is rakho and than idx ko maintain karo and jaise hi idx jisko point kr raha hai 
        //usse different element encounter hoga than usko place krdo
        int idx = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[idx]!=nums[i]){
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx+1;
    }
}
