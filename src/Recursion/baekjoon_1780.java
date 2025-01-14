package Recursion;
import java.util.*;
import java.lang.*;
import java.io.*;
// 종이의 개수
// https://www.acmicpc.net/problem/1780
public class baekjoon_1780 {
    static int[][] map;
    static int minus,plus,zero;
    public static boolean checkPaper(int startX,int startY,int size){
        if(size==1){
            return true;
        }
        int first = map[startX][startY];

        for(int y=0;y<size;y++){
            for(int x=0;x<size;x++){
                if(map[startX+x][startY+y]!=first){
                    return false;
                }
            }
        }
        return true;
    }
    public static void recursion(int startX,int startY,int size){
        if(checkPaper(startX,startY,size)==true){
            if(map[startX][startY]==0){
                zero += 1;
            }
            else if(map[startX][startY]==1){
                plus += 1;
            }
            else{

                minus += 1;
            }
        }
        else{
            for(int y=0;y<3;y++){
                for(int x=0;x<3;x++){
                    //오답노트 : 재귀함수 실행시 newStartX,newStartY가
                    //각각 x*(size/3),y*(size/3)로 지정했었는데 이러면 기준이 되었던 위치정보가 사라짐
                    int newStartX = startX+x*(size/3);
                    int newStartY = startY+y*(size/3);
                    recursion(newStartX,newStartY,size/3);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        String[] input;
        for(int y=0;y<N;y++){
            input = br.readLine().split(" ");
            for(int x=0;x<N;x++){
                map[x][y] = Integer.parseInt(input[x]);
            }
        }
        recursion(0,0,N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);

    }
}