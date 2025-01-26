package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 가장 긴 감소하는 부분 수열
// https://www.acmicpc.net/problem/11722
public class baekjoon_11722 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        String[] input = br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(input[i-1]);
        }
        // 10 30 10 20 20 10
        // [0] = 1
        // [1] = 1
        // [2] = 2 -> [1]+1 -> 30 10
        // [3] = 2 -> [1]+1 -> 30 20
        // [4] = 2 -> [1]+1 -> 30 20
        // [5] = 3 -> [4]+1 -> 30 20 10
        // 11
        // 1 2 3 4 5 6 5 4 3 2 1
        // 6

        // 10
        // 1 5 3 4 2 1 7 2 1 5 1
        // 4

        // 1
        // 1
        // 1

        // 3
        // 1 2 3
        // 1

        // 15
        // 1 15 3 5 4 8 94 12 15 13 15 5 8 7 3
        // 94
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]&&dp[i]<=dp[j]){
                    dp[i] = dp[j]+1;
                }
                else if(arr[i]==arr[j]){
                    dp[i] = dp[j];
                }
            }
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}