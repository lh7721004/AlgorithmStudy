package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
// 이친수
// https://www.acmicpc.net/problem/2193
public class baekjoon_2193 {
    public static void main(String[] args) throws IOException{
        //이친수는 0으로 시작하지 않는다.
        //이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.

        // N = 1
        // 1 -> 1
        // 1개

        // N = 2
        // 10 -> 2
        // 1개

        // N = 3
        // 100 -> 4
        // 101 -> 5
        // 2개

        // N = 4
        // 1000 -> 8
        // 1001 -> 9 +1
        // 1010 -> 10 +1
        // 3개

        // N = 5
        // 10000 -> 16
        // 10001 -> 17 +1
        // 10010 -> 18 +1
        // 10100 -> 20 +2
        // 10101 -> 21 +1
        // 5개

        // N = 6
        // 100000 -> 32
        // 100001 -> 33 +1
        // 100010 -> 34 +1
        // 100100 -> 36 +2
        // 100101 -> 37 +1
        // 101000 -> 40 +3
        // 101001 -> 41 +1
        // 101010 -> 42 +1
        // 8개

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] answer = new long[N+1];
        answer[0] = 0;
        answer[1] = 1;
        for(int i =2;i<=N;i++){
            answer[i] = answer[i-1]+answer[i-2];
        }
        System.out.println(answer[N]);
    }
}