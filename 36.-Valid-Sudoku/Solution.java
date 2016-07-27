public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        //用三个数组记录行、列和单元格中已出现过的数字，数字为索引，为true则说明出现过
        boolean [][]rows = new boolean[length][length];
        boolean [][]cols = new boolean[length][length];
        boolean [][]cells = new boolean[length][length];
        
        for(int i=0;i<length;i++){
        	for(int j=0;j<length;j++){
        		rows[i][j]=false;
        		cols[i][j]=false;
        		cells[i][j]=false;
        	}
        }
        
        
        for(int i=0;i<length;i++){
        	for(int j=0;j<length;j++){
        		if(board[i][j]!='.'){
        			int num = Integer.parseInt(board[i][j]+"")-1;
        			if(rows[i][num]==true||cols[num][j]==true||cells[i/3*3+j/3][num]==true){
        				return false;
        			}
        			rows[i][num]=true;
        			cols[num][j]=true;
        			cells[i/3*3+j/3][num]=true;
        		}
        	}
        }
        return true;
    }
}
