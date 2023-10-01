import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
public class NewGame{
  //ゲーム開始(スタートボタンで使用)
  public void newGame(Data data){
    //0~9までの数字を格納
    List list = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
    //メソッドを使用してシャッフルを行い、先頭３つを取り出しchar[]に格納
    Collections.shuffle(list);
    Iterator it = list.iterator();
    char[] gameNum = new char[3];
  	System.out.print("ゲーム側の数字：");
    for(int i=0; i<gameNum.length; i++){
      Character value = (Character)it.next();
      gameNum[i] = value;
      System.out.print(gameNum[i]);
    }
  	System.out.println();
    data.setGameNumbers(new char[]{gameNum[0],gameNum[1],gameNum[2]});
  }

  //ゲームの初期化(リセットボタンで使用)
  public Data gameReset(Data data){
    data = new Data();
    return data;
  }


}
