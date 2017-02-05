package jp.ac.uryukyu.ie.e165703;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by e165703 on 2017/02/03.
 */
public class Numeron{
    private int[] player_answer = new int[3];
    private int[] answer;
    private int eat,bite;
    private boolean player_win = false;//プレイヤーの勝ち負けを表す
    public Numeron(int[] answer){this.answer = answer;}
    public boolean isPlayer_win() {return player_win;}
    public void setPlayer_win(boolean player_win){this.player_win = player_win;}
    public int getEat(){return eat;}
    public void setEat(int eat){this.eat = eat;}
    public int getBite(){return bite;}
    public void setBite(int bite){this.bite = bite;}
    public int[] getAnswer(){return answer;}
    public void setAnswer(int[] answer) {this.answer = answer;}
    public int[] getPlayer_answer(){return player_answer;}

    public void setPlayer_answer(int[] player_answer) {this.player_answer = player_answer;}

    public void settei(){
        BufferedReader input
                = new BufferedReader(new InputStreamReader(System.in));//プレイヤー入力の保存
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "個目 : ");
            try {
                player_answer[i] = Integer.parseInt(input.readLine());//inputに入力された文字をint型にして保存
            } catch (NumberFormatException e) {//例外処理
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {//例外処理
                System.err.println("もう一度入力してください");
                i--;
            }
        }
    }
    public void check_the_answer(){
        eat = 0;//数字、場所被りの場合、値が加算される
        //例：答えが1,5,4 プレイヤーが9,5,2 この場合eat = 1
        bite = 0;//数字被りの場合、値が加算される
        //例：答えが1,5,4　プレイヤーが5,7,9　この場合bite = 1
        for (int i = 0; i < answer.length; i++) {//プレイヤーとホスト、二つの答え比較
            for (int j = 0; j < answer.length; j++) {
                if (i == j && player_answer[i] == answer[j]) {
                    eat++;
                } else if (player_answer[i] == answer[j]) {
                    bite++;
                }
            }
        }
        System.out.println(eat + "EAT" + " " + bite + "BITE");
        if(eat == 3){
            player_win = true;
        }
    }

}
