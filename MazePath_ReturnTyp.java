import java.util.ArrayList;

public class MazePath_ReturnTyp {

	static ArrayList<String> mazePath(int curRow, int curCol, int endRow, int endCol){
//		positive termination case
		if(curCol==endCol && curRow==endRow) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
//		negative termination case
		if(curCol>endCol || curRow>endRow) {
			ArrayList<String> res = new ArrayList<>();
			return res;
		}
		ArrayList<String> finalRes = new ArrayList<>();
		ArrayList<String> rightRes = mazePath(curRow, curCol+1, endRow, endCol);
		for(String r : rightRes) {
			finalRes.add("R"+r);
		}
		ArrayList<String> bottomRes = mazePath(curRow+1, curCol, endRow, endCol);
		for(String b : bottomRes) {
			finalRes.add("D"+b);
		}
		return finalRes;
	}
	public static void main(String[] args) {
		ArrayList<String> res = mazePath( 0, 0, 2, 2);
		System.out.println(res);
	}

}
