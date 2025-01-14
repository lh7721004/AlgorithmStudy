package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 쉬운 계단 수
// https://www.acmicpc.net/problem/10844
public class baekjoon_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MOD = 1000000000;
        int N = sc.nextInt();
        long[][] dp = new long[N + 1][10];
        // dp[i][j]: 길이가 i이고 j로 끝나는 계단 수의 개수
        // 길이가 1일 때 초기화
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 길이가 2일때 부터 N까지 계산
        for (int i=2;i<=N;i++) {
            for (int j=0;j<10;j++) {
                if (j== 0) {
                    dp[i][j] = dp[i-1][1];  // 0은 이전 자릿수가 1일 때만 가능
                } else if (j==9) {
                    dp[i][j] = dp[i-1][8];  // 9는 이전 자릿수가 8일 때만 가능
                } else {
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % MOD;  // 중간수는 -1, +1 가능
                }
            }
        }

        long result = 0;
        for (int i=0;i<10;i++) {
            result = (result+dp[N][i])%MOD;
        }

        System.out.println(result);
        /*
        1
        2
        3
        4
        5
        6
        7
        8
        9

        12
        23
        34
        45
        56
        67
        78
        89
        98
        87
        76
        65
        54
        43
        32
        21
        10

        dp[N]
        dp[0] = 0
        dp[1] = 9
        dp[2] = 17
                1 -> [0,2]
                2 -> [1,3]
                3 -> [2,4]
                4 -> [3,5]
                5 -> [4,6]
                6 -> [5,7]
                7 -> [6,8]
                8 -> [7,9]
                9 -> 8
                2*8 + 1
        dp[3] =
                1 -> [0,2] -> [1],[1,3]
                2 -> [1,3] -> [0,2],[2,4]
                3 -> [2,4] -> [1,3],[3,5]
                4 -> [3,5] -> [2,4],[4,6]
                5 -> [4,6] -> [3,5],[5,7]
                ...
                8 -> [7,9] -> [6,8],[8]
                9 -> [8] -> [7,9]
                3+4*6+3+2

        */
    }
}