package DP;

import java.util.*;
import java.lang.*;
import java.io.*;
// 퇴사
// https://www.acmicpc.net/problem/14501
public class baekjoon_14501 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        String[] input;

        N = Integer.parseInt(br.readLine());
        int[] Time = new int[N+1];
        int[] Pay = new int[N+1];
        int[] dp = new int[N+2];
        for(int i=1;i<=N;i++){
            input = br.readLine().split(" ");
            Time[i] = Integer.parseInt(input[0]);
            Pay[i] = Integer.parseInt(input[1]);
        }
        //퇴사일 : N+1일
        //dp[i] : i일까지의 최대 수익
        //상담을 진행할 때 : 퇴사일을 넘기지 않아야함,
        //-> 상담을 진행하고 퇴사일을 넘기지 않을 때: (i일)+(i일 에 상담을 했을 때 걸리는 시간)<=퇴사일
        //->i+Time[i]<=N+1=>이게 조건
        //dp[i+Time[i]] -> i일에 상담을 시작하면 i+Time[i]일에 상담이 종료됨
        //dp[i+Time[i]]에 최댓값 갱신, dp[i+Time[i]](기존)과 dp[i]+Pay[i]비교

        //상담을 진행하지 않을 때 : 이전날짜의 보상액을 이월
        //-> Max(dp[i+1],dp[i])
        for(int i=1;i<=N;i++){
            dp[i+1] = Math.max(dp[i+1],dp[i]);
            if(i+Time[i]<=N+1){
                dp[i+Time[i]] = Math.max(dp[i+Time[i]],dp[i]+Pay[i]);
            }
        }
        System.out.println(dp[N+1]);
    }
}