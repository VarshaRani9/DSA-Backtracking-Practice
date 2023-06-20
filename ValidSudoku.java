import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	static int MAX_SIZE = 9;
	public static void main(String[] args) {
		char [][]board ={
				{'5','3','.','.','7','.','.','.','.'},
				{'2','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'6','.','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','.'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		boolean res = isValidSudokuHelp(board,0,0);
		System.out.println(res==true?"Valid":"Not Valid");
	}
    
    private static boolean isValidSudokuHelp(char[][] board,int row, int col) {
        if(rowRepeat(board,row) || colRepeat(board,col) || subGridRepeat(board,row,col)){
            System.out.println(rowRepeat(board,row));
            System.out.println(colRepeat(board,col));
            System.out.println(subGridRepeat(board,row,col));
            return false;
        }
        if(col == MAX_SIZE){
            row+=1;
            col = 1;
            return isValidSudokuHelp(board, row, col);
        }
        if(row == MAX_SIZE){
               return true;
        }
        return isValidSudokuHelp(board, row, col+1);
    }
    private static boolean rowRepeat(char[][] board, int row) {
        row = row%9;
        Set<Character> encounteredValues = new HashSet<>();
        for(int col = 0;col<MAX_SIZE;col++){
            if(board[row][col] == '.')continue;
                if (encounteredValues.contains(board[row][col])) {
                    return true;
                }
                encounteredValues.add(board[row][col]);
        }
       return false;
    }
    private static boolean colRepeat(char[][] board, int col) {
        Set<Character> encounteredValues = new HashSet<>();
        col = col%9;
        for(int row = 0;row<MAX_SIZE;row++){
            if(board[row][col] == '.')continue;
            if (encounteredValues.contains(board[row][col])) {
                return true;
            }
            encounteredValues.add(board[row][col]);
        }
       return false;
    }
    private static boolean subGridRepeat(char[][] board,int row, int col) {
        int startRow = (row - row % 3)%9;
        int startCol = (col - col % 3)%9;
        Set<Character> encounteredValues = new HashSet<>();
        for(int i = startRow; i<startRow+3; i++){
            for(int j= startCol; j<startCol+3; j++){
                if(board[i][j] == '.')continue;
                if (encounteredValues.contains(board[i][j])) {
                    return true;
                }
                encounteredValues.add(board[i][j]);
            }
        }
        return false;
    }
}
