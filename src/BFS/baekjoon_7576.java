package BFS;
import java.util.*;
import java.lang.*;
import java.io.*;
// 토마토
// https://www.acmicpc.net/problem/7576
public class baekjoon_7576 {
    static int N,M;
    static int[][] arr;
    static int[][] POS = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visit;
    static Queue<int[]> queue = new LinkedList<>();
    static int days = 0;
    static boolean checkmap(){
        for(int y=0;y<M;y++){
            for(int x=0;x<N;x++){
                if(arr[x][y]==0)
                    return false;
            }
        }
        return true;
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRed = false;
            for(int i=0;i<size;i++){
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                for(int j=0;j<4;j++){
                    int px = x+POS[j][0];
                    int py = y+POS[j][1];
                    if(px>=0&&px<N&&py>=0&&py<M&&arr[px][py]==0){
                        arr[px][py] = 1;
                        queue.add(new int[]{px,py});
                        isRed = true;
                    }
                }

            }
            if(isRed)
                days++;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        visit = new boolean[N][M];
        for(int y=0;y<M;y++){
            input = br.readLine().split(" ");
            for(int x=0;x<N;x++){
                arr[x][y] = Integer.parseInt(input[x]);
                if(arr[x][y]==1){
                    queue.add(new int[]{x,y});
                }
            }
        }
        bfs();
        if(checkmap()){
            System.out.println(days);
        }
        else{
            System.out.println(-1);
        }

    }
}