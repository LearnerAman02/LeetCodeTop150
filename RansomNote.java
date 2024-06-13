// pblm link --> https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
//T.C. --> O(N+M)  -- {M - length of magazine string}
// S.C. --> O(N)  -- { N - length of ransomNote string }
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //simply first traverse krke ransomNote ko place krdo map mei and than aapne ye cheez krni hai ki
        //traverse kro magzine ko and remove kro elements ko from map agar at the map empty ho jata hai than return true 
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            hmap.put(ransomNote.charAt(i),hmap.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        //now magzine ko traverse kro and remove karo characters ko if they exist in map
        for(int i=0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            //decrement the frequency if the character is present in hmap
            if(hmap.containsKey(ch)){
                hmap.put(ch,hmap.getOrDefault(ch,0)-1);
                //agar frequency uss particular character ki 0 ho gayi than simply remove that element
                if(hmap.get(ch)==0){
                    hmap.remove(ch);
                }
            }
            //check kro agar hashmap empty ho gaya than return true 
            if(hmap.isEmpty()){
                return true;
            }
        }
        return false;
    }
}
