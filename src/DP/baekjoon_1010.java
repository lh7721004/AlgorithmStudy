package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 다리 놓기
// https://www.acmicpc.net/problem/1010
public class baekjoon_1010 {
    public static void main(String[] args) throws IOException{
        int Height = 30;
        int[][] pascal = new int[Height][Height];
        for (int i = 0; i < Height; i++) {
            pascal[i] = new int[i + 1];
            // 각 행의 첫 번쨰와 마지막 숫자는 1
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            // 중간에 위치한 숫자는 이전 행의 왼쪽에 있는 숫자와 바로 위에 있는 숫자의 합
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int n,m;
        for(int i=0;i<T;i++){
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            System.out.println(pascal[m][n]);
        }
    }
}