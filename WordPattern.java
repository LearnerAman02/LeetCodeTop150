//pblm link --> https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
//T.C. --> O(N)
//S.C. --> O(N)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        HashMap<Character,String> hmap = new HashMap<>();
        //agar words array ka size equal nhi hai to pattern ka length than simply return false kyunki har ek character ke corresponding than unique mapping not possible
        if(pattern.length() != words.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            //agar current index pe jo character hai woh already hai map mei toh uske corresponding jo string mapped hai usse different string 
            // agar current index pe present hai than simply return false
            if(hmap.containsKey(ch)){
                String str = hmap.get(ch);
                if(!str.equals(words[i])){
                    return false;
                }
            }
            else{
                //agar new character aaya hai jisko hume map mei put krna hai than hume ye bhi ensure krna hai ki new String aaye 
                //because already ye string present hai agar map mei than unique mapping nhi ho rahi hai
                if(hmap.containsValue(words[i])){
                    return false;
                }
                hmap.put(ch,words[i]);
            }
        }
        return true;
    }
}
