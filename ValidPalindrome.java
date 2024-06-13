//pblm link --> https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
/*
MY APPROACH using StringBuilder
pehla task mera ye hai ki mai convert karu main given string ko into required string 
"A man, a plan, a canal: Panama"
"amanaplanacanalpanama" 

so iske liye we will use StringBuilder and Character.isLetterOrDigit(character) method
and for converting into lowercase Character.toLowerCase()

and than simply two pointers ka use krke check kar lenge ki resultant string palindrome hai yaa nhi

T.C. --> O(N) -- {Traversing the entire string for conversion}
S.C. --> O(N) -- {StringBuilder will consume extra space for building the string again}
*/
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        String f = sb.toString();
        //ab iss final string ko traverse karo and than two pointers ke help se palindrome check kar lo
        //ek start ptr 0 index pe rakho and ek end ptr length-1 pe rakho and than simply check krlo ki kya character match ho rahe hai
        // agar match hote hai than increase start ptr by 1 and decrement end ptr by 1 and simply ye karte jaao till start <= end
        //and kahi par bhi agar character match nhi hote toh return krdo false 
        //iss logic ko ek string pe run krke dekho tab achhe se understanding hogi
        n = f.length();
        int l=0;
        int r=n-1;
        while(l<=r){
            if(f.charAt(l)!=f.charAt(r)){
                return false;
            }
            else{
                //character match kr rahe hai dono index pe
                l++;
                r--;
            }
        }
        return true;
    }
}

/*
more optimized approach using two pointer only
T.C. --> O(N)
S.C. --> O(1)

string s = 'a, bb, c? bba'
ab 2 ptr se kaise karenge samajhte hai iss string pe pointers ko chalake

l                                            r
a | , |  | b | b | , |  | c | ? |  | b | b | a |

dono pe same characters hai and they are alphanumeric than just increment l and decrement r

    l                                    r
a | , |  | b | b | , |  | c | ? |  | b | b | a |

now since l ptr alphanumeric character ko point nhi kr raha toh usko tab tak increment kro jab tak it is not pointing to alphanumeric character

           l                             r
a | , |  | b | b | , |  | c | ? |  | b | b | a |
now again charAt[l] = charAt[r]
so l++ and r--

               l                     r
a | , |  | b | b | , |  | c | ? |  | b | b | a |
now again charAt[l] = charAt[r]
so l++ and r--

                   l              r
a | , |  | b | b | , |  | c | ? |  | b | b | a |

now l jab tak alphanumeric character ko point nhi kr raha hai increment krte raho
and r ke liye bhi same usko decrement karate jaao jab tak it is not pointing to alphanumeric character

                          lr
a | , |  | b | b | , |  | c | ? |  | b | b | a |

now l and r are at same and point to same so l++ and r--
and ab break kr jaao
*/
class Solution {
    public boolean isPalindrome(String s) {

        int l=0;
        int r=s.length()-1;
        while(l<=r){
            //jab tak alphanumeric character pe l nhi aa jata increment it
            while(l<s.length() && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            //jab tak alphanumeric character pe r nhi aa jata decrement it
            while(r>0 && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            //bhau jab check karoge characters ko toh ye ensure kro ki lowercase mei convert krke check kro characters ko
            if(l<s.length() && r>0 && Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}
