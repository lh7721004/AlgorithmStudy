package DP;

import java.util.*;
import java.lang.*;
import java.io.*;
// 2×n 타일링 2
// https://www.acmicpc.net/problem/11727
public class baekjoon_11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();// 길이
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3;i<=N;i++){
            dp[i] = (dp[i-2]*2+dp[i-1])%10007;
        }
        System.out.println(dp[N]);
        // dp[i] : 길이가 2xi인 직사각형 채우는 경우의 수
        // dp[0] : 0
        // dp[1] : [세로1개] -> 1
        // dp[2] : [가로2개][세로2개][정사각형1개] -> 3
        // dp[3] :
        //[세로1개,가로2개]
        //[세로3개]
        //[가로2개,세로1개]
        //[정사각형1개,세로1개]
        //[세로1개,정사각형1개] -> 5

        // dp[4] :    [세로4개][가로4개][가로2개,세로2개][세로1개,가로2개,세로1개]
        //[세로2개,가로2개][정사각형1개,세로2개]
        //[정사각형1개,가로2개][가로2개,정사각형1개]
        //[세로2개,정사각형1개][정사각형1개,정사각형1개]
        //[세로1개,정사각형1개,세로1개] ->11개


    }
}