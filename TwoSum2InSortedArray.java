//pblm link --> https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150
//T.C. --> O(N)
//S.C. --> O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        int sum = 0;
        int ans[] = new int[2];
        sum += (numbers[l]+numbers[r]);//store krlo initial value of sum as first and last element of array ka sum
        while(l<r){
            //agar sum = target ho gaya than simply store krdo values ko and break krdo loop ko
            if(sum==target){
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            }
            else if(sum>target){
                //since sum>target toh hume sum ki value ko decrease krna hai than hum r ptr pe jo value hai usko subtract karenge
                //r ptr pe jo value hai usko subtract karo
                sum -= numbers[r];
                r--;
                //and than simply add krdo current r pointing index ke value ko
                if(r>l){
                    sum += numbers[r];
                }
            }
            else{
                //since sum<target toh hume sum ki value ko increase krna hai than hum l ptr pe jo value hai usko subtract karenge and next bigger value ko add karenge in sum
                //l ptr pe jo value hai usko subtract kro
                sum -= numbers[l];
                l++;
                //now add the next value to which l is pointing
                if(l<r){
                    sum += numbers[l];
                }
            }
        }
        return ans;
    }
}
