import java.util.ArrayList;

public class DiceBoardGame_ReturnTyp {

	static ArrayList<String> diceGame(int currentVal, int endVal){
		if(currentVal == endVal) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		if(currentVal > endVal) {
			ArrayList<String> res = new ArrayList<>();
			return res;
		}
		ArrayList<String> ans = new ArrayList<>();
		for(int dice = 1;dice<=6;dice++) {
			int newVal = currentVal + dice;
			ArrayList<String> list = diceGame(newVal,endVal);
		for(String s : list) {
			ans.add(dice+s);
		}
		}
		return ans;
	}
	public static void main(String[] args) {
		ArrayList<String> res = diceGame(0,6);
//		System.out.println(res);
		for(String s : res) {
			System.out.println(s);
		}
	}

}
