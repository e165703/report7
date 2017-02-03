package jp.ac.uryukyu.ie.e165703;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by e165703 on 2017/02/03.
 */
public class Main {
    public static void main(String[] args){
        int[] input = new int[3];
        int turn = 0;

        System.out.println("３つの数字を入力してください¥n");
        BufferedReader in
                = new BufferedReader(new InputStreamReader(System.in));
        for(int i= 0; i<3;i++){
            System.out.print( (i + 1) + "個目 : ");
            try {
                input[i] = Integer.parseInt(in.readLine());
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            }
        }
        while(win == false){
        }

    }
}
