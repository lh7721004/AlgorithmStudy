package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 1로 만들기
// https://www.acmicpc.net/problem/
public class baekjoon_1463 {
    static int[] dp = new int[1000001];
    // 순서 : 1빼기>2나누기>3나누기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1]+1;// 1을 빼주는건 모든 숫자가 가능, 가장 적게 줄어들기 때문에 가장 먼저
            if(i%2==0)
                dp[i] = dp[i]>dp[i/2]+1?dp[i/2]+1:dp[i];
            if(i%3==0)
                dp[i] = dp[i]>dp[i/3]+1?dp[i/3]+1:dp[i];
        }
        System.out.println(dp[N]);

    }
}