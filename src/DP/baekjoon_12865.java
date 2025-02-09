package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 평범한 배낭
// https://www.acmicpc.net/problem/12865
public class baekjoon_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,cost;
        n = sc.nextInt();
        cost = sc.nextInt();
        int[] v = new int[n+1];
        int[] w = new int[n+1];
        int[][] dp = new int[n+1][cost+1];
        for(int i=1;i<=n;i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=cost;j++){
                if(j-w[i]>=0){//물건을 담을 수 있으면
                    dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i],dp[i-1][j]);//가장 가치 있는 물건을 담는다
                }
                else//물건을 담을 수 없으면
                    dp[i][j] = dp[i-1][j];//남은 배낭 용량을 유지한다
            }
        }

        /*
        dp 정의
        dp[i][j] : i번째 물건까지 선택했을 때 남은 용량 j에서 얻을 수 있는 최대 가치

        선택지 정의
        물건을 담는다:남은 배낭용량이 줄고, 담은 물건만큼 가치 증가 -> dp[i-1][j-w[i]]+v[i]
        물건을 담지 않는다:이전 상태와 같은 값 유지 -> dp[i-1][j]

        2가지 선택지중 최대값을 선택

        관계식 도출
        dp[i][j] = max(dp[i-1][j-w[i]]+v[i],dp[i-1][j])


        초기값 설정
        dp[0][j] = 0 -> 0번째 물건까지 선택했을 때 : 아무 물건도 선택하지 않았을 때
        dp[i][0] = 0 -> 남은 배낭용량이 0일 때


        */
        System.out.println(dp[n][cost]);
    }
}
