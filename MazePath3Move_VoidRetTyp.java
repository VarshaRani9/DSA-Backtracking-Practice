// void mazePathProblem(int row , int col, int endRow, int endCol, String result)
// Step - 1 Move to the Right
// Step-2 Move to the Down
// Step-3 Move to the Diagonal

public class MazePath3Move_VoidRetTyp {

	private static void mazePath(int row, int col, int endRow, int endCol, String res) {
		if(row == endRow && col == endCol) {
			System.out.println(res);
			return;
		}
		if(row > endRow || col > endCol) {
			return;
		}
		mazePath(row, col+1,endRow, endCol, res+"R");
		mazePath(row+1, col,endRow, endCol, res+"D");
		mazePath(row+1, col+1,endRow, endCol, res+"I");
	}
	public static void main(String[] args) {
		mazePath(0, 0, 2, 2, "");
	}

}
