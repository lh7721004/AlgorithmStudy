package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 가장 큰 증가하는 부분 수열
// https://www.acmicpc.net/problem/11055
public class baekjoon_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        String[] input = br.readLine().split(" ");

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int i=0;i<N;i++){
            dp[i] = arr[i];
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                }
            }
        }

        int max = 0;
        for(int i=0;i<N;i++){
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }
}