package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 정수 삼각형
// https://www.acmicpc.net/problem/1932
public class baekjoon_1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] tri = new int[N+1][N+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                tri[i][j] = sc.nextInt();
            }
        }
        for(int i=N-2;i>0;i--){
            for(int j=0;j<=i;j++){
                tri[i][j] = tri[i][j]+Math.max(tri[i+1][j],tri[i+1][j+1]);
            }
        }
        tri[0][0] = tri[0][0] + Math.max(tri[1][0],tri[1][1]);
        System.out.println(tri[0][0]);
    }
}
