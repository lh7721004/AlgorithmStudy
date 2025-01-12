package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 피보나치 함수
// https://www.acmicpc.net/problem/1003
public class baekjoon_1003 {
    static int[][] dp = new int[2][41];
    public static void main(String[] args) {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        Scanner sc = new Scanner(System.in);
        int n;
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            n = sc.nextInt();
            for(int k=2;k<=n;k++){
                dp[0][k] = dp[0][k-1]+dp[0][k-2];
                dp[1][k] = dp[1][k-1]+dp[1][k-2];
            }
            System.out.println(dp[0][n]+" "+dp[1][n]);
        }
        sc.close();
    }
}