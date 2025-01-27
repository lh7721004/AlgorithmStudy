package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 부녀회장이 될테야
// https://www.acmicpc.net/problem/2775
public class baekjoon_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k,n;
        int T = sc.nextInt();
        int[][] peoples = new int[15][15];
        //0층 1호~14호 초기화
        for(int i=1;i<=14;i++){
            peoples[i][1] = 1;
            peoples[0][i] = i;
        }
        for(int i=1;i<=14;i++){
            for(int j=2;j<=14;j++){
                peoples[i][j] = peoples[i][j-1]+peoples[i-1][j];
            }
        }
        for(int i=0;i<T;i++){
            k = sc.nextInt();
            n = sc.nextInt();
            System.out.println(peoples[k][n]);
        }
        sc.close();

    }
}