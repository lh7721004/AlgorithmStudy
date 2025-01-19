package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 계단 오르기
// https://www.acmicpc.net/problem/2579
public class baekjoon_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N+1];
        int[][] dp = new int[N+1][3];
        for(int i=1;i<=N;i++){
            score[i] = sc.nextInt();
        }
        dp[1][1] = score[1];
        if(N>=2){
            dp[2][1] = score[2];
            dp[2][2] = score[1]+score[2];
        }
        for(int i=3;i<=N;i++){
            dp[i][1] = Math.max(dp[i-2][1],dp[i-2][2])+score[i];
            dp[i][2] = dp[i-1][1]+score[i];
        }
        System.out.println(Math.max(dp[N][1],dp[N][2]));
    }
}