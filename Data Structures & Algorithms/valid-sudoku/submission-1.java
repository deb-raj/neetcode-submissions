class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            Set<Character>set=new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        for(int i=0;i<board.length;i++){
            Set<Character>set=new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(set.contains(board[j][i])){
                    return false;
                }
                set.add(board[j][i]);
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                Set<Character>set=new HashSet<>();
                for(int r=i;r<i+3;r++){
                    for(int c=j;c<j+3;c++){
                        if(board[r][c]=='.'){
                            continue;
                        }
                        if(set.contains(board[r][c])){
                            return false;
                        }
                        set.add(board[r][c]);
                    }
                }
            }
        }
        return true;
    }
}
