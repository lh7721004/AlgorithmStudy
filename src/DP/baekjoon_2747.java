package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 피보나치 수
// https://www.acmicpc.net/problem/2747
public class baekjoon_2747 {
    public static int[] dp = new int[10000];
    public static void fibo(int now,int n){
        if(now==n){return;}
        if(now==0){
            dp[0] = 0;
        }
        else if(now==1){
            dp[1] = 1;
        }
        else if(dp[now]==0){
            dp[now] = dp[now-1]+dp[now-2];
        }
        fibo(now+1,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fibo(0,N+1);
        System.out.println(dp[N]);
    }
}