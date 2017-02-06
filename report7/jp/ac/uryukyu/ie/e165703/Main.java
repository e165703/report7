package jp.ac.uryukyu.ie.e165703;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by e165703 on 2017/02/03.
 */
public class Main {
    public static void main(String[] args){
        int[] answer = new int[3];
        for (int i = 0; i < answer.length; i++) {
            boolean flag = false;
            answer[i] = (int) (Math.random() * 8 + 1);//randomを用いて答えの設定
            do {
                flag = false;
                for (int j = i - 1; j >= 0; j--) {//一つ前の数字が同一か判断、そうであれば繰り返す
                    if (answer[i] == answer[j]) {
                        flag = true;
                        answer[i] = (int) (Math.random() * 6 + 1);
                    }
                }

            } while (flag == true);//do文を用いて、３つの数字に被りがなくなるようにする
        }
        System.out.printf("ヌメロンゲームを始めます\n");
        int turn = 0;
        Player player = new Player(answer);
        do{//プレイヤーが３つの数字を当てるまで繰り返す
            turn ++;
            System.out.printf("%dターン目\n",turn);
            System.out.printf("３つの数字を入力してね！\n");
            player.settei();//プレイヤーに入力を求めるメソッド
            player.check_the_answer();//答えとプレイヤーの答えを照らし合わせていくつ正解しているか返すメソッド
            if(turn == 7 ){//7ターンになったらループから出る
                break;
            }
        } while(player.isPlayer_win() == false);
        if (player.isPlayer_win() == true){
            System.out.printf("あなたの勝ち！");
        }
        else{
            System.out.printf("あなたの負け！\n");
            System.out.printf("答えは%d,%d,%dでした",answer[0],answer[1],answer[2]);
        }

    }

}
