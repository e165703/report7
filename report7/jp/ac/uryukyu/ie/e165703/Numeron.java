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
    private boolean player_win = false;
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
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "個目 : ");
            try {
                player_answer[i] = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            }
        }
    }
    public void check_the_answer(){
        eat = 0;
        bite = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (i == j && player_answer[i] == answer[j]) {
                    eat++;
                } else if (player_answer[i] == answer[j]) {
                    bite++;
                }
            }
        }
        //終了判断　ヒットが3つになったら終了
        System.out.println(eat + "EAT" + " " + bite + "BITE");
        if(eat == 3){
            player_win = true;
        }
    }

}
