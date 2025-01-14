package Implementation;
import java.util.*;
import java.lang.*;
import java.io.*;
// 연구소
// https://www.acmicpc.net/problem/14502
public class baekjoon_14502 {
    static int N,M;
    static int[][] map;
    static int[][] copymap;
    static int[][] POS = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visit;
    static ArrayList<ArrayList<Integer>> virus = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> wall = new ArrayList<ArrayList<Integer>>();
    public static void cloneMap(){
        for(int y=0;y<N;y++){
            for(int x=0;x<M;x++){
                copymap[x][y] = map[x][y];
            }
        }
    }
    public static int printMap(){
        int safe = 0;
        for(int y=0;y<N;y++){
            for(int x=0;x<M;x++){
                if(copymap[x][y]==0)
                    safe++;
                // System.out.print(copymap[x][y]+" ");
            }
            // System.out.println();
        }
        return safe;
    }
    public static void spread_virus(int x,int y){
        if(visit[x][y] == true){
            return;
        }
        visit[x][y] = true;
        if(copymap[x][y]==0){
            copymap[x][y] = 2;
        }
        for(int i=0;i<4;i++){
            int px = x+POS[i][0];
            int py = y+POS[i][1];
            if(px>=0&&px<M&&py>=0&&py<N&&copymap[px][py]==0){
                spread_virus(px,py);
            }
        }
        visit[x][y] = false;
    }
    static int[] toXY(int number){
        int[] xy = new int[2];
        xy[0] = number/M;
        xy[1] = number%M;
        return xy;
    }
    // 배열 출력
    static int print(int[] arr, boolean[] visited) {
        boolean canPut = true;
        cloneMap();
        int[][] putPos = new int[3][2];
        int cnt = 0;
        int safe = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true){
                // System.out.print(toXY(i)[0]+","+toXY(i)[1]+"\t");
                if(copymap[toXY(i)[1]][toXY(i)[0]]!=0){
                    canPut = false;
                }
                putPos[cnt] = toXY(i);
                cnt++;
            }
        }
        if(canPut){


            // 벽 설치
            copymap[putPos[0][1]][putPos[0][0]] = 1;
            copymap[putPos[1][1]][putPos[1][0]] = 1;
            copymap[putPos[2][1]][putPos[2][0]] = 1;

            // 바이러스 퍼뜨리기
            for(int i=0;i<virus.size();i++){
                ArrayList<Integer> pos = virus.get(i);
                int x = pos.get(0);
                int y = pos.get(1);
                spread_virus(x,y);
            }
            safe = printMap();
            // visit = new boolean[M][N];
            // System.out.print(putPos[0][0]+","+putPos[0][1]+"\t");
            // System.out.print(putPos[1][0]+","+putPos[1][1]+"\t");
            // System.out.println(putPos[2][0]+","+putPos[2][1]);
        }
        return safe;
    }
    static int combination(int[] arr, boolean[] visited, int start, int r,int safe) {
        if(r == 0){
            return print(arr,visited);
        }
        else{
            for(int i=start;i<arr.length; i++){
                visited[i] = true;
                safe = Math.max(safe,combination(arr, visited, i + 1, r - 1,safe));
                visited[i] = false;
            }
        }
        return safe;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[M][N];
        copymap = new int[M][N];
        visit = new boolean[M][N];
        for(int y=0;y<N;y++){
            input = br.readLine().split(" ");
            for(int x=0;x<M;x++){
                map[x][y] = Integer.parseInt(input[x]);
                if(map[x][y]==2){
                    ArrayList temp = new ArrayList<Integer>();
                    temp.add(x);
                    temp.add(y);
                    virus.add(temp);
                }
                if(map[x][y]==1){
                    ArrayList temp = new ArrayList<Integer>();
                    temp.add(x);
                    temp.add(y);
                    wall.add(temp);
                }
            }
        }
        int[] arr = new int[N*M];
        int Count = N*M;
        for(int i=0;i<N*M;i++){
            arr[i] = i;
        }
        boolean[] visited = new boolean[N*M];
        int answer = combination(arr, visited, 0, 3,-1);
        System.out.println(answer);
    }
}