// pblm link --> https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
// T.C. --> O(N)
//S.C. --> O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int prevCurr = nums[0];
        int count = 1;
        int curr = nums[0];
        int idx = 1;
        for(int i=1;i<nums.length;i++){
            //pehle check krlo ki kya previous element ke barabar current element hai kya agar hai than increment count and check that, can it be placed agar count <=2 hai
            if(prevCurr == nums[i]){
                count++;
                if(count<=2){
                    //agar count<=2 hai than index pe place krdo element ko 
                    nums[idx] = nums[i];
                    idx++;
                }
            }
            else{
                //agar previous unique element current element ke equal nhi hai means new unique element mila hai so update krdo prevCurr ko
                prevCurr = nums[i];
                nums[idx] = nums[i];
                idx++;
                count = 1;
            }
        }
        return idx;//index at the end hoga 1 position ahead of all elements placed so we don't need to return idx+1
    }
}
