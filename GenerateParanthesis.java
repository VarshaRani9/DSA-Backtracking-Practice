import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public static void main(String[] args) {
		int n = 4;
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		generateParenthesis(res,n,0,0,sb);
		System.out.println(res);
	}
    public static void generateParenthesis(List<String> res, int n, int opening, int closing, StringBuilder op) {
        if(op.length() == n*2){
            res.add(op.toString());
            return;
        }
  
        if(opening < n){
            op.append("(");
            generateParenthesis(res, n, opening+1, closing, op);
            op.deleteCharAt(op.length()-1);
        }
        
        if(closing < opening){
            op.append(")");
            generateParenthesis(res, n, opening, closing+1, op);
            op.deleteCharAt(op.length()-1);
        }
    }
}
