package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 01타일
// https://www.acmicpc.net/problem/1904
public class baekjoon_1904 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;
        if(N>=2){
            dp[2] = 2;
        }


        for(int i=3; i<=N; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%15746;
        }

        System.out.println(dp[N]%15746);
    }
}