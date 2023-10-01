import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameManager extends Frame{
  private Button newGame;
  private Button endGame;
  private Button judge;
  private Button numberReset;
  private Button hint;

  private Button btn0;
  private Button btn1;
  private Button btn2;
  private Button btn3;
  private Button btn4;
  private Button btn5;
  private Button btn6;
  private Button btn7;
  private Button btn8;
  private Button btn9;

  private TextArea ruleDisplay;
  private TextArea historyDisplay;

  private Label judgeResult;
  private Label count;

  private Label firstDigitLabel;
  private Label secondDigitLabel;
  private Label thirdDigitLabel;

  //ユーザーが入力した値の表示
  private TextField firstDigit;		//1桁目
  private TextField secondDigit;	//2桁目
  private TextField thirdDigit;		//3桁目

  private String rule ="-----ルール-----\n" +
"0～9の数字を使って、3桁の数が作られる\n(数字は重複しない)\n"+
"プレイヤーは作成された3桁の数を予想し、数字を入力する\n"+
"入力された数を判定\n"+
"位置と番号が合っていた場合 Hit と表示\n"+
"位置はあっていないが番号が合っていた場合は Blow と表示\n"+
"3桁すべて制限回数以内に当てた(3Hitした)場合プレイヤーの勝利となる\n"+
"\n\n"+
"-----遊び方-----\n"+
"1. 「スタート」を押す\n"+
"2. 数字ボタンで3桁入力する\n"+
"3. 「判定」を押す\n"+
"4. 判定結果が表示される\n"+
"5. 2～4を繰り返し、制限回数以内に当てられればクリア！\n"+
"\n"+
"どうしてもわからないときは･･･\n"+
"「High＆Low」を押してみよう\n\n"+
"当てる数字が、\n"+
"0～4の場合 → Low \n5～9の場合 → High \nと表示される\n\n"+
"「リタイア」を押すと答えが表示されるよ";

  private Data data;
  private NewGame start;

  private ArrayList list;
  private String historys;


  public GameManager(){
	  setLayout(null);
	  data = new Data();
	  addWindowListener(new WindowClose());

	  newGame = new Button("スタート");
	  newGame.setBounds(500, 620, 300, 70);
    newGame.setFont(new Font("ＭＳ ゴシック", Font.ITALIC, 40));
    newGame.setForeground(Color.BLUE);
	  add(newGame);

	  endGame = new Button("リタイア");
    endGame.setBounds(810, 60, 100,  40);
    endGame.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 20));
    endGame.setBackground(Color.orange);
    endGame.setForeground(Color.white);
    endGame.setEnabled(false);
    add(endGame);

	  judge = new Button("判定");
	  judge.setBounds(450, 470, 175, 100);
    judge.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 40));
    judge.setForeground(Color.RED);
	  add(judge);
  	judge.setEnabled(false);

	  numberReset = new Button("数字リセット");
	  numberReset.setBounds(700, 470, 175, 100);
    numberReset.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 25));
	  add(numberReset);
  	numberReset.setEnabled(false);

    hint = new Button("High＆Low");
    hint.setBounds(830, 630, 100, 45);
    hint.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 15));
    hint.setForeground(Color.white);
    hint.setBackground(Color.pink);
    hint.setEnabled(false);
    add(hint);

	  btn0 = new Button("0");
	  btn0.setBounds(390, 200, 100, 100);
    btn0.setBackground(Color.lightGray);
    btn0.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn0);

	  btn1 = new Button("1");
	  btn1.setBounds(500, 200, 100, 100);
    btn1.setBackground(Color.darkGray);
    btn1.setForeground(Color.white);
    btn1.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn1);

	  btn2 = new Button("2");
	  btn2.setBounds(610, 200, 100, 100);
    btn2.setBackground(Color.lightGray);
    btn2.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn2);

	  btn3 = new Button("3");
	  btn3.setBounds(720, 200, 100, 100);
    btn3.setBackground(Color.darkGray);
    btn3.setForeground(Color.white);
    btn3.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn3);

	  btn4 = new Button("4");
	  btn4.setBounds(830, 200, 100, 100);
    btn4.setBackground(Color.lightGray);
    btn4.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn4);

	  btn5 = new Button("5");
	  btn5.setBounds(390, 310, 100, 100);
    btn5.setBackground(Color.darkGray);
    btn5.setForeground(Color.white);
    btn5.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn5);

	  btn6 = new Button("6");
	  btn6.setBounds(500, 310, 100, 100);
    btn6.setBackground(Color.lightGray);
    btn6.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn6);

	  btn7 = new Button("7");
	  btn7.setBounds(610, 310, 100, 100);
    btn7.setBackground(Color.darkGray);
    btn7.setForeground(Color.white);
    btn7.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn7);

	  btn8 = new Button("8");
	  btn8.setBounds(720, 310, 100, 100);
    btn8.setBackground(Color.lightGray);
    btn8.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn8);

	  btn9 = new Button("9");
	  btn9.setBounds(830, 310, 100, 100);
    btn9.setBackground(Color.darkGray);
    btn9.setForeground(Color.white);
    btn9.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(btn9);


	  firstDigit = new TextField("");
	  firstDigit.setBounds(555, 50, 70 ,70);
	  firstDigit.setFocusable(false);
	  firstDigit.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(firstDigit);

	  secondDigit = new TextField("");
	  secondDigit.setBounds(625, 50, 70 ,70);
	  secondDigit.setFocusable(false);
	  secondDigit.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(secondDigit);

	  thirdDigit = new TextField("");
	  thirdDigit.setBounds(695, 50, 70 ,70);
	  thirdDigit.setFocusable(false);
	  thirdDigit.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
	  add(thirdDigit);

    firstDigitLabel = new Label("");
    firstDigitLabel.setBounds(565, 120, 60, 30);
    firstDigitLabel.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 20));
    firstDigitLabel.setForeground(Color.pink);
    add(firstDigitLabel);

    secondDigitLabel = new Label("");
    secondDigitLabel.setBounds(635, 120, 60, 30);
    secondDigitLabel.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 20));
    secondDigitLabel.setForeground(Color.pink);
    add(secondDigitLabel);

    thirdDigitLabel = new Label("");
    thirdDigitLabel.setBounds(705, 120, 60, 30);
    thirdDigitLabel.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 20));
    thirdDigitLabel.setForeground(Color.pink);
    add(thirdDigitLabel);

	  ruleDisplay = new TextArea(rule, 150, 50, TextArea.SCROLLBARS_NONE);
	  ruleDisplay.setBounds(50, 50, 300, 650);
	  ruleDisplay.setFocusable(false);
	  ruleDisplay.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 18));
	  add(ruleDisplay);


  	historyDisplay = new TextArea("", 150, 50,TextArea.SCROLLBARS_NONE);
	  historyDisplay.setBounds(960, 50, 250, 650);
	  historyDisplay.setFocusable(false);
	  historyDisplay.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 23));
	  add(historyDisplay);

	  judgeResult = new Label(data.getJudgeResult());
	  judgeResult.setBounds(615, 140, 150,  50);
    judgeResult.setFont(new Font("SunsSerif", Font.ITALIC, 20));
	  add(judgeResult);

	  count = new Label("");
	  count.setBounds(380, 50, 140,  70);
	  count.setFont(new Font("SunsSerif", Font.ITALIC, 20));
	  add(count);

	  newGame.addActionListener(new GameStart());
  	judge.addActionListener(new Judge());
  	numberReset.addActionListener(new NumberReset());
    endGame.addActionListener(new GameEnd());
    hint.addActionListener(new Hint());

  	btn0.addActionListener(new AddNumber0());
  	btn1.addActionListener(new AddNumber1());
  	btn2.addActionListener(new AddNumber2());
  	btn3.addActionListener(new AddNumber3());
  	btn4.addActionListener(new AddNumber4());
  	btn5.addActionListener(new AddNumber5());
  	btn6.addActionListener(new AddNumber6());
  	btn7.addActionListener(new AddNumber7());
  	btn8.addActionListener(new AddNumber8());
  	btn9.addActionListener(new AddNumber9());

  	btnOff();

  }
    //パーツ初期化
	public void reset(){
		firstDigit.setText("");
    secondDigit.setText("");
    thirdDigit.setText("");

    firstDigitLabel.setText("");
    secondDigitLabel.setText("");
    thirdDigitLabel.setText("");

		judgeResult.setText("");
    judgeResult.setFont(new Font("SunsSerif", Font.ITALIC, 20));
    judgeResult.setForeground(Color.BLACK);

		count.setText("");

		historyDisplay.setText("");

		btnOn();

	}
	//ボタン使用不可
	public void btnOff(){
		btn0.setEnabled(false);
    btn1.setEnabled(false);
    btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
	}
	//ボタン使用可
	public void btnOn(){
		btn0.setEnabled(true);
    btn1.setEnabled(true);
    btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true);
		btn6.setEnabled(true);
		btn7.setEnabled(true);
		btn8.setEnabled(true);
		btn9.setEnabled(true);
	}

	//数字ボタンの分岐処理
	public void btnAction(Button btn, String num){
		if(firstDigit.getText().equals("")==true){
     		firstDigit.setText(num);
     		btn.setEnabled(false);
     	}else if(firstDigit.getText().equals("")==false && secondDigit.getText().equals("")==true){
     		secondDigit.setText(num);
     		btn.setEnabled(false);
     	}else if(firstDigit.getText().equals("")==false && secondDigit.getText().equals("")==false){
     		thirdDigit.setText(num);
     		btn.setEnabled(false);
     		btnOff();
     		judge.setEnabled(true);
     	}
	}

   //履歴表示の処理
	public void showHistory(ArrayList al) {
	  	  if(al!=null){
		  	  Iterator it = al.iterator();
		  	  while(it.hasNext()){
		  	  	historys = (String)it.next();
		  	  }
		  	historyDisplay.append(historys+"\n");
	  	  }
	}

  class WindowClose extends WindowAdapter{
     public void windowClosing(WindowEvent e){
         System.exit(0);
     }
  }

  //スタートボタン
  class GameStart implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	reset();
     	numberReset.setEnabled(true);
      endGame.setEnabled(true);
      hint.setEnabled(true);
     	start = new NewGame();
     	start.gameReset(data);
     	start.newGame(data);

     	data.resetJudgeCount();
     	count.setText("あと10回");
      historys = "";
      data.resetHistory();
    }
  }
  //数字を選びなおすボタン
  class NumberReset implements ActionListener{
     public void actionPerformed(ActionEvent e){
    	firstDigit.setText("");
      secondDigit.setText("");
      thirdDigit.setText("");
      btnOn();
      judge.setEnabled(false);
     }
  }
  //リタイアボタン
  class GameEnd implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	reset();
     	numberReset.setEnabled(false);
      judge.setEnabled(false);
      count.setText("リタイア");

      list = data.getHistory();
      Iterator it = list.iterator();
      while(it.hasNext()){
        historys = (String)it.next();
        historyDisplay.append(historys+"\n");
      }

      historyDisplay.append("リタイアされたよ\n");
      historyDisplay.append("スタートで再挑戦！");
      judgeResult.setText("答えは「"+data.getGameNumbers()[0]+data.getGameNumbers()[1]+data.getGameNumbers()[2]+"」");
      judgeResult.setFont(new Font("SunsSerif", Font.BOLD, 20));
      judgeResult.setForeground(Color.RED);
      btnOff();
      endGame.setEnabled(false);
      hint.setEnabled(false);
     }
  }
  //High&Lowボタン
  class Hint implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(data.getGameNumbers()[0]=='0' || data.getGameNumbers()[0]=='1' || data.getGameNumbers()[0]=='2' || data.getGameNumbers()[0]=='3' || data.getGameNumbers()[0]=='4' ){
        firstDigitLabel.setText("Low");
      }else{
        firstDigitLabel.setText("High");
      }
      if(data.getGameNumbers()[1]=='0' || data.getGameNumbers()[1]=='1' || data.getGameNumbers()[1]=='2' || data.getGameNumbers()[1]=='3' || data.getGameNumbers()[1]=='4' ){
        secondDigitLabel.setText("Low");
      }else{
        secondDigitLabel.setText("High");
      }
      if(data.getGameNumbers()[2]=='0' || data.getGameNumbers()[2]=='1' || data.getGameNumbers()[2]=='2' || data.getGameNumbers()[2]=='3' || data.getGameNumbers()[2]=='4' ){
        thirdDigitLabel.setText("Low");
      }else{
        thirdDigitLabel.setText("High");
      }
      hint.setEnabled(false);
    }
  }
  //判定ボタン
  class Judge implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	if(firstDigit.getText().equals("")==false && secondDigit.getText().equals("")==false && thirdDigit.getText().equals("")==false){
	     	NumbersJudge nj = new NumbersJudge();
	     	char[] digit1 = firstDigit.getText().toCharArray();
	     	char[] digit2 = secondDigit.getText().toCharArray();
	      char[] digit3 = thirdDigit.getText().toCharArray();

     		judge.setEnabled(false);

	     	data.setInputNumbers(new char[]{digit1[0], digit2[0], digit3[0]});

	     	System.out.print("入力された数字：" + digit1[0]);
	     	System.out.print(digit2[0]);
	     	System.out.print(digit3[0]);
	     	System.out.println();

	     	String judgeCount = Integer.valueOf(data.decrementJudgeCount()).toString();
     		count.setText("あと"+judgeCount+ "回");

	     	String num = firstDigit.getText() + secondDigit.getText() + thirdDigit.getText();

	     	String result = nj.numberJudge(data);
	     	judgeResult.setText(result);
	     	System.out.println(result);

	     	int inputCount = 10 - Integer.parseInt(judgeCount);
	     	data.setHistory(inputCount+"："+num + "　" +result);
        list = data.getHistory();
	     	showHistory(list);

	     	if(result.equals("3Hit!!")) {
	     		count.setText("ゲームクリア");
	     		numberReset.setEnabled(false);
	     		historyDisplay.append("ゲームクリア！\n");
          historyDisplay.append("スタートで再挑戦！");
          endGame.setEnabled(false);
          hint.setEnabled(false);
	     	}else if(judgeCount.equals("0")){
	     		count.setText("ゲームオーバー");
	     		numberReset.setEnabled(false);
	     		historyDisplay.append("残念ゲームオーバー\n");
          historyDisplay.append("スタートで再挑戦！");
	     		judgeResult.setText("答えは「"+data.getGameNumbers()[0]+data.getGameNumbers()[1]+data.getGameNumbers()[2]+"」");
          judgeResult.setFont(new Font("SunsSerif", Font.BOLD, 20));
          judgeResult.setForeground(Color.RED);
          endGame.setEnabled(false);
          hint.setEnabled(false);
	     	}else {

		     	firstDigit.setText("");
		     	secondDigit.setText("");
		     	thirdDigit.setText("");
		     	btnOn();

		     	System.out.println("残り回数：" + judgeCount);
	     	}

     	}
     }
  }

  //数字ボタン0～9
  class AddNumber0 implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	btnAction(btn0, "0");

     }
  }
	  class AddNumber1 implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	btnAction(btn1, "1");
     }
  }
	  class AddNumber2 implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	btnAction(btn2, "2");
     }
  }
	  class AddNumber3 implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	btnAction(btn3, "3");
     }
  }
	  class AddNumber4 implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	btnAction(btn4, "4");
     }
  }
	  class AddNumber5 implements ActionListener{
     public void actionPerformed(ActionEvent e){
      	btnAction(btn5, "5");
     }
  }
	  class AddNumber6 implements ActionListener{
     public void actionPerformed(ActionEvent e){
      	btnAction(btn6, "6");
     }
  }
	  class AddNumber7 implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	btnAction(btn7, "7");
     }
  }
	  class AddNumber8 implements ActionListener{
     public void actionPerformed(ActionEvent e){
     	btnAction(btn8, "8");
     }
  }
	  class AddNumber9 implements ActionListener{
     public void actionPerformed(ActionEvent e){
      	btnAction(btn9, "9");
     }
  }
}
