//pblm link --> https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150
//T.C. --> O(nlogn)
//S.C. --> O(1)
/*
h index means mujhe maximum numbers of papers find krne hai jisme, number of citations >= number of papers ho

so hum GREEDY APPPROACH apply karenge, simply first we will sort the array and than hum find karenge ki kitne papers maximum aise hai jo h index ke condition ko satisfy krte hai

Example se samajhte hai
h = 0 {initially 0 papers are there o papers}
Array --> [3,0,6,1,5]
After sorting --> [0,1,3,5,6]

h = 0
 i
[0,1,3,5,6]    Total published papers with citation atleast 0 --> 5, but citation value at current idx is 0 which is less than numbers of cited papers


   i
[0,1,3,5,6]    Total published papers with citation atleast 1 --> 4, but citation value at current idx is 1 which is less than numbers of remaining cited papers including current paper

     i
[0,1,3,5,6]    Total published papers with citation atleast 3 --> 3, but citation value at current idx is 3 which is >= numbers of remaining cited papers including current paper
so h index = Math.max(h,no.of papers with citation atleast 3) 
therefore h = 3

       i
[0,1,3,5,6]    Total published papers with citation atleast 5 --> 2, but citation value at current idx is 5 which is greater than numbers of remaining cited papers including current paper
so h index = Math.max(h,no.of papers with citation atleast 5) 
h = Math.max(3,2)
therefore h = 3

         i
[0,1,3,5,6]    Total published papers with citation atleast 5 --> 2, but citation value at current idx is 6 which is greater than numbers of remaining cited papers including current paper
so h index = Math.max(h,no.of papers with citation atleast 6) 
h = Math.max(3,1)
therefore h = 3
*/
class Solution {
    public int hIndex(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            int maxPapers = citations.length-i;
            if(citations[i]>=maxPapers){
                h = Math.max(h,maxPapers);
            }
        }
        return h;
    }
}
