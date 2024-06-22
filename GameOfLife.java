//pblm link --> https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150

//NOTE -->pblm toh given hai GAME OF LIFE, but actually mei aapko GAME khelna hai with INDEXES properly so that U cam WIN(SOLVE)

//T.C. --> O(m.n)
//S.C. --> O(m.n)
class Solution {
    public void gameOfLife(int[][] board) {
        //BRUTE FORCE using EXTRA SPACE
        int m = board.length;
        int n = board[0].length;
        int[][] board2 = new int[m][n];
        //simple approach ye hai ki MATRIX ko traverse krna start kro and than jab aap current cell par ho
        //toh phir uske 8 directions mei check karlo LIVES ka count
        //and than count ko FIND krne ke baad BOARD2 ke andar UPDATED/NEXT STATE ko store karado
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = 0;//store count of live neighbours
                //now 8 directions mei jaao aur count lelo
                //ab yaha par maine observation kiya hai ki kin kin indexes par jaane ke liye [i-1] is a common factor
                if(i-1>=0){
                    if(board[i-1][j]==1){
                        count++;
                    }
                    if(j-1>=0 && board[i-1][j-1]==1){
                        count++;
                    }
                    if(j+1<n && board[i-1][j+1]==1){
                        count++;
                    }
                }
                //ab yaha par maine observation kiya hai ki kin kin indexes par jaane ke liye [j-1] is a common factor
                if(j-1>=0){
                    if(board[i][j-1]==1){
                        count++;
                    }
                    if(i+1<m && board[i+1][j-1]==1){
                        count++;
                    }
                }
                if(j+1<n){
                    if(board[i][j+1]==1){
                        count++;
                    }
                    if(i+1<m && board[i+1][j+1]==1){
                        count++;
                    }
                }
                if(i+1<m){
                    if(board[i+1][j]==1){
                        count++;
                    }
                }

                //now grid ki value check karo and than DIE yaa phir LIVE krdo
                if(board[i][j]==1 && count<2){
                    board2[i][j] = 0;
                }
                else if(board[i][j]==1 && (count==2 || count==3)){
                    board2[i][j] = 1;
                }
                else if(board[i][j]==1 && count>3){
                    board2[i][j] = 0;
                }
                else if(board[i][j]==0 && count==3){
                    board2[i][j]=1;
                }
            }
        }
        //now board2 se board mei place krdo values ko
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = board2[i][j];
            }
        }
    }
}
