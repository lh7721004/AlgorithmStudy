package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 가장 긴 증가하는 부분 수열
// https://www.acmicpc.net/problem/11053
public class baekjoon_11053 {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int i=0;i<N;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]&&dp[i]<=dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<N;i++){
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}