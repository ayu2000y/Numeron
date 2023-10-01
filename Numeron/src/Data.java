import java.util.ArrayList;
public class Data{
	private char[] gameNumbers;
	private char[] inputNumbers;
	private String judgeResult;
	private int judgeCount;
	private ArrayList resultHistory = new ArrayList();


	public void setGameNumbers(char[] c){
		gameNumbers = c;
	}
	public char[] getGameNumbers(){
		return gameNumbers;
	}

	public void setInputNumbers(char[] c){
		inputNumbers = c;
	}
	public char[] getInputNumbers(){
		return inputNumbers;
	}

	public void setJudgeResult(String s){
		judgeResult = s;
	}
	public String getJudgeResult(){
		return judgeResult;
	}

	public int decrementJudgeCount(){
		judgeCount--;
		return judgeCount;
	}
	public int resetJudgeCount(){
		judgeCount = 10;
		return judgeCount;
	}

	public void setHistory(String al){
		resultHistory.add(al);
	}
	public ArrayList getHistory(){
		return resultHistory;
	}
	public void resetHistory(){
		resultHistory.clear();
	}
}
