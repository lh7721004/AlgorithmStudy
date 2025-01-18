package Recursion;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
// 하노이 탑
// https://www.acmicpc.net/problem/1914
public class baekjoon_1914 {
    public static void hanoi(int N, int first,int mid,int last){
        if(N==1){//남은 원판이 1개면 바로 마지막으로 이동 가능
            System.out.println(first+" "+last);
            return;
        }
        hanoi(N-1,first,last,mid);//first->mid로 n-1개의 원판 이동(그래야 가장 큰 원판을 마지막으로 이동 시킬 수 있음)
        System.out.println(first+" "+last);//first->last로 가장 큰 원판 이동
        hanoi(N-1,mid,first,last);//mid->last로 n-1개의 원판 이동
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger base = new BigInteger("2");
        BigInteger one = new BigInteger("1");

        System.out.println(base.pow(N).subtract(one));//(2^N)-1
        if(N<=20){
            hanoi(N,1,2,3);
        }

    }
}