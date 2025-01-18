package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 가장 긴 바이토닉 부분 수열
// https://www.acmicpc.net/problem/11054
public class baekjoon_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N+1];
        int[] increase_dp = new int[N+1];
        int[] decrease_dp = new int[N+1];
        for(int i=1;i<=N;i++){
            numbers[i] = sc.nextInt();
        }
        for(int i=1;i<=N;i++){
            increase_dp[i] = 1;
            for(int j=0;j<i;j++){
                if(numbers[j]<numbers[i]){//증가할 때
                    increase_dp[i] = Math.max(increase_dp[i],increase_dp[j]+1);
                }
            }
        }
        for(int i=N;i>=0;i--){
            decrease_dp[i] = 1;
            for(int j=N;j>i;j--){
                if(numbers[j]<numbers[i]){//감소할 때
                    decrease_dp[i] = Math.max(decrease_dp[i],decrease_dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=1;i<=N;i++){
            max = Math.max(max,increase_dp[i]+decrease_dp[i]);
        }
        System.out.println(max-1);
    }
}