package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 2×n 타일링
// https://www.acmicpc.net/problem/11726
public class baekjoon_11726 {
    static int[] dp = new int[1001];
    public static void main(String[] args) {
        dp[1] = 1;
        dp[2] = 2;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }
        System.out.println(dp[n]);
        sc.close();
    }
}