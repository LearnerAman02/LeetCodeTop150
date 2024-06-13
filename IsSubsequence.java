// pblm link --> https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
//T.C. --> O(N)
//S.C. --> O(1)
//simple approach ye hai ki hum 2 pointer use karenge and ek pointer s pe rakhenge and second ko t pe
//ab inke working ko samajhte hai
/*
  j           i
 "a b c"     "a h b g d c"   NOTE --> spaces between characters isiliye show kiya hai so that aap pointer ke movement ko achhe se dekh sake
 agar i and j pe jo character hai woh same hai than increment both pointers
    j           i
 "a b c"     "a h b g d c"
 agar i and j pe jo character hai woh different hai than increment only pointer i
    j             i
 "a b c"     "a h b g d c"
 same --> increment both
      j             i
 "a b c"     "a h b g d c"
 differnt --> only increment i
      j               i
 "a b c"     "a h b g d c"
 differnt --> only increment i
      j                 i
 "a b c"     "a h b g d c"
 same --> increment both
        j                 i
 "a b c"     "a h b g d c"
 jaise hi j string ke length ke equal ho gaya means woh string jisko j point kar rha tha woh subsequence hai 
*/
class Solution {
    public boolean isSubsequence(String s, String t){
        //creating two pointers
        if(s.length()==0){
            return true;
        }
        int i=0;
        int j=0;
        //loop run kro jab tak j s ke length 
        while(i<t.length() && j<s.length()){
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
            i++;
        }
        if(j==s.length()){
            return true;
        }
        else{
            return false;
        }
    }
}
